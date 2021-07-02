package shopify;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.OriginalPO;

public class changePlan extends AbstractTest {
    private WebDriver driver;
    private AbstractPage abstractPage;
    private OriginalPO originalPage;

    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browserName){
        driver = getBrowserDriver(browserName);
        abstractPage = new AbstractPage(driver);
    }

    @Test
    public void changePlan(){
        log.info("Read data from document and change the plan");
        originalPage = PageGeneratorManager.getOriginalPage(driver);

    }
}
