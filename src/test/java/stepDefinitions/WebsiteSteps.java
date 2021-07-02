package stepDefinitions;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;
import pageObject.WebsitePO;
import pageUI.WebsiteUI;

public class WebsiteSteps extends AbstractTest {
    WebDriver driver;
    WebsitePO websitePage;
    AbstractPage abstractPage;

    public WebsiteSteps() {
        driver = Hooks.openBrowser();
        websitePage = new WebsitePO(driver);
        abstractPage = new AbstractPage(driver);
    }

    @Given("^I access the website$")
    public void i_access_the_website() {
        driver.get(Constants.WEBSITE_URL);
    }

    @And("^I quit the browser$")
    public void i_quit_the_browser() {
        closeBrowserAndDriver(driver);
    }


    @When("^I access the \"([^\"]*)\" from header$")
    public void i_access_the_something_from_header(String headerMenu) {
        websitePage.clickToHeaderDynamic(headerMenu);
    }

    @And("^verify the Home page has been accessed$")
    public void verify_the_home_page_has_been_accessed() {
        abstractPage.switchToWindowsByTitle("Home Page - Fireapps");
        verifyTrue(websitePage.isHomePageAccessed());
    }

    @And("^I take the screenshot as \"([^\"]*)\"$")
    public void i_take_the_screenshot_as_something(String fileName) {
        abstractPage.takeScreenshot(fileName);
    }

    @And("^I close the messenger pop up$")
    public void i_close_the_messenger_pop_up() {
        websitePage.scrollToFooter();
        websitePage.clickToCloseMessenger();
    }

    @And("^verify the Shopify Apps page has been accessed$")
    public void verify_the_shopify_apps_page_has_been_accessed() {
        abstractPage.sleepInSecond(1);
        verifyTrue(websitePage.isShopifyAppsPageAccessed());
    }

    @And("^verify the Blog page has been accessed$")
    public void verify_the_blog_page_has_been_accessed() {
        verifyTrue(websitePage.isBlogPageAccessed());
    }

    @And("^verify the Affiliate page has been accessed$")
    public void verify_the_affiliate_page_has_been_accessed() {
        verifyTrue(websitePage.isAffiliateTabAccessed());
        abstractPage.takeScreenshot("Header4-Affiliate.jpg");
        abstractPage.switchToWindowsByTitle("Blog - FireApps");
        verifyTrue(websitePage.isBlogPageAccessed());
    }

    @And("^verify the FireApps app store has been accessed$")
    public void verify_the_fireapps_app_store_has_been_accessed() {
        String url = websitePage.getCurrentPageURL();
        verifyEquals(url, Constants.WEBSITE_SHOPIFY_APPS);
    }

    @Then("^I return to Home page$")
    public void i_return_to_home_page() {
        abstractPage.switchToWindowsByTitle("Blog - Fireapps");
        websitePage.clickToHeaderDynamic(Constants.WEBSITE_HOME_BUTTON);
        abstractPage.switchToWindowsByTitle("Home Page - Fireapps");
        verifyTrue(websitePage.isHomePageAccessed());
    }

    @When("^I click on Get App Now button$")
    public void i_click_on_get_app_now_button() {
        websitePage.clickToBodyGetAppNow();
    }

    @And("^I check the Ali Review app from the slider$")
    public void i_check_the_ali_review_app_from_the_slider() {
        websitePage.scrollToAppSlideBar();
        abstractPage.sleepInSecond(1);
        verifyTrue(websitePage.isAppLogoDisplayedAfterSelectSlidebar("alireviews"));
    }

    @And("^verify the Previous button is disabled$")
    public void verify_the_Previous_button_is_disabled() {
        verifyEquals(websitePage.isPrevSlideButtonDisabled(), "true");
    }

    @And("^I click to Get App button of \"([^\"]*)\" app$")
    public void i_click_to_get_app_button_of_something_app(String app) {
        switch (app) {
            case "Ali Reviews":
                websitePage.clickToGetAppButtonInSlidebar(Constants.ALI_REVIEW_GET_APP);
                break;
            case "Ali Orders":
                websitePage.clickToGetAppButtonInSlidebar(Constants.ALI_ORDERS_GET_APP);
                break;
            case "Ali Hunter":
                websitePage.clickToGetAppButtonInSlidebar(Constants.ALI_HUNTER_GET_APP);
                break;
            case "Sales Box":
                websitePage.clickToGetAppButtonInSlidebar(Constants.SALES_BOX_GET_APP);
                break;
        }
    }

