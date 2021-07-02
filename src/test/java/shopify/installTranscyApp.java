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
import pageObject.TranscyPO;
import pageUI.InstallAppUI;

public class installTranscyApp extends AbstractTest {
    private WebDriver driver;
    private AbstractPage abstractPage;
    private TranscyPO transcyPage;
    private ShopifyPO shopifyPage;

    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browserName) {
        driver = getBrowserDriver(browserName);
        abstractPage = new AbstractPage(driver);
    }

    @Test
    public void installOriginalApp() {
        log.info("Read data from CSV file and install Transcy app depends on Store Type column");
        transcyPage = PageGeneratorManager.getTranscyPage(driver);
        transcyPage.readDataCsv();
    }

    @AfterTest
    public void afterTest() {
        closeBrowserAndDriver(driver);
    }
}
