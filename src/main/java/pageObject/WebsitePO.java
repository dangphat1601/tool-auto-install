package pageObject;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import commons.ReadDataCSV;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pageUI.WebsiteUI;

public class WebsitePO extends AbstractPage {
    WebDriver driver;
    public String storeURL;
    AbstractTest abstractTest = new AbstractTest();
    ReadDataCSV readDataCSV = new ReadDataCSV();

    public WebsitePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToHeaderDynamic(String headerLink){
        waitToElementClickable(WebsiteUI.HEADER_LINKS_DYNAMIC, headerLink);
        clickToElement(WebsiteUI.HEADER_LINKS_DYNAMIC, headerLink);
    }

    public boolean isHomePageAccessed(){
        return isElementDisplayed(WebsiteUI.H4_TEXT_CONTENT, "Premium e-commerce solutions come together");
    }

    public boolean isShopifyAppsPageAccessed(){
        sleepInSecond(1);
        String currentURL = getCurrentPageURL();
        return currentURL.contains(Constants.WEBSITE_SHOPIFY_APPS);
    }

    public boolean isBlogPageAccessed(){
        sleepInSecond(2);
        return isElementDisplayed(WebsiteUI.BLOG_LATEST_ARTICLES_MENU);
    }

    public boolean isAffiliateTabAccessed(){
        switchToWindowsByTitle("Affiliate - FireApps");
        return isElementDisplayed(WebsiteUI.AFFILIATE_JOIN_NOW_BUTTON);
    }

    public boolean isGetAppNowButtonWorkWell(){
        waitToElementVisible(WebsiteUI.H4_TEXT_CONTENT, "FireApps - Premium");
        return isElementDisplayed(WebsiteUI.H4_TEXT_CONTENT, "FireApps - Prenium");
    }

    public void clickToBodyGetAppNow(){
        waitToElementVisible(WebsiteUI.BODY_GET_APP_NOW_BUTTON);
        clickToElement(WebsiteUI.BODY_GET_APP_NOW_BUTTON);
    }

    public boolean isShopifyAppStoreFireAppsDisplayed(){
        waitToElementVisible(WebsiteUI.H2_TEXT_CONTENT, "FireApps - Premium Apps");
        return  isElementDisplayed(WebsiteUI.H2_TEXT_CONTENT, "FireApps - Premium Apps");
    }

    public boolean isAppLogoDisplayedAfterSelectSlidebar(String fileLogo){
        scrollToElement(WebsiteUI.APPS_LOGO_IN_SLIDEBAR, fileLogo);
        return isElementDisplayed(WebsiteUI.APPS_LOGO_IN_SLIDEBAR, fileLogo);
    }

    public void clickToGetAppButtonInSlidebar(String appHref){
        waitToElementVisible(WebsiteUI.GET_APP_LINK_IN_SLIDEBAR, appHref);
//        abstractTest.verifyTrue(isElementDisplayed(WebsiteUI.GET_APP_LINK_IN_SLIDEBAR, appHref));
        clickToElement(WebsiteUI.GET_APP_LINK_IN_SLIDEBAR, appHref);
    }

    public void scrollToAppSlideBar(){
        scrollToElement(WebsiteUI.EXPLORE_ALL_OF_OUR_APPS_LINK);
    }

    public String isPrevSlideButtonDisabled(){
        return getAttributeValue(WebsiteUI.PREVIOUS_SLIDE_BTN, "aria-disabled");
    }

    public String isNextSlideButtonDisabled(){
        return getAttributeValue(WebsiteUI.NEXT_SLIDE_BTN, "aria-disabled");
    }

    public boolean isGetAppPageAccessed(String link){
        sleepInSecond(1);
        String url = getCurrentPageURL();
        return url.contains(link);
    }

    public void clickToBlogPostInHomePage(String postTitle){
        waitToElementClickable(WebsiteUI.BLOG_POST_IN_HOME_PAGE, postTitle);
        scrollToElement(WebsiteUI.BLOG_POST_IN_HOME_PAGE, postTitle);
        clickToElementByJS(WebsiteUI.BLOG_POST_IN_HOME_PAGE, postTitle);
    }

    public boolean isTheBlogPostAccessed(String postTitle){
        waitToElementVisible(WebsiteUI.BLOG_POST_TITLE, postTitle);
        return isElementDisplayed(WebsiteUI.BLOG_POST_TITLE, postTitle);
    }

