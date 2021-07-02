package fireappsIO;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObject.WebsitePO;

public class functionHomePage extends AbstractTest {
    private WebDriver driver;
    private AbstractPage abstractPage;
    private WebsitePO websitePage;

    @Parameters("browser")
    @BeforeClass
    public void beforeTest(String browserName){
        driver = getBrowserDriver(browserName);
        abstractPage = new AbstractPage(driver);
        driver.get(Constants.WEBSITE_URL);
    }

    @Test(enabled = false)
    public void Home1_checkHeaderLinks(){
        log.info("Header 1: Home button");
        websitePage = PageGeneratorManager.getWebsitePage(driver);
        websitePage.clickToHeaderDynamic(Constants.WEBSITE_HOME_BUTTON);
        verifyTrue(websitePage.isHomePageAccessed());
        abstractPage.sleepInSecond(1);
        abstractPage.takeScreenshot("HomePage1-Header.jpg");
        log.info("Close Messenger pop up");
        websitePage.clickToCloseMessenger();

        log.info("Header 2: Shopify apps button");
        websitePage.clickToHeaderDynamic("SHOPIFY APPS");
        verifyTrue(websitePage.isShopifyAppsPageAccessed());

        log.info("Header 3: Blog button");
        websitePage.clickToHeaderDynamic("Blog");
        verifyTrue(websitePage.isBlogPageAccessed());
        abstractPage.takeScreenshot("HomePage2-Header-Blog.jpg");

        log.info("Header 4: Affiliate button");
        websitePage.clickToHeaderDynamic("Affiliate");
        verifyTrue(websitePage.isAffiliateTabAccessed());
        abstractPage.takeScreenshot("HomePage3-Header-Affiliate.jpg");
        abstractPage.switchToWindowsByTitle("Blog - FireApps");
        verifyTrue(websitePage.isBlogPageAccessed());

        log.info("Header 5: Get App Now button");
        websitePage.clickToHeaderDynamic("Get App Now");
        verifyTrue(websitePage.isShopifyAppsPageAccessed());
        abstractPage.takeScreenshot("HomePage4-Header-ShopifyApps.jpg");
        websitePage.clickToHeaderDynamic(Constants.WEBSITE_HOME_BUTTON);
        abstractPage.switchToWindowsByTitle("Home Page - FireApps");
        verifyTrue(websitePage.isHomePageAccessed());
    }

    @Test(enabled=false)
    public void Home2_CheckSlideApps(){
        log.info("Slide App 1: Check Ali Review");
        websitePage = PageGeneratorManager.getWebsitePage(driver);
        websitePage.scrollToOurEssentialApps();
        websitePage.clickToCloseMessenger();
        verifyEquals(websitePage.isPrevSlideButtonDisabled(), "true");
        verifyTrue(websitePage.isAppLogoDisplayedAfterSelectSlidebar("alireviews"));
        websitePage.clickToGetAppButtonInSlidebar("alireviews");
        verifyTrue(websitePage.isGetAppPageAccessed(Constants.WEBSITE_ALI_REVIEW_URL));
        abstractPage.switchToWindowsByTitle("Home Page - FireApps");

        log.info("Slide App 2: Check Ali Hunter");
        websitePage.clickToNextAppSlide();
        abstractPage.sleepInSecond(1);
        verifyTrue(websitePage.isAppLogoDisplayedAfterSelectSlidebar("alihunter"));
        websitePage.clickToGetAppButtonInSlidebar("alihunter");
        verifyTrue(websitePage.isGetAppPageAccessed(Constants.WEBSITE_ALI_HUNTER_URL));
        abstractPage.switchToWindowsByTitle("Home Page - FireApps");
        abstractPage.sleepInSecond(1);

        log.info("Slide App 2: Check Ali Orders");
        websitePage.clickToNextAppSlide();
        abstractPage.sleepInSecond(1);
        verifyTrue(websitePage.isAppLogoDisplayedAfterSelectSlidebar("aliorders"));
        websitePage.clickToGetAppButtonInSlidebar("aliorders");
        verifyTrue(websitePage.isGetAppPageAccessed(Constants.WEBSITE_ALI_ORDERS_URL));
        abstractPage.switchToWindowsByTitle("Home Page - FireApps");
        abstractPage.sleepInSecond(1);

        log.info("Slide App 2: Check Sales Box");
        websitePage.clickToNextAppSlide();
        abstractPage.sleepInSecond(1);
        verifyTrue(websitePage.isAppLogoDisplayedAfterSelectSlidebar("salesbox"));
        websitePage.clickToGetAppButtonInSlidebar("salesbox");
        abstractPage.sleepInSecond(2);
        verifyTrue(websitePage.isGetAppPageAccessed(Constants.WEBSITE_SALES_BOX_URL));
        abstractPage.switchToWindowsByTitle("Home Page - FireApps");

    }

