package pageObject;

import commons.*;
import org.openqa.selenium.WebDriver;
import pageUI.InstallAppUI;
import pageUI.ShopifyPageUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class TranscyPO extends AbstractPage {
    WebDriver driver;
    ReadDataCSV readDataCSV = new ReadDataCSV();
    AbstractTest abstractTest = new AbstractTest();
    boolean isInstalledApp;

    public TranscyPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputStoreURL(String storeURL) {
        waitToElementVisible(InstallAppUI.STORE_NAME_TEXTBOX);
        sendKeyToElement(InstallAppUI.STORE_NAME_TEXTBOX, storeURL);
    }

    public void clickToLoginButton() {
        waitToElementClickable(InstallAppUI.LOGIN_BUTTON);
        clickToElement(InstallAppUI.LOGIN_BUTTON);
    }

    public void clickToLoginToAnotherAccount() {
        waitToElementClickable(InstallAppUI.LOGIN_TO_ANOTHER_ACCOUNT);
        clickToElement(InstallAppUI.LOGIN_TO_ANOTHER_ACCOUNT);
    }

    public void inputToLoginTextboxes(String attributeValue, String textValue) {
        waitToElementVisible(InstallAppUI.LOGIN_TEXTBOXES, attributeValue);
        sendKeyToElement(InstallAppUI.LOGIN_TEXTBOXES, textValue, attributeValue);
    }

    public void clickToDynamicButtons(String buttonText) {
        waitToElementClickable(InstallAppUI.DYNAMIC_BUTTONS, buttonText);
        clickToElement(InstallAppUI.DYNAMIC_BUTTONS, buttonText);
    }

    public boolean isDataAcceptableToInstall() {
        waitToElementVisible(InstallAppUI.INSTALL_LABEL);
        return isElementDisplayed(InstallAppUI.INSTALL_LABEL);
    }

    public void selectStartFree() {
        scrollToElement(InstallAppUI.START_FREE_BUTTON);
        waitToElementVisible(InstallAppUI.START_FREE_BUTTON);
        clickToElement(InstallAppUI.START_FREE_BUTTON);
    }

    public boolean isLoginSuccessfully() {
        return isElementPresentInDOM(InstallAppUI.START_FREE_BUTTON);
    }

    public void clickToStart7DaysTrialButton() {
        waitToElementClickable(InstallAppUI.START_TRIAL_BUTTON);
        clickToElement(InstallAppUI.START_TRIAL_BUTTON);
    }

    public void clickToStartFreeTrialButton() {
        waitToElementClickable(InstallAppUI.START_FREE_TRIAL_BUTTON);
        clickToElement(InstallAppUI.START_FREE_TRIAL_BUTTON);
    }

    public void clickToPricingMenu() {
        waitToElementClickable(InstallAppUI.PRICING_MENU);
        clickToElement(InstallAppUI.PRICING_MENU);
    }

    public void clickLoginToAnotherAccount() {
        scrollToElement(InstallAppUI.LOGIN_TO_ANOTHER_ACCOUNT);
        clickToLoginToAnotherAccount();
    }

    public void selectPlan(String planName) {
        waitToElementClickable(InstallAppUI.SELECT_PLAN_BUTTONS_NEW_DESIGN, planName);
        clickToElement(InstallAppUI.SELECT_PLAN_BUTTONS_NEW_DESIGN, planName);
    }

    public boolean isSelectedThePlan() {
        sleepInSecond(2);
        String url = getCurrentPageURL();
        return url.contains(Constants.WELCOME_TRANSCY_URL);
    }

    public void loginToTranscy() {
        inputStoreURL(Constants.URL);
        clickToLoginButton();
        sleepInSecond(1);
        if (isElementPresentInDOM(InstallAppUI.LOGIN_TEXTBOXES, "email") || isElementPresentInDOM(InstallAppUI.LOGIN_TO_ANOTHER_ACCOUNT)) {
            if (isLoginToAnotherAccountPresentInDOM(InstallAppUI.LOGIN_TO_ANOTHER_ACCOUNT)) {
                clickLoginToAnotherAccount();
            }
            inputToLoginTextboxes("email", Constants.STORE_EMAIL_CSV);
            clickToDynamicButtons("Next");

            inputToLoginTextboxes("password", Constants.STORE_PASSWORD_CSV);
            clickToDynamicButtons("Log in");
        }
    }


    public void installApp() {
        loginToTranscy();
        if (isElementPresentInDOM(InstallAppUI.DYNAMIC_BUTTONS, "Install unlisted app")) {
            scrollToElement(InstallAppUI.DYNAMIC_BUTTONS, "Install unlisted app");
            scrollToEndOfPage();
            clickToDynamicButtons("Install unlisted app");
        } else if (driver.getCurrentUrl().equals("https://translate-dev.fireapps.io/")) {
            System.out.println("THIS ACCOUNT " + Constants.STORE_URL_CSV + " HAS BEEN SELECTED THE PLAN BEFORE");
            isInstalledApp = true;
        }
    }

    public void clickToInstallApp() {
        sleepInSecond(5);
        scrollToEndOfPage();
        sleepInSecond(3);
        waitToElementVisible(InstallAppUI.DYNAMIC_BUTTONS, "Install app");
        clickToDynamicButtons("Install app");
    }

    public void initStoreData(List<String> store) {
//        String stt = store.get(0);
        String storeLink = store.get(0);
        String storeLinkSplit = storeLink.substring(8);
        Constants.STORE_URL_CSV = storeLinkSplit.substring(0, storeLinkSplit.length() - 14);
        Constants.STORE_EMAIL_CSV = store.get(1);
        Constants.STORE_NAME_CSV = store.get(2);
        Constants.STORE_TYPE_CSV = store.get(3);
        Constants.STORE_PASSWORD_CSV = store.get(4);

        if (Constants.STORE_TYPE_CSV.equals(Constants.PREMIUM_PLAN)) {
            driver.get(Constants.TRANSCY_URL);
            installApp();
            if (isElementPresentInDOM(InstallAppUI.SELECT_PLAN_BUTTONS_NEW_DESIGN, Constants.PREMIUM_PLAN)) {
                selectPlan(Constants.PREMIUM_PLAN);
                clickToStart7DaysTrialButton();
                clickToStartFreeTrialButton();
                abstractTest.verifyTrue(isElementDisplayed(InstallAppUI.LOGO));
                System.out.println(Constants.STORE_NAME_CSV + "has been installed the Transcy app");
            }
        } else if (Constants.STORE_TYPE_CSV.equals(Constants.ESSENTIAL_PLAN)) {
            driver.get(Constants.TRANSCY_URL);
            installApp();
            if (isElementPresentInDOM(InstallAppUI.SELECT_PLAN_BUTTONS_NEW_DESIGN, Constants.ESSENTIAL_PLAN)) {
                selectPlan(Constants.ESSENTIAL_PLAN);
                clickToStart7DaysTrialButton();
                clickToStartFreeTrialButton();
                abstractTest.verifyTrue(isElementDisplayed(InstallAppUI.LOGO));
                System.out.println(Constants.STORE_NAME_CSV + " has been installed the Transcy App");
            }
        } else if (Constants.STORE_TYPE_CSV.equals(Constants.STARTER_PLAN)) {
            driver.get(Constants.TRANSCY_URL);
            installApp();
            if (isElementPresentInDOM(InstallAppUI.SELECT_PLAN_BUTTONS_NEW_DESIGN, Constants.STARTER_PLAN)) {
                selectPlan(Constants.STARTER_PLAN);
                clickToStart7DaysTrialButton();
                clickToStartFreeTrialButton();
                abstractTest.verifyTrue(isElementDisplayed(InstallAppUI.LOGO));
                System.out.println(Constants.STORE_NAME_CSV + " has been installed the Transcy App");
            }
        } else if (Constants.STORE_TYPE_CSV.equals(Constants.FREE_PLAN)) {
            driver.get(Constants.TRANSCY_URL);
            installApp();
            if (isElementPresentInDOM(InstallAppUI.SELECT_PLAN_BUTTONS_NEW_DESIGN, Constants.STARTER_PLAN)) {
                selectStartFree();
                sleepInSecond(2);
                abstractTest.verifyTrue(isSelectedThePlan());
                System.out.println(Constants.STORE_NAME_CSV + " has been installed the Transcy App");
            }
        } else {
            driver.get(Constants.TRANSCY_URL);
            installApp();
            if (isInstalledApp == false) {
                abstractTest.verifyTrue(isElementDisplayed(InstallAppUI.LOGO));
                System.out.println(Constants.STORE_NAME_CSV + " has been installed the Original App");
            }
        }
    }

    public void readDataCsv() {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(Constants.READ_CSV_FILE_PATH));

            //Read file in java line by line
            while ((line = br.readLine()) != null) {
                initStoreData(readDataCSV.parseCsvLine(line));
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

    public void selectAppsMenu() {
        waitToElementClickable(ShopifyPageUI.APPS_MENU);
        clickToElement(ShopifyPageUI.APPS_MENU);
    }

    public String getRandomKeyword() {
        final String[] keywords = new String[]{"currency", "Currency", "currency"};
        Random random = new Random();
        int index = random.nextInt(keywords.length);
        return keywords[index];
    }

    public void clickToVisitShopifyAppStore() {
        waitToElementClickable(ShopifyPageUI.VISIT_SHOPIFY_APP_STORE_BTN);
        clickToElement(ShopifyPageUI.VISIT_SHOPIFY_APP_STORE_BTN);
        sleepInSecond(3);
    }

    public void inputKeyword(String keyword) {
        sleepInSecond(5);
        switchToWindowsByTitle("Shopify App Store: Ecommerce App Marketplace");
        waitToElementVisible(ShopifyPageUI.SEARCH_APPS_TEXTBOX);
        sendKeyToElement(ShopifyPageUI.SEARCH_APPS_TEXTBOX, keyword);
    }

    public void selectTranscyInAppStore() {
        waitToElementVisible(ShopifyPageUI.TRANSCY_APP_IN_APPSTORE);
        clickToElement(ShopifyPageUI.TRANSCY_APP_IN_APPSTORE);
    }


    public void clickToAddApp() {
        waitToElementClickable(ShopifyPageUI.ADD_APP_BTN);
        clickToElement(ShopifyPageUI.ADD_APP_BTN);
        sleepInSecond(3);
    }

    public void clickToSearchBtn() {
        sleepInSecond(3);
        waitToElementVisible(ShopifyPageUI.SEARCH_BTN);
        clickToElement(ShopifyPageUI.SEARCH_BTN);
    }

    public boolean isRequiredUpgradePageDisplay() {
        sleepInSecond(1);
        return isElementDisplayed(ShopifyPageUI.UPGRADE_YOUR_ACCOUNT_PAGE);
    }


}
