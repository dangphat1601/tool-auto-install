package pageUI;

public class WebsiteUI {

    //Header
    public static final String HEADER_LINKS_DYNAMIC = "//ul[@class='navbar-nav']//a[contains(text(), '%s')]";
    public static final String H4_TEXT_CONTENT = "//h4[contains(text(), '%s')]";
    public static final String H2_TEXT_CONTENT = "//h2[contains(text(), '%s')]";
    public static final String BLOG_LATEST_ARTICLES_MENU = "//div[@class='border-top border-bottom d-none d-md-block m-subNav']//a[@title='Latest Articles']";
    public static final String AFFILIATE_JOIN_NOW_BUTTON = "//div[@class='text-center']/a[@href='https://affiliate.fireapps.io/register']";
    public static final String BODY_GET_APP_NOW_BUTTON = "//h4/following-sibling::a[@class='a-btn a-btn-pink btn rounded-pill']";

    //Apps slide bar at Home Page
    public static final String SLIDE_BAR_BUTTONS = "//span[@aria-label='Go to slide %s']";
//    public static final String APPS_LOGO_IN_SLIDEBAR = "//div[@class='row flex-md-row-reverse']//img[contains(@src, '%s')]";
    public static final String APPS_LOGO_IN_SLIDEBAR = "//div[contains(@class, 'swiper-slide-active')]//img[contains(@src, '%s')]";

//    public static final String DESCRIPTION_APP_IN_SLIDEBAR = "//p[@class='a-text a-line-bottom' and contains(text(), '%s')]";
//    public static final String GET_APP_LINK_IN_SLIDEBAR = "//img[contains(@src, '%s')]/parent::div/following-sibling::a[contains(@class, 'a-text-danger')]";
    public static final String GET_APP_LINK_IN_SLIDEBAR = "//img[contains(@src, '%s')]/ancestor::div[contains(@class, 'swiper-slide-active')]//a[contains(@class, 'a-text-danger')]";
    public static final String CLOSE_BUTTON_MESSENGER_POPUP = "//div[@class='_2t-5']";
    public static final String MESSENGER_ICON = "//div[@tabindex='0' and @role='button' and @style='cursor: pointer; outline: none;']";
    public static final String MESSENGER_IFRAME = "//iframe[contains(@src, 'customerchat')]";
    public static final String EXPLORE_ALL_OF_OUR_APPS_LINK = "//div[@class='text-center container']/a[@class='a-text-danger underlineltr']";

    public static final String LOVED_BY_PEOPLES_LABEL = "//p[@class='a-text-big' and contains(text(), 'Loved')]";

    //App slider
    public static final String PREVIOUS_SLIDE_BTN = "//span[contains(@class, 'swiper-button-prev')]";
    public static final String NEXT_SLIDE_BTN = "//span[contains(@class, 'swiper-button-next')]";
    public static final String DOT_ICON_TO_MOVE_SLIDE_APP = "//span[contains(@class, 'swiper-pagination-bullet') and @aria-label='Go to slide %s']";
    public static final String OUR_ESSENTIAL_APPS_TEXT = "//p[text()='Our essential apps']";
    public static final String GO_TO_SLIDE_DOTS = "//span[@aria-label='Go to slide %s']";


    public static final String FEEDBACK_LABEL = "//h4[@class='a-text-lead']";
    public static final String MAP_SLIDEBAR = "//div[@class='swiper-slide-content swiper-slide swiper-slide-active' and @data-swiper-slide-index='%s']";
    public static final String VIEW_ALL_BLOGS_LINK = "//p[@class='mb-0 text-center']/a[contains(text(), 'View all blogs')]";
    public static final String ALI_HUNTER_DESCRIPTION = "//p[@class='para-hunter']";

    //Blog articles at Home Page
    public static final String BLOG_POST_IN_HOME_PAGE = "//h4/a[contains(text(), '%s')]";
    public static final String BLOG_TITLE_IN_HOME_PAGE = "//div[@class='col-12 col-md-4 mb-3 mb-md-0'][%s]//h4/a";
    public static final String BLOG_CHECK_TITLE = "//article[@class='m-article-detail mb-5']/h1";
    public static final String BLOG_POST_TITLE = "//h1[contains(text(), '%s')]";

    //Footer
    public static final String FOOTER_MENUS = "//a[@class='nav-link' and contains(text(), '%s')]";
    public static final String FOOTER_SOCIAL_ICONS = "//i[@class='fab fa-%s']";

