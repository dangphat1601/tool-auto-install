package shopify;

import com.github.javafaker.Faker;
import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.ShopifyPO;
import pageObject.SwiftPO;
import pageUI.ShopifyPageUI;
import pageObject.OberloPO;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.lang.Thread;

public class SearchKeywordSwift extends AbstractTest {
    private WebDriver driver;
    private AbstractPage abstractPage;
    private ShopifyPO shopifyPage;
    private SwiftPO swiftPage;
    private OberloPO oberloPage;
    //String url, email, storeName, phoneNumber, store_type, dateTime, country, city, address, firstName, lastName, password, password_confirmation;
    String keyword, dateTime;
    private String storeNameBackup, industry;
    boolean isStoreNameExisted;
    public int randomNumber;
    Faker faker;
    public String csvName;


    @Parameters("browser")
    @BeforeTest
    public void beforeTest() {
        driver = getBrowserDriver("chrome");
        abstractPage = new AbstractPage(driver);

        //Init fake library
        faker = new Faker(new Locale("en-US"));

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();
        csvName = dateFormat.format(date) + "_Swift.csv";

        //Clear data before test
        log.info("Pre-condition: Clear test data");
        shopifyPage = PageGeneratorManager.getShopifyPage(driver);
        shopifyPage.clearStoreData(Constants.WRITE_CSV_FILE_PATH);
    }

    @Test(invocationCount = 1)
    public void TC01_CreateShopifyStore() throws IOException {
        //Init data
        Random random = new Random();
        randomNumber = random.nextInt(99);
        swiftPage = PageGeneratorManager.getSwiftPage(driver);
        keyword = swiftPage.getRandomKeyword();
        dateTime = swiftPage.getCurrentDateTime();
        //shopifyPage = PageGeneratorManager.getShopifyPage(driver);
        /*country = shopifyPage.getRandomCountry();
        industry = shopifyPage.getRandomIndustry();
        address = faker.address().streetAddress();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        password = faker.name().firstName() + randomNumber;
        password_confirmation = password;
        city = faker.address().city();
        store_type = Constants.FREE_PLAN;

        email = firstName.toLowerCase() + "_" + lastName.toLowerCase() + "@mail.com";
        storeName = firstName + " " + lastName;
        storeNameBackup = faker.name().fullName() + country;
        phoneNumber = Constants.PHONE_NUMBER + abstractPage.randomNumber(Constants.RAMDOM_BOUND);*/


        //Search app Swift
        log.info("Step 01: Pre-condition: Access App Store Shopify");
        driver.get(Constants.URL_APP);
        shopifyPage.switchToFirstWindow();
        shopifyPage = PageGeneratorManager.getShopifyPage(driver);

        log.info("Step 02: Search keyword swift");
        swiftPage = PageGeneratorManager.getSwiftPage(driver);
        swiftPage.inputKeyword(swiftPage.getRandomKeyword());

        log.info("Step 03: Print store info");
        System.out.println("Keyword search:");
        System.out.println("keyword: " + keyword);
        System.out.println("Created time: " + dateTime);

        log.info("Step 04: Write data to the csv" + csvName);
        shopifyPage.writeCsvFileKeywordSearch(System.getProperty("user.dir") + "/src/test/resources/" + csvName, keyword, dateTime);

        swiftPage.clickToSearchBtn();
//        swiftPage.scrollPage();

        log.info("Step 05: Click choose app Swift");
        swiftPage.selectSwiftInAppStore();
        swiftPage.clickShowFullDescription();

        shopifyPage.sleepRandomly();
    }

    @AfterClass
    public void quitBrowser() {
        closeBrowserAndDriver(driver);
    }
}
