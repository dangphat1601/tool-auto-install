package shopify;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.OriginalPO;
import pageObject.ShopifyPO;

public class uninstallApp extends AbstractTest {
    private WebDriver driver;
    private AbstractPage abstractPage;
    private OriginalPO originalPO;
    private ShopifyPO shopifyPage;

    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browserName){
        driver = getBrowserDriver(browserName);
        abstractPage = new AbstractPage(driver);
        driver.get(Constants.URL);
    }

    @Test
    public void uninstallOriginalApp(){
        log.info("Read data from CSV file and uninstall app for all account in file");
        shopifyPage = PageGeneratorManager.getShopifyPage(driver);
        shopifyPage.readDataAndDeleteApp();
    }

    @AfterTest
    public void afterTest(){
        closeBrowserAndDriver(driver);
    }
}
