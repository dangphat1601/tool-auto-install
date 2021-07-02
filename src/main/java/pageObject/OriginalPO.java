package pageObject;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import commons.ReadDataCSV;
import org.openqa.selenium.WebDriver;
import pageUI.InstallAppUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class OriginalPO extends AbstractPage {
    WebDriver driver;
    ReadDataCSV readDataCSV = new ReadDataCSV();
    AbstractTest abstractTest = new AbstractTest();
    boolean isInstalledApp;

    public OriginalPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputStoreURL(String textValue) {
        waitToElementVisible(InstallAppUI.STORE_NAME_TEXTBOX);
        sendKeyToElement(InstallAppUI.STORE_NAME_TEXTBOX, textValue);
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

    public void selectPlan(String planName) {
        waitToElementClickable(InstallAppUI.SELECT_PLAN_BUTTONS, planName);
        clickToElement(InstallAppUI.SELECT_PLAN_BUTTONS, planName);
    }

    public void clickToStart7DaysTrialButton() {
        waitToElementClickable(InstallAppUI.START_TRIAL_BUTTON);
        clickToElement(InstallAppUI.START_TRIAL_BUTTON);
    }

    public void clickToStartFreeTrialButton() {
        waitToElementClickable(InstallAppUI.START_FREE_TRIAL_BUTTON);
        clickToElement(InstallAppUI.START_FREE_TRIAL_BUTTON);
    }

    public boolean isOriginalLogoDisplayed() {
        waitToElementVisible(InstallAppUI.LOGO);
        return isElementDisplayed(InstallAppUI.LOGO);
    }

    public void clickToPricingMenu(){
        waitToElementClickable(InstallAppUI.PRICING_MENU);
        clickToElement(InstallAppUI.PRICING_MENU);
    }

    public void clickLoginToAnotherAccount(){
        scrollToElement(InstallAppUI.LOGIN_TO_ANOTHER_ACCOUNT);
        clickToLoginToAnotherAccount();
    }

    public void loginToOriginal(){
        inputStoreURL(Constants.STORE_URL_CSV);
        clickToLoginButton();
        if (isLoginToAnotherAccountPresentInDOM(InstallAppUI.LOGIN_TO_ANOTHER_ACCOUNT)) {
            clickLoginToAnotherAccount();
        }
        inputToLoginTextboxes("email", Constants.STORE_EMAIL_CSV);
        clickToDynamicButtons("Next");
        inputToLoginTextboxes("password", Constants.SHOPIFY_PASSWORD);
        clickToDynamicButtons("Log in");
    }

    public void installApp() {
        loginToOriginal();
        if (isElementPresentInDOM(InstallAppUI.DYNAMIC_BUTTONS, "Install unlisted app")) {
            scrollToElement(InstallAppUI.DYNAMIC_BUTTONS, "Install unlisted app");
            clickToDynamicButtons("Install unlisted app");
        } else if (driver.getCurrentUrl().equals("https://origin-dev.fireapps.io/")) {
            System.out.println("THIS ACCOUNT " + Constants.STORE_URL_CSV + " HAS BEEN SELECTED THE PLAN BEFORE");
            isInstalledApp = true;
        }
    }


    public void initStoreData(List<String> store) {
        String stt = store.get(0);
        String url = store.get(1);
        String urlSplit1 = url.substring(8);
        Constants.STORE_URL_CSV = urlSplit1.substring(0, urlSplit1.length() - 14);
        Constants.STORE_EMAIL_CSV = store.get(2);
        Constants.STORE_NAME_CSV = store.get(3);
        Constants.STORE_TYPE_CSV = store.get(4);

        if (Constants.STORE_TYPE_CSV.equals(Constants.PREMIUM_PLAN)) {
            driver.get(Constants.ORIGINAL_URL);
            installApp();
            if (isElementPresentInDOM(InstallAppUI.SELECT_PLAN_BUTTONS, "PREMIUM")) {
                selectPlan("PREMIUM");
                clickToStart7DaysTrialButton();
                clickToStartFreeTrialButton();
                abstractTest.verifyTrue(isElementDisplayed(InstallAppUI.LOGO));
                System.out.println(Constants.STORE_NAME_CSV + " has been installed the Original App");
                System.out.println("Ordinal Numbers: " + stt + " | Plan: " + Constants.STORE_TYPE_CSV);
            }
        } else if (Constants.STORE_TYPE_CSV.equals(Constants.ESSENTIAL_PLAN)) {
            driver.get(Constants.ORIGINAL_URL);
            installApp();
            if (isElementPresentInDOM(InstallAppUI.SELECT_PLAN_BUTTONS, "ESSENTIAL")) {
                selectPlan("ESSENTIAL");
                clickToStart7DaysTrialButton();
                clickToStartFreeTrialButton();
                abstractTest.verifyTrue(isElementDisplayed(InstallAppUI.LOGO));
                System.out.println(Constants.STORE_NAME_CSV + " has been installed the Original App");
                System.out.println("Ordinal Numbers: " + stt + " | Plan: " + Constants.STORE_TYPE_CSV);
            }
        } else if (Constants.STORE_TYPE_CSV.equals(Constants.STARTER_PLAN)) {
            driver.get(Constants.ORIGINAL_URL);
            installApp();
            if (isElementPresentInDOM(InstallAppUI.SELECT_PLAN_BUTTONS, "STARTER")) {
                selectPlan("STARTER");
                clickToStart7DaysTrialButton();
                clickToStartFreeTrialButton();
                abstractTest.verifyTrue(isElementDisplayed(InstallAppUI.LOGO));
                System.out.println(Constants.STORE_NAME_CSV + " has been installed the Original App");
                System.out.println("Ordinal Numbers: " + stt + " | Plan: " + Constants.STORE_TYPE_CSV);
            }
        } else {
            driver.get(Constants.ORIGINAL_URL);
            installApp();
            if (isInstalledApp == false) {
                abstractTest.verifyTrue(isElementDisplayed(InstallAppUI.LOGO));
                System.out.println(Constants.STORE_NAME_CSV + " has been installed the Original App");
                System.out.println("Ordinal Numbers: " + stt + " | Plan: " + Constants.STORE_TYPE_CSV);
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
                while ((line = br.readLine()) != null) {
                    while ((line = br.readLine()) != null) {
                        initStoreData(readDataCSV.parseCsvLine(line));
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


    //CHANGE PLAN
    public void changePlan(List<String> stores) {
        String stt = stores.get(0);
        String url = stores.get(1);
        String urlSplit1 = url.substring(8);
        Constants.STORE_URL_CSV = urlSplit1.substring(0, urlSplit1.length() - 14);
        Constants.STORE_EMAIL_CSV = stores.get(2);
        Constants.STORE_NAME_CSV = stores.get(3);
        Constants.STORE_TYPE_CSV = stores.get(4);

        driver.get(Constants.ORIGINAL_URL);
        loginToOriginal();
        //If No-plan before
        if(isElementPresentInDOM(InstallAppUI.SELECT_PLAN_BUTTONS, "PREMIUM")){
            switch (Constants.STORE_TYPE_CSV){
                case Constants.PREMIUM_PLAN:
                    selectPlan("PREMIUM");
                    clickToStart7DaysTrialButton();
                    clickToStartFreeTrialButton();
                    abstractTest.verifyTrue(isElementDisplayed(InstallAppUI.LOGO));
                    System.out.println(Constants.STORE_NAME_CSV + " has been changed to PREMIUM");
                    break;
                case Constants.ESSENTIAL_PLAN:
                    selectPlan("ESSENTIAL");
                    clickToStart7DaysTrialButton();
                    clickToStartFreeTrialButton();
                    abstractTest.verifyTrue(isElementDisplayed(InstallAppUI.LOGO));
                    System.out.println(Constants.STORE_NAME_CSV + " has been changed to ESSENTIAL");
                    break;
                case Constants.STARTER_PLAN:
                    selectPlan("STARTER");
                    clickToStart7DaysTrialButton();
                    clickToStartFreeTrialButton();
                    abstractTest.verifyTrue(isElementDisplayed(InstallAppUI.LOGO));
                    System.out.println(Constants.STORE_NAME_CSV + " has been changed to STARTER");
                    break;
            }
            //Can lam tiep phan nay
        }
        if (Constants.STORE_TYPE_CSV.equals(Constants.NO_PLAN)) {
            if (!isElementPresentInDOM(InstallAppUI.SELECT_PLAN_BUTTONS, "PREMIUM")) {
                System.out.println("CAN NOT CHANGE THE PLAN FROM OTHERS TO NO-PLAN");
            }
        }
        if (Constants.STORE_TYPE_CSV.equals(Constants.PREMIUM_PLAN)) {

            clickToPricingMenu();
            selectPlan("PREMIUM");
            if (isElementPresentInDOM(InstallAppUI.YOU_ARE_HERE_BUTTON)) {
                System.out.println("NO PLAN CHANGE");
            }else{
                clickToStart7DaysTrialButton();
                clickToStartFreeTrialButton();
                abstractTest.verifyTrue(isElementDisplayed(InstallAppUI.LOGO));
                System.out.println(Constants.STORE_NAME_CSV + " has been changed to PREMIUM");
            }
        }
        if(Constants.STORE_TYPE_CSV.equals(Constants.ESSENTIAL_PLAN)){
            clickToPricingMenu();
        }
    }

}
