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
import pageObject.*;
import pageUI.ShopifyPageUI;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.lang.Thread;

public class createStoreAndInstallChatalyst extends AbstractTest {
    private WebDriver driver;
    private AbstractPage abstractPage;
    private ShopifyPO shopifyPage;
    private ChatalystPO chatalystPage;
    private OberloPO oberloPage;
    private MultiImporterPO multiImporterPage;
    private SynceeDropshippingPO synceeDropshippingPage;
    String url, email, storeName, phoneNumber, store_type, dateTime, country, city, address, firstName, lastName, password, password_confirmation;
    String appNameShopify, appNameList1Oberlo, appNameList2Oberlo, appNameList1, appNameList2;
    private String storeNameBackup, industry;
    boolean isStoreNameExisted;
    public int randomNumber;
    Faker faker;
    public String csvName;
    private String[] freeShopifyApp;
    private int indexOfFreeShopifyApp;
    private String[] freeOtherAppsList1Oberlo;
    private int indexOfFreeOtherAppsList1Oberlo;
    private String[] freeOtherAppsList2Oberlo;
    private int indexOfFreeOtherAppsList2Oberlo;
    private String[] freeOtherAppsList1;
    private int indexOfFreeOtherAppsList1;
    private String[] freeOtherAppsList2;
    private int indexOfFreeOtherAppsList2;

    @Parameters("browser")
    @BeforeTest
    public void beforeTest() {
        driver = getBrowserDriver("chrome");
        abstractPage = new AbstractPage(driver);

        //Init fake library
        faker = new Faker(new Locale("en-US"));

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();
        csvName = dateFormat.format(date) + "_Chatalyst.csv";

        //Clear data before test
        log.info("Pre-condition: Clear test data");
        shopifyPage = PageGeneratorManager.getShopifyPage(driver);
        shopifyPage.clearStoreData(Constants.WRITE_CSV_FILE_PATH);

        //Init Free Shopify Apps
        freeShopifyApp = shopifyPage.getFreeShopifyApp();
        indexOfFreeShopifyApp = 0;

        //Init Free Other Apps cho VPS có install Oberlo (List 1)
        freeOtherAppsList1Oberlo = shopifyPage.getFreeOtherAppsList1AndOberlo();
        indexOfFreeOtherAppsList1Oberlo = 0;

        //Init Free Other Apps cho VPS có install Oberlo (List 2)
        freeOtherAppsList2Oberlo = shopifyPage.getFreeOtherAppsList2AndOberlo();
        indexOfFreeOtherAppsList2Oberlo = 0;

        //Init Free Other Apps(List 1)
        freeOtherAppsList1 = shopifyPage.getFreeOtherAppsList1();
        indexOfFreeOtherAppsList1 = 0;

        //Init Free Other Apps (List 2)
        freeOtherAppsList2 = shopifyPage.getFreeOtherAppsList2();
        indexOfFreeOtherAppsList2 = 0;
    }

    @Test(invocationCount = 30)
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
        password_confirmation = password;
        city = faker.address().city();
        store_type = Constants.FREE_PLAN;
        appNameShopify = shopifyPage.searchFreeShopifyApp();
        appNameList1Oberlo = shopifyPage.searchFreeOtherAppsList1AndOberlo();
        appNameList2Oberlo = shopifyPage.searchFreeOtherAppsList2AndOberlo();
        appNameList1 = shopifyPage.searchFreeOtherAppsList1();
        appNameList2 = shopifyPage.searchFreeOtherAppsList2();

        email = firstName.toLowerCase() + "_" + lastName.replaceAll("'", "").toLowerCase() + "@gmail.com";
        storeName = firstName + " " + lastName;
        storeNameBackup = faker.name().fullName() + country;
        phoneNumber = Constants.PHONE_NUMBER + abstractPage.randomNumber(Constants.RAMDOM_BOUND) + abstractPage.randomNumber(Constants.RAMDOM_BOUND);

        //Create store test
        log.info("Pre-condition: Access Shopify");
        driver.get(Constants.URL);

        log.info("Step 01: Press on Start free trial button");
        shopifyPage.switchToFirstWindow();
        shopifyPage.closeTabToTheRight();
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

        boolean isTooManyRequest = abstractPage.isElementPresentInDOM(ShopifyPageUI.TITLE_TOO_MANY_REQUEST);
        if (isTooManyRequest) {
            log.info("Too many request");
            abstractPage.enableCreateAccountButton();
            shopifyPage.clickToContinueButton();
        }

