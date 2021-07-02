package fireappsIO;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.WebsitePO;

public class functionsShopifyApps extends AbstractTest {
    private WebDriver driver;
    private AbstractPage abstractPage;
    private WebsitePO websitePage;

    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browserName){
        driver = getBrowserDriver(browserName);
        abstractPage = new AbstractPage(driver);
        driver.get(Constants.WEBSITE_URL);
        websitePage = PageGeneratorManager.getWebsitePage(driver);
        websitePage.clickToHeaderDynamic("SHOPIFY APPS");
        verifyEquals(websitePage.isShopifyAppsPageAccessed(), Constants.WEBSITE_SHOPIFY_APPS);
        abstractPage.takeScreenshot("ShopifyApps.jpg");
    }

    @Test
    public void S1_SMSMessent(){
    }
}