    public static final String WHATS_NEW_LOGO = "//div[@class=' group-logo ']//a[contains(text(), 'What')]";
    public static final String EMAIL_TEXTBOX_CONTACT_US = "//input[@name='your-email']";
    public static final String FOOTER_REDIRECT_PAGE_TITLE = "//h1[contains(text(), '%s')]";
    public static final String BACK_TO_TOP_BUTTON = "//a[@class='a-btn-top a-btn shadow']";
    public static final String HELP_PAGE_LOGO = "//div[@class='header__logo']//img[@alt='FireApps']";


    //BLOG PAGE
    public static final String BLOG_HOME_SLIDE_BANNER = "//figure[@class='a-banner-top']/a/img";
    public static final String BLOG_CATEGORIES_MENU = "//ul[contains(@class, 'justify-content-md-around')]/li/a[@title='%s']";
    public static final String BLOG_3POST_EACH_CATEGORY = "//h4[text()='%s']/parent::div[@class='container']//div[@class='col']";
    public static final String BLOG_TOP_BANNER_AT_CATEGORY = "//section[@class='o-content-topBanner']//img";
    public static final String BLOG_CATEGORY_TITLE = "//h4[@class='a-title-h2 a-title mb-4 mb-md-5']";

    public static final String BLOG_SEARCH_BUTTON = "//div[@class='m-searchForm']/button[@aria-controls='searchForm']";
    public static final String BLOG_SEARCH_TEXTBOX = "//form[@class='form-inline fade focus collapse show']//input[@placeholder='What are you interested in?']";
    public static final String BLOG_CLOSE_SEARCH_BUTTON = "//form[@class='form-inline fade focus collapse show']/following-sibling::i";
    public static final String BLOG_SEARCH_ACTION_BUTTON = "//form[@class='form-inline fade focus collapse show']//i[@class='far fa-search']";
    public static final String BLOG_SEARCH_RESULT_LABEL = "//span[@class='a-text-bold font-weight-bold']";

    public static final String BLOG_BANNER_AT_SEARCHRESULT = "//a[@class='d-block']";
    public static final String BLOG_SLIDE_BANNER = "//a[@class='d-block rounded-xl overflow-hidden']";

    public static final String BLOG_SUBSCRIBE_NOW_BTN = "//button[text()='Subscribe Now']";
    public static final String BLOG_SUBSCRIBE_TEXTBOXES = "//input[@placeholder='%s']";
    public static final String BLOG_ERROR_TOOLTIPS = "//div[@class='tooltip-inner']";
    public static final String BLOG_TOOLTIP_INVALID_EMAIL = "//div[@class='tooltip-inner' and text()='Please enter a valid email address.']";


    //WHAT'S NEW PAGE
    public static final String WHATSNEW_LOADING_WHEEL = "//i[@class='fas fa-spinner fa-spin js-what-news-loading']";
    public static final String WHATSNEW_POSTS_TITLE = "//h4[@class='card-title mb-3']/a";
    public static final String WHATSNEW_ENDOFPAGE_LABEL = "//span[text()='That’s the last of the results.']";
    public static final String WHATSNEW_TAG_POSTS = "//a[@class='a-btn a-btn-pink btn rounded-pill mr-2' and text()='%s']";
    public static final String WHATSNEW_APP_CHECKBOXES = "//input[@name='what_new_app' and @value='%s']";
//    public static final String WHATSNEW_APP_CHECKBOXES = "//label[@class='custom-control-label' and text()='%s']";
    public static final String WHATSNEW_SEARCH_TEXTBOX = "//aside[@class='o-sidebar col-12 col-md-4']//input[@placeholder='Search']";
    public static final String WHATSNEW_BACK_BTN = "//span[text()='Back to all changes']";
    public static final String WHATSNEW_SEARCH_ACTION_BTN = "//button[@class='btn a-btn-icon']";
    public static final String WHATSNEW_NO_POSTS_DISPLAY = "//div[@class='no-result-news m-article-changeLog text-center']";
    public static final String WHATSNEW_FIRST_POST_SHARE_ICON = "//article[@class='card m-article-changeLog shadow-sm position-relative'][1]//a[@class='a-icon-sharing dropdown-toggle']";
    public static final String WHATSNEW_FIRST_POST_SHARE_OPTIONS = "//article[@class='card m-article-changeLog shadow-sm position-relative'][1]//span[text()='%s']/parent::a";

    public static final String WHATSNEW_FACEBOOK_SHARE_PAGE = "//div[text()='Log into your Facebook account to share.']";
    public static final String WHATSNEW_TWITTER_SHARE_PAGE = "//span[text()='You’ll need to log in before you can share that Tweet.']";
    public static final String WHATSNEW_LINKEDIN_SHARE_PAGE = "//p[text()='New to LinkedIn? ']";









}