        log.info("Step 04: Verify Create an account");
        boolean isInputToCreateAnAccount = abstractPage.isElementPresentInDOM(ShopifyPageUI.TITLE_CREATE_AN_ACCOUNT);
        // enable Create account button
        if (isInputToCreateAnAccount) {
            abstractPage.enableCreateAccountButton();
            shopifyPage.inputToCreateAccount("first_name", firstName);
            shopifyPage.inputToCreateAccount("last_name", lastName);
            shopifyPage.inputToCreateAccount("password", password);
            shopifyPage.inputToCreateAccount("password_confirmation", password_confirmation);
            shopifyPage.clickToCreateAccountButton();
        }


        log.info("Step 05: Verify the user can create the store");
        verifyTrue(shopifyPage.isRegisterInfoAcceptable());

        log.info("Step 06: Fill info at About yourself");
        boolean isDropdownStepChanged = abstractPage.isElementPresentInDOM(ShopifyPageUI.DROPDOWN_SEEDING_QUESTION);
        if (isDropdownStepChanged) {
            shopifyPage.selectAlreadySellingDropdown(Constants.ALREADY_SELLING);
            /*shopifyPage.selectCurrentRevenueDropdown(Constants.CURRENT_REVENUE);
            shopifyPage.selectIndustryDropdown(industry);*/
        } else {
            shopifyPage.selectDescribesDropdown(1);
        }
        shopifyPage.clickToNextButton();

        log.info("Step 07: Fill address");
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

        log.info("Step 08: Verify the store has been created");
        verifyTrue(shopifyPage.isTheStoreCreated());
        dateTime = shopifyPage.getCurrentDateTime();

        log.info("Step 09: Print store info");
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

//        // INSTALL APP IMPORT PRODUCT
//        log.info("Step 10: Select Apps menu");
//        shopifyPage = PageGeneratorManager.getShopifyPage(driver);
//        shopifyPage.selectAppsMenu();
//
//        log.info("Step 11: Visit Shopify App store");
//        shopifyPage.clickToVisitShopifyAppStore();
//
//        log.info("Random delay");
//
//        shopifyPage.switchTabChooseAccount();
//        boolean isChooseAnAccountToShopifyAppStore = abstractPage.isElementPresentInDOM(ShopifyPageUI.TITLE_CHOOSE_AN_ACCOUNT);
//        if (isChooseAnAccountToShopifyAppStore) {
//            shopifyPage.chooseAccount();
//        }
//
//        log.info("Step 12: Search import product app");
//        shopifyPage.inputKeyword(freeShopifyApp[indexOfFreeShopifyApp]);
//        shopifyPage.clickToSearchBtn();
//
//        boolean isPageNotResult = abstractPage.isElementPresentInDOM(ShopifyPageUI.NO_RESULT);
//        if (isPageNotResult) {
//            shopifyPage.searchAppInShopifyAppStore();
//            shopifyPage.inputKeywordWhenNoResult(freeShopifyApp[indexOfFreeShopifyApp]);
//        }
//
//
//        log.info("Step 13: Select app");
//        shopifyPage.selectFreeShopifyAppRandom(freeShopifyApp[indexOfFreeShopifyApp]);
//
//        log.info("Step 14: Add random app to store");
//        shopifyPage.sWitchTab();

        //INSTALL OBERLO APP
        log.info("Step 10: Select Apps menu");
        oberloPage = PageGeneratorManager.getOberloPO(driver);
        oberloPage.selectAppsMenu();

        log.info("Step 11: Visit Shopify App store");
        oberloPage.clickToVisitShopifyAppStore();

        log.info("Step 12: choose account to continue to shopify app");
        shopifyPage.switchTabChooseAccount();
        boolean isChooseAnAccountToShopifyAppStore = abstractPage.isElementPresentInDOM(ShopifyPageUI.TITLE_CHOOSE_AN_ACCOUNT);
        if (isChooseAnAccountToShopifyAppStore) {
            shopifyPage.chooseAccount();
        }

        log.info("Step 13: Search app Oberlo");
        shopifyPage.inputKeyword(oberloPage.searchOberlo());
        shopifyPage.clickToSearchBtn();

        boolean isPageNotResult1 = abstractPage.isElementPresentInDOM(ShopifyPageUI.NO_RESULT);
        if (isPageNotResult1) {
            shopifyPage.searchAppInShopifyAppStore();
            shopifyPage.inputKeywordWhenNoResult(oberloPage.searchOberlo());
        }