    public void clickToNextAppSlide(){
        waitToElementVisible(WebsiteUI.NEXT_SLIDE_BTN);
        sleepInSecond(1);
        clickToElementByJS(WebsiteUI.NEXT_SLIDE_BTN);
    }

    public void clickToPrevAppSlide(){
        waitToElementVisible(WebsiteUI.PREVIOUS_SLIDE_BTN);
        clickToElement(WebsiteUI.PREVIOUS_SLIDE_BTN);
    }

    public void clickToFooterMenus(String menuText){
        scrollToElement(WebsiteUI.FOOTER_MENUS, menuText);
        waitToElementClickable(WebsiteUI.FOOTER_MENUS, menuText);
        clickToElement(WebsiteUI.FOOTER_MENUS, menuText);
    }

    public void clickToViewAllBlogsLink(){
        waitToElementVisible(WebsiteUI.VIEW_ALL_BLOGS_LINK);
        clickToElement(WebsiteUI.VIEW_ALL_BLOGS_LINK);
    }

    public boolean isWhatsNewPageAccessed(){
        sleepInSecond(1);
        String url = getCurrentPageURL();
        return url.contains("fireapps.io/whats-new");
    }

    public boolean isContactUsPageAccessed(){
        return isElementDisplayed(WebsiteUI.EMAIL_TEXTBOX_CONTACT_US);
    }

    public boolean isAboutUsPageAccessed(){
        return isElementDisplayed(WebsiteUI.FOOTER_REDIRECT_PAGE_TITLE, "About Us");
    }

    public boolean isHelpCenterPageAccessed(){
        switchToWindowsByTitle(Constants.HELP_PAGE_TITLE);
        waitToElementVisible(WebsiteUI.HELP_PAGE_LOGO);
        return isElementDisplayed(WebsiteUI.HELP_PAGE_LOGO);
    }

    public boolean isPrivacyPolicyPageAccessed(){
        return isElementDisplayed(WebsiteUI.FOOTER_REDIRECT_PAGE_TITLE, "Privacy Policy");
    }

    public boolean isTermsOfServicePageAccessed(){
        return isElementDisplayed(WebsiteUI.FOOTER_REDIRECT_PAGE_TITLE, "Terms Of Service");
    }

    public void clickToFooterSocialIcons(String socialNetwork){
        waitToElementClickable(WebsiteUI.FOOTER_SOCIAL_ICONS, socialNetwork);
        clickToElement(WebsiteUI.FOOTER_SOCIAL_ICONS, socialNetwork);
    }

    public boolean isFooterSocialAccessed(String tabTitle, String expectedURL){
        switchToWindowsByTitle(tabTitle);
        return getCurrentPageURL().equals(expectedURL);
    }

    public void clickToBackToTopButton(){
        scrollToElement(WebsiteUI.FOOTER_MENUS, "Terms of Service");
        waitToElementClickable(WebsiteUI.BACK_TO_TOP_BUTTON);
        clickToElement(WebsiteUI.BACK_TO_TOP_BUTTON);
    }

    public boolean isPageBackToTop(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        sleepInSecond(1);
        Long value = (Long) jsExecutor.executeScript("return window.pageYOffset;");
        return value==0;
    }

    public boolean isSlideBannerInBlogHomeDisplayed(){
        return isElementDisplayed(WebsiteUI.BLOG_HOME_SLIDE_BANNER);
    }

    public boolean isCategoryHave3SlidePosts(String category){
        int slidePostsNum = countElements(WebsiteUI.BLOG_3POST_EACH_CATEGORY, category);
        return slidePostsNum==3;
    }

    public boolean isTopBannerBlogDisplayed(){
        return isElementDisplayed(WebsiteUI.BLOG_TOP_BANNER_AT_CATEGORY);
    }

    public void clickToCategoryOnMenu(String category){
        waitToElementClickable(WebsiteUI.BLOG_CATEGORIES_MENU, category);
        clickToElement(WebsiteUI.BLOG_CATEGORIES_MENU, category);
    }

    public boolean isCategoryTitleEquals(String categoryName){
        String categoryTitle = getTextElement(WebsiteUI.BLOG_CATEGORY_TITLE);
        return categoryName.equals(categoryTitle);
    }

    public void clickToSearchIcon(){
        waitToElementClickable(WebsiteUI.BLOG_SEARCH_BUTTON);
        clickToElement(WebsiteUI.BLOG_SEARCH_BUTTON);
    }