    @And("^verify the \"([^\"]*)\" install page appears$")
    public void verify_the_something_install_page_appears(String app) {
        switch (app) {
            case "Ali Reviews":
//                abstractPage.switchToWindowsByTitle("Ali Reviews – Import AliExpress Reviews to Shopify Store - FireApps");
                verifyTrue(websitePage.isInstallAppPageAccessed("Ali Reviews"));
                abstractPage.switchToWindowsByTitle(Constants.HOME_PAGE_TITLE);
                break;
            case "Ali Hunter":
//                abstractPage.switchToWindowsByTitle("Ali Hunter - FireApps");
                abstractPage.sleepInSecond(1);
                verifyTrue(websitePage.isInstallAppPageAccessed("Ali Hunter"));
                abstractPage.switchToWindowsByTitle(Constants.HOME_PAGE_TITLE);
                break;
            case "Ali Orders":
//                abstractPage.switchToWindowsByTitle("Ali Orders – Automate Your AliExpress Dropshipping Business - FireApps");
                abstractPage.sleepInSecond(1);
                verifyTrue(websitePage.isInstallAppPageAccessed("Ali Orders"));
                abstractPage.switchToWindowsByTitle(Constants.HOME_PAGE_TITLE);
                break;
            case "Sales Box":
//                abstractPage.switchToWindowsByTitle("Sales Box - FireApps");
                abstractPage.sleepInSecond(1);
                verifyTrue(websitePage.isInstallAppPageAccessed("Sales Box"));
//                verifyTrue(websitePage.isGetAppPageAccessed(Constants.WEBSITE_SALES_BOX_URL));
                abstractPage.switchToWindowsByTitle(Constants.HOME_PAGE_TITLE);
                break;
        }
    }

    @And("^verify the Ali Reviews install page appears$")
    public void verify_the_ali_reviews_install_page_appears() {
        abstractPage.sleepInSecond(1);
        verifyTrue(websitePage.isInstallAppPageAccessed("Ali Reviews"));
        abstractPage.switchToWindowsByTitle(Constants.HOME_PAGE_TITLE);
    }

    @And("^verify the Ali Hunter install page appears$")
    public void verify_the_ali_hunter_install_page_appears(){
        abstractPage.sleepInSecond(1);
        verifyTrue(websitePage.isInstallAppPageAccessed("Ali Hunter"));
        abstractPage.switchToWindowsByTitle(Constants.HOME_PAGE_TITLE);
    }

    @And("^verify the Ali Orders install page appears$")
    public void verify_the_ali_orders_install_page_appears(){
        abstractPage.sleepInSecond(1);
        verifyTrue(websitePage.isInstallAppPageAccessed("Ali Orders"));
        abstractPage.switchToWindowsByTitle(Constants.HOME_PAGE_TITLE);
    }

    @And("^verify the Sales Box install page appears$")
    public void verify_the_sales_box_install_page_appears(){
        abstractPage.sleepInSecond(1);
        verifyTrue(websitePage.isInstallAppPageAccessed("Sales Box"));
        abstractPage.switchToWindowsByTitle(Constants.HOME_PAGE_TITLE);
    }

    @And("^I check the Ali Hunter app from the slider$")
    public void i_check_the_ali_hunter_app_from_the_slider() {
        websitePage.scrollToAppSlideBar();
//        websitePage.clickToNextAppSlide();
        websitePage.switchBannerByDot("3");
        abstractPage.sleepInSecond(1);
        verifyTrue(websitePage.isAppLogoDisplayedAfterSelectSlidebar("alihunter"));
    }

    @And("^I check the Ali Orders app from the slider$")
    public void i_check_the_ali_orders_app_from_the_slider() {
        abstractPage.sleepInSecond(1);
        websitePage.scrollToAppSlideBar();
//        websitePage.clickToNextAppSlide();
        websitePage.switchBannerByDot("2");
        abstractPage.sleepInSecond(1);
        verifyTrue(websitePage.isAppLogoDisplayedAfterSelectSlidebar("aliorders"));
    }