    @Test(enabled = false)
    public void Home2_checkBodyFunctions(){
        log.info("Body 1: Get App Now button");
        websitePage = PageGeneratorManager.getWebsitePage(driver);
        websitePage.clickToBodyGetAppNow();
        verifyEquals(websitePage.isShopifyAppsPageAccessed(), Constants.WEBSITE_SHOPIFY_APPS);
        websitePage.clickToHeaderDynamic(Constants.WEBSITE_HOME_BUTTON);
        verifyTrue(websitePage.isHomePageAccessed());
        websitePage.clickToCloseMessenger();

        log.info("Body 2: Ali Review in slide bar - Get App button");
        websitePage.scrollToAppSlideBar();
        verifyTrue(websitePage.isAppLogoDisplayedAfterSelectSlidebar("alireviews"));
        abstractPage.takeScreenshot("HomePage5-AliReview.jpg");
        verifyEquals(websitePage.isPrevSlideButtonDisabled(), "true");
        websitePage.clickToGetAppButtonInSlidebar(Constants.ALI_REVIEW_GET_APP);
        verifyTrue(websitePage.isGetAppPageAccessed(Constants.WEBSITE_ALI_REVIEW_URL));
        abstractPage.takeScreenshot("HomePage6-AliReviewAppPage.jpg");
        abstractPage.switchToWindowsByTitle("Home Page - Fireapps");

        log.info("Body 3: Ali Hunter in slide bar - Get App button");
        websitePage.scrollToAppSlideBar();
        websitePage.clickToNextAppSlide();
        verifyTrue(websitePage.isAppLogoDisplayedAfterSelectSlidebar("alihunter"));
        abstractPage.takeScreenshot("HomePage7-AliHunter.jpg");
        websitePage.clickToGetAppButtonInSlidebar(Constants.ALI_HUNTER_GET_APP);
        abstractPage.takeScreenshot("HomePage8-AliHunter.jpg");
        verifyTrue(websitePage.isGetAppPageAccessed(Constants.WEBSITE_ALI_HUNTER_URL));
        abstractPage.switchToWindowsByTitle("Home Page - Fireapps");

        log.info("Body 4: Ali Orders in slide bar - Get App button");
//        websitePage.scrollToAppSlideBar();
        websitePage.clickToNextAppSlide();
//        abstractPage.sleepInSecond(2);
        verifyTrue(websitePage.isAppLogoDisplayedAfterSelectSlidebar("aliorders"));
        abstractPage.takeScreenshot("Homepage9-AliOrders.jpg");
        websitePage.clickToGetAppButtonInSlidebar(Constants.ALI_ORDERS_GET_APP);
        abstractPage.takeScreenshot("Homepage10-AliOrders");
        abstractPage.switchToWindowsByTitle("Home Page - Fireapps");

        log.info("Body 4: Sales Box in slide bar - Get App button");
//        websitePage.scrollToAppSlideBar();
        websitePage.clickToNextAppSlide();
//        abstractPage.sleepInSecond(2);
        verifyTrue(websitePage.isAppLogoDisplayedAfterSelectSlidebar("salesbox"));
        abstractPage.takeScreenshot("Homepage9-SalesBox.jpg");
//        log.info("Body 4: Sales Box in slide bar - Get App button");
//        abstractPage.sleepInSecond(1);
//        websitePage.clickToSlideBarButtons("3");
//        websitePage.clickToSlideBarButtons("3");
//        verifyTrue(websitePage.isDescriptionDisplayedAfterSelectSlidebar("salesbox"));
//        abstractPage.takeScreenshot("HomePage9-SalesBox.jpg");
////        websitePage.clickToGetAppButtonInSlidebar(Constants.WEBSITE_SALES_BOX_URL);
////        verifyTrue(websitePage.isGetAppPageAccessed(Constants.WEBSITE_SALES_BOX_URL));
//        abstractPage.takeScreenshot("HomePage10-SalesBoxAppPage.jpg");
//        driver.get(Constants.WEBSITE_URL);

//        log.info("Body 5: Ali Hunter in slide bar - Get App button");
//        abstractPage.sleepInSecond(1);
//        websitePage.clickToSlideBarButtons("4");
//        websitePage.clickToSlideBarButtons("4");
//        verifyTrue(websitePage.isDescriptionDisplayedAfterSelectSlidebar("alihunter"));
//        abstractPage.takeScreenshot("HomePage11-AliHunter.jpg");
////        websitePage.clickToGetAppButtonInSlidebar(Constants.WEBSITE_ALI_HUNTER_URL);
////        verifyTrue(websitePage.isGetAppPageAccessed(Constants.WEBSITE_ALI_HUNTER_URL));
//        abstractPage.takeScreenshot("HomePage12-AliHunterAppPage.jpg");
//        driver.get(Constants.WEBSITE_URL);

//        log.info("Body 6: Check Maps on Home Page");
        websitePage.waitForMapSlideAndTakeTheScrShot("0", "HomePage-AliReviewMap0.jpg");
//        websitePage.waitForMapSlideAndTakeTheScrShot("1", "HomePage-AliOrdersMap1.jpg");
//        websitePage.waitForMapSlideAndTakeTheScrShot("2", "HomePage-SalesBoxMap2.jpg");
//        websitePage.waitForMapSlideAndTakeTheScrShot("3", "HomePage-AliHunterMap3.jpg");
//        websitePage.waitForMapSlideAndTakeTheScrShot("4", "HomePage-AliReviewMap4.jpg");
//        websitePage.waitForMapSlideAndTakeTheScrShot("5", "HomePage-AliOrdersMap5.jpg");
//        websitePage.waitForMapSlideAndTakeTheScrShot("6", "HomePage-SalesBoxMap6.jpg");
//        websitePage.waitForMapSlideAndTakeTheScrShot("7", "HomePage-AliHunterMap7.jpg");

        log.info("Body 6: Access 1st Blog post in Home Page");
        websitePage.clickToBlogPostInHomePage(Constants.BLOG_POST_TITLE1);
        verifyTrue(websitePage.isTheBlogPostAccessed(Constants.BLOG_POST_TITLE1));
        abstractPage.takeScreenshot("HomePage13-BlogPostFromHomePage.jpg");
        websitePage.clickToHeaderDynamic(Constants.WEBSITE_HOME_BUTTON);
        abstractPage.sleepInSecond(1);
        verifyTrue(websitePage.isHomePageAccessed());

        log.info("Body 7: Access 2nd Blog post in Home Page");
        websitePage.clickToBlogPostInHomePage(Constants.BLOG_POST_TITLE2);
        verifyTrue(websitePage.isTheBlogPostAccessed(Constants.BLOG_POST_TITLE2));
        websitePage.clickToHeaderDynamic(Constants.WEBSITE_HOME_BUTTON);
        abstractPage.sleepInSecond(1);
        verifyTrue(websitePage.isHomePageAccessed());

        log.info("Body 8: Access 3nd Blog post in Home Page");
        websitePage.clickToBlogPostInHomePage(Constants.BLOG_POST_TITLE3);
        verifyTrue(websitePage.isTheBlogPostAccessed(Constants.BLOG_POST_TITLE3));
        websitePage.clickToHeaderDynamic(Constants.WEBSITE_HOME_BUTTON);
        abstractPage.sleepInSecond(1);
        verifyTrue(websitePage.isHomePageAccessed());
    }

