package commons;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
    WebDriver driver;
    WebElement element;
    By by;
    Select select;
    JavascriptExecutor jsExecutor;
    WebDriverWait waitExplicit;
    List<WebElement> elements;
    Set<String> allWindows;
    Actions action;
    long shortTimeout = 3;
    long midTimeout = 5;
    long longTimeout = 30;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
    }

    /* WEB BROWSER */

    public void openURL(String url) {
        driver.get(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentPageURL() {
        return driver.getCurrentUrl();
    }

    public void backToPage() {
        driver.navigate().back();
    }

    public void forwardToPage() {
        driver.navigate().forward();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void cancelAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String getTextAlert() {
        return driver.switchTo().alert().getText();
    }

    public void sendKeyToAlert(String value) {
        driver.switchTo().alert().sendKeys(value);
    }

    /* WEB ELEMENTS */

    public void clickToElement(String locator) {
        element = driver.findElement(By.xpath(locator));
        element.click();
    }

    public void clickToElement(String locator, String value) {
        locator = String.format(locator, value);
        element = driver.findElement(By.xpath(locator));
        element.click();
    }

    public void doubleClickToElement(String locator, String value) {
        locator = String.format(locator, value);
        element = driver.findElement(By.xpath(locator));
        element.click();
        element.click();
    }

    public void clickToElement(String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        element = driver.findElement(By.xpath(locator));
        element.click();
    }

    public void clickToElementByJS(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public void clickToElementByJS(String locator, String attributeValue){
        locator = String.format(locator, attributeValue);
        element = driver.findElement(By.xpath(locator));
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public void sendKeyToElement(String locator, String textValue, String... values) {
        locator = String.format(locator, (Object[]) values);
        element = driver.findElement(By.xpath(locator));
        element.clear();
        element.sendKeys(textValue);
    }

    public void selectItemInDropdown(String locator, String valueItem) {
        select = new Select(driver.findElement(By.xpath(locator)));
        select.selectByVisibleText(valueItem);
    }

    public void selectItemInDropdown(String locator, String valueItem, String... valueField) {
        locator = String.format(locator, (Object[]) valueField);
        element = driver.findElement(By.xpath(locator));
        select = new Select(element);
        select.selectByVisibleText(valueItem);
    }

    public void selectItemInDropdownByIndex(String locator, int index, String... valueField) {
        locator = String.format(locator, (Object[]) valueField);
        element = driver.findElement(By.xpath(locator));
        select = new Select(element);
        select.selectByIndex(index);
    }

    public void selectItemInDropdownByIndex(String locator, int index) {
        element = driver.findElement(By.xpath(locator));
        select = new Select(element);
        select.selectByIndex(index);
    }

    public String getFirstItemInDropdown(String locator) {
        select = new Select(driver.findElement(By.xpath(locator)));
        return select.getFirstSelectedOption().getText();
    }

    public void scrollToElement(String locator) {
        element = driver.findElement(By.xpath(locator));
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public void scrollToElement(String locator, String attribute) {
        locator = String.format(locator, attribute);
        element = driver.findElement(By.xpath(locator));
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public void scrollToEndOfPage(){
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollPage(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,600)");
    }

    public void selectItemInCustomDropdown(String parentLocator, String allItemsLocator, String expectedItem) {
        jsExecutor = (JavascriptExecutor) driver;
        waitExplicit = new WebDriverWait(driver, longTimeout);

        WebElement element = driver.findElement(By.xpath(parentLocator));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
        jsExecutor.executeScript("arguments[0].click();", element);

        waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemsLocator)));

        elements = driver.findElements(By.xpath(allItemsLocator));
        for (WebElement item : elements) {
            if (item.getText().equals(expectedItem)) {
                jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
                sleepInSecond(1);
                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    public String getAttributeValue(String locator, String attributeName) {
        element = driver.findElement(By.xpath(locator));
        return element.getAttribute(attributeName);
    }

    public String getTextElement(String locator) {
        element = driver.findElement(By.xpath(locator));
        return element.getText();
    }

    public String getTextElement(String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        element = driver.findElement(By.xpath(locator));
        return element.getText();
    }

    public String getTextElement(String locator, long indexValue) {
        locator = String.format(locator, indexValue);
        element = driver.findElement(By.xpath(locator));
        return element.getText();
    }

    public int countNumberOfElement(String locator) {
        elements = driver.findElements(By.xpath(locator));
        return elements.size();
    }

    public boolean isElementDisplayed(String locator) {
        element = driver.findElement(By.xpath(locator));
        return element.isDisplayed();
    }

    public boolean isElementDisplayed(String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
//        overideGlobalTimeout(shortTimeout);
        element = driver.findElement(By.xpath(locator));
//        overideGlobalTimeout(longTimeout);
        return element.isDisplayed();
    }

    public boolean isElementSelected(String locator) {
        element = driver.findElement(By.xpath(locator));
        return element.isSelected();
    }

    public boolean isElementEnabled(String locator) {
        element = driver.findElement(By.xpath(locator));
        return element.isEnabled();
    }

    public void checkToCheckBox(String locator) {
        if (!isElementSelected(locator)) {
            clickToElement(locator);
        }
    }

    public void unCheckToCheckBox(String locator) {
        if (isElementSelected(locator)) {
            clickToElement(locator);
        }
    }

    public void switchToWindowsByTitle(String title) {
        allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWindow = driver.getTitle();
            if (currentWindow.equals(title)) {
                break;
            }
        }
    }

    public boolean closeAllWindowsWithoutParent(String parentWindow) {
        allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentWindow)) {
                driver.switchTo().window(runWindow);
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);

        if (driver.getWindowHandles().size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void switchToFrameOrIframe(String locator) {
        element = driver.findElement(By.xpath(locator));
        driver.switchTo().frame(element);
    }

    public void switchToParentPage() {
        driver.switchTo().defaultContent();
    }

    public void hoverMouseToElement(String locator) {
        element = driver.findElement(By.xpath(locator));
        action.moveToElement(element).perform();
    }

    public void hoverMouseToElement(String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        element = driver.findElement(By.xpath(locator));
        action.moveToElement(element).perform();
    }

    public void doubleClickToElement(String locator) {
        element = driver.findElement(By.xpath(locator));
        action.doubleClick(element).perform();
    }

    public void sendKeyBoardToElement(String locator, Keys key) {
        element = driver.findElement(By.xpath(locator));
        action.sendKeys(element, key).perform();
    }

    public boolean checkImageLoaded(String locator) {
        element = driver.findElement(By.xpath(locator));
        jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth>0",
                element);
        if (status) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyTextInInnerText(String textExpected) {
        jsExecutor = (JavascriptExecutor) driver;
        String textActual = (String) jsExecutor
                .executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
        return textActual.equals(textExpected);
    }

    public void waitToElementVisible(String locator) {
        by = By.xpath(locator);
        waitExplicit = new WebDriverWait(driver, longTimeout);
        waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitToElementVisible(String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        by = By.xpath(locator);
        waitExplicit = new WebDriverWait(driver, longTimeout);
        waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitToElementVisible(String locator, long indexValue) {
        locator = String.format(locator, indexValue);
        by = By.xpath(locator);
        waitExplicit = new WebDriverWait(driver, longTimeout);
        waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitToElementClickable(String locator) {
        by = By.xpath(locator);
        waitExplicit = new WebDriverWait(driver, longTimeout);
        waitExplicit.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitToElementClickable(String locator, String value){
        locator = String.format(locator, value);
        by = By.xpath(locator);
        waitExplicit = new WebDriverWait(driver, longTimeout);
        waitExplicit.until(ExpectedConditions.elementToBeClickable(by));
    }

    public boolean isElementEquals(String locator, String expectedResult) {
        element = driver.findElement(By.xpath(locator));
        String actualText = element.getText();
        return actualText.equals(expectedResult);
    }

    public void enableCreateAccountButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByClassName('captcha__submit')[0].removeAttribute('disabled')");
    }

    public boolean isElementEquals(String locator, String expectedResult, String... values) {
        locator = String.format(locator, (Object[]) values);
        element = driver.findElement(By.xpath(locator));
        String actualText = element.getText();
        return actualText.equals(expectedResult);
    }

    @SuppressWarnings("unlikely-arg-type")
    public boolean isElementSplitEquals(String locator, String[] expectedResult, String... values) {
        locator = String.format(locator, (Object[]) values);
        element = driver.findElement(By.xpath(locator));
        String actualText = element.getText();
        return actualText.equals(expectedResult);
    }

    public boolean isElementContainsText(String locator, String textContains) {
        element = driver.findElement(By.xpath(locator));
        String actualText = element.getText();
        return actualText.contains(textContains);
    }

    public void sleepInSecond(long numberInSecond) {
        try {
            Thread.sleep(numberInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void overideGlobalTimeout(long timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public int randomNumber(int boundNumber) {
        Random random = new Random();
        return random.nextInt(boundNumber);
    }

    public boolean isElementPresentInDOM(String locator) {
        overideGlobalTimeout(shortTimeout);
        elements = driver.findElements(By.xpath(locator));
        overideGlobalTimeout(longTimeout);
        if (elements.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isElementPresentInDOM(String locator, String attribute) {
        overideGlobalTimeout(shortTimeout);
        locator = String.format(locator, attribute);
        elements = driver.findElements(By.xpath(locator));
        overideGlobalTimeout(longTimeout);
        if (elements.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isLoginToAnotherAccountPresentInDOM(String locator){
        overideGlobalTimeout(midTimeout);
        elements = driver.findElements(By.xpath(locator));
        overideGlobalTimeout(longTimeout);
        if (elements.size() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isCurrentURLContains(String valueContains) {
        String currentURL = getCurrentPageURL();
        return currentURL.contains(valueContains);
    }

    public int countElements(String locators) {
        overideGlobalTimeout(shortTimeout);
        elements = driver.findElements(By.xpath(locators));
        overideGlobalTimeout(longTimeout);
        return elements.size();
    }

    public int countElements(String locators, String attribute) {
        locators = String.format(locators, attribute);
        overideGlobalTimeout(shortTimeout);
        elements = driver.findElements(By.xpath(locators));
        overideGlobalTimeout(longTimeout);
        return elements.size();
    }

    public List<String> getTextListElements(String locator) {
        String textElement = null;
        List<String> allText = new ArrayList<String>();
        elements = driver.findElements(By.xpath(locator));
        for (WebElement item : elements) {
            textElement = item.getText();
            System.out.println(textElement);
            allText.add(textElement);
        }
        return allText;
    }

    public boolean checkElementsSorted(String locator) {
        ArrayList<String> listElement = new ArrayList<>();
        elements = driver.findElements(By.xpath(locator));
        for (WebElement item : elements) {
            listElement.add(item.getText());
        }
        ArrayList<String> sortedList = new ArrayList<>();
        for (String item : listElement) {
            sortedList.add(item);
        }
        Collections.sort(sortedList);
        return sortedList.equals(listElement);
    }

    public boolean checkElementsSortedReverse(String locator) {
        ArrayList<String> listElement = new ArrayList<>();
        elements = driver.findElements(By.xpath(locator));
        for (WebElement item : elements) {
            listElement.add(item.getText());
        }
        ArrayList<String> sortedList = new ArrayList<>();
        for (String item : listElement) {
            sortedList.add(item);
        }
        Collections.sort(sortedList);
        Collections.reverse(sortedList);
        return sortedList.equals(listElement);
    }


    public long getIndexFromProductName(String productName) {
        jsExecutor = (JavascriptExecutor) driver;
        return (long) jsExecutor.executeScript("return $(document.evaluate(\"//a[text()='" + productName + "']/parent::td\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).index() +1;");
    }

    public void takeScreenshot(String fileName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("C:\\Attachments\\Selenium Attachments\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
