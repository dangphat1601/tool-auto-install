package fireappsIO;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.WebsitePO;

public class functionWhatsNewPage extends AbstractTest {

    private WebDriver driver;
    private AbstractPage abstractPage;
    private WebsitePO websitePage;

    @Parameters("browser")
    @BeforeClass
    public void beforeTest(String browserName) {
        driver = getBrowserDriver(browserName);
        abstractPage = new AbstractPage(driver);
        driver.get(Constants.WEBSITE_URL);
        websitePage = PageGeneratorManager.getWebsitePage(driver);
        log.info("What's New - Pre-condition: Access What's New page");
        websitePage.clickToFooterMenus("What");
        verifyTrue(websitePage.isWhatsNewPageAccessed());
    }

    @Test
    public void WhatsNew1_CheckLazyLoad(){
        log.info("What's New1: Lazy load - Check if there are more than 4 post then scroll down");
//        verifyTrue(websitePage.isThereLoadingWheel());
        abstractPage.takeScreenshot("WhatsNew1_Lazyload.jpg");
        log.info("Close messenger pop up");
        websitePage.clickToCloseMessenger();
    }

//    @Test
    public void WhatsNew2_CheckFilterByAppCheckbox(){
        log.info("What's New 2: Check the posts filtered by Ali Reviews");
        websitePage.selectAppFilter(Constants.WHATSNEW_ALIREVIEWS);
        verifyTrue(websitePage.isOnlyAliReviewsPostsFiltered());
        abstractPage.takeScreenshot("WhatsNew2_AliReviewFilter.jpg");
        websitePage.clickToBackToAllChanges();

        log.info("What's New 2: Check the posts filtered by Ali Orders");
        websitePage.selectAppFilter(Constants.WHATSNEW_ALIORDERS);
        verifyTrue(websitePage.isOnlyAliOrdersPostsFiltered());
        abstractPage.takeScreenshot("WhatsNew3_AliOrdersFilter.jpg");
        websitePage.clickToBackToAllChanges();

        log.info("What's New 2: Check the posts filtered by Sales Box");
        websitePage.selectAppFilter(Constants.WHATSNEW_SALESBOX);
        verifyTrue(websitePage.isOnlySalesBoxPostsFiltered());
        abstractPage.takeScreenshot("WhatsNew4_SalesBoxFilter.jpg");
        websitePage.clickToBackToAllChanges();

        log.info("What's New 2: Check the posts filtered by Ali Hunter");
        websitePage.selectAppFilter(Constants.WHATSNEW_ALIHUNTER);
        verifyTrue(websitePage.isOnlyAliHunterPostsFiltered());
        abstractPage.takeScreenshot("WhatsNew5_AliHunterFilter.jpg");
        websitePage.clickToBackToAllChanges();
    }

//    @Test
    public void WhatsNew3_CheckFilterByTag(){
        abstractPage.sleepInSecond(1);
        log.info("What's New 3: Select tag Ali Reviews and verify only the post have AliReviews tag display");
        websitePage.scrollToFooter();
        websitePage.clickToTagApps(Constants.APP_ALIREVIEWS);
        verifyTrue(websitePage.isOnlyAliReviewsPostsFiltered());
        websitePage.clickToBackToAllChanges();

        log.info("What's New 3: Select tag Ali Orders and verify only the post have AliOrders tag display");
        websitePage.clickToTagApps(Constants.APP_ALIORDERS);
        verifyTrue(websitePage.isOnlyAliOrdersPostsFiltered());
        websitePage.clickToBackToAllChanges();

        log.info("What's New 3: Select tag Sales Box and verify only the post have SalesBox tag display");
        websitePage.clickToTagApps(Constants.APP_SALESBOX);
        verifyTrue(websitePage.isOnlySalesBoxPostsFiltered());
        websitePage.clickToBackToAllChanges();

        log.info("What's New 3: Select tag Ali Hunter and verify only the post have AliHunter tag display");
        websitePage.clickToTagApps(Constants.APP_ALIHUNTER);
        verifyTrue(websitePage.isOnlyAliHunterPostsFiltered());
        websitePage.clickToBackToAllChanges();
    }

    @Test
    public void WhatsNew4_CheckSearchFunction(){
        log.info("What's New 4: Check the search function with keyword");
        websitePage.inputToWhatsNewSearch("review");
        websitePage.clickToWhatsNewSearchAction();
        verifyTrue(websitePage.isWhatsNewSearchResultContains("review"));

        log.info("What's New 4: Check the search function with no result");
        websitePage.inputToWhatsNewSearch("!@#");
        websitePage.clickToWhatsNewSearchAction();
        verifyTrue(websitePage.isWhatsNewNoResult());
        abstractPage.takeScreenshot("WhatsNew6_NoResult.jpg");
        websitePage.clickToBackToAllChanges();
    }

    @Test
    public void WhatsNew5_CheckShareIcon(){
        log.info("What's New 5: Press share to Facebook at 1st post");
        websitePage.selectShareOptions("Facebook");
        verifyTrue(websitePage.isSharedPostToFacebook());
        abstractPage.switchToWindowsByTitle("What’s New - Fireapps");

        log.info("What's New 5: Press share to Twitter at 1st post");
        websitePage.selectShareOptions("Twitter");
        verifyTrue(websitePage.isSharedPostToTwitter());
        abstractPage.switchToWindowsByTitle("What’s New - Fireapps");

        log.info("What's New 5: Press share to Linkedin at 1st post");
        websitePage.selectShareOptions("Linkedln");
        verifyTrue(websitePage.isSharedPostToLinkedin());
        abstractPage.switchToWindowsByTitle("What’s New - Fireapps");
    }

    @AfterClass
    public void afterClass(){
        closeBrowserAndDriver(driver);
    }
}