        log.info("Step 14: Select Oberlo app");
        oberloPage.selectOberloInAppStore();

        log.info("Step 15: Add Oberlo app to store");
        oberloPage.clickToAddApp();
        oberloPage.clickToInstallApp();

        log.info("Step 16: Create new account oberlo");
        oberloPage.clickToCreateNewOberloAccount();
        oberloPage.inputToEmailObelo("email oberlo", email);
        oberloPage.inputToPassword("QA12345678");
        oberloPage.clickToCreateFreeAccount();

        oberloPage.clickToSkipButton();

        shopifyPage.sleepRandomly();
//        oberloPage.clickToNextPopup();
//        oberloPage.clickToNextPopup();
        oberloPage.clickToClosePopup();
        log.info("Step 17: Search product Oberlo");
        oberloPage.clickToSearchProduct();

        log.info("Step 18: Search random product");
        oberloPage.inputNameProduct(oberloPage.searchProductOberlo());
        oberloPage.clickToSearchProductBtn();

        log.info("Step 19: Add product to import list");
        oberloPage.clickAddToImportList_1();
        oberloPage.clickAddToImportList_2();
        oberloPage.clickAddToImportList_3();
        oberloPage.clickAddToImportList_4();
        oberloPage.clickAddToImportList_5();
        oberloPage.clickAddToImportList_6();

        log.info("Step 20: Import List product");
        oberloPage.clickImportListMenu();
        oberloPage.clickCheckboxAllProduct();
        oberloPage.clickImportAllToStore();
        oberloPage.clickToPushProduct();
        shopifyPage.sWitchTab();

        //BACK TO SHOPIFY AND CHOOSE THEMES
        /*log.info("Setting Themes");
        shopifyPage.clickToThemesMenu();
        shopifyPage.clickExploreFreeThemes();
        shopifyPage.clickSelectThemes();
        shopifyPage.selectActionPublishTheme(); */

        //ADD FREE SHOPIFY APP (RANDOM FROM LIST)
        log.info("Step 21: Select Apps menu");
        shopifyPage = PageGeneratorManager.getShopifyPage(driver);
        shopifyPage.selectAppsMenu();

        log.info("Step 22: Visit Shopify App store");
        shopifyPage.clickToVisitShopifyAppStore();

        log.info("Step 22a: Choose account to continue to shopify app");
        shopifyPage.switchTabChooseAccount();
        boolean isChooseAnAccountToShopifyAppStore1 = abstractPage.isElementPresentInDOM(ShopifyPageUI.TITLE_CHOOSE_AN_ACCOUNT);
        if (isChooseAnAccountToShopifyAppStore1) {
            shopifyPage.chooseAccount();
        }

        log.info("Random delay");

        log.info("Step 23: Search free Shopify app");
        shopifyPage.inputKeyword(appNameShopify);
        shopifyPage.clickToSearchBtn();

        boolean isPageNotResult2 = abstractPage.isElementPresentInDOM(ShopifyPageUI.NO_RESULT);
        if (isPageNotResult2) {
            shopifyPage.searchAppInShopifyAppStore();
            shopifyPage.inputKeywordWhenNoResult(appNameShopify);
        }
        log.info( "APP NAME (SHOPIFY): " + appNameShopify);

        log.info("Write data to the csv" + csvName);
        shopifyPage.writeCsvFileKeywordSearch(System.getProperty("user.dir") + "/src/test/resources/" + csvName, appNameShopify, dateTime);


        log.info("Step 24: Select app");
        shopifyPage.selectFreeShopifyAppRandom(appNameShopify);
        shopifyPage.sWitchTab();

//        if(indexOfFreeShopifyApp == freeShopifyApp.length - 1 ){
//            indexOfFreeShopifyApp = 0;
//        } else {
//            indexOfFreeShopifyApp++;
//        }

        //ADD FREE APP - INSTALL OBERLO (List 1) (RANDOM FROM LIST)
        log.info("Step 25: Select Apps menu");
        shopifyPage = PageGeneratorManager.getShopifyPage(driver);
        shopifyPage.selectAppsMenu();

        log.info("Step 26: Visit Shopify App store");
        shopifyPage.clickToVisitShopifyAppStore();

        log.info("Step 27: Search free Shopify app");
        shopifyPage.sleepInSecond(2);
        shopifyPage.inputKeyword(appNameList1Oberlo);
        shopifyPage.clickToSearchBtn();