    public void inputToBlogSearch(String searchKeyword){
        waitToElementVisible(WebsiteUI.BLOG_SEARCH_TEXTBOX);
        sendKeyToElement(WebsiteUI.BLOG_SEARCH_TEXTBOX, searchKeyword);
    }

    public void clickToCloseSearchTextBox(){
        waitToElementClickable(WebsiteUI.BLOG_CLOSE_SEARCH_BUTTON);
        clickToElement(WebsiteUI.BLOG_CLOSE_SEARCH_BUTTON);
    }

    public void clickToSearchActionButton(){
        waitToElementClickable(WebsiteUI.BLOG_SEARCH_ACTION_BUTTON);
        clickToElement(WebsiteUI.BLOG_SEARCH_ACTION_BUTTON);
    }

    public boolean isTheSearchResultLabelContains(String keyword){
        String searchResultLabel = getTextElement(WebsiteUI.BLOG_SEARCH_RESULT_LABEL);
        return searchResultLabel.contains(keyword);
    }

    public boolean isSearchResultURLContains(String keyword){
        String resultURL = getCurrentPageURL();
        return resultURL.contains(keyword);
    }

    public void waitForMapSlideAndTakeTheScrShot(String indexValue, String fileName){
        waitToElementVisible(WebsiteUI.MAP_SLIDEBAR, indexValue);
        if(isElementDisplayed(WebsiteUI.MAP_SLIDEBAR, indexValue)){
            sleepInSecond(1);
            takeScreenshot(fileName);
        }
    }

    public void clickToBannerAtSearchResult(){
        waitToElementVisible(WebsiteUI.BLOG_BANNER_AT_SEARCHRESULT);
        clickToElement(WebsiteUI.BLOG_BANNER_AT_SEARCHRESULT);
    }

    public boolean isBlogBannerCorrectURL(String URL){
        String currentURL = getCurrentPageURL();
        return currentURL.contains(URL);
    }

    public void clickToSlideBanner(){
        waitToElementVisible(WebsiteUI.BLOG_SLIDE_BANNER);
        clickToElement(WebsiteUI.BLOG_SLIDE_BANNER);
    }

    public void clickToSubscribeNowBtn(){
        waitToElementClickable(WebsiteUI.BLOG_SUBSCRIBE_NOW_BTN);
        clickToElement(WebsiteUI.BLOG_SUBSCRIBE_NOW_BTN);
    }

    public boolean isErrorToolTipAppear(int numOfTooltips){
        waitToElementVisible(WebsiteUI.BLOG_ERROR_TOOLTIPS);
        return countElements(WebsiteUI.BLOG_ERROR_TOOLTIPS) == numOfTooltips;
    }

    public void inputToSubscribeTextboxes(String placeHolder, String textValue){
        waitToElementVisible(WebsiteUI.BLOG_SUBSCRIBE_TEXTBOXES, placeHolder);
        sendKeyToElement(WebsiteUI.BLOG_SUBSCRIBE_TEXTBOXES, textValue, placeHolder);
    }

    public boolean isErrorToolTipEmailDisplayed(){
        return isElementDisplayed(WebsiteUI.BLOG_TOOLTIP_INVALID_EMAIL);
    }

    public boolean isThereLoadingWheel(){
        boolean isLoadingWheelDisplay;
        if(countElements(WebsiteUI.WHATSNEW_POSTS_TITLE) >= 4){
            scrollToElement(WebsiteUI.FOOTER_MENUS, "About Us");
            isLoadingWheelDisplay = isElementDisplayed(WebsiteUI.WHATSNEW_LOADING_WHEEL);
        }else{
            System.out.println("There is lower than 4 post to load more");
            isLoadingWheelDisplay = !isElementDisplayed(WebsiteUI.WHATSNEW_LOADING_WHEEL);
        }
        return isLoadingWheelDisplay;
    }

    public boolean isEndOfPageLabelDisplayed(){
        sleepInSecond(2);
        scrollToElement(WebsiteUI.WHATSNEW_ENDOFPAGE_LABEL);
        return isElementDisplayed(WebsiteUI.WHATSNEW_ENDOFPAGE_LABEL);
    }

