package fireappsIO;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObject.WebsitePO;

public class functionBlogPage extends AbstractTest {
    private WebDriver driver;
    private AbstractPage abstractPage;
    private WebsitePO websitePage;
    String searchKeyword;

    @Parameters("browser")
    @BeforeClass
    public void beforeTest(String browserName) {
        driver = getBrowserDriver(browserName);
        abstractPage = new AbstractPage(driver);
        driver.get(Constants.WEBSITE_URL);
        websitePage = PageGeneratorManager.getWebsitePage(driver);
        log.info("Pre-condition: Access Blog Page");
        websitePage.clickToHeaderDynamic("Blog");
        verifyTrue(websitePage.isBlogPageAccessed());
        abstractPage.takeScreenshot("BlogPage1.jpg");
    }

    @Test
    public void Blog1_BlogHome(){
        log.info("Blog Home 1: Check slide banner display");
        websitePage.isSlideBannerInBlogHomeDisplayed();

        log.info("Blog Home 2: Verify eCommerce Marketing category has 3 slide posts");
        verifyTrue(websitePage.isCategoryHave3SlidePosts(Constants.BLOG_ECOMMERCE));

        log.info("Blog Home 3: Verify Super Tools category has 3 slide posts");
        verifyTrue(websitePage.isCategoryHave3SlidePosts(Constants.BLOG_SUPERTOOLS));

        log.info("Blog Home 4: Verify Case Studies category has 3 slide posts");
        verifyTrue(websitePage.isCategoryHave3SlidePosts(Constants.BLOG_CASESTUDIES));

        log.info("Blog Home 5: Verify Extra Talk category has 3 slide posts");
        verifyTrue(websitePage.isCategoryHave3SlidePosts(Constants.BLOG_EXTRATALK));

        log.info("Blog Home 6: Access eCommerce Marketing category and verify");
        websitePage.clickToCategoryOnMenu(Constants.BLOG_ECOMMERCE);
        verifyTrue(websitePage.isCategoryTitleEquals(Constants.BLOG_ECOMMERCE));
        abstractPage.takeScreenshot("BlogPage2-EcommerceCategory.jpg");

        log.info("Blog Home 7: Access Super Tools category and verify");
        websitePage.clickToCategoryOnMenu(Constants.BLOG_SUPERTOOLS);
        verifyTrue(websitePage.isCategoryTitleEquals(Constants.BLOG_SUPERTOOLS));
        abstractPage.takeScreenshot("BlogPage3-SupperToolsCategory.jpg");

        log.info("Blog Home 6: Access Case Studies category and verify");
        websitePage.clickToCategoryOnMenu(Constants.BLOG_CASESTUDIES);
        verifyTrue(websitePage.isCategoryTitleEquals(Constants.BLOG_CASESTUDIES));
        abstractPage.takeScreenshot("BlogPage4-CaseStudiesCategory.jpg");

        log.info("Blog Home 6: Access Extra Talk category and verify");
        websitePage.clickToCategoryOnMenu(Constants.BLOG_EXTRATALK);
        verifyTrue(websitePage.isCategoryTitleEquals(Constants.BLOG_EXTRATALK));
        abstractPage.takeScreenshot("BlogPage5-ExtraTalkCategory.jpg");
    }

    @Test
    public void Blog2_SearchFunction(){
        searchKeyword = "Shopify";
        log.info("Search Blog 1: Search for the result");
        websitePage.clickToSearchIcon();
        websitePage.inputToBlogSearch(searchKeyword);
        websitePage.clickToCloseSearchTextBox();
        abstractPage.sleepInSecond(1);
        websitePage.clickToSearchIcon();
        websitePage.clickToSearchActionButton();

        log.info("Search Blog 2: Check the result");
        verifyTrue(websitePage.isTheSearchResultLabelContains(searchKeyword));
        verifyTrue(websitePage.isSearchResultURLContains(searchKeyword));
        abstractPage.takeScreenshot("BlogPage6-SearchResult.jpg");

        log.info("Search Blog 3: Check Banner at search result redirect correct URL");
        websitePage.clickToBannerAtSearchResult();
        abstractPage.switchToWindowsByTitle("Ali Reviews AliExpress Reviews – Ecommerce Plugins for Online Stores – Shopify App Store");
        verifyTrue(websitePage.isBlogBannerCorrectURL(Constants.BANNER_AT_SEARCHRESULT_URL));
        abstractPage.switchToWindowsByTitle("Search blog - Fireapps");
    }

    @Test
    public void Blog3_SlideBanner(){
        log.info("Slide Banner Blog 1: Back to Blog home");
        websitePage.clickToHeaderDynamic("Blog");
        verifyTrue(websitePage.isBlogPageAccessed());

        log.info("Slide Banner Blog 2: Click to slide banner");
        websitePage.clickToSlideBanner();
        abstractPage.switchToWindowsByTitle("Ali Reviews AliExpress Reviews – Ecommerce Plugins for Online Stores – Shopify App Store");
        verifyTrue(websitePage.isBlogBannerCorrectURL(Constants.BLOG_SLIDE_BANNER_URL));
        abstractPage.switchToWindowsByTitle("Blog - Fireapps");
    }

    @Test
    public void Blog4_SubscribeFooter(){
        log.info("Blog Subscribe 1: Back to Blog home");
        websitePage.clickToHeaderDynamic("Blog");
        verifyTrue(websitePage.isBlogPageAccessed());

        log.info("Blog Subscribe 2: Name and Email are empty");
        websitePage.clickToSubscribeNowBtn();
        verifyTrue(websitePage.isErrorToolTipAppear(2));
        abstractPage.takeScreenshot("BlogPage7-Subscribe-Tooltips.jpg");

        log.info("Blog Subscribe 3: Name is empty");
        driver.get("https://fireapps.io/blog/");
        websitePage.inputToSubscribeTextboxes("Name", "Tam Nguyen");
        websitePage.clickToSubscribeNowBtn();
        verifyTrue(websitePage.isErrorToolTipAppear(1));

        log.info("Blog Subscribe 3: Email is empty");
        driver.get("https://fireapps.io/blog/");
        websitePage.inputToSubscribeTextboxes("Your email", "tamqada@gmail.com");
        websitePage.clickToSubscribeNowBtn();
        verifyTrue(websitePage.isErrorToolTipAppear(1));
        abstractPage.sleepInSecond(2);

        log.info("Blog Subscribe 4: Wrong Email format");
        websitePage.inputToSubscribeTextboxes("Name", "Tam Nguyen");
        websitePage.inputToSubscribeTextboxes("Your email", "tammail");
        websitePage.clickToSubscribeNowBtn();
        verifyTrue(websitePage.isErrorToolTipEmailDisplayed());
        abstractPage.takeScreenshot("BlogPage8-Subscribe-InvalidEmail.jpg");
    }

    @AfterClass
    public void afterTest(){
        closeBrowserAndDriver(driver);
    }


}