        boolean isPageNotResult3 = abstractPage.isElementPresentInDOM(ShopifyPageUI.NO_RESULT);
        if (isPageNotResult3) {
            shopifyPage.searchAppInShopifyAppStore();
            shopifyPage.inputKeywordWhenNoResult(appNameList1Oberlo);
        }
        log.info("APP NAME (LIST 1 - Oberlo): " + appNameList1Oberlo);

        log.info("Write data to the csv" + csvName);
        shopifyPage.writeCsvFileKeywordSearch(System.getProperty("user.dir") + "/src/test/resources/" + csvName, appNameList1Oberlo, dateTime);


        log.info("Step 28: Select app");
        shopifyPage.selectFreeOtherAppAndOberloRandomByURL(appNameList1Oberlo);

        log.info("Step 29: Add random app to store");
        shopifyPage.sWitchTab();

        /*if(indexOfFreeOtherAppsList1Oberlo == freeOtherAppsList1Oberlo.length - 1 ){
            indexOfFreeOtherAppsList1Oberlo = 0;
        } else {
            indexOfFreeOtherAppsList1Oberlo++;
        }*/

        //ADD FREE APP (List 1) (RANDOM FROM LIST)
        /*log.info("Step 25: Select Apps menu");
        shopifyPage = PageGeneratorManager.getShopifyPage(driver);
        shopifyPage.selectAppsMenu();

        log.info("Step 26: Visit Shopify App store");
        shopifyPage.clickToVisitShopifyAppStore();

        log.info("Step 27: Search free Shopify app");
        shopifyPage.sleepInSecond(2);
        shopifyPage.inputKeyword(appNameList1);
        shopifyPage.clickToSearchBtn();

        boolean isPageNotResult4 = abstractPage.isElementPresentInDOM(ShopifyPageUI.NO_RESULT);
        if (isPageNotResult4) {
            shopifyPage.searchAppInShopifyAppStore();
            shopifyPage.inputKeywordWhenNoResult(appNameList1);
        }
        log.info("APP NAME (LIST 1): " + appNameList1);

        log.info("Write data to the csv" + csvName);
        shopifyPage.writeCsvFileKeywordSearch(System.getProperty("user.dir") + "/src/test/resources/" + csvName, appNameList1, dateTime);

        log.info("Step 28: Select app");
        shopifyPage.selectFreeOtherAppRandomByURL(appNameList1);

        log.info("Step 29: Add random app to store");
        shopifyPage.sWitchTab();*/

        /*if(indexOfFreeOtherAppsList1 == freeOtherAppsList1.length - 1 ){
            indexOfFreeOtherAppsList1 = 0;
        } else {
            indexOfFreeOtherAppsList1++;
        } */

		//Install Chatalyst app
        // pause code
        log.info("Step 30: Select Apps menu");
        chatalystPage = PageGeneratorManager.getChatalystPage(driver);
        chatalystPage.selectAppsMenu();

        log.info("Step 31: Visit Shopify App store");
        chatalystPage.clickToVisitShopifyAppStore();

        log.info("Step 32 : Search app by keyword");
        chatalystPage.inputKeyword(chatalystPage.getRandomKeyword());
        chatalystPage.clickToSearchBtn();

        boolean isPageNotResult5 = abstractPage.isElementPresentInDOM(ShopifyPageUI.NO_RESULT);
        if (isPageNotResult5) {
            shopifyPage.searchAppInShopifyAppStore();
            shopifyPage.inputKeywordWhenNoResult(chatalystPage.getRandomKeyword());
        }

        log.info("Step 33: Select Chatalyst app");
        chatalystPage.findElementInPage();

        log.info("Step 34: Add Chatalyst app to store");
        chatalystPage.clickToAddApp();

        log.info("Step 35: Write data to the csv" + csvName);
        shopifyPage.writeDataToCsv(System.getProperty("user.dir") + "/src/test/resources/" + csvName, email, storeName, store_type, password, address, city, country, dateTime);
        //shopifyPage.writeDataToCsv(Constants.WRITE_CSV_FILE_PATH, email, storeName, store_type, password, address, city, country, dateTime);
        System.out.println("Written Data");

        log.info("Step 36: Add Chatalyst app to store");
        chatalystPage.clickToInstallApp();
        shopifyPage.sWitchTab();
		
