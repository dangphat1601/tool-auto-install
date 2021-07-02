package pageObject;

import commons.*;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUI.InstallAppUI;
import pageUI.ShopifyPageUI;

import javax.swing.plaf.PanelUI;
import java.util.UUID;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class SynceeDropshippingPO extends AbstractPage {
    WebDriver driver;
    ReadDataCSV readDataCSV = new ReadDataCSV();
    AbstractTest abstractTest = new AbstractTest();
    boolean isInstalledApp;

    public SynceeDropshippingPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void clickToDynamicButtons(String buttonText) {
        waitToElementClickable(InstallAppUI.DYNAMIC_BUTTONS, buttonText);
        clickToElement(InstallAppUI.DYNAMIC_BUTTONS, buttonText);
    }

    public void selectAppsMenu() {
        waitToElementClickable(ShopifyPageUI.APPS_MENU);
        clickToElement(ShopifyPageUI.APPS_MENU);
        sleepInSecond(3);
    }

    public String searchSynceeDropshipping() {
        final String[] keywords = new String[]{"Syncee - Global Dropshipping", "Syncee - Global Dropshipping"};
        Random random = new Random();
        int index = random.nextInt(keywords.length);
        return keywords[index];
    }

    public void clickToVisitShopifyAppStore() {
        waitToElementClickable(ShopifyPageUI.VISIT_SHOPIFY_APP_STORE_BTN);
        clickToElement(ShopifyPageUI.VISIT_SHOPIFY_APP_STORE_BTN);
        sleepInSecond(3);
    }

    public void clickToInstallApp() {
        sleepInSecond(4);
        scrollToEndOfPage();
        waitToElementVisible(InstallAppUI.DYNAMIC_BUTTONS, "Install app");
        clickToDynamicButtons("Install app");
    }

    public void inputKeyword(String keyword) {
        sleepInSecond(3);
        switchToWindowsByTitle("Shopify App Store: Ecommerce App Marketplace");
        waitToElementVisible(ShopifyPageUI.SEARCH_APPS_TEXTBOX);
        sendKeyToElement(ShopifyPageUI.SEARCH_APPS_TEXTBOX, keyword);
    }


    public void selectSynceeGlobalDropshippingInAppStore() {
        waitToElementVisible(ShopifyPageUI.SYNCEE_GLOBAL_DROPSHIPPING_APP_IN_APPSTORE);
        clickToElement(ShopifyPageUI.SYNCEE_GLOBAL_DROPSHIPPING_APP_IN_APPSTORE);
    }

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

    public void clickToSearchAppBtn() {
        sleepInSecond(5);
        waitToElementVisible(ShopifyPageUI.SEARCH_BTN_SHOPIFY_APP_STORE_BTN);
        clickToElement(ShopifyPageUI.SEARCH_BTN_SHOPIFY_APP_STORE_BTN);
    }

    public void inputKeywordSynceeGlobalDropshipping(String keyword) {
        sleepInSecond(3);
        //switchToWindowsByTitle("Shopify App Store: Ecommerce App Marketplace");
        waitToElementVisible(ShopifyPageUI.SEARCH_APP_OBERLO_TEXTBOX);
        sendKeyToElement(ShopifyPageUI.SEARCH_APP_OBERLO_TEXTBOX, keyword);
    }
}