    @And("^I check the Sales Box app from the slider$")
    public void i_check_the_sales_box_app_from_the_slider() {
        websitePage.scrollToAppSlideBar();
        websitePage.switchBannerByDot("4");
        abstractPage.sleepInSecond(1);
        verifyTrue(websitePage.isAppLogoDisplayedAfterSelectSlidebar("salesbox"));
    }

    @And("^I wait for testimonial slide \"([^\"]*)\" display and take the screenshot$")
    public void i_wait_for_testimonial_slide_something_display_and_take_the_screenshot(String slideNum) {
        abstractPage.scrollToElement(WebsiteUI.LOVED_BY_PEOPLES_LABEL);
        String indexValue;
        switch (slideNum) {
            case "1":
                indexValue = "0";
                websitePage.waitForMapSlideAndTakeTheScrShot("0", "HomePage5-AliReviewMap0.jpg");
//                abstractPage.waitToElementVisible(WebsiteUI.MAP_SLIDEBAR, indexValue);
//                verifyTrue(abstractPage.isElementDisplayed(WebsiteUI.MAP_SLIDEBAR, indexValue));
//                abstractPage.takeScreenshot("HomePage5-AliReviewMap1.jpg");
                break;
            case "2":
                indexValue = "1";
                websitePage.waitForMapSlideAndTakeTheScrShot(indexValue, "HomePage6-AliOrderMap1.jpg");
//                abstractPage.waitToElementVisible(WebsiteUI.MAP_SLIDEBAR, indexValue);
//                verifyTrue(abstractPage.isElementDisplayed(WebsiteUI.MAP_SLIDEBAR, indexValue));
//                abstractPage.takeScreenshot("HomePage6-AliOrderMap1.jpg");
                break;
            case "3":
                indexValue = "2";
                websitePage.waitForMapSlideAndTakeTheScrShot(indexValue, "HomePage7-SalesBoxMap2.jpg");
//                abstractPage.waitToElementVisible(WebsiteUI.MAP_SLIDEBAR, indexValue);
//                verifyTrue(abstractPage.isElementDisplayed(WebsiteUI.MAP_SLIDEBAR, indexValue));
//                abstractPage.takeScreenshot("HomePage7-SalesBoxMap2.jpg");
                break;
            case "4":
                indexValue = "3";
                websitePage.waitForMapSlideAndTakeTheScrShot(indexValue, "HomePage8-AliHunterMap3.jpg");
//                abstractPage.waitToElementVisible(WebsiteUI.MAP_SLIDEBAR, indexValue);
//                verifyTrue(abstractPage.isElementDisplayed(WebsiteUI.MAP_SLIDEBAR, indexValue));
//                abstractPage.takeScreenshot("HomePage8-AliHunterMap3.jpg");
                break;
            case "5":
                indexValue = "4";
                websitePage.waitForMapSlideAndTakeTheScrShot(indexValue, "HomePage9-AliReviewMap4.jpg");
//                abstractPage.waitToElementVisible(WebsiteUI.MAP_SLIDEBAR, indexValue);
//                verifyTrue(abstractPage.isElementDisplayed(WebsiteUI.MAP_SLIDEBAR, indexValue));
//                abstractPage.takeScreenshot("HomePage9-AliReviewMap4.jpg");
                break;
            case "6":
                indexValue = "5";
                websitePage.waitForMapSlideAndTakeTheScrShot(indexValue, "HomePage10-AliOrdersMap5.jpg");
//                abstractPage.waitToElementVisible(WebsiteUI.MAP_SLIDEBAR, indexValue);
//                verifyTrue(abstractPage.isElementDisplayed(WebsiteUI.MAP_SLIDEBAR, indexValue));
//                abstractPage.takeScreenshot("HomePage10-AliOrdersMap5.jpg");
                break;
            case "7":
                indexValue = "6";
                websitePage.waitForMapSlideAndTakeTheScrShot(indexValue, "HomePage11-SalesBoxMap6.jpg");
//                abstractPage.waitToElementVisible(WebsiteUI.MAP_SLIDEBAR, indexValue);
//                verifyTrue(abstractPage.isElementDisplayed(WebsiteUI.MAP_SLIDEBAR, indexValue));
//                abstractPage.takeScreenshot("HomePage11-SalesBoxMap6.jpg");
                break;
            case "8":
                indexValue = "7";
                websitePage.waitForMapSlideAndTakeTheScrShot(indexValue, "HomePage12-AliHunterMap7.jpg");
//                abstractPage.waitToElementVisible(WebsiteUI.MAP_SLIDEBAR, indexValue);
//                verifyTrue(abstractPage.isElementDisplayed(WebsiteUI.MAP_SLIDEBAR, indexValue));
//                abstractPage.takeScreenshot("HomePage12-AliHunterMap7.jpg");
                break;
        }
    }