		//CREATE DISCOUT CODE 
        log.info("Step 37: Select Discount menu");
        shopifyPage.clickTodDiscountsMenu();
        shopifyPage.clickCreateDiscountCode();

        log.info("Step 38: Input random code name");
        shopifyPage.inputKeywordCodeName(shopifyPage.inputCodeName());

        log.info("Step 39: Input random discount value");
        shopifyPage.inputKeywordCodeValue(shopifyPage.inputDiscountValue());

        log.info("Step 40: Check Limit to one use per customer");
        shopifyPage.scrollPage();
        shopifyPage.sleepRandomly();
        shopifyPage.checkToUsageLimits();
        shopifyPage.sleepRandomly();
        shopifyPage.clickToSave();
        shopifyPage.sleepRandomly();

        //ADD FREE APP - INSTALL OBERLO (List 2) (RANDOM FROM LIST)
        log.info("Step 41: Select Apps menu");
        shopifyPage = PageGeneratorManager.getShopifyPage(driver);
        shopifyPage.selectAppsMenu();

        log.info("Step 42: Visit Shopify App store");
        shopifyPage.clickToVisitShopifyAppStore();

        log.info("Step 43: Search free Shopify app");
        shopifyPage.sleepInSecond(2);
        shopifyPage.inputKeyword(appNameList2Oberlo);
        shopifyPage.clickToSearchBtn();

        boolean isPageNotResult6 = abstractPage.isElementPresentInDOM(ShopifyPageUI.NO_RESULT);
        if (isPageNotResult6) {
            shopifyPage.searchAppInShopifyAppStore();
            shopifyPage.inputKeywordWhenNoResult(appNameList2Oberlo);
        }
        log.info("APP NAME (LIST 2 - Oberlo) :" + appNameList2Oberlo);

        log.info("Write data to the csv" + csvName);
        shopifyPage.writeCsvFileKeywordSearch(System.getProperty("user.dir") + "/src/test/resources/" + csvName, appNameList2Oberlo, dateTime);

        log.info("Step 44: Select app");
        shopifyPage.selectFreeOtherAppAndOberloRandomByURL2(appNameList2Oberlo);

        log.info("Step 45: Add random app to store");
        shopifyPage.sWitchTab();

        /*if(indexOfFreeOtherAppsList2Oberlo == freeOtherAppsList2Oberlo.length - 1 ){
            indexOfFreeOtherAppsList2Oberlo = 0;
        } else {
            indexOfFreeOtherAppsList2Oberlo++;
        }*/

        //ADD FREE APP  (List 2) (RANDOM FROM LIST)
        /*log.info("Step 41: Select Apps menu");
        shopifyPage = PageGeneratorManager.getShopifyPage(driver);
        shopifyPage.selectAppsMenu();

        log.info("Step 42: Visit Shopify App store");
        shopifyPage.clickToVisitShopifyAppStore();

        log.info("Step 43: Search free Shopify app");
        shopifyPage.sleepInSecond(2);
        shopifyPage.inputKeyword(appNameList2);
        shopifyPage.clickToSearchBtn();

        boolean isPageNotResult7 = abstractPage.isElementPresentInDOM(ShopifyPageUI.NO_RESULT);
        if (isPageNotResult7) {
            shopifyPage.searchAppInShopifyAppStore();
            shopifyPage.inputKeywordWhenNoResult(appNameList2);
        }
        log.info("APP NAME (LIST 2) :" + appNameList2);

        log.info("Write data to the csv" + csvName);
        shopifyPage.writeCsvFileKeywordSearch(System.getProperty("user.dir") + "/src/test/resources/" + csvName, appNameList2, dateTime);

        log.info("Step 44: Select app");
        shopifyPage.selectFreeOtherAppRandomByURL2(appNameList2);


        log.info("Step 45: Add random app to store");
        shopifyPage.sWitchTab();*/

        /*if(indexOfFreeOtherAppsList2 == freeOtherAppsList2.length - 1 ){
            indexOfFreeOtherAppsList2 = 0;
        } else {
            indexOfFreeOtherAppsList2++;
        }*/
    }

    //    @Test
    public void TC02_ReadAndInstallChatalyst() {
        log.info("Read data from CSV file and install Messent app depends on Store Type column");
        chatalystPage = PageGeneratorManager.getChatalystPage(driver);
        chatalystPage.readDataCsv();
    }

    @AfterClass
    public void quitBrowser() {
        closeBrowserAndDriver(driver);
    }

}