    @Test(enabled = false)
    public void Home3_checkFooterFunctions(){
        log.info("Footer 1: Shopify Apps link");
        websitePage = PageGeneratorManager.getWebsitePage(driver);
        websitePage.clickToCloseMessenger();
        websitePage.clickToFooterMenus("Shopify Apps");
        verifyTrue(websitePage.isShopifyAppsPageAccessed());
        abstractPage.takeScreenshot("HomePage14-Footer-ShopifyApps.jpg");

        log.info("Footer 2: What's New link");
        websitePage.clickToFooterMenus("What");
        verifyTrue(websitePage.isWhatsNewPageAccessed());
        abstractPage.takeScreenshot("HomePage15-Footer-WhatsNew.jpg");

        log.info("Footer 3: Contact Us link");
        websitePage.clickToFooterMenus("Contact Us");
        verifyTrue(websitePage.isContactUsPageAccessed());
        abstractPage.takeScreenshot("HomePage16-Footer-ContactUs.jpg");

        log.info("Footer 4: About Us link");
        websitePage.clickToFooterMenus("About Us");
        verifyTrue(websitePage.isAboutUsPageAccessed());
        abstractPage.takeScreenshot("HomePage17-Footer-AboutUs.jpg");

        log.info("Footer 5: Help Center link");
        websitePage.clickToFooterMenus("Help Center");
        verifyTrue(websitePage.isHelpCenterPageAccessed());
        abstractPage.takeScreenshot("HomePage18-Footer-HelpCenter.jpg");
        driver.get(Constants.WEBSITE_URL);
        websitePage.clickToCloseMessenger();

        log.info("Footer 6: Privacy Policy link");
        websitePage.clickToFooterMenus("Privacy Policy");
        verifyTrue(websitePage.isPrivacyPolicyPageAccessed());
        abstractPage.takeScreenshot("HomePage19-Footer-PrivacyPolicy.jpg");

        log.info("Footer 7: Terms Of Service link");
        websitePage.clickToFooterMenus("Terms of Service");
        verifyTrue(websitePage.isTermsOfServicePageAccessed());
        abstractPage.takeScreenshot("HomePage20-Footer-TermsOfService.jpg");
        abstractPage.sleepInSecond(1);

        log.info("Footer 8: Facebook icon");
        websitePage.clickToFooterSocialIcons("facebook-square");
        verifyTrue(websitePage.isFooterSocialAccessed(Constants.FACEBOOK_TITLE, Constants.FOOTER_FACEBOOK_URL));
        abstractPage.takeScreenshot("HomePage21-Footer-Facebook.jpg");
        abstractPage.switchToWindowsByTitle("Terms Of Service - FireApps");

        log.info("Footer 9: Instagram icon");
        websitePage.clickToFooterSocialIcons("instagram");
        abstractPage.sleepInSecond(1);
        verifyTrue(websitePage.isFooterSocialAccessed(Constants.INSTAGRAM_TITLE, Constants.FOOTER_INSTAGRAM_URL));
        abstractPage.takeScreenshot("HomePage22-Footer-Instagram.jpg");
        abstractPage.switchToWindowsByTitle("Terms Of Service - FireApps");

        log.info("Footer 10: Twitter icon");
        websitePage.clickToFooterSocialIcons("twitter-square");
        verifyTrue(websitePage.isFooterSocialAccessed(Constants.TWITTER_TITLE, Constants.FOOTER_TWITTER_URL));
        abstractPage.takeScreenshot("HomePage23-Footer-Twitter.jpg");
        abstractPage.switchToWindowsByTitle("Terms Of Service - FireApps");

        log.info("Footer 10: Youtube icon");
        websitePage.clickToFooterSocialIcons("youtube");
        verifyTrue(websitePage.isFooterSocialAccessed(Constants.YOUTUBE_TITLE, Constants.FOOTER_YOUTUBE_URL));
        abstractPage.takeScreenshot("HomePage24-Footer-Youtube.jpg");
        abstractPage.switchToWindowsByTitle("Terms Of Service - FireApps");

        log.info("Footer 11: Back to top button");
        websitePage.clickToBackToTopButton();
        verifyTrue(websitePage.isPageBackToTop());
    }

    @Test
    public void test(){
        log.info("Footer 2: What's New link");
        websitePage = PageGeneratorManager.getWebsitePage(driver);
        websitePage.clickToFooterMenus("What");
        verifyTrue(websitePage.isWhatsNewPageAccessed());
        abstractPage.takeScreenshot("HomePage15-Footer-WhatsNew.jpg");

        String app = Constants.WHATSNEW_ALIREVIEWS;
        websitePage.selectAppFilter(app);
    }

    @AfterClass
    public void closeBowserAdDeleteBDatta(){
        closeBrowserAndDriver(driver);
    }
}
