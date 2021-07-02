package pageObject;

import com.github.javafaker.Faker;
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


public class OberloPO extends AbstractPage {
    WebDriver driver;
    ReadDataCSV readDataCSV = new ReadDataCSV();
    AbstractTest abstractTest = new AbstractTest();
    boolean isInstalledApp;

    public OberloPO(WebDriver driver) {
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

    public String searchOberlo() {
        final String[] keywords = new String[]{"Oberlo", "oberlo"};
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


    public void selectOberloInAppStore() {
        waitToElementVisible(ShopifyPageUI.URL_OBERLO_APP_IN_APPSTORE);
        clickToElement(ShopifyPageUI.URL_OBERLO_APP_IN_APPSTORE);
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
     //when page app store shopify is not found

    public void clickToSearchAppBtn() {
        sleepInSecond(5);
        waitToElementVisible(ShopifyPageUI.SEARCH_BTN_SHOPIFY_APP_STORE_BTN);
        clickToElement(ShopifyPageUI.SEARCH_BTN_SHOPIFY_APP_STORE_BTN);
    }

    public void inputKeywordOberlo(String keyword) {
        sleepInSecond(3);
        //switchToWindowsByTitle("Shopify App Store: Ecommerce App Marketplace");
        waitToElementVisible(ShopifyPageUI.SEARCH_APP_OBERLO_TEXTBOX);
        sendKeyToElement(ShopifyPageUI.SEARCH_APP_OBERLO_TEXTBOX, keyword);
    }

    /* public void inputToPassword(String password_oberlo) {
         waitToElementVisible(ShopifyPageUI.NEW_PASSWORD);
         sendKeyToElement(ShopifyPageUI.NEW_PASSWORD, password_oberlo);
     }

     public void inputToConfirmNewPassword(String confirm_password_oberlo) {
         waitToElementVisible(ShopifyPageUI.CONFIRM_NEW_PASSWORD);
         sendKeyToElement(ShopifyPageUI.CONFIRM_NEW_PASSWORD, confirm_password_oberlo);
     }
 */
    public void clickToSavePassword() {
        waitToElementVisible(ShopifyPageUI.SAVE_PASSWORD);
        clickToElement(ShopifyPageUI.SAVE_PASSWORD);
    }

    public void clickToSkipButton() {
        sleepInSecond(3);
        waitToElementClickable(ShopifyPageUI.CLICK_TO_SKIP_BTN);
        clickToElement(ShopifyPageUI.CLICK_TO_SKIP_BTN);
    }

   /* public void clickToClosePopup() {
        sleepInSecond(3);
        WebDriverWait waiter = new WebDriverWait(driver, 1000);
        //driver.switchTo().defaultContent();
        driver.switchTo().frame("intercom-modal-frame");
        driver.findElement(By.xpath("//span[contains(text(),'Boundless')]")).click();
        sleepInSecond(5);
        //click button Add to themes libary
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='_1wLbD _1eCDN']")));
        driver.findElement(By.xpath("//button[@class='_1wLbD _1eCDN']")).click();
    }*/

    public void clickToNextPopup(){
        sleepInSecond(5);
        driver.switchTo().frame("intercom-tour-frame");
        driver.findElement(By.xpath("//*[@id=\"intercom-container\"]/div/div/div/div/div[4]/div[2]/button")).click();
        driver.switchTo().defaultContent();
    }

    public void clickToClosePopup(){
        sleepInSecond(3);
        driver.switchTo().frame("intercom-modal-frame");
        driver.findElement(By.xpath("//*[@id=\"intercom-container\"]/div/span/div/div/div/div[2]/div/div/span")).click();
        driver.switchTo().defaultContent();
    }

    public void clickToSearchProduct() {
        sleepInSecond(2);
        waitToElementClickable(ShopifyPageUI.SEARCH_PRODUCT_MENU);
        clickToElement(ShopifyPageUI.SEARCH_PRODUCT_MENU);
    }

    //Random import 2-6 products
    public void randomImprortProduct() {
        sleepInSecond(2);
        List<WebElement> products = driver.findElements(By.xpath("//div[//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div[3]/div[2]/div/div[8]/div/div[2]/div[2]/div/div[2]/button/span[2]]"));
        Random random = new Random();
        int index = random.nextInt(products.size() -1);
    }

    //product 1
    public void clickAddToImportList_1() {
        waitToElementClickable(ShopifyPageUI.CLICK_TO_ORDER_TEXT1);
        clickToElement(ShopifyPageUI.CLICK_TO_ORDER_TEXT1);
        waitToElementClickable(ShopifyPageUI.ADD_PRODUCT1_TO_IMPORT_LIST);
        clickToElement(ShopifyPageUI.ADD_PRODUCT1_TO_IMPORT_LIST);
        sleepInSecond(1);
    }

    //product 2
    public void clickAddToImportList_2() {
        waitToElementClickable(ShopifyPageUI.CLICK_TO_ORDER_TEXT2);
        clickToElement(ShopifyPageUI.CLICK_TO_ORDER_TEXT2);
        waitToElementClickable(ShopifyPageUI.ADD_PRODUCT2_TO_IMPORT_LIST);
        clickToElement(ShopifyPageUI.ADD_PRODUCT2_TO_IMPORT_LIST);
        sleepInSecond(1);
    }

    //product 3
    public void clickAddToImportList_3() {
        waitToElementClickable(ShopifyPageUI.CLICK_TO_ORDER_TEXT3);
        clickToElement(ShopifyPageUI.CLICK_TO_ORDER_TEXT3);
        waitToElementClickable(ShopifyPageUI.ADD_PRODUCT3_TO_IMPORT_LIST);
        clickToElement(ShopifyPageUI.ADD_PRODUCT3_TO_IMPORT_LIST);
        sleepInSecond(1);
    }

    //product 4
    public void clickAddToImportList_4() {
        waitToElementClickable(ShopifyPageUI.CLICK_TO_ORDER_TEXT4);
        clickToElement(ShopifyPageUI.CLICK_TO_ORDER_TEXT4);
        waitToElementClickable(ShopifyPageUI.ADD_PRODUCT4_TO_IMPORT_LIST);
        clickToElement(ShopifyPageUI.ADD_PRODUCT4_TO_IMPORT_LIST);
        sleepInSecond(1);
    }

    //product 5
    public void clickAddToImportList_5() {
        waitToElementClickable(ShopifyPageUI.CLICK_TO_ORDER_TEXT5);
        clickToElement(ShopifyPageUI.CLICK_TO_ORDER_TEXT5);
        waitToElementClickable(ShopifyPageUI.ADD_PRODUCT5_TO_IMPORT_LIST);
        clickToElement(ShopifyPageUI.ADD_PRODUCT5_TO_IMPORT_LIST);
        sleepInSecond(1);
    }

    //product 6
    public void clickAddToImportList_6() {
        waitToElementClickable(ShopifyPageUI.CLICK_TO_ORDER_TEXT6);
        clickToElement(ShopifyPageUI.CLICK_TO_ORDER_TEXT6);
        waitToElementClickable(ShopifyPageUI.ADD_PRODUCT6_TO_IMPORT_LIST);
        clickToElement(ShopifyPageUI.ADD_PRODUCT6_TO_IMPORT_LIST);
        sleepInSecond(1);
    }

    //producT default 1
    public void clickAddToImportList_Default1() {
        waitToElementClickable(ShopifyPageUI.CLICK_TO_ORDER_TEXT_DEFAULT1);
        clickToElement(ShopifyPageUI.CLICK_TO_ORDER_TEXT_DEFAULT1);
        waitToElementClickable(ShopifyPageUI.ADD_PRODUCT_DEFAULT1_TO_IMPORT_LIST);
        clickToElement(ShopifyPageUI.ADD_PRODUCT_DEFAULT1_TO_IMPORT_LIST);
        sleepInSecond(1);
    }

    //producT default 2
    public void clickAddToImportList_Default2() {
        waitToElementClickable(ShopifyPageUI.CLICK_TO_ORDER_TEXT_DEFAULT2);
        clickToElement(ShopifyPageUI.CLICK_TO_ORDER_TEXT_DEFAULT2);
        waitToElementClickable(ShopifyPageUI.ADD_PRODUCT_DEFAULT2_TO_IMPORT_LIST);
        clickToElement(ShopifyPageUI.ADD_PRODUCT_DEFAULT2_TO_IMPORT_LIST);
        sleepInSecond(1);
    }

    //producT default 3
    public void clickAddToImportList_Default3() {
        waitToElementClickable(ShopifyPageUI.CLICK_TO_ORDER_TEXT_DEFAULT3);
        clickToElement(ShopifyPageUI.CLICK_TO_ORDER_TEXT_DEFAULT3);
        waitToElementClickable(ShopifyPageUI.ADD_PRODUCT_DEFAULT3_TO_IMPORT_LIST);
        clickToElement(ShopifyPageUI.ADD_PRODUCT_DEFAULT3_TO_IMPORT_LIST);
        sleepInSecond(1);
    }

    //producT default 4
    public void clickAddToImportList_Default4() {
        waitToElementClickable(ShopifyPageUI.CLICK_TO_ORDER_TEXT_DEFAULT4);
        clickToElement(ShopifyPageUI.CLICK_TO_ORDER_TEXT_DEFAULT4);
        waitToElementClickable(ShopifyPageUI.ADD_PRODUCT_DEFAULT4_TO_IMPORT_LIST);
        clickToElement(ShopifyPageUI.ADD_PRODUCT_DEFAULT4_TO_IMPORT_LIST);
        sleepInSecond(1);
    }


    public void inputNameProduct(String keyword) {
        sleepInSecond(6);
        switchToWindowsByTitle("AliExpress");
        waitToElementVisible(ShopifyPageUI.SEARCH_PRODUCT_TEXTBOX);
        sendKeyToElement(ShopifyPageUI.SEARCH_PRODUCT_TEXTBOX, keyword);
    }

    public String searchProductOberlo() {
        final String[] keywords = new String[]{"Phone", "Watch", "Shoes", "Adidas", "Flower", "Makeup", "Glasses", "Dress", "Hat", "Toys"};
        Random random = new Random();
        int index = random.nextInt(keywords.length);
        return keywords[index];
    }

    public void clickToSearchProductBtn() {
        sleepInSecond(5);
        waitToElementVisible(ShopifyPageUI.SEARCH_BUTTON);
        clickToElement(ShopifyPageUI.SEARCH_BUTTON);
    }

    public void clickImportListMenu() {
        waitToElementVisible(ShopifyPageUI.IMPORT_LIST);
        clickToElement(ShopifyPageUI.IMPORT_LIST);
        sleepInSecond(3);
    }

    public void clickCheckboxAllProduct() {
        waitToElementVisible(ShopifyPageUI.SELECT_ALL_PRODUCT_CHECKBOX);
        clickToElement(ShopifyPageUI.SELECT_ALL_PRODUCT_CHECKBOX);
        sleepInSecond(3);
    }

    public void clickImportAllToStore() {
        waitToElementVisible(ShopifyPageUI.IMPORT_ALL_PRODUCT_TO_STORE);
        clickToElement(ShopifyPageUI.IMPORT_ALL_PRODUCT_TO_STORE);
        sleepInSecond(5);
    }

    public void clickToPushProduct() {
        waitToElementVisible(ShopifyPageUI.PUSH_PRODUCTS);
        clickToElement(ShopifyPageUI.PUSH_PRODUCTS);
        sleepInSecond(8);
    }

    public void clickToCreateNewOberloAccount(){
        waitToElementVisible(ShopifyPageUI.CONNECT_OBERLO_WITH_SHOPIFY);
        clickToElement(ShopifyPageUI.CLICK_TO_CREATE_NEW_OBERLO_ACCOUNT);
    }

    /*public void inputToEmail(String email_oberlo) {
        sleepInSecond(2);
        waitToElementVisible(ShopifyPageUI.INPUT_EMAIL_OBERLO);
        sendKeyToElement(ShopifyPageUI.INPUT_EMAIL_OBERLO, email_oberlo);
    }*/

    public void inputToEmailObelo(String placeHolder, String value) {
        waitToElementVisible(ShopifyPageUI.INPUT_EMAIL_OBERLO, placeHolder);
        sendKeyToElement(ShopifyPageUI.INPUT_EMAIL_OBERLO, value, placeHolder);
        sleepInSecond(1);
    }

    public void inputToPassword(String password_oberlo) {
        sleepInSecond(2);
        waitToElementVisible(ShopifyPageUI.INPUT_PASSWORD_OBERLO);
        sendKeyToElement(ShopifyPageUI.INPUT_PASSWORD_OBERLO, password_oberlo);
    }

    public void clickToCreateFreeAccount(){
        waitToElementClickable(ShopifyPageUI.CLICK_TO_CREATE_FREE_ACCOUTN_BUTTON);
        clickToElement(ShopifyPageUI.CLICK_TO_CREATE_FREE_ACCOUTN_BUTTON);
    }
   /* public void inputToPassword(String password_oberlo) {
        waitToElementVisible(ShopifyPageUI.NEW_PASSWORD);
        sendKeyToElement(ShopifyPageUI.NEW_PASSWORD, password_oberlo);
    }*/

   /* public void clickBackShopifyAdmin(){
        waitToElementVisible(ShopifyPageUI.BACK_TO_SHOPIFY_ADMIN);
        clickToElement(ShopifyPageUI.BACK_TO_SHOPIFY_ADMIN);
        sleepInSecond(5);
    }*/

    public void reloadPage() {
        driver.navigate().refresh();
    }

}