    @And("^I back to Home page$")
    public void i_back_to_home_page() {
        driver.get(Constants.WEBSITE_URL);
    }

    @And("^I check the 1st blog post at Home page work well$")
    public void i_check_the_1st_blog_post_at_home_page_work_well() {
        verifyTrue(websitePage.checkBlogPostAtHomePage("1"));
    }

    @And("^I check the 2nd blog post at Home page work well$")
    public void i_check_the_2nd_blog_post_at_home_page_work_well() {
        verifyTrue(websitePage.checkBlogPostAtHomePage("2"));
    }

    @And("^I check the 3rd blog post at Home page work well$")
    public void i_check_the_3rd_blog_post_at_home_page_work_well() {
        verifyTrue(websitePage.checkBlogPostAtHomePage("3"));
    }

    @And("^I click to View all blogs link$")
    public void i_click_to_view_all_blogs_link(){
        websitePage.clickToViewAllBlogsLink();
    }

    @When("^I click to \"([^\"]*)\" from the footer$")
    public void i_click_to_something_from_the_footer(String menuText) {
        websitePage.clickToFooterMenus(menuText);
    }

    @And("^verify the What's New page has been accessed$")
    public void verify_the_whats_new_page_has_been_accessed() {
        websitePage.isWhatsNewPageAccessed();
    }

    @And("^verify the Contact Us page has been accessed$")
    public void verify_the_contact_us_page_has_been_accessed() {
        verifyTrue(websitePage.isContactUsPageAccessed());
    }

    @And("^verify the About Us page has been accessed$")
    public void verify_the_about_us_page_has_been_accessed() {
        abstractPage.sleepInSecond(1);
        verifyTrue(websitePage.isAboutUsPageAccessed());
    }

    @And("^verify the Help Center page has been accessed$")
    public void verify_the_help_center_page_has_been_accessed() {
        verifyTrue(websitePage.isHelpCenterPageAccessed());
    }

    @And("^verify the Privacy Policy page has been accessed$")
    public void verify_the_privacy_policy_page_has_been_accessed() {
        verifyTrue(websitePage.isPrivacyPolicyPageAccessed());
    }

    @And("^verify the Term of Service page has been accessed$")
    public void verify_the_term_of_service_page_has_been_accessed() {
        verifyTrue(websitePage.isTermsOfServicePageAccessed());
    }

    @And("^I click to \"([^\"]*)\" social icon in the footer$")
    public void i_click_to_something_social_icon_in_the_footer(String social) {
        String socialNetwork = null;
        switch (social){
            case "Facebook":
                socialNetwork = "facebook-square";
                websitePage.clickToFooterSocialIcons(socialNetwork);
                break;
            case "Instagram":
                socialNetwork = "instagram";
                websitePage.clickToFooterSocialIcons(socialNetwork);
                break;
            case "Twitter":
                socialNetwork = "twitter-square";
                abstractPage.sleepInSecond(1);
                websitePage.clickToFooterSocialIcons(socialNetwork);
                break;
            case "Youtube":
                socialNetwork = "youtube";
                websitePage.clickToFooterSocialIcons(socialNetwork);
                break;
            default: System.out.println("Please fill the social network");
        }
    }

    @And("^verify the Facebook page has been accessed$")
    public void verify_the_facebook_page_has_been_accessed() {
        verifyTrue(websitePage.isFooterSocialAccessed(Constants.FACEBOOK_TITLE, Constants.FOOTER_FACEBOOK_URL));
    }

