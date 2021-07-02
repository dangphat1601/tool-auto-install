package pageObject;

import commons.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUI.InstallAppUI;
import pageUI.ShopifyPageUI;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShopifyPO extends AbstractPage {
    WebDriver driver;
    public String storeURL;
    AbstractTest abstractTest = new AbstractTest();
    ReadDataCSV readDataCSV = new ReadDataCSV();

    public ShopifyPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToStartFreeTrialBtn() {
        waitToElementClickable(ShopifyPageUI.START_FREE_TRIAL_BUTTON);
        clickToElement(ShopifyPageUI.START_FREE_TRIAL_BUTTON);
    }

    public void inputToRegisterTextBoxes(String placeHolder, String value) {
        waitToElementVisible(ShopifyPageUI.REGISTER_TEXT_BOXES, placeHolder);
        sendKeyToElement(ShopifyPageUI.REGISTER_TEXT_BOXES, value, placeHolder);
        sleepInSecond(1);
    }

    public void clickToCreateYourStoreButton() {
        sleepInSecond(3);
        waitToElementClickable(ShopifyPageUI.CREATE_YOUR_STORE_BUTTON);
        clickToElement(ShopifyPageUI.CREATE_YOUR_STORE_BUTTON);
        clickToElement(ShopifyPageUI.CREATE_YOUR_STORE_BUTTON);
    }

    public boolean isRegisterInfoAcceptable() {
        waitToElementVisible(ShopifyPageUI.TITLE_MORE_INFO);
        return isElementPresentInDOM(ShopifyPageUI.TITLE_MORE_INFO);
    }

    public void selectAlreadySellingDropdown(String item) {
        waitToElementVisible(ShopifyPageUI.DROPDOWN_SEEDING_QUESTION);
        selectItemInDropdown(ShopifyPageUI.DROPDOWN_SEEDING_QUESTION, item);
        sleepInSecond(2);
    }

    public void selectCurrentRevenueDropdown(String item) {
        sleepInSecond(3);
        waitToElementVisible(ShopifyPageUI.DROPDOWN_BUSINESS_REVENUE);
        selectItemInDropdown(ShopifyPageUI.DROPDOWN_BUSINESS_REVENUE, item);
    }

    public void selectIndustryDropdown(String item) {
        sleepInSecond(3);
        waitToElementVisible(ShopifyPageUI.DROPDOWN_STORE_INDUSTRY);
        selectItemInDropdown(ShopifyPageUI.DROPDOWN_STORE_INDUSTRY, item);
    }

    public void selectDescribesDropdown(int index) {
        sleepInSecond(3);
        waitToElementVisible(ShopifyPageUI.DROPDOWN_DESCRIBES);
        selectItemInDropdownByIndex(ShopifyPageUI.DROPDOWN_DESCRIBES, index);
    }

    public void clickToNextButton() {
        sleepInSecond(3);
        waitToElementClickable(ShopifyPageUI.NEXT_BUTTON);
        clickToElement(ShopifyPageUI.NEXT_BUTTON);
    }

    public void inputAddressTextboxes(String nameValue, String textValue) {
        if (isElementPresentInDOM(ShopifyPageUI.ADDRESS_INFO_TEXTBOXES, nameValue)) {
            waitToElementVisible(ShopifyPageUI.ADDRESS_INFO_TEXTBOXES, nameValue);
            sendKeyToElement(ShopifyPageUI.ADDRESS_INFO_TEXTBOXES, textValue, nameValue);
        }
    }

    public void inputToCreateAccount(String nameValue, String textValue) {
        if (isElementPresentInDOM(ShopifyPageUI.CREATE_ACCOUNT_TEXTBOXES, nameValue)) {
            waitToElementVisible(ShopifyPageUI.CREATE_ACCOUNT_TEXTBOXES, nameValue);
            sendKeyToElement(ShopifyPageUI.CREATE_ACCOUNT_TEXTBOXES, textValue, nameValue);
        }
    }

    public void clickToCreateAccountButton() {
        sleepInSecond(3);
        waitToElementClickable(ShopifyPageUI.CREATE_ACCOUNT_BUTTON);
        clickToElement(ShopifyPageUI.CREATE_ACCOUNT_BUTTON);
    }

    public void clickToContinueButton() {
        sleepInSecond(5);
        waitToElementClickable(ShopifyPageUI.CONTINUE_BUTTON);
        clickToElement(ShopifyPageUI.CONTINUE_BUTTON);
    }

    public void clickToEnterMyStoreButton() {
        sleepInSecond(1);
        waitToElementClickable(ShopifyPageUI.ENTER_MY_STORE_BUTTON);
        clickToElement(ShopifyPageUI.ENTER_MY_STORE_BUTTON);
        sleepInSecond(2);
        if (isElementPresentInDOM(ShopifyPageUI.ERR_ZIP_CODE)) {
            inputAddressTextboxes("zip", "2020");
        }
    }

    public boolean isTheStoreCreated() {
        return isElementDisplayed(ShopifyPageUI.SELECT_PLAN_MSG);
    }

    public void printStoreURL() {
        if (isTheStoreCreated()) {
            String urlContains = driver.getCurrentUrl();
            storeURL = urlContains.substring(0, urlContains.length() - 6);
            System.out.println("Store URL: " + storeURL);
        }
    }


    public void clickToLoginButton() {
        waitToElementClickable(ShopifyPageUI.LOGIN_BUTTON);
        clickToElement(ShopifyPageUI.LOGIN_BUTTON);
    }

    public void clickLoginToAnotherAccount() {
        waitToElementClickable(ShopifyPageUI.LOGIN_TO_ANOTHER_ACCOUNT);
        clickToElement(ShopifyPageUI.LOGIN_TO_ANOTHER_ACCOUNT);
    }

    public void inputToStoreURLTextBox(String url) {
        waitToElementVisible(ShopifyPageUI.STORE_URL_TEXTBOX);
        sendKeyToElement(ShopifyPageUI.STORE_URL_TEXTBOX, url);
    }

    public void inputToEmailPasswordTextBoxes(String attributeValue, String textValue) {
        waitToElementVisible(ShopifyPageUI.EMAIL_PASSWORD_TEXTBOXES, attributeValue);
        sendKeyToElement(ShopifyPageUI.EMAIL_PASSWORD_TEXTBOXES, textValue, attributeValue);
    }

    public void clickToDynamicButton(String attributeValue) {
        waitToElementClickable(ShopifyPageUI.DYNAMIC_BUTTON, attributeValue);
        clickToElement(ShopifyPageUI.DYNAMIC_BUTTON, attributeValue);
    }

    public boolean isStoreNameLabelDisplayed(String storeName) {
        waitToElementClickable(ShopifyPageUI.STORE_NAME_LABEL, storeName);
        return isElementDisplayed(ShopifyPageUI.STORE_NAME_LABEL, storeName);
    }

    public void clickToAppsMenu() {
        sleepInSecond(5);
        waitToElementClickable(ShopifyPageUI.APPS_MENU);
        clickToElement(ShopifyPageUI.APPS_MENU);
    }

    public void clickToDeleteOriginalApp() {
        waitToElementClickable(ShopifyPageUI.DELETE_ORIGINAL);
        clickToElement(ShopifyPageUI.DELETE_ORIGINAL);
    }

    public void clickToConfirmDeleteOriginal() {
        sleepInSecond(1);
        waitToElementClickable(ShopifyPageUI.CONFIRM_DELETE_ORIGINAL);
        waitToElementVisible(ShopifyPageUI.DELETE_APP_CONFIRMATION_TEXT);
        clickToElement(ShopifyPageUI.CONFIRM_DELETE_ORIGINAL);
    }

    public void writeDataToCsv(String fileName, String email, String storeName, String store_type, String password, String address, String city, String country, String dateTime) throws IOException {
        //Create new data object
        StoresLink data = new StoresLink(storeURL, email, storeName, store_type, password, address, city, country, dateTime);

        List<StoresLink> storeData = new ArrayList<>();
        storeData.add(data);
        File src = new File(System.getProperty("user.dir") + "/src/test/resources/templateStoreData.csv");
        File dest = new File(fileName);

        if (!dest.exists()) {
            FileUtils.copyFile(src, dest);
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName, true);
            //Write the CSV file Header
//            fileWriter.append(Constants.FILE_HEADER);
            //Add a new line separator after the header
//            fileWriter.append(Constants.NEW_LINE_SEPARATOR);

            //Write new data objects list to the CSV file
            for (StoresLink storeValues : storeData) {
                fileWriter.append(storeValues.getUrl());
                fileWriter.append(Constants.COMMA_DELIMITER);
                fileWriter.append(storeValues.getEmail());
                fileWriter.append(Constants.COMMA_DELIMITER);
                fileWriter.append(storeValues.getStoreName());
                fileWriter.append(Constants.COMMA_DELIMITER);
                fileWriter.append(storeValues.getStore_type());
                fileWriter.append(Constants.COMMA_DELIMITER);
                fileWriter.append(storeValues.getPassword());
                fileWriter.append(Constants.COMMA_DELIMITER);
                fileWriter.append(storeValues.getAddress());
                fileWriter.append(Constants.COMMA_DELIMITER);
                fileWriter.append(storeValues.getCity());
                fileWriter.append(Constants.COMMA_DELIMITER);
                fileWriter.append(storeValues.getCountry());
                fileWriter.append(Constants.COMMA_DELIMITER);
                fileWriter.append(storeValues.getDateTime());
            }

            fileWriter.append(Constants.NEW_LINE_SEPARATOR);

            System.out.println("CSV file was created successfully !!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!");
                e.printStackTrace();
            }
        }
    }


    public void writeCsvFileKeywordSearch(String fileName, String keyword, String dateTime) throws IOException {
        Keyword data = new Keyword(keyword, dateTime);

        List<Keyword> keywords = new ArrayList<>();
        keywords.add(data);
        File src = new File(System.getProperty("user.dir") + "/src/test/resources/templateStoreData.csv");
        File dest = new File(fileName);

        if (!dest.exists()) {
            FileUtils.copyFile(src, dest);
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName, true);
            //Write the CSV file Header
//            fileWriter.append(Constants.FILE_HEADER);
            //Add a new line separator after the header
//            fileWriter.append(Constants.NEW_LINE_SEPARATOR);

            //Write new data objects list to the CSV file
            for (Keyword storeValues : keywords) {
                fileWriter.append(storeValues.getKeyword());
                fileWriter.append(Constants.COMMA_DELIMITER);
                fileWriter.append(storeValues.getDateTime());
            }

            fileWriter.append(Constants.NEW_LINE_SEPARATOR);

            System.out.println("CSV file was created successfully !!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!");
                e.printStackTrace();
            }
        }
    }

    public void uninstallApps(List<String> store) {
        String stt = store.get(0);
        Constants.STORE_URL_CSV = store.get(1);
        Constants.STORE_EMAIL_CSV = store.get(2);
        Constants.STORE_NAME_CSV = store.get(3);
        Constants.STORE_TYPE_CSV = store.get(4);

        driver.get(Constants.URL);
        clickToLoginButton();
        if (isElementPresentInDOM(ShopifyPageUI.LOGIN_TO_ANOTHER_ACCOUNT)) {
            clickLoginToAnotherAccount();
        }
        inputToStoreURLTextBox(Constants.STORE_URL_CSV);
        clickToDynamicButton("Next");
        inputToEmailPasswordTextBoxes("email", Constants.STORE_EMAIL_CSV);
        clickToDynamicButton("Next");
        inputToEmailPasswordTextBoxes("password", Constants.SHOPIFY_PASSWORD);
        clickToDynamicButton("Log in");
        //Verify login successfully
        abstractTest.verifyTrue(isStoreNameLabelDisplayed(Constants.STORE_NAME_CSV));
        clickToAppsMenu();
        if (isElementPresentInDOM(ShopifyPageUI.DELETE_ORIGINAL)) {
            clickToDeleteOriginalApp();
            clickToConfirmDeleteOriginal();
            String deleteSuccess = getTextElement(ShopifyPageUI.DELETE_SUCCESS_MESSAGE);
            abstractTest.verifyTrue(deleteSuccess.equals(Constants.DELETE_SUCCESS_MESSAGE));
            System.out.println("THE STORE " + Constants.STORE_NAME_CSV + " HAS BEEN REMOVED THE ORIGINAL APP");
            System.out.println("Ordinal Numbers: " + stt);
        } else {
            System.out.println("THIS STORE ALREADY DELETED THE ORIGINAL APP");
            System.out.println("Ordinal Numbers: " + stt);
        }
    }

    public String getRandomCountry() {
        //Declare list countries
        final String[] countries = new String[]{"Afghanistan", "Ã…land Islands", "Albania", "Algeria", "Andorra", "Angola", "Anguilla", "Antigua & Barbuda",
                "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium",
                "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia & Herzegovina", "Botswana", "Brazil", "British Virgin Islands", "Brunei",
                "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Chad",
                "Chile", "China", "Colombia", "Comoros", "Congo - Brazzaville", "Congo - Kinshasa", "Cook Islands", "Costa Rica", "Croatia", "CuraÃ§ao", "Cyprus",
                "Czechia", "CÃ´te dâ€™Ivoire", "Denmark", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Estonia",
                "Eswatini", "Ethiopia", "Faroe Islands", "Fiji", "Finland", "France", "French Guiana", "French Polynesia", "Gabon", "Gambia", "Georgia", "Germany", "Ghana",
                "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guatemala", "Guernsey", "Guyana", "Haiti", "Honduras", "Hong Kong SAR China", "Hungary",
                "Iceland", "India", "Indonesia", "Iraq", "Ireland", "Isle of Man", "Israel", "Italy", "Jamaica", "Japan", "Jersey", "Jordan", "Kazakhstan", "Kenya",
                "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Liechtenstein", "Lithuania", "Luxembourg", "Macao SAR China", "Madagascar",
                "Malawi", "Malaysia", "Maldives", "Malta", "Martinique", "Mauritius", "Mayotte", "Mexico", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco",
                "Mozambique", "Myanmar (Burma)", "Namibia", "Nepal", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Macedonia",
                "Norway", "Oman", "Pakistan", "Palestinian Territories", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar",
                "RÃ©union", "Romania", "Russia", "Rwanda", "Samoa", "San Marino", "SÃ£o TomÃ© & PrÃ­ncipe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Singapore",
                "Sint Maarten", "Slovakia", "Slovenia", "Solomon Islands", "South Africa", "South Korea", "South Sudan", "Spain", "Sri Lanka", "St. Kitts & Nevis", "St. Lucia",
                "St. Martin", "St. Vincent & Grenadines", "Sudan", "Suriname", "Sweden", "Switzerland", "Taiwan", "Tanzania", "Thailand", "Timor-Leste", "Togo", "Trinidad & Tobago",
                "Tunisia", "Turkey", "Turkmenistan", "Turks & Caicos Islands", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan",
                "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"};
        Random random = new Random();
        int index = random.nextInt(countries.length);
        return countries[index];
    }

    public void selectCountry(String country) {
        waitToElementVisible(ShopifyPageUI.COUNTRY_DROPDOWN);
        selectItemInDropdown(ShopifyPageUI.COUNTRY_DROPDOWN, country);
    }

    public String getRandomIndustry() {
        String[] industry = new String[]{"Beauty", "Clothing", "Electronics", "Furniture", "Handcrafts", "Jewelry",
                "Painting", "Photography", "Restaurants", "Groceries", "Other food & drink", "Sports", "Toys",
                "Services", "Virtual services"};
        Random random = new Random();
        int index = random.nextInt(industry.length);
        return industry[index];
    }

    public void selectStateorProvince(int index) {
        if (isElementPresentInDOM(ShopifyPageUI.STATES_DROPDOWN)) {
            waitToElementVisible(ShopifyPageUI.STATES_DROPDOWN);
            selectItemInDropdownByIndex(ShopifyPageUI.STATES_DROPDOWN, index);
        } else if (isElementPresentInDOM(ShopifyPageUI.PROVINCE_DROPDOWN)) {
            waitToElementVisible(ShopifyPageUI.PROVINCE_DROPDOWN);
            selectItemInDropdownByIndex(ShopifyPageUI.PROVINCE_DROPDOWN, index);
        } else {
            System.out.println("There is no State or Province for this country");
        }
    }

    public void readDataAndDeleteApp() {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(Constants.READ_CSV_FILE_PATH));

            //Read file in java line by line
            while ((line = br.readLine()) != null) {
                while ((line = br.readLine()) != null) {
                    while ((line = br.readLine()) != null) {
                        uninstallApps(readDataCSV.parseCsvLine(line));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public String getCurrentDateTime() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar calobj = Calendar.getInstance();
        return df.format(calobj.getTime());
    }

    public void clickToProductMenu() {
        waitToElementVisible(ShopifyPageUI.PRODUCT_MENU);
        clickToElement(ShopifyPageUI.PRODUCT_MENU);
    }

    public void clickToAddProduct() {
        waitToElementClickable(ShopifyPageUI.ADD_PRODUCT_BTN);
        clickToElement(ShopifyPageUI.ADD_PRODUCT_BTN);
    }

    public void inputToProductName(String productName) {
        waitToElementVisible(ShopifyPageUI.PRODUCT_NAME_TEXTBOX);
        sendKeyToElement(ShopifyPageUI.PRODUCT_NAME_TEXTBOX, productName);
    }

    public void clickToSaveProduct() {
        waitToElementClickable(ShopifyPageUI.SAVE_PRODUCT_BTN);
        clickToElement(ShopifyPageUI.SAVE_PRODUCT_BTN);
    }

    public boolean isPreviewProductButtonDisplayed() {
        return isElementDisplayed(ShopifyPageUI.PREVIEW_PRODUCT_BTN);
    }

    public void clearStoreData(String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickToThemesMenu() {
        driver.getWindowHandle();
        waitToElementClickable(ShopifyPageUI.ONLINE_STORE_MENU);
        clickToElement(ShopifyPageUI.ONLINE_STORE_MENU);
        sleepInSecond(5);
    }

    public void clickExploreFreeThemes() {
        WebElement iFrame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrame);
        driver.findElement(By.xpath("//button[@class='_1wLbD _1eWnt']")).click();
        scrollToEndOfPage();
        sleepInSecond(3);
    }

    public void clickSelectThemes() {
        sleepInSecond(3);
        WebDriverWait waiter = new WebDriverWait(driver, 1000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("app-modal-iframe");
        driver.findElement(By.xpath("//span[contains(text(),'Boundless')]")).click();
        sleepInSecond(5);
        //click button Add to themes libary
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='_1wLbD _1eCDN']")));
        driver.findElement(By.xpath("//button[@class='_1wLbD _1eCDN']")).click();
    }

    /*public void clickAddToThemeLibary(){
        WebElement iFrame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrame);
        driver.findElement(By.xpath("//button[@class='_1wLbD _1eCDN']")).click();
        sleepInSecond(5);
        driver.switchTo().defaultContent();
    }*/

    public void selectActionPublishTheme() {
        sleepInSecond(10);
        WebDriverWait waiter = new WebDriverWait(driver, 1000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("app-iframe");
        driver.findElement(By.xpath("//button[@class='_1wLbD _32TRG']//span[@class='_1GgwJ'][contains(text(),'Actions')]")).click();
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Publish')]")));
        driver.findElement(By.xpath("//div[contains(text(),'Publish')]")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("app-modal-iframe");
        driver.findElement(By.xpath("//button[@class='_1wLbD _1eCDN']")).click();
        driver.switchTo().defaultContent();
        sleepInSecond(10);
    }

    //ADD FREE SHOPIFY APPS (RANDOM 1 APP FROM LIST)
    public String[] getFreeShopifyApp() {
        final String[] keywords = new String[]{
                AppName.GOOGLE_CHANEL,
                AppName.GEOLOCATION,
                AppName.SHOPIFY_EMAIL,
                AppName.FACEBOOK_CHANNEL,
                AppName.KIT,
                AppName.PRODUCT_REVIEW
        };
        return keywords;
    }

    //ADD FREE SHOPIFY APPS (RANDOM 1 APP FROM LIST)
    public String searchFreeShopifyApp() {
        sleepInSecond(2);
        final String[] keywords = new String[]{
                AppName.GOOGLE_CHANEL,
                AppName.GEOLOCATION,
                AppName.SHOPIFY_EMAIL,
                AppName.FACEBOOK_CHANNEL,
                AppName.KIT,
                AppName.PRODUCT_REVIEW};
        Random random = new Random();
        int index = random.nextInt(keywords.length);
        return keywords[index];
    }


    /*public String searchImportProductApp() {
        String[] keywords = new String[]{"Multichannel Importer", "Spocket by Spockets", "DSers by DSers", "CJDropshipping"};
        Random random = new Random();
        int index = random.nextInt(keywords.length);
        return keywords[index];
    }

    public void selectImportProductAppRandom() {
        if (isElementPresentInDOM(ShopifyPageUI.URL_MULTI_IMPORTER_APP_IN_APPSTORE)) {
            waitToElementVisible(ShopifyPageUI.URL_MULTI_IMPORTER_APP_IN_APPSTORE);
            clickToElement(ShopifyPageUI.URL_MULTI_IMPORTER_APP_IN_APPSTORE);
            clickToAddApp();
            clickToInstallApp();
		} else if (isElementPresentInDOM(ShopifyPageUI.URL_CJDROPSHIPPING)) {
            waitToElementVisible(ShopifyPageUI.URL_CJDROPSHIPPING);
            clickToElement(ShopifyPageUI.URL_CJDROPSHIPPING);
        } else if (isElementPresentInDOM(ShopifyPageUI.URL_SPOCKET_DROPSHIPPING_APP_IN_APPSTORE)) {
            waitToElementVisible(ShopifyPageUI.URL_SPOCKET_DROPSHIPPING_APP_IN_APPSTORE);
            clickToElement(ShopifyPageUI.URL_SPOCKET_DROPSHIPPING_APP_IN_APPSTORE);
            clickToAddApp();
            clickToInstallApp();
		} else if (isElementPresentInDOM(ShopifyPageUI.URL_DSER_ALIEXPRESS_DROPSHIPPING_APP_IN_APPSTORE)) {
            waitToElementVisible(ShopifyPageUI.URL_DSER_ALIEXPRESS_DROPSHIPPING_APP_IN_APPSTORE);
            clickToElement(ShopifyPageUI.URL_DSER_ALIEXPRESS_DROPSHIPPING_APP_IN_APPSTORE);
            clickToAddApp();
            clickToInstallApp();
		} else if (isElementPresentInDOM(ShopifyPageUI.URL_SPOCKET_DROPSHIPPING_APP_IN_APPSTORE)) {
            waitToElementVisible(ShopifyPageUI.URL_SPOCKET_DROPSHIPPING_APP_IN_APPSTORE);
            clickToElement(ShopifyPageUI.URL_SPOCKET_DROPSHIPPING_APP_IN_APPSTORE);
            clickToAddApp();
            clickToInstallApp();
        }
    }*/

    //Free Other Apps cho VPS có install Oberlo (List 1)
    public String[] getFreeOtherAppsList1AndOberlo() {
        final String[] keywords = new String[]{
                AppName.QUICK_ANNOUNCEMENT_BAR,
                AppName.SNAPCHAT_ADS,
                AppName.EMAIL_MARKETING_BY_AUTOMIZELY,
                AppName.TRUST_ME_FREE_TRUST_BADGES,
                AppName.FACEBOOK_INSTAGRAM_AUTO_POST,
                AppName.KEEP_CART,
                AppName.ZENDROP,
                AppName.MAILERLITE_EMAIL_MARKETING,
                AppName.DYNAMIC_BANNER_SUITE,
                AppName.PHOTO_RESIZE,
                AppName.EZYSLIPS_SHIPPING_RETURN,
                AppName.DRAG_DROP_PDF_INVOICE
        };
        return keywords;
    }

    //Free Other Apps cho VPS có install Oberlo (List 1)
    public String searchFreeOtherAppsList1AndOberlo() {
        sleepInSecond(2);
        final String[] keywords = new String[]{
                AppName.QUICK_ANNOUNCEMENT_BAR,
                AppName.SNAPCHAT_ADS,
                AppName.EMAIL_MARKETING_BY_AUTOMIZELY,
                AppName.TRUST_ME_FREE_TRUST_BADGES,
                AppName.FACEBOOK_INSTAGRAM_AUTO_POST,
                AppName.KEEP_CART,
                AppName.ZENDROP,
                AppName.MAILERLITE_EMAIL_MARKETING,
                AppName.DYNAMIC_BANNER_SUITE,
                AppName.PHOTO_RESIZE,
                AppName.EZYSLIPS_SHIPPING_RETURN,
                AppName.DRAG_DROP_PDF_INVOICE
        };
        Random random = new Random();
        int index = random.nextInt(keywords.length);
        return keywords[index];
    }

    //Free Other Apps cho VPS có install Oberlo (List 2)
    public String[] getFreeOtherAppsList2AndOberlo() {
        final String[] keywords = new String[]{
                AppName.OMNISEND_EMAIL_MARKETING,
                AppName.BACK_INSTOCK_RESTOCK_ALERTS,
                AppName.DATA_EXPORT_REPORTS,
                AppName.EPROLO_DROPSHIPPING_AND_BRANDING,
                AppName.ZOORIX_UPSELL_CORSS_SELL,
                AppName.FONTIFY_USE_ANY_FONT,
                AppName.KIWI_SIZE_CHART_RECOMMENDER,
                AppName.AFTERSHIP_RETURNS_CENTER,
                AppName.SIMPLIO_SIMPLE_INVOICE,
                AppName.QUANLITY_BREAK_DISCOUNTS,
                AppName.URGENCY_BEAR_COUNTDOWN_TIMER,
                AppName.INSTANT_TRAFFIC_ADS,
                AppName.CUSTOM_FIELDS

        };
        return keywords;
    }

    //Free Other Apps cho VPS có install Oberlo (List 2)
    public String searchFreeOtherAppsList2AndOberlo() {
        sleepInSecond(2);
        final String[] keywords = new String[]{
                AppName.OMNISEND_EMAIL_MARKETING,
                AppName.BACK_INSTOCK_RESTOCK_ALERTS,
                AppName.DATA_EXPORT_REPORTS,
                AppName.EPROLO_DROPSHIPPING_AND_BRANDING,
                AppName.ZOORIX_UPSELL_CORSS_SELL,
                AppName.FONTIFY_USE_ANY_FONT,
                AppName.KIWI_SIZE_CHART_RECOMMENDER,
                AppName.AFTERSHIP_RETURNS_CENTER,
                AppName.SIMPLIO_SIMPLE_INVOICE,
                AppName.QUANLITY_BREAK_DISCOUNTS,
                AppName.URGENCY_BEAR_COUNTDOWN_TIMER,
                AppName.INSTANT_TRAFFIC_ADS,
                AppName.CUSTOM_FIELDS
        };
        Random random = new Random();
        int index = random.nextInt(keywords.length);
        return keywords[index];
    }

    //Get free Other Apps (List 1)
    public String[] getFreeOtherAppsList1() {
        final String[] keywords = new String[]{
                AppName.SMART_MEGA_MENU_NAV,
                AppName.MULTI_IMPORTER,
                AppName.EXCELIFY,
                AppName.SHOPPING_FEED_FOR_GOOGLE,
                AppName.GDPR_CCPA_COOKIE_MANAGEMENT,
                AppName.REPLAY_LIVE_SESSION_RECORDINGS,
                AppName.SPOCKET_DROPSHIPPING,
                AppName.BULK_DISCOUNT_CODE_GENERATOR,
                AppName.STOCK_SYNC_QTY_UPDATE_BY_SKU,
                AppName.DSER_ALIEXPRESS_DROPSHIPPING,
                AppName.SMARTMAIL_EMAIL_MARKETING,
                AppName.CJDROPSHIPPING,
                AppName.CONVERSION_PLUS,
                AppName.SALE_KIT_BOOST_SALES_BUNDLE
        };
        return keywords;
    }

    //Get free Other Apps (List 1)
    public String searchFreeOtherAppsList1() {
        sleepInSecond(2);
        final String[] keywords = new String[]{
                AppName.SMART_MEGA_MENU_NAV,
                AppName.MULTI_IMPORTER,
                AppName.EXCELIFY,
                AppName.SHOPPING_FEED_FOR_GOOGLE,
                AppName.GDPR_CCPA_COOKIE_MANAGEMENT,
                AppName.REPLAY_LIVE_SESSION_RECORDINGS,
                AppName.SPOCKET_DROPSHIPPING,
                AppName.BULK_DISCOUNT_CODE_GENERATOR,
                AppName.STOCK_SYNC_QTY_UPDATE_BY_SKU,
                AppName.DSER_ALIEXPRESS_DROPSHIPPING,
                AppName.SMARTMAIL_EMAIL_MARKETING,
                AppName.CJDROPSHIPPING,
                AppName.CONVERSION_PLUS,
                AppName.SALE_KIT_BOOST_SALES_BUNDLE
        };
        Random random = new Random();
        int index = random.nextInt(keywords.length);
        return keywords[index];
    }

    //Get free Other Apps (List 2)
    public String[] getFreeOtherAppsList2() {
        final String[] keywords = new String[]{
                AppName.METAFIELDS_GURU,
                AppName.GDPR_COOKIE_BAR_EPRIVATE_PAGE,
                AppName.HYPERSKU,
                AppName.FREE_TRUST_BADGE,
                AppName.IN_CART_UPSELL_CROSS_SELL,
                AppName.CLICKSIT_RETURN_CENTER,
                AppName.BUY_ME_BUY_BUTTON,
                AppName.INSTAGRAM_FEED_STORIES,
                AppName.HELPCENTER_FAQ_HELPDESK,
                AppName.HONEYCOMB_UPSELL_CROSS_SELL,
                AppName.WISHLIST_PLUS,
                AppName.COZY_ANTITHEFT,
                AppName.PLUG_IN_SEO_OPTIMIZER,
                AppName.EASY_FAQ_FAST_FLEXIBLE,
                AppName.FREE_TRAFFIC_ADS_BY_VARINODE
        };
        return keywords;
    }

    //Get free Other Apps (List 2)
    public String searchFreeOtherAppsList2() {
        sleepInSecond(2);
        final String[] keywords = new String[]{
                AppName.METAFIELDS_GURU,
                AppName.GDPR_COOKIE_BAR_EPRIVATE_PAGE,
                AppName.HYPERSKU,
                AppName.FREE_TRUST_BADGE,
                AppName.IN_CART_UPSELL_CROSS_SELL,
                AppName.CLICKSIT_RETURN_CENTER,
                AppName.BUY_ME_BUY_BUTTON,
                AppName.INSTAGRAM_FEED_STORIES,
                AppName.HELPCENTER_FAQ_HELPDESK,
                AppName.HONEYCOMB_UPSELL_CROSS_SELL,
                AppName.WISHLIST_PLUS,
                AppName.COZY_ANTITHEFT,
                AppName.PLUG_IN_SEO_OPTIMIZER,
                AppName.EASY_FAQ_FAST_FLEXIBLE,
                AppName.FREE_TRAFFIC_ADS_BY_VARINODE
        };
        Random random = new Random();
        int index = random.nextInt(keywords.length);
        return keywords[index];
    }


    public void clickToDynamicButtons(String buttonText) {
        waitToElementClickable(InstallAppUI.DYNAMIC_BUTTONS, buttonText);
        clickToElement(InstallAppUI.DYNAMIC_BUTTONS, buttonText);
    }

    public void selectAppsMenu() {
        driver.getCurrentUrl();
        waitToElementClickable(ShopifyPageUI.APPS_MENU);
        clickToElement(ShopifyPageUI.APPS_MENU);
        sleepInSecond(5);
    }

    public void clickTodDiscountsMenu() {
        driver.getCurrentUrl();
        waitToElementClickable(ShopifyPageUI.DISCOUNTS_MENU);
        clickToElement(ShopifyPageUI.DISCOUNTS_MENU);
        sleepInSecond(5);
    }

    public void clickCreateDiscountCode() {
        waitToElementClickable(ShopifyPageUI.CREATE_DISCOUNT_BTN);
        clickToElement(ShopifyPageUI.CREATE_DISCOUNT_BTN);
        sleepInSecond(3);
    }

    public void inputKeywordCodeName(String keyword) {
        sleepInSecond(3);
        waitToElementVisible(ShopifyPageUI.DISCOUNT_CODE_TEXTBOX);
        sendKeyToElement(ShopifyPageUI.DISCOUNT_CODE_TEXTBOX, keyword);
    }

    public void inputKeywordCodeValue(String keyword) {
        sleepInSecond(3);
        waitToElementVisible(ShopifyPageUI.DISCOUNT_VALUE_TEXTBOX);
        sendKeyToElement(ShopifyPageUI.DISCOUNT_VALUE_TEXTBOX, keyword);
    }

    public String inputCodeName() {
        final String[] keywords = new String[]{"HOLIDAY", "BACK2SCHOOL", "FESTIVE", "SPRINGDEAL", "FREESHIP", "BOOST SALES", "WELCOME", "DISCOUNT",
                "GIFTGUIDE", "NEW ARRIVAL", "MYSTERY", "GIFT", "BIRTHDAY", "BESTSELLING", "DISTRIBUTE", "LIMITED", "HAPPYDAY", "LOVE", "FLASHDEAL", "VALENTINE",
                "FORMOM", "FORDAD", "DAYOFF", "HAPPYHOURS", "HAPPYWEEK"};
        Random random = new Random();
        int index = random.nextInt(keywords.length);
        return keywords[index];
    }

    public String inputDiscountValue() {
        final String[] keywords = new String[]{"5", "10", "15", "20", "8", "12", "17", "7", "25", "22", "13", "18"};
        Random random = new Random();
        int index = random.nextInt(keywords.length);
        return keywords[index];
    }

    public void checkToUsageLimits() {
        sleepInSecond(5);
        scrollPage();
        if (!isElementSelected(ShopifyPageUI.USAGE_LIMITS_CHECKBOX)) {
            clickToElement(ShopifyPageUI.USAGE_LIMITS_CHECKBOX);
        }
    }

    public void clickToSave() {
        sleepInSecond(3);
        waitToElementClickable(ShopifyPageUI.SAVE_PRODUCT_BTN);
        clickToElement(ShopifyPageUI.SAVE_PRODUCT_BTN);
        sleepInSecond(5);
    }

    public void clickToVisitShopifyAppStore() {
        waitToElementClickable(ShopifyPageUI.VISIT_SHOPIFY_APP_STORE_BTN);
        clickToElement(ShopifyPageUI.VISIT_SHOPIFY_APP_STORE_BTN);
        sleepInSecond(3);
    }

    public void clickToInstallApp() {
        sleepInSecond(5);
        scrollToEndOfPage();
        if (isElementPresentInDOM(InstallAppUI.DYNAMIC_BUTTONS, "Install app")) {
            waitToElementVisible(InstallAppUI.DYNAMIC_BUTTONS, "Install app");
            clickToDynamicButtons("Install app");
        } else {
            waitToElementVisible(InstallAppUI.DYNAMIC_BUTTONS, "Add sales channel");
            clickToDynamicButtons("Add sales channel");
        }
    }

    public void clickToLoadPageTwo() {
        String elementPage2 = "//div//a[@class='search-pagination__link' and text()='2']";
        waitToElementVisible(elementPage2);
        clickToElement(elementPage2);
    }

    public void clickToLoadPageThree() {
        String elementPage3= "//div//a[@class='search-pagination__link' and text()='3']";
        waitToElementVisible(elementPage3);
        clickToElement(elementPage3);
    }

    public void inputKeyword(String keyword) {
        sleepInSecond(3);
        switchToWindowsByTitle("Shopify App Store: Ecommerce App Marketplace");
        waitToElementVisible(ShopifyPageUI.SEARCH_APPS_TEXTBOX);
        sendKeyToElement(ShopifyPageUI.SEARCH_APPS_TEXTBOX, keyword);
    }

    //FREE OTHER APP - INSTALL OBERLO (LIST 1)
    public void selectFreeOtherAppAndOberloRandomByURL(String appName) {
        if (appName.equals(AppName.QUICK_ANNOUNCEMENT_BAR)
                && isElementPresentInDOM(ShopifyPageUI.URL_QUICK_ANNOUNCEMENT_BAR)) {
            waitToElementVisible(ShopifyPageUI.URL_QUICK_ANNOUNCEMENT_BAR);
            clickToElement(ShopifyPageUI.URL_QUICK_ANNOUNCEMENT_BAR);
            clickToAddApp();
            clickToInstallApp();
            System.out.println(AppName.QUICK_ANNOUNCEMENT_BAR);
        } else if (appName.equals(AppName.SNAPCHAT_ADS)
                && isElementPresentInDOM(ShopifyPageUI.URL_SNAPCHAT_ADS)) {
            waitToElementVisible(ShopifyPageUI.URL_SNAPCHAT_ADS);
            clickToElement(ShopifyPageUI.URL_SNAPCHAT_ADS);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.EMAIL_MARKETING_BY_AUTOMIZELY)
                && isElementPresentInDOM(ShopifyPageUI.URL_EMAIL_MARKETING_BY_AUTOMIZELY)) {
            waitToElementVisible(ShopifyPageUI.URL_EMAIL_MARKETING_BY_AUTOMIZELY);
            clickToElement(ShopifyPageUI.URL_EMAIL_MARKETING_BY_AUTOMIZELY);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.TRUST_ME_FREE_TRUST_BADGES)
                && isElementPresentInDOM(ShopifyPageUI.URL_TRUST_ME_FREE_TRUST_BADGES)) {
            waitToElementVisible(ShopifyPageUI.URL_TRUST_ME_FREE_TRUST_BADGES);
            clickToElement(ShopifyPageUI.URL_TRUST_ME_FREE_TRUST_BADGES);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.FACEBOOK_INSTAGRAM_AUTO_POST)
                && isElementPresentInDOM(ShopifyPageUI.URL_FACEBOOK_INSTAGRAM_AUTO_POST)) {
            waitToElementVisible(ShopifyPageUI.URL_FACEBOOK_INSTAGRAM_AUTO_POST);
            clickToElement(ShopifyPageUI.URL_FACEBOOK_INSTAGRAM_AUTO_POST);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.KEEP_CART)
                && isElementPresentInDOM(ShopifyPageUI.URL_KEEP_CART)) {
            waitToElementVisible(ShopifyPageUI.URL_KEEP_CART);
            clickToElement(ShopifyPageUI.URL_KEEP_CART);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.ZENDROP)
                && isElementPresentInDOM(ShopifyPageUI.URL_ZENDROP)) {
            waitToElementVisible(ShopifyPageUI.URL_ZENDROP);
            clickToElement(ShopifyPageUI.URL_ZENDROP);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.MAILERLITE_EMAIL_MARKETING)
                && isElementPresentInDOM(ShopifyPageUI.URL_MAILERLITE_EMAIL_MARKETING)) {
            waitToElementVisible(ShopifyPageUI.URL_MAILERLITE_EMAIL_MARKETING);
            clickToElement(ShopifyPageUI.URL_MAILERLITE_EMAIL_MARKETING);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.DYNAMIC_BANNER_SUITE)
                && isElementPresentInDOM(ShopifyPageUI.URL_DYNAMIC_BANNER_SUITE)) {
            waitToElementVisible(ShopifyPageUI.URL_DYNAMIC_BANNER_SUITE);
            clickToElement(ShopifyPageUI.URL_DYNAMIC_BANNER_SUITE);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.PHOTO_RESIZE)
                && isElementPresentInDOM(ShopifyPageUI.URL_PHOTO_RESIZE)) {
            waitToElementVisible(ShopifyPageUI.URL_PHOTO_RESIZE);
            clickToElement(ShopifyPageUI.URL_PHOTO_RESIZE);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.EZYSLIPS_SHIPPING_RETURN)
                && isElementPresentInDOM(ShopifyPageUI.URL_EZYSLIPS_SHIPPING_RETURN)) {
            waitToElementVisible(ShopifyPageUI.URL_EZYSLIPS_SHIPPING_RETURN);
            clickToElement(ShopifyPageUI.URL_EZYSLIPS_SHIPPING_RETURN);
            clickToAddApp();
            clickToInstallApp();
        } else {
            waitToElementVisible(ShopifyPageUI.URL_DRAG_DROP_PDF_INVOICE);
            clickToElement(ShopifyPageUI.URL_DRAG_DROP_PDF_INVOICE);
            clickToAddApp();
            clickToInstallApp();
        }
    }

    //FREE OTHER APP - INSTALL OBERLO (LIST 2)
    public void selectFreeOtherAppAndOberloRandomByURL2(String appName) {
        if (appName.equals(AppName.OMNISEND_EMAIL_MARKETING)
                && isElementPresentInDOM(ShopifyPageUI.URL_OMNISEND_EMAIL_MARKETING)) {
            waitToElementVisible(ShopifyPageUI.URL_OMNISEND_EMAIL_MARKETING);
            clickToElement(ShopifyPageUI.URL_OMNISEND_EMAIL_MARKETING);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.BACK_INSTOCK_RESTOCK_ALERTS)
                && isElementPresentInDOM(ShopifyPageUI.URL_BACK_INSTOCK_RESTOCK_ALERTS)) {
            waitToElementVisible(ShopifyPageUI.URL_BACK_INSTOCK_RESTOCK_ALERTS);
            clickToElement(ShopifyPageUI.URL_BACK_INSTOCK_RESTOCK_ALERTS);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.DATA_EXPORT_REPORTS)
                && isElementPresentInDOM(ShopifyPageUI.URL_DATA_EXPORT_REPORTS)) {
            waitToElementVisible(ShopifyPageUI.URL_DATA_EXPORT_REPORTS);
            clickToElement(ShopifyPageUI.URL_DATA_EXPORT_REPORTS);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.EPROLO_DROPSHIPPING_AND_BRANDING)
                && isElementPresentInDOM(ShopifyPageUI.URL_EPROLO_DROPSHIPPING_BRANDING)) {
            waitToElementVisible(ShopifyPageUI.URL_EPROLO_DROPSHIPPING_BRANDING);
            clickToElement(ShopifyPageUI.URL_EPROLO_DROPSHIPPING_BRANDING);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.ZOORIX_UPSELL_CORSS_SELL)
                && isElementPresentInDOM(ShopifyPageUI.URL_ZOORIX_UPSELL_CROSS_SELL)) {
            waitToElementVisible(ShopifyPageUI.URL_ZOORIX_UPSELL_CROSS_SELL);
            clickToElement(ShopifyPageUI.URL_ZOORIX_UPSELL_CROSS_SELL);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.FONTIFY_USE_ANY_FONT)
                && isElementPresentInDOM(ShopifyPageUI.URL_FONTIFY_USE_ANY_FONT)) {
            waitToElementVisible(ShopifyPageUI.URL_FONTIFY_USE_ANY_FONT);
            clickToElement(ShopifyPageUI.URL_FONTIFY_USE_ANY_FONT);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.KIWI_SIZE_CHART_RECOMMENDER)
                && isElementPresentInDOM(ShopifyPageUI.URL_KIWI_SIZE_CHART_RECOMMENDER)) {
            waitToElementVisible(ShopifyPageUI.URL_KIWI_SIZE_CHART_RECOMMENDER);
            clickToElement(ShopifyPageUI.URL_KIWI_SIZE_CHART_RECOMMENDER);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.AFTERSHIP_RETURNS_CENTER)
                && isElementPresentInDOM(ShopifyPageUI.URL_AFTERSHIP_RETURNS_CENTER)) {
            waitToElementVisible(ShopifyPageUI.URL_AFTERSHIP_RETURNS_CENTER);
            clickToElement(ShopifyPageUI.URL_AFTERSHIP_RETURNS_CENTER);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.SIMPLIO_SIMPLE_INVOICE)
                && isElementPresentInDOM(ShopifyPageUI.URL_SIMPLIO_SIMPLE_INVOICE)) {
            waitToElementVisible(ShopifyPageUI.URL_SIMPLIO_SIMPLE_INVOICE);
            clickToElement(ShopifyPageUI.URL_SIMPLIO_SIMPLE_INVOICE);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.QUANLITY_BREAK_DISCOUNTS)
                && isElementPresentInDOM(ShopifyPageUI.URL_QUANLITY_BREAK_DISCOUNTS)) {
            waitToElementVisible(ShopifyPageUI.URL_QUANLITY_BREAK_DISCOUNTS);
            clickToElement(ShopifyPageUI.URL_QUANLITY_BREAK_DISCOUNTS);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.URGENCY_BEAR_COUNTDOWN_TIMER)
                && isElementPresentInDOM(ShopifyPageUI.URL_URGENCY_BEAR_COUNTDOWN_TIMER)) {
            waitToElementVisible(ShopifyPageUI.URL_URGENCY_BEAR_COUNTDOWN_TIMER);
            clickToElement(ShopifyPageUI.URL_URGENCY_BEAR_COUNTDOWN_TIMER);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.INSTANT_TRAFFIC_ADS)
                && isElementPresentInDOM(ShopifyPageUI.URL_INSTANT_TRAFFIC_ADS)) {
            waitToElementVisible(ShopifyPageUI.URL_INSTANT_TRAFFIC_ADS);
            clickToElement(ShopifyPageUI.URL_INSTANT_TRAFFIC_ADS);
            clickToAddApp();
            clickToInstallApp();
        } else {
            waitToElementVisible(ShopifyPageUI.URL_CUSTOM_FIELDS);
            clickToElement(ShopifyPageUI.URL_CUSTOM_FIELDS);
            clickToAddApp();
            clickToInstallApp();
        }
    }

    //FREE OTHER APP (LIST 1)
    public void selectFreeOtherAppRandomByURL(String appName) {
        if (appName.equals(AppName.MULTI_IMPORTER)
                && isElementPresentInDOM(ShopifyPageUI.URL_MULTI_IMPORTER_APP_IN_APPSTORE)) {
            waitToElementVisible(ShopifyPageUI.URL_MULTI_IMPORTER_APP_IN_APPSTORE);
            clickToElement(ShopifyPageUI.URL_MULTI_IMPORTER_APP_IN_APPSTORE);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.SPOCKET_DROPSHIPPING)
                && isElementPresentInDOM(ShopifyPageUI.URL_SPOCKET_DROPSHIPPING_APP_IN_APPSTORE)) {
            waitToElementVisible(ShopifyPageUI.URL_SPOCKET_DROPSHIPPING_APP_IN_APPSTORE);
            clickToElement(ShopifyPageUI.URL_SPOCKET_DROPSHIPPING_APP_IN_APPSTORE);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.DSER_ALIEXPRESS_DROPSHIPPING)
                && isElementPresentInDOM(ShopifyPageUI.URL_DSER_ALIEXPRESS_DROPSHIPPING_APP_IN_APPSTORE)) {
            waitToElementVisible(ShopifyPageUI.URL_DSER_ALIEXPRESS_DROPSHIPPING_APP_IN_APPSTORE);
            clickToElement(ShopifyPageUI.URL_DSER_ALIEXPRESS_DROPSHIPPING_APP_IN_APPSTORE);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.CJDROPSHIPPING)
                && isElementPresentInDOM(ShopifyPageUI.URL_CJDROPSHIPPING)) {
            waitToElementVisible(ShopifyPageUI.URL_CJDROPSHIPPING);
            clickToElement(ShopifyPageUI.URL_CJDROPSHIPPING);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.REPLAY_LIVE_SESSION_RECORDINGS)
                && isElementPresentInDOM(ShopifyPageUI.URL_REPLAY_LIVE_SESSION_RECORDINGS)) {
            waitToElementVisible(ShopifyPageUI.URL_REPLAY_LIVE_SESSION_RECORDINGS);
            clickToElement(ShopifyPageUI.URL_REPLAY_LIVE_SESSION_RECORDINGS);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.SALE_KIT_BOOST_SALES_BUNDLE)
                && isElementPresentInDOM(ShopifyPageUI.URL_SALE_KIT_BOOST_SALES_BUNDLE)) {
            waitToElementVisible(ShopifyPageUI.URL_SALE_KIT_BOOST_SALES_BUNDLE);
            clickToElement(ShopifyPageUI.URL_SALE_KIT_BOOST_SALES_BUNDLE);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.SMARTMAIL_EMAIL_MARKETING)
                && isElementPresentInDOM(ShopifyPageUI.URL_SMARTMAIL_EMAIL_MARKETING)) {
            waitToElementVisible(ShopifyPageUI.URL_SMARTMAIL_EMAIL_MARKETING);
            clickToElement(ShopifyPageUI.URL_SMARTMAIL_EMAIL_MARKETING);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.GDPR_CCPA_COOKIE_MANAGEMENT)
                && isElementPresentInDOM(ShopifyPageUI.URL_GDPR_CCPA_COOKIE_MANAGEMENT)) {
            waitToElementVisible(ShopifyPageUI.URL_GDPR_CCPA_COOKIE_MANAGEMENT);
            clickToElement(ShopifyPageUI.URL_GDPR_CCPA_COOKIE_MANAGEMENT);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.BULK_DISCOUNT_CODE_GENERATOR)
                && isElementPresentInDOM(ShopifyPageUI.URL_BULK_DISCOUNT_CODE_GENERATOR)) {
            waitToElementVisible(ShopifyPageUI.URL_BULK_DISCOUNT_CODE_GENERATOR);
            clickToElement(ShopifyPageUI.URL_BULK_DISCOUNT_CODE_GENERATOR);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.EXCELIFY)
                && isElementPresentInDOM(ShopifyPageUI.URL_EXCELIFY)) {
            waitToElementVisible(ShopifyPageUI.URL_EXCELIFY);
            clickToElement(ShopifyPageUI.URL_EXCELIFY);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.SHOPPING_FEED_FOR_GOOGLE)
                && isElementPresentInDOM(ShopifyPageUI.URL_SHOPPING_FEED_FOR_GOOGLE)) {
            waitToElementVisible(ShopifyPageUI.URL_SHOPPING_FEED_FOR_GOOGLE);
            clickToElement(ShopifyPageUI.URL_SHOPPING_FEED_FOR_GOOGLE);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.SMART_MEGA_MENU_NAV)
                && isElementPresentInDOM(ShopifyPageUI.URL_SMART_MEGA_MENU_NAV)) {
            waitToElementVisible(ShopifyPageUI.URL_SMART_MEGA_MENU_NAV);
            clickToElement(ShopifyPageUI.URL_SMART_MEGA_MENU_NAV);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.STOCK_SYNC_QTY_UPDATE_BY_SKU)
                && isElementPresentInDOM(ShopifyPageUI.URL_STOCK_SYNC_QTY_UPDATE_BY_SKU)) {
            waitToElementVisible(ShopifyPageUI.URL_STOCK_SYNC_QTY_UPDATE_BY_SKU);
            clickToElement(ShopifyPageUI.URL_STOCK_SYNC_QTY_UPDATE_BY_SKU);
            clickToAddApp();
            clickToInstallApp();
        } else {
            waitToElementVisible(ShopifyPageUI.URL_CONVERSION_PLUS);
            clickToElement(ShopifyPageUI.URL_CONVERSION_PLUS);
            clickToAddApp();
            clickToInstallApp();
        }
    }

    //FREE OTHER APP (LIST 2)
    public void selectFreeOtherAppRandomByURL2(String appName) {
        if (appName.equals(AppName.COZY_ANTITHEFT)
                && isElementPresentInDOM(ShopifyPageUI.URL_COZY_ANTITHEFT)) {
            waitToElementVisible(ShopifyPageUI.URL_COZY_ANTITHEFT);
            clickToElement(ShopifyPageUI.URL_COZY_ANTITHEFT);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.BUY_ME_BUY_BUTTON)
                && isElementPresentInDOM(ShopifyPageUI.URL_BUY_ME_BUY_BUTTON)) {
            waitToElementVisible(ShopifyPageUI.URL_BUY_ME_BUY_BUTTON);
            clickToElement(ShopifyPageUI.URL_BUY_ME_BUY_BUTTON);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.HELPCENTER_FAQ_HELPDESK)
                && isElementPresentInDOM(ShopifyPageUI.URL_HELPCENTER_FAQ_HELPDESK)) {
            waitToElementVisible(ShopifyPageUI.URL_HELPCENTER_FAQ_HELPDESK);
            clickToElement(ShopifyPageUI.URL_HELPCENTER_FAQ_HELPDESK);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.FREE_TRUST_BADGE)
                && isElementPresentInDOM(ShopifyPageUI.URL_FREE_TRUST_BADGE)) {
            waitToElementVisible(ShopifyPageUI.URL_FREE_TRUST_BADGE);
            clickToElement(ShopifyPageUI.URL_FREE_TRUST_BADGE);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.HONEYCOMB_UPSELL_CROSS_SELL)
                && isElementPresentInDOM(ShopifyPageUI.URL_HONEYCOMB_UPSELL_CROSS_SELL)) {
            waitToElementVisible(ShopifyPageUI.URL_HONEYCOMB_UPSELL_CROSS_SELL);
            clickToElement(ShopifyPageUI.URL_HONEYCOMB_UPSELL_CROSS_SELL);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.WISHLIST_PLUS)
                && isElementPresentInDOM(ShopifyPageUI.URL_WISHLIST_PLUS)) {
            waitToElementVisible(ShopifyPageUI.URL_WISHLIST_PLUS);
            clickToElement(ShopifyPageUI.URL_WISHLIST_PLUS);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.INSTAGRAM_FEED_STORIES)
                && isElementPresentInDOM(ShopifyPageUI.URL_INSTAGRAM_FEED_STORIES)) {
            waitToElementVisible(ShopifyPageUI.URL_INSTAGRAM_FEED_STORIES);
            clickToElement(ShopifyPageUI.URL_INSTAGRAM_FEED_STORIES);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.PLUG_IN_SEO_OPTIMIZER)
                && isElementPresentInDOM(ShopifyPageUI.URL_PLUG_IN_SEO_OPTIMIZER)) {
            waitToElementVisible(ShopifyPageUI.URL_PLUG_IN_SEO_OPTIMIZER);
            clickToElement(ShopifyPageUI.URL_PLUG_IN_SEO_OPTIMIZER);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.EASY_FAQ_FAST_FLEXIBLE)
                && isElementPresentInDOM(ShopifyPageUI.URL_EASY_FAQ_FAST_FLEXIBLE)) {
            waitToElementVisible(ShopifyPageUI.URL_EASY_FAQ_FAST_FLEXIBLE);
            clickToElement(ShopifyPageUI.URL_EASY_FAQ_FAST_FLEXIBLE);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.METAFIELDS_GURU)
                && isElementPresentInDOM(ShopifyPageUI.URL_METAFIELDS_GURU)) {
            waitToElementVisible(ShopifyPageUI.URL_METAFIELDS_GURU);
            clickToElement(ShopifyPageUI.URL_METAFIELDS_GURU);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.IN_CART_UPSELL_CROSS_SELL)
                && isElementPresentInDOM(ShopifyPageUI.URL_IN_CART_UPSELL_CROSS_SELL)) {
            waitToElementVisible(ShopifyPageUI.URL_IN_CART_UPSELL_CROSS_SELL);
            clickToElement(ShopifyPageUI.URL_IN_CART_UPSELL_CROSS_SELL);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.HYPERSKU)
                && isElementPresentInDOM(ShopifyPageUI.URL_HYPERSKU)) {
            waitToElementVisible(ShopifyPageUI.URL_HYPERSKU);
            clickToElement(ShopifyPageUI.URL_HYPERSKU);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.GDPR_COOKIE_BAR_EPRIVATE_PAGE)
                && isElementPresentInDOM(ShopifyPageUI.URL_GDPR_COOKIE_BAR_EPRIVATE_PAGE)) {
            waitToElementVisible(ShopifyPageUI.URL_GDPR_COOKIE_BAR_EPRIVATE_PAGE);
            clickToElement(ShopifyPageUI.URL_GDPR_COOKIE_BAR_EPRIVATE_PAGE);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.CLICKSIT_RETURN_CENTER)
                && isElementPresentInDOM(ShopifyPageUI.URL_CLICKSIT_RETURN_CENTER)) {
            waitToElementVisible(ShopifyPageUI.URL_CLICKSIT_RETURN_CENTER);
            clickToElement(ShopifyPageUI.URL_CLICKSIT_RETURN_CENTER);
            clickToAddApp();
            clickToInstallApp();
        } else {
            waitToElementVisible(ShopifyPageUI.URL_FREE_TRFFIC_ADS_BY_VARINODE);
            clickToElement(ShopifyPageUI.URL_FREE_TRFFIC_ADS_BY_VARINODE);
            clickToAddApp();
            clickToInstallApp();
        }
    }

    public void inputKeywordWhenNoResult(String keyword) {
        sleepInSecond(3);
        switchToWindowsByTitle("Shopify App Store: Ecommerce App Marketplace");
        waitToElementVisible(ShopifyPageUI.SEARCH_BTN_SHOPIFY_APP_STORE_BTN);
        sendKeyToElement(ShopifyPageUI.SEARCH_APP_TEXTBOX, keyword);
        sleepInSecond(5);
        waitToElementVisible(ShopifyPageUI.SEARCH_BTN_SHOPIFY_APP_STORE_BTN);
        clickToElement(ShopifyPageUI.SEARCH_BTN_SHOPIFY_APP_STORE_BTN);
    }

    //Free Shopify Apps
    public void selectFreeShopifyAppRandom(String appName) {
        if (appName.equals(AppName.PRODUCT_REVIEW)
                && isElementPresentInDOM(ShopifyPageUI.PRODUCT_REVIEW_APP_IN_APPSTORE)) {
            waitToElementVisible(ShopifyPageUI.PRODUCT_REVIEW_APP_IN_APPSTORE);
            clickToElement(ShopifyPageUI.PRODUCT_REVIEW_APP_IN_APPSTORE);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.KIT)
                && isElementPresentInDOM(ShopifyPageUI.KIT_APP_IN_APPSTORE)) {
            waitToElementVisible(ShopifyPageUI.KIT_APP_IN_APPSTORE);
            clickToElement(ShopifyPageUI.KIT_APP_IN_APPSTORE);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.GOOGLE_CHANEL)
                && isElementPresentInDOM(ShopifyPageUI.GOOGLE_CHANNEL_APP_IN_APPSTORE)) {
            waitToElementVisible(ShopifyPageUI.GOOGLE_CHANNEL_APP_IN_APPSTORE);
            clickToElement(ShopifyPageUI.GOOGLE_CHANNEL_APP_IN_APPSTORE);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.SHOPIFY_EMAIL)
                && isElementPresentInDOM(ShopifyPageUI.SHOPIFY_EMAIL_APP_IN_APPSTORE)) {
            waitToElementVisible(ShopifyPageUI.SHOPIFY_EMAIL_APP_IN_APPSTORE);
            clickToElement(ShopifyPageUI.SHOPIFY_EMAIL_APP_IN_APPSTORE);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.FACEBOOK_CHANNEL)
                && isElementPresentInDOM(ShopifyPageUI.FACEBOOK_CHANNEL_APP_IN_APPSTORE)) {
            waitToElementVisible(ShopifyPageUI.FACEBOOK_CHANNEL_APP_IN_APPSTORE);
            clickToElement(ShopifyPageUI.FACEBOOK_CHANNEL_APP_IN_APPSTORE);
            clickToAddApp();
            clickToInstallApp();
        } else if (appName.equals(AppName.GEOLOCATION)
                && isElementPresentInDOM(ShopifyPageUI.GEOLOCATION_IN_APPSTORE)) {
            waitToElementVisible(ShopifyPageUI.GEOLOCATION_IN_APPSTORE);
            clickToElement(ShopifyPageUI.GEOLOCATION_IN_APPSTORE);
            clickToAddApp();
            clickToInstallApp();
        } else {

        }
    }



    //Free Other Apps (List 1)
    /*public void selectFreeOtherAppRandom() {
        if (isElementPresentInDOM(ShopifyPageUI.CONTACT_FORM_BUILDER_FREE)) {
            waitToElementVisible(ShopifyPageUI.CONTACT_FORM_BUILDER_FREE);
            clickToElement(ShopifyPageUI.CONTACT_FORM_BUILDER_FREE);
            clickToAddApp();
            clickToInstallApp();
        } else if (isElementPresentInDOM(ShopifyPageUI.MULTI_ANNOUNCEMENT_BAR_TIMER)) {
            waitToElementVisible(ShopifyPageUI.MULTI_ANNOUNCEMENT_BAR_TIMER);
            clickToElement(ShopifyPageUI.MULTI_ANNOUNCEMENT_BAR_TIMER);
            clickToAddApp();
            clickToInstallApp();
        } else if (isElementPresentInDOM(ShopifyPageUI.SEARCH_PRODUCT_FILTER)) {
            waitToElementVisible(ShopifyPageUI.SEARCH_PRODUCT_FILTER);
            clickToElement(ShopifyPageUI.SEARCH_PRODUCT_FILTER);
            clickToAddApp();
            clickToInstallApp();
        } else if (isElementPresentInDOM(ShopifyPageUI.ULTIMATE_GDPR_EU_COOKIE_BANNER)) {
            waitToElementVisible(ShopifyPageUI.ULTIMATE_GDPR_EU_COOKIE_BANNER);
            clickToElement(ShopifyPageUI.ULTIMATE_GDPR_EU_COOKIE_BANNER);
            clickToAddApp();
            clickToInstallApp();
        } else if (isElementPresentInDOM(ShopifyPageUI.AVADA_SIZE_CHART_FREE)) {
            waitToElementVisible(ShopifyPageUI.AVADA_SIZE_CHART_FREE);
            clickToElement(ShopifyPageUI.AVADA_SIZE_CHART_FREE);
            clickToAddApp();
            clickToInstallApp();
        } else if (isElementPresentInDOM(ShopifyPageUI.URGENCY_PACK_ULTIMATE)) {
            waitToElementVisible(ShopifyPageUI.URGENCY_PACK_ULTIMATE);
            clickToElement(ShopifyPageUI.URGENCY_PACK_ULTIMATE);
            clickToAddApp();
            clickToInstallApp();
        } else if (isElementPresentInDOM(ShopifyPageUI.POPUP_EMAIL_EXIIT_POPUPS)) {
            waitToElementVisible(ShopifyPageUI.POPUP_EMAIL_EXIIT_POPUPS);
            clickToElement(ShopifyPageUI.POPUP_EMAIL_EXIIT_POPUPS);
            clickToAddApp();
            clickToInstallApp();
        } else if (isElementPresentInDOM(ShopifyPageUI.EASY_GDPR_COOKIE_BAR)) {
            waitToElementVisible(ShopifyPageUI.EASY_GDPR_COOKIE_BAR);
            clickToElement(ShopifyPageUI.EASY_GDPR_COOKIE_BAR);
            clickToAddApp();
            clickToInstallApp();
        } else if (isElementPresentInDOM(ShopifyPageUI.THANK_YOU_EMAIL_MARKETING_TOOL)) {
            waitToElementVisible(ShopifyPageUI.THANK_YOU_EMAIL_MARKETING_TOOL);
            clickToElement(ShopifyPageUI.THANK_YOU_EMAIL_MARKETING_TOOL);
            clickToAddApp();
            clickToInstallApp();
        } else if (isElementPresentInDOM(ShopifyPageUI.MASSFULFILL)) {
            waitToElementVisible(ShopifyPageUI.MASSFULFILL);
            clickToElement(ShopifyPageUI.MASSFULFILL);
            clickToAddApp();
            clickToInstallApp();
        } else {

        }
    }*/

    //Free Other Apps (List 2)
    /*public void selectFreeOtherAppRandom2() {
        if (isElementPresentInDOM(ShopifyPageUI.SPIN_WHEEL_POP_UPS_EMAIL_POPUP)) {
            waitToElementVisible(ShopifyPageUI.SPIN_WHEEL_POP_UPS_EMAIL_POPUP);
            clickToElement(ShopifyPageUI.SPIN_WHEEL_POP_UPS_EMAIL_POPUP);
            clickToAddApp();
            clickToInstallApp();
        } else if (isElementPresentInDOM(ShopifyPageUI.VIDEO_AD_MACHINE)) {
            waitToElementVisible(ShopifyPageUI.VIDEO_AD_MACHINE);
            clickToElement(ShopifyPageUI.VIDEO_AD_MACHINE);
            clickToAddApp();
            clickToInstallApp();
        } else if (isElementPresentInDOM(ShopifyPageUI.MULTI_PIXELS_FOR_FACEBOOK)) {
            waitToElementVisible(ShopifyPageUI.MULTI_PIXELS_FOR_FACEBOOK);
            clickToElement(ShopifyPageUI.MULTI_PIXELS_FOR_FACEBOOK);
            clickToAddApp();
            clickToInstallApp();
        } else if (isElementPresentInDOM(ShopifyPageUI.ULTIMATE_TRUST_BADGES_FREE)) {
            waitToElementVisible(ShopifyPageUI.ULTIMATE_TRUST_BADGES_FREE);
            clickToElement(ShopifyPageUI.ULTIMATE_TRUST_BADGES_FREE);
            clickToAddApp();
            clickToInstallApp();
        } else if (isElementPresentInDOM(ShopifyPageUI.SMART_PUSH_MARKETING_WEBPUSH)) {
            waitToElementVisible(ShopifyPageUI.SMART_PUSH_MARKETING_WEBPUSH);
            clickToElement(ShopifyPageUI.SMART_PUSH_MARKETING_WEBPUSH);
            clickToAddApp();
            clickToInstallApp();
        } else if (isElementPresentInDOM(ShopifyPageUI.FORM_BUILDER_WITH_FILE_UPLOAD)) {
            waitToElementVisible(ShopifyPageUI.FORM_BUILDER_WITH_FILE_UPLOAD);
            clickToElement(ShopifyPageUI.FORM_BUILDER_WITH_FILE_UPLOAD);
            clickToAddApp();
            clickToInstallApp();
        } else if (isElementPresentInDOM(ShopifyPageUI.STORE_IMPORTER)) {
            waitToElementVisible(ShopifyPageUI.STORE_IMPORTER);
            clickToElement(ShopifyPageUI.STORE_IMPORTER);
            clickToAddApp();
            clickToInstallApp();
        } else if (isElementPresentInDOM(ShopifyPageUI.BULK_DISCOUNTS_NOW)) {
            waitToElementVisible(ShopifyPageUI.BULK_DISCOUNTS_NOW);
            clickToElement(ShopifyPageUI.BULK_DISCOUNTS_NOW);
            clickToAddApp();
            clickToInstallApp();
        } else if (isElementPresentInDOM(ShopifyPageUI.COUNTDOWN_ANNOUNCEMENT_BAR)) {
            waitToElementVisible(ShopifyPageUI.COUNTDOWN_ANNOUNCEMENT_BAR);
            clickToElement(ShopifyPageUI.COUNTDOWN_ANNOUNCEMENT_BAR);
            clickToAddApp();
            clickToInstallApp();
        } else if (isElementPresentInDOM(ShopifyPageUI.PUSHDADDY_COUNTDOWN_TIMER)) {
            waitToElementVisible(ShopifyPageUI.PUSHDADDY_COUNTDOWN_TIMER);
            clickToElement(ShopifyPageUI.PUSHDADDY_COUNTDOWN_TIMER);
            clickToAddApp();
            clickToInstallApp();
        } else if (isElementPresentInDOM(ShopifyPageUI.WHATSAPP_CHAT_CART_RECOVERY)) {
            waitToElementVisible(ShopifyPageUI.WHATSAPP_CHAT_CART_RECOVERY);
            clickToElement(ShopifyPageUI.WHATSAPP_CHAT_CART_RECOVERY);
            clickToAddApp();
            clickToInstallApp();
        } else {

        }
    }*/


    public void clickToAddApp() {
        waitToElementClickable(ShopifyPageUI.ADD_APP_BTN);
        clickToElement(ShopifyPageUI.ADD_APP_BTN);
        sleepInSecond(3);
    }

    public void clickToSearchBtn() {
        sleepInSecond(5);
        waitToElementVisible(ShopifyPageUI.SEARCH_BTN);
        clickToElement(ShopifyPageUI.SEARCH_BTN);
    }

    public void sWitchTab() {
        sleepInSecond(5);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        sleepInSecond(3);
    }

    //random delay 30s- 80s
    public void sleepRandomly() {
        try {
            Thread.sleep(getMillis());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static long getMillis() {
        return (long) (Math.random() * 10_000 + 30_000);
    }

    public void chooseAccount() {
        sleepInSecond(2);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        isElementPresentInDOM(ShopifyPageUI.CHOOSE_ACCOUNT_SELECT);
        waitToElementVisible(ShopifyPageUI.CHOOSE_ACCOUNT_SELECT);
        clickToElement(ShopifyPageUI.CHOOSE_ACCOUNT_SELECT);
    }

    public void switchTabChooseAccount() {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    public void switchToFirstWindow() {
        Set<String> handlesSet = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<String>(handlesSet);
        //driver.switchTo().window(handlesList.get(1));
        //driver.close();
        driver.switchTo().window(handlesList.get(0));
    }

    public void closeTabToTheRight() {
        String originalHandle = driver.getWindowHandle();
        //Do something to open new tabs
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.switchTo().window(originalHandle);
    }

    public void searchAppInShopifyAppStore() {
        sleepInSecond(3);
        waitToElementClickable(ShopifyPageUI.SEARCH_SHOPIFY_APP_STORE_BTN);
        clickToElement(ShopifyPageUI.SEARCH_SHOPIFY_APP_STORE_BTN);
    }

    class AppName {
        //FREE SHOPIFY APP
        public static final String FACEBOOK_CHANNEL = "Facebook Channel";
        public static final String PRODUCT_REVIEW = "Product Reviews";
        public static final String GOOGLE_CHANEL = "Google Channel";
        public static final String KIT = "Kit";
        public static final String SHOPIFY_EMAIL = "Shopify Email";
        public static final String GEOLOCATION = "Geolocation";

        //FREE OTHER APP NAMES - OBERLO (LIST 1)
        public static final String QUICK_ANNOUNCEMENT_BAR = "Quick Announcement Bar";
        public static final String SNAPCHAT_ADS = "Snapchat Ads";
        public static final String EMAIL_MARKETING_BY_AUTOMIZELY = "Email Marketing by Automizely";
        public static final String TRUST_ME_FREE_TRUST_BADGES = "Trust Me Free Trust Badges";
        public static final String FACEBOOK_INSTAGRAM_AUTO_POST = "Facebook Instagram Auto Post";
        public static final String KEEP_CART = "Keep Cart";
        public static final String ZENDROP = "Zendrop";
        public static final String MAILERLITE_EMAIL_MARKETING = "MailerLite Email Marketing";
        public static final String DYNAMIC_BANNER_SUITE = "Dynamic Banner Suite";
        public static final String PHOTO_RESIZE = "Photo Resize";
        public static final String EZYSLIPS_SHIPPING_RETURN = "EzySlips Shipping Returns";
        public static final String DRAG_DROP_PDF_INVOICE = "Drag Drop PDF Invoice";

        //FREE OTHER APP NAMES - OBERLO (LIST 2)
        public static final String OMNISEND_EMAIL_MARKETING = "Omnisend Email Marketing";
        public static final String BACK_INSTOCK_RESTOCK_ALERTS = "Back In Stock Restock Alerts";
        public static final String DATA_EXPORT_REPORTS = "Data Export Reports";
        public static final String EPROLO_DROPSHIPPING_AND_BRANDING = "EPROLO Dropshipping Branding";
        public static final String ZOORIX_UPSELL_CORSS_SELL = "Zoorix Upsell Cross Sell";
        public static final String FONTIFY_USE_ANY_FONT = "Fontify Use Any Font";
        public static final String KIWI_SIZE_CHART_RECOMMENDER = "Kiwi Size Chart & Recommender";
        public static final String AFTERSHIP_RETURNS_CENTER = "AfterShip Returns Center";
        public static final String SIMPLIO_SIMPLE_INVOICE = "Simplio Simple Invoice";
        public static final String QUANLITY_BREAK_DISCOUNTS = "Quantity Breaks Discounts";
        public static final String URGENCY_BEAR_COUNTDOWN_TIMER = "Urgency Bear Countdown Timer";
        public static final String INSTANT_TRAFFIC_ADS = "Instant Traffic Ads";
        public static final String CUSTOM_FIELDS = "Custom Fields";

        //FREE OTHER APP NAMES (LIST 1)
        public static final String MULTI_IMPORTER = "Multichannel Importer";
        public static final String SPOCKET_DROPSHIPPING = "Spocket Dropshipping";
        public static final String DSER_ALIEXPRESS_DROPSHIPPING = "Dser Aliexpress dropshipping";
        public static final String CJDROPSHIPPING = "CJDropshipping";
        public static final String REPLAY_LIVE_SESSION_RECORDINGS = "Replay Live Session Recordings by CartKit";
        public static final String SALE_KIT_BOOST_SALES_BUNDLE = "Sale Kit Boost sales bundle";
        public static final String SMARTMAIL_EMAIL_MARKETING = "SmartrMail Email Marketing";
        public static final String GDPR_CCPA_COOKIE_MANAGEMENT = "GDPR CCPA Cookie Management";
        public static final String BULK_DISCOUNT_CODE_GENERATOR = "Bulk Discount Code Generator";
        public static final String EXCELIFY = "Excelify";
        public static final String SHOPPING_FEED_FOR_GOOGLE = "Shopping Feed for Google";
        public static final String SMART_MEGA_MENU_NAV = "Smart Mega Menu Navigation";
        public static final String STOCK_SYNC_QTY_UPDATE_BY_SKU = "Stock Sync Qty update by SKU";
        public static final String CONVERSION_PLUS = "Conversion Plus";

        //FREE OTHER APP NAMES (LIST 2)
        public static final String COZY_ANTITHEFT = "Cozy AntiTheft";
        public static final String FREE_TRUST_BADGE = "Free Trust Badge by ShopClimb";
        public static final String BUY_ME_BUY_BUTTON = "Buy Me Buy Button";
        public static final String HELPCENTER_FAQ_HELPDESK = "HelpCenter FAQ HelpDesk";
        public static final String HONEYCOMB_UPSELL_CROSS_SELL = "Honeycomb Upsell Cross Sell";
        public static final String WISHLIST_PLUS = "Wishlist Plus";
        public static final String INSTAGRAM_FEED_STORIES = "Instagram Feed Stories";
        public static final String PLUG_IN_SEO_OPTIMIZER = "Plug in SEO Optimizer";
        public static final String EASY_FAQ_FAST_FLEXIBLE = "Easy FAQ Fast Flexible";
        public static final String METAFIELDS_GURU = "Metafields Guru";
        public static final String IN_CART_UPSELL_CROSS_SELL = "In Cart Upsell Cross Sell";
        public static final String HYPERSKU = "HyperSKU";
        public static final String GDPR_COOKIE_BAR_EPRIVATE_PAGE = "GDPR Cookie Bar ePrivacy Page";
        public static final String CLICKSIT_RETURN_CENTER = "Clicksit Return Center";
        public static final String FREE_TRAFFIC_ADS_BY_VARINODE = "Traffic Ads by Varinode";

    }
}
