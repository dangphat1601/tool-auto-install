package pageObject;

//import com.sun.org.apache.bcel.internal.generic.PUSH;
import commons.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUI.InstallAppUI;
import pageUI.ShopifyPageUI;
import commons.AbstractTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ChatalystPO extends AbstractPage {
    WebDriver driver;
    ReadDataCSV readDataCSV = new ReadDataCSV();
    AbstractTest abstractTest = new AbstractTest();
    boolean isInstalledApp;

    public ChatalystPO(WebDriver driver) {
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
        sleepInSecond(3);
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
                System.out.println(Constants.STORE_NAME_CSV + "has been installed the Chatalyst app");
            }
        } else if (Constants.STORE_TYPE_CSV.equals(Constants.ESSENTIAL_PLAN)) {
            driver.get(Constants.TRANSCY_URL);
            installApp();
            if (isElementPresentInDOM(InstallAppUI.SELECT_PLAN_BUTTONS_NEW_DESIGN, Constants.ESSENTIAL_PLAN)) {
                selectPlan(Constants.ESSENTIAL_PLAN);
                clickToStart7DaysTrialButton();
                clickToStartFreeTrialButton();
                abstractTest.verifyTrue(isElementDisplayed(InstallAppUI.LOGO));
                System.out.println(Constants.STORE_NAME_CSV + " has been installed the Chatalyst App");
            }
        } else if (Constants.STORE_TYPE_CSV.equals(Constants.STARTER_PLAN)) {
            driver.get(Constants.TRANSCY_URL);
            installApp();
            if (isElementPresentInDOM(InstallAppUI.SELECT_PLAN_BUTTONS_NEW_DESIGN, Constants.STARTER_PLAN)) {
                selectPlan(Constants.STARTER_PLAN);
                clickToStart7DaysTrialButton();
                clickToStartFreeTrialButton();
                abstractTest.verifyTrue(isElementDisplayed(InstallAppUI.LOGO));
                System.out.println(Constants.STORE_NAME_CSV + " has been installed the Chatalyst App");
            }
        } else if (Constants.STORE_TYPE_CSV.equals(Constants.FREE_PLAN)) {
            driver.get(Constants.TRANSCY_URL);
            installApp();
            if (isElementPresentInDOM(InstallAppUI.SELECT_PLAN_BUTTONS_NEW_DESIGN, Constants.STARTER_PLAN)) {
                selectStartFree();
                sleepInSecond(2);
                abstractTest.verifyTrue(isSelectedThePlan());
                System.out.println(Constants.STORE_NAME_CSV + " has been installed the Chatalyst App");
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
        sleepInSecond(3);
        waitToElementClickable(ShopifyPageUI.APPS_MENU);
        clickToElement(ShopifyPageUI.APPS_MENU);
    }

    public String getRandomKeyword() {
        final String[] keywords = new String[]{"live chat",  "customer support", "livechat", "chat", "FAQ", "FAQs"};
        Random random = new Random();
        int index = random.nextInt(keywords.length);
        return keywords[index];
    }

    public String getRandomKeywordForInstall() {
        final String[] keywords = new String[]{"Chat", "Chat", "Chat"};
        Random random = new Random();
        int index = random.nextInt(keywords.length);
        return keywords[index];
    }

    public String getCurrentDateTime() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar calobj = Calendar.getInstance();
        return df.format(calobj.getTime());
    }

    public void clickToVisitShopifyAppStore() {
        waitToElementClickable(ShopifyPageUI.VISIT_SHOPIFY_APP_STORE_BTN);
        clickToElement(ShopifyPageUI.VISIT_SHOPIFY_APP_STORE_BTN);
        sleepInSecond(3);
    }

    public void inputKeyword(String keyword) {
        sleepInSecond(3);
        switchToWindowsByTitle("Shopify App Store: Ecommerce App Marketplace");
        waitToElementVisible(ShopifyPageUI.SEARCH_APPS_TEXTBOX);
        sendKeyToElement(ShopifyPageUI.SEARCH_APPS_TEXTBOX, keyword);
    }

    /*public void clickToLoadPageTwo() {
        String elementPage2 = "//div//a[@class='search-pagination__link' and text()='5']";
        waitToElementVisible(elementPage2);
        clickToElement(elementPage2);
    }*/

    public void selectChatalystInAppStore() {
        waitToElementVisible(ShopifyPageUI.CHATALYST_APP_IN_APPSTORE);
        clickToElement(ShopifyPageUI.CHATALYST_APP_IN_APPSTORE);
        sleepInSecond(3);
        scrollPage();
        sleepInSecond(10);
        scrollPage();
        sleepInSecond(5);
    }

    public void clickToChatalystAppInAppStore() {
        waitToElementVisible(ShopifyPageUI.CHATALYST_APP_IN_APPSTORE);
        clickToElement(ShopifyPageUI.CHATALYST_APP_IN_APPSTORE);
        sleepInSecond(3);
    }

    public void clickToURLAppChatalyst() {
        driver.findElement(By.xpath(".//a[contains(@href,'apps.shopify.com/chatalyst')]")).click();
        List<WebElement> linksList = driver.findElements(By.xpath(".//a[contains(@href,'apps.shopify.com/chatalyst')]"));
        for (WebElement webElement : linksList) {
            webElement.click();
        }
    }

    public void findElementInPage() {
        int count = 0;
        boolean isFind = false;
        int Page = 2;
        String PAGINATION = "//div//a[@class='search-pagination__link' and text()='" + Page + "']";

        while (isFind==false) {
            System.out.println("start " + isFind);
            while (count <= 4 && isFind==false) {
            System.out.println("while inside " + count);
                if (isElementPresentInDOM(ShopifyPageUI.URL_CHATALYST)) {
                    sleepInSecond(2);
                    waitToElementVisible(ShopifyPageUI.URL_CHATALYST);
                    clickToElement(ShopifyPageUI.URL_CHATALYST);
                    return;
                } else {
                    scrollPage();
                    if (isElementPresentInDOM(ShopifyPageUI.URL_CHATALYST)) {
                        sleepInSecond(2);
                        waitToElementVisible(ShopifyPageUI.URL_CHATALYST);
                        clickToElement(ShopifyPageUI.URL_CHATALYST);
                    }
                }
                count++;
            }
            waitToElementClickable(PAGINATION);
            clickToElement(PAGINATION);
            Page++;
            PAGINATION = "//div//a[@class='search-pagination__link' and text()='" + Page + "']";
            count = 0;
            System.out.println("end while " + isFind);
        }
    }

    public void clickToAddApp() {
        sleepInSecond(3);
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
        sleepInSecond(3);
        return isElementDisplayed(ShopifyPageUI.UPGRADE_YOUR_ACCOUNT_PAGE);
    }


    public boolean isChoosePlanPageDisplay() {
        sleepInSecond(3);
        return isElementDisplayed("//button[@type='button' and contains(@class, 'submit-button a-btn a-btn-primary a-btn-background-ghost')]");
    }

    public void randomClickChoosePlanFree() {
        int code = (int) Math.floor(((Math.random() * 2) + 10));
        int randomNo = code % 2;
        if (randomNo == 0) {
            driver.findElement(By.xpath("//*[@id=\"app-layout-master\"]/div/div[2]/div[2]/div[1]/div/div/div/div[1]/div/div[1]/div[1]/div[2]/div[1]/div/form/button")).click();
        } else {
        }
        sleepInSecond(3);
    }

    public void clickShowFullDescription() {
        sleepInSecond(2);
        waitToElementVisible(ShopifyPageUI.SHOW_FULL_DESCRIPTION_BTN);
        clickToElement(ShopifyPageUI.SHOW_FULL_DESCRIPTION_BTN);
        sleepInSecond(10);
    }
}