    @And("^verify the Instagram page has been accessed$")
    public void verify_the_instagram_page_has_been_accessed() {
        abstractPage.sleepInSecond(1);
        verifyTrue(websitePage.isFooterSocialAccessed(Constants.INSTAGRAM_TITLE, Constants.FOOTER_INSTAGRAM_URL));
    }

    @And("^verify the Youtube page has been accessed$")
    public void verify_the_youtube_page_has_been_accessed() {
        abstractPage.sleepInSecond(1);
        verifyTrue(websitePage.isFooterSocialAccessed(Constants.YOUTUBE_TITLE, Constants.FOOTER_YOUTUBE_URL));
    }

    @And("^verify the Twitter page has been accessed$")
    public void verify_the_twitter_page_has_been_accessed(){
        abstractPage.sleepInSecond(1);
        verifyTrue(websitePage.isFooterSocialAccessed(Constants.TWITTER_TITLE, Constants.FOOTER_TWITTER_URL));
    }

    @And("^verify the loading wheel is displayed if there are more than 4 posts$")
    public void verify_the_loading_wheel_is_displayed_if_there_are_more_than_4_posts() {
        verifyTrue(websitePage.isThereLoadingWheel());
    }

    @And("^verify the text label display after scroll to the end of page$")
    public void verify_the_text_label_display_after_scroll_to_the_end_of_page(){
        verifyTrue(websitePage.isEndOfPageLabelDisplayed());
    }

    @And("^I click on the \"([^\"]*)\" checkbox$")
    public void i_click_on_the_something_checkbox(String appCheckbox){
        String app = null;
        abstractPage.sleepInSecond(1);
        switch (appCheckbox){
            case "Ali Reviews":
                app = Constants.WHATSNEW_ALIREVIEWS;
                websitePage.selectAppFilter(app);
                break;
            case "Ali Hunter":
                app = Constants.WHATSNEW_ALIHUNTER;
                websitePage.selectAppFilter(app);
                break;
            case "Ali Orders":
                app = Constants.WHATSNEW_ALIORDERS;
                websitePage.selectAppFilter(app);
                break;
            case "Sales Box":
                app = Constants.WHATSNEW_SALESBOX;
                websitePage.selectAppFilter(app);
                break;
            default:
                System.out.println("The app name you inputted is incorrect or you did not input the app name");
        }
    }

    @And("^verify that only the posts of \"([^\"]*)\" displayed$")
    public void verify_that_only_the_posts_of_something_displayed(String appFiltered) {
        switch (appFiltered){
            case "Ali Reviews":
                verifyTrue(websitePage.isOnlyAliReviewsPostsFiltered());
                break;
            case "Ali Hunter":
                verifyTrue(websitePage.isOnlyAliHunterPostsFiltered());
                break;
            case "Ali Orders":
                verifyTrue(websitePage.isOnlyAliOrdersPostsFiltered());
                break;
            case "Sales Box":
                verifyTrue(websitePage.isOnlySalesBoxPostsFiltered());
                break;
        }
    }

    @And("^I click on back to all changes button$")
    public void i_click_on_back_to_all_changes_button() {
        websitePage.clickToBackToAllChanges();
    }

    @And("^I scroll to the bottom of page$")
    public void i_scroll_to_the_bottom_of_page() {
        websitePage.scrollToFooter();
    }

    @And("^I select the \"([^\"]*)\" tag$")
    public void i_select_the_something_tag(String tagName){
        websitePage.clickToTagApps(tagName);
    }

    @And("^I input the \"([^\"]*)\" keyword to the search text box$")
    public void i_input_the_something_keyword_to_the_search_text_box(String keyword){
        websitePage.inputToWhatsNewSearch(keyword);
    }

    @And("^I click to search button$")
    public void i_click_to_search_button() {
        websitePage.clickToWhatsNewSearchAction();
    }

    @Then("^verify the result contains the \"([^\"]*)\" keyword$")
    public void verify_the_result_contains_the_something_keyword(String keyword) {
        verifyTrue(websitePage.isWhatsNewSearchResultContains(keyword));
    }

    @Then("^verify there are no result display$")
    public void verify_there_are_no_result_display() {
        verifyTrue(websitePage.isWhatsNewNoResult());
    }
}