    public void selectAppFilter(String app){
//        scrollToElement(WebsiteUI.WHATSNEW_SEARCH_TEXTBOX);
//        waitToElementClickable(WebsiteUI.WHATSNEW_APP_CHECKBOXES, app);
        clickToElementByJS(WebsiteUI.WHATSNEW_APP_CHECKBOXES, app);
    }

    public boolean isOnlyAliReviewsPostsFiltered(){
        boolean isOnlyAliReviews = false;
        if(!isElementPresentInDOM(WebsiteUI.WHATSNEW_TAG_POSTS, Constants.APP_ALIORDERS) &&
        !isElementPresentInDOM(WebsiteUI.WHATSNEW_TAG_POSTS, Constants.APP_ALIHUNTER)&&
        !isElementPresentInDOM(WebsiteUI.WHATSNEW_TAG_POSTS, Constants.APP_SALESBOX)){
            isOnlyAliReviews = true;
        }
        return isOnlyAliReviews;
    }

    public boolean isOnlyAliOrdersPostsFiltered(){
        boolean isOnlyAliOrders = false;
        if(!isElementPresentInDOM(WebsiteUI.WHATSNEW_TAG_POSTS, Constants.APP_ALIREVIEWS) &&
                !isElementPresentInDOM(WebsiteUI.WHATSNEW_TAG_POSTS, Constants.APP_ALIHUNTER)&&
                !isElementPresentInDOM(WebsiteUI.WHATSNEW_TAG_POSTS, Constants.APP_SALESBOX)){
            isOnlyAliOrders = true;
        }
        return isOnlyAliOrders;
    }

    public boolean isOnlySalesBoxPostsFiltered(){
        boolean isOnlySalesBox = false;
        if(!isElementPresentInDOM(WebsiteUI.WHATSNEW_TAG_POSTS, Constants.APP_ALIORDERS) &&
                !isElementPresentInDOM(WebsiteUI.WHATSNEW_TAG_POSTS, Constants.APP_ALIHUNTER)&&
                !isElementPresentInDOM(WebsiteUI.WHATSNEW_TAG_POSTS, Constants.APP_ALIREVIEWS)){
            isOnlySalesBox = true;
        }
        return isOnlySalesBox;
    }

    public boolean isOnlyAliHunterPostsFiltered(){
        boolean isOnlyAliHunter = false;
        if(!isElementPresentInDOM(WebsiteUI.WHATSNEW_TAG_POSTS, Constants.APP_ALIORDERS) &&
                !isElementPresentInDOM(WebsiteUI.WHATSNEW_TAG_POSTS, Constants.APP_ALIREVIEWS)&&
                !isElementPresentInDOM(WebsiteUI.WHATSNEW_TAG_POSTS, Constants.APP_SALESBOX)){
            isOnlyAliHunter = true;
        }
        return isOnlyAliHunter;
    }

    public void clickToTagApps(String appsTag){
        waitToElementClickable(WebsiteUI.WHATSNEW_TAG_POSTS, appsTag);
        clickToElementByJS(WebsiteUI.WHATSNEW_TAG_POSTS, appsTag);
    }

    public void scrollToFooter(){
        scrollToElement(WebsiteUI.FOOTER_MENUS, "Shopify Apps");
    }

    public void clickToBackToAllChanges(){
        waitToElementVisible(WebsiteUI.WHATSNEW_BACK_BTN);
        clickToElement(WebsiteUI.WHATSNEW_BACK_BTN);
    }

    public void inputToWhatsNewSearch(String keyword){
        waitToElementVisible(WebsiteUI.WHATSNEW_SEARCH_TEXTBOX);
        sendKeyToElement(WebsiteUI.WHATSNEW_SEARCH_TEXTBOX, keyword);
    }

    public void clickToWhatsNewSearchAction(){
        waitToElementClickable(WebsiteUI.WHATSNEW_SEARCH_ACTION_BTN);
        clickToElement(WebsiteUI.WHATSNEW_SEARCH_ACTION_BTN);
    }

    public boolean isWhatsNewSearchResultContains(String keyword){
        String result = getTextElement(WebsiteUI.WHATSNEW_POSTS_TITLE);
        return result.contains(keyword);
    }

    public boolean isWhatsNewNoResult(){
        return isElementDisplayed(WebsiteUI.WHATSNEW_NO_POSTS_DISPLAY);
    }

