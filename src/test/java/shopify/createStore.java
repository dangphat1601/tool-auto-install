package shopify;

import com.github.javafaker.Faker;
import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObject.ShopifyPO;
import pageUI.ShopifyPageUI;

import java.io.IOException;
import java.util.Locale;
import java.util.Random;

public class createStore extends AbstractTest {
    private WebDriver driver;
    private AbstractPage abstractPage;
    private ShopifyPO shopifyPage;
    String  email, storeName, phoneNumber, store_type, dateTime, country, city, address, firstName, lastName, password;
    private String storeNameBackup, industry;
    boolean isStoreNameExisted;
    public int randomNumber;
    Faker faker;


    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browserName) {
        driver = getBrowserDriver(browserName);
        abstractPage = new AbstractPage(driver);

        //Init fake library
        faker = new Faker(new Locale("en-US"));
    }

    @Test(invocationCount = 1)
    public void TC01_CreateShopifyStore() throws IOException {
        //Init data
        Random random = new Random();
        randomNumber = random.nextInt(99);
        shopifyPage = PageGeneratorManager.getShopifyPage(driver);
        country = shopifyPage.getRandomCountry();
        industry = shopifyPage.getRandomIndustry();
        address = faker.address().streetAddress();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        password = faker.name().firstName() + randomNumber;
        city = faker.address().city();
        store_type = Constants.FREE_PLAN;

        email = firstName.toLowerCase() + "_" + lastName.toLowerCase() + "@mail.com";
        storeName = firstName + " " + lastName;
        storeNameBackup = faker.name().fullName() + country;
        phoneNumber = Constants.PHONE_NUMBER + abstractPage.randomNumber(Constants.RAMDOM_BOUND);

        //Create store test
        log.info("Pre-condition: Access Shopify");
        driver.get(Constants.URL);

        log.info("Step 01: Press on Start free trial button");
        shopifyPage = PageGeneratorManager.getShopifyPage(driver);
        shopifyPage.clickToStartFreeTrialBtn();

        log.info("Step 02: Fill info to register");
        shopifyPage.inputToRegisterTextBoxes("Email address", email);
        shopifyPage.inputToRegisterTextBoxes("Password", password);
        shopifyPage.inputToRegisterTextBoxes("Your store name", storeName);

        log.info("Step 03: Press Create your store button");
        isStoreNameExisted = abstractPage.isElementPresentInDOM(ShopifyPageUI.ERR_NAME_EXISTS);
        if (isStoreNameExisted) {
            shopifyPage.inputToRegisterTextBoxes("Your store name", storeNameBackup);
        } else {
        shopifyPage.clickToCreateYourStoreButton();
        }

        log.info("Step 04: Verify the user can create the store");
        verifyTrue(shopifyPage.isRegisterInfoAcceptable());

        log.info("Step 05: Fill info at About yourself");
        boolean isDropdownStepChanged = abstractPage.isElementPresentInDOM(ShopifyPageUI.DROPDOWN_SEEDING_QUESTION);
        if (isDropdownStepChanged) {
            shopifyPage.selectAlreadySellingDropdown(Constants.ALREADY_SELLING);
            shopifyPage.selectCurrentRevenueDropdown(Constants.CURRENT_REVENUE);
            shopifyPage.selectIndustryDropdown(industry);
        } else {
            shopifyPage.selectDescribesDropdown(1);
        }
        shopifyPage.clickToNextButton();

        log.info("Step 06: Fill address");
        shopifyPage.inputAddressTextboxes("firstName", firstName);
        shopifyPage.inputAddressTextboxes("lastName", lastName);
        shopifyPage.inputAddressTextboxes("address1", address);
        shopifyPage.inputAddressTextboxes("city", city);
        shopifyPage.selectCountry(country);
        System.out.println("Country: " + country);
        //Select the 2nd state/province
        shopifyPage.selectStateorProvince(2);
        shopifyPage.inputAddressTextboxes("zip", Constants.ZIPCODE);

        shopifyPage.inputAddressTextboxes("phone", phoneNumber);
        shopifyPage.clickToEnterMyStoreButton();

        log.info("Step 07: Verify the store has been created");
        verifyTrue(shopifyPage.isTheStoreCreated());
        dateTime = shopifyPage.getCurrentDateTime();

        log.info("Step 08: Print store info");
        shopifyPage.printStoreURL();
        System.out.println("Account info:");
        System.out.println("Email: " + email);
        System.out.println("Store Name: " + storeName);
        System.out.println("Store type: " + store_type);
        System.out.println("Password: " + password);
        System.out.println("Address: " + address);
        System.out.println("City: " + city);
        System.out.println("Country: " + country);
        System.out.println("Created time: " + dateTime);

        log.info("Step 09: Write data to the csv");
        shopifyPage.writeDataToCsv(Constants.WRITE_CSV_FILE_PATH, email, storeName, store_type, password, address, city, country, dateTime);
        System.out.println("Written Data");

        //Create item
        log.info("Step 10: Add new product");
        shopifyPage.clickToProductMenu();
        shopifyPage.clickToAddProduct();
        shopifyPage.inputToProductName("Test");
        shopifyPage.clickToSaveProduct();

        log.info("Step 11: Verify the product has been added");
        verifyTrue(shopifyPage.isPreviewProductButtonDisplayed());
    }

    @AfterClass
    public void quitBrowser() {
        closeBrowserAndDriver(driver);
    }
}