    public void selectShareOptions(String option){
        waitToElementClickable(WebsiteUI.WHATSNEW_FIRST_POST_SHARE_ICON);
        clickToElement(WebsiteUI.WHATSNEW_FIRST_POST_SHARE_ICON);
        waitToElementVisible(WebsiteUI.WHATSNEW_FIRST_POST_SHARE_OPTIONS, option);
        clickToElement(WebsiteUI.WHATSNEW_FIRST_POST_SHARE_OPTIONS, option);
    }

    public boolean isSharedPostToFacebook(){
        switchToWindowsByTitle("Facebook");
        waitToElementVisible(WebsiteUI.WHATSNEW_FACEBOOK_SHARE_PAGE);
        return isElementDisplayed(WebsiteUI.WHATSNEW_FACEBOOK_SHARE_PAGE);
    }

    public boolean isSharedPostToTwitter(){
        switchToWindowsByTitle("Twitter");
        waitToElementVisible(WebsiteUI.WHATSNEW_TWITTER_SHARE_PAGE);
        return isElementDisplayed(WebsiteUI.WHATSNEW_TWITTER_SHARE_PAGE);
    }

    public boolean isSharedPostToLinkedin(){
        switchToWindowsByTitle("LinkedIn Login, Sign in | LinkedIn");
        waitToElementVisible(WebsiteUI.WHATSNEW_LINKEDIN_SHARE_PAGE);
        return isElementDisplayed(WebsiteUI.WHATSNEW_LINKEDIN_SHARE_PAGE);
    }

    public void clickToCloseMessenger(){
        if(isElementPresentInDOM(WebsiteUI.MESSENGER_IFRAME)) {
            sleepInSecond(1);
            switchToFrameOrIframe(WebsiteUI.MESSENGER_IFRAME);
            waitToElementVisible(WebsiteUI.CLOSE_BUTTON_MESSENGER_POPUP);
            clickToElement(WebsiteUI.CLOSE_BUTTON_MESSENGER_POPUP);
            driver.switchTo().defaultContent();
        }
    }

    public boolean checkBlogPostAtHomePage(String postPosition){
        String postTitle;
//        waitToElementVisible(WebsiteUI.BLOG_TITLE_IN_HOME_PAGE, postPosition);
        postTitle = getTextElement(WebsiteUI.BLOG_TITLE_IN_HOME_PAGE, postPosition);
        System.out.println(postTitle);
        clickToElement(WebsiteUI.BLOG_TITLE_IN_HOME_PAGE, postPosition);
        String title = getTextElement(WebsiteUI.BLOG_CHECK_TITLE);
        return postTitle.contains(title);
    }


    //SLIDE APPS
    public void scrollToOurEssentialApps(){
        scrollToElement(WebsiteUI.OUR_ESSENTIAL_APPS_TEXT);
    }

    public void selectAppsByDot(String dotPos){
        waitToElementVisible(WebsiteUI.GO_TO_SLIDE_DOTS, dotPos);
        clickToElement(WebsiteUI.GO_TO_SLIDE_DOTS, dotPos);
    }

    public boolean isInstallAppPageAccessed(String app){
        boolean pageAccessed;
        switch (app){
            case "Ali Reviews":
                switchToWindowsByTitle("Ali Reviews – Import AliExpress Reviews to Shopify Store - FireApps");
                pageAccessed = isElementPresentInDOM(WebsiteUI.BLOG_POST_TITLE, "Ali Reviews");
                break;
            case "Ali Hunter":
                switchToWindowsByTitle("Ali Hunter - FireApps");
                sleepInSecond(1);
                pageAccessed = isElementDisplayed(WebsiteUI.ALI_HUNTER_DESCRIPTION);
                break;
            case "Ali Orders":
                switchToWindowsByTitle("Ali Orders – Automate Your AliExpress Dropshipping Business - FireApps");
                pageAccessed = isElementPresentInDOM(WebsiteUI.BLOG_POST_TITLE, "Ali Orders");
                break;
            case "Sales Box":
                switchToWindowsByTitle("Sales Box - FireApps");
                pageAccessed = isElementPresentInDOM(WebsiteUI.BLOG_POST_TITLE, "Sales Box");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + app);
        }
        return pageAccessed;
    }

    public void switchBannerByDot(String position){
        waitToElementVisible(WebsiteUI.DOT_ICON_TO_MOVE_SLIDE_APP, position);
        clickToElement(WebsiteUI.DOT_ICON_TO_MOVE_SLIDE_APP, position);
    }

}
