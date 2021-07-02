package pageUI;

//import com.sun.org.apache.bcel.internal.generic.PUSH;

public class ShopifyPageUI {
    //Register
    public static final String START_FREE_TRIAL_BUTTON = "//ul[@class='marketing-nav__items marketing-nav__user display--expanded-nav']//input[@value='Start free trial']";
    //shopify doi text button start free trial random
    //public static final String START_FREE_TRIAL_BUTTON = "//*[@id=\"Hero\"]/div[1]/div/div[2]/form/div/div/button";
    public static final String REGISTER_TEXT_BOXES = "//input[@placeholder='%s']";
    public static final String CREATE_YOUR_STORE_BUTTON = "//button[text()='Create your store']";

    //Error Msg
    public static final String ERR_NAME_EXISTS = "//span[contains(text(), 'A store with that name already exists')]";
    public static final String ERR_ZIP_CODE = "//div[@id='PolarisTextField8Error']";
    public static final String ERR_PAGE_NOT_FOUND = "//h3[contains(text(),'The page youʼre looking for canʼt be found')]";
    public static final String NO_RESULT = "//h2[contains(text(),'No results for this request')]";

    //Tell us a little about yourself
    public static final String TITLE_MORE_INFO = "//h1[text()='Tell us a little about yourself']";
    public static final String DROPDOWN_SEEDING_QUESTION = "//select[@id='QuestionnaireSelect-background']";
    public static final String DROPDOWN_BUSINESS_REVENUE = "//select[@id='QuestionnaireSelect-business_revenue']";
    public static final String DROPDOWN_STORE_INDUSTRY = "//select[@id='QuestionnaireSelect-store_industry']";
    public static final String DROPDOWN_DESCRIBES = "//select[@id='QuestionnaireSelect-which_best_describes_you']";
    public static final String NEXT_BUTTON = "//button[@aria-label='Next']";

    //Account
    public static final String CREATE_ACCOUNT_TEXTBOXES = "//input[@name='account[%s]']";
    public static final String CREATE_ACCOUNT_BUTTON = "//button[text()='Create account']";
    public static final String TITLE_CHOOSE_AN_ACCOUNT = "//h1[text()='Choose an account']";
    public static final String CHOOSE_ACCOUNT_SELECT = "//div[@class='main-card-section']//a[last()-1]";
    public static final String CONTINUE_BUTTON = "//button[text()='Continue']";

    //Address info
    public static final String ADDRESS_INFO_TEXTBOXES = "//input[@name='account_setup[%s]']";
    public static final String ENTER_MY_STORE_BUTTON = "//button[@aria-label='Enter my store']";
    public static final String COUNTRY_DROPDOWN = "//select[@name='account_setup[country]']";
    public static final String STATES_DROPDOWN = "//select[@id='PolarisSelect3']";
    public static final String PROVINCE_DROPDOWN = "//select[@id='PolarisSelect2']";

    //Create an account
    public static final String TITLE_CREATE_AN_ACCOUNT = "//h1[text()='Create an account']";
    public static final String TITLE_TOO_MANY_REQUEST = "//h1[text()='Too Many Requests']";

    //Admin Page
    public static final String PAGINATION_TWO = "//div//a[@class='search-pagination__link' and text()='2']";
    public static final String PAGINATION_THREE = "//div//a[@class='search-pagination__link' and text()='3']";

    public static final String SELECT_PLAN_MSG = "//p[text()='Your trial just started']";
    public static final String STORE_NAME_LABEL = "//div[@class='_1lIG3']//span[text()='%s']";
    public static final String APPS_MENU = "//a[@href='/admin/apps']";
    public static final String DISCOUNTS_MENU = "//a[@href='/admin/discounts']";
    public static final String DELETE_ORIGINAL = "//button[@aria-label='Delete origin-app-dev']";
    public static final String CONFIRM_DELETE_ORIGINAL = "//div[@class='_1fyLs']//span[text()='Delete']";
    public static final String DELETE_SUCCESS_MESSAGE = "//div[@id='Banner1Content']";
    public static final String PRODUCT_MENU = "//span[text()='Products']/ancestor::a";
    public static final String ADD_PRODUCT_BTN = "//span[text()='Add product']/ancestor::a";
    public static final String PRODUCT_NAME_TEXTBOX = "//input[@name='title']";
    public static final String SAVE_PRODUCT_BTN = "//span[text()='Save']/ancestor::button";
    public static final String PREVIEW_PRODUCT_BTN = "//span[text()='Preview']/ancestor::button";
    public static final String VISIT_SHOPIFY_APP_STORE_BTN = "//*[@id=\"AppFrameMain\"]/div/div/div[1]/div/div[2]/div/a/span";
    public static final String SEARCH_APPS_TEXTBOX = "//input[@type='search' and contains(@class, 'hero')]";
    public static final String TRANSCY_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Transcy')]";
    public static final String MESSENT_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Messent')]";
    public static final String CHATALYST_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Chatalyst Customer Support')]";
    public static final String SWIFT_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Swift ‑ Page Speed Optimizer')]";
    public static final String ADD_APP_BTN = "//input[@value='Add app']";
//    public static final String ADD_APP_BTN = "//a[contains(text(),'Add app')]";
    public static final String UPGRADE_YOUR_ACCOUNT_PAGE = "//h1[text()='Upgrade your account']";
    public static final String SEARCH_BTN = "//button[@type='submit' and contains(@class, 'hero-search')]";
    public static final String CHOOSE_PLAN = "//h4[text()='Choose your plan']";
    public static final String CHOOSE_PLAN_FREE = "//div[@class='pricing-plan__content-scroll sticky-item']//div[1]//div[1]//form[1]//button[1]";
    public static final String OBERLO_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h2[contains(text(), 'Oberlo ‑ Dropshipping App')]";
    public static final String URL_OBERLO_APP_IN_APPSTORE = ".//a[contains(@href,'apps.shopify.com/oberlo')]";
    public static final String SHOW_FULL_DESCRIPTION_BTN = "//button[contains(text(),'Show full description')]";
    public static final String CREATE_DISCOUNT_BTN = "//span[contains(text(),'Create discount code')]";
    //public static final String SEARCH_SHOPIFY_APP_STORE_BTN = "//*[@id=\"ShopifyMainNav\"]/button[1]";
    public static final String SEARCH_APP_STORE_BTN = "//*[@id=\"ShopifyMainNav\"]/button[1]/span";
    public static final String SEARCH_BTN_SHOPIFY_APP_STORE_BTN = "//body/div[@id='UiSearchNavbar']/div[1]/div[1]/form[1]/label[1]/button[1]/*[1]";
    public static final String SEARCH_SHOPIFY_APP_STORE_BTN = "//*[@id=\"ShopifyMainNav\"]/button[1]";
    public static final String SEARCH_APP_TEXTBOX = "//*[@id=\"UiSearchSuggestionForm\"]/label/input";
    public static final String SEARCH_APP_OBERLO_TEXTBOX = "//*[@id=\"UiSearchSuggestionForm\"]/label/input";

    public static final String MULTI_IMPORTER_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Multichannel Importer')]";
    public static final String SPOCKET_DROPSHIPPING_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Spocket ‑ US & EU Dropshipping')]";
    public static final String DSER_ALIEXPRESS_DROPSHIPPING_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'DSers‑AliExpress Dropshipping')]";
    public static final String CJDROPSHIPPING = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'CJDropshipping')]";
    public static final String SYNCEE_GLOBAL_DROPSHIPPING_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Syncee ‑ Global Dropshipping')]";

    //CREATE DISCOUNT CODE
    public static final String DISCOUNT_CODE_TEXTBOX = "//input[@placeholder='e.g. SPRINGSALE']";
    public static final String DISCOUNT_VALUE_TEXTBOX = "//input[@id='percentageValueField']";
    public static final String USAGE_LIMITS_CHECKBOX = "//span[contains(text(),'Limit to one use per customer')]";
    public static final String SAVE_DISSCOUNT_CODE_BTN = "//span[contains(text(),'Save discount code')]";

    //FREE SHOPIFY APP - XPATH
    public static final String PRODUCT_REVIEW_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[(text()='Product Reviews')]";
    public static final String KIT_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[(text()='Kit')]";
    public static final String GOOGLE_CHANNEL_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[(text()='Google channel')]";
    public static final String SHOPIFY_EMAIL_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[(text()='Shopify Email')]";
    //public static final String SHOPIFY_CHAT_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[(text()='Shopify Chat')]";
    public static final String GEOLOCATION_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[(text()='Geolocation')]";
    public static final String FACEBOOK_CHANNEL_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[(text()='Facebook channel')]";

    //FREE SHOPIFY APP - URL
    public static final String URL_CHATALYST = ".//a[contains(@href,'apps.shopify.com/chatalyst')]";

    public static final String URL_PRODUCT_REVIEW_APP_IN_APPSTORE = ".//a[contains(@href,'apps.shopify.com/product-reviews')]";
    public static final String URL_KIT_APP_IN_APPSTORE = ".//a[contains(@href,'apps.shopify.com/kit')]";
    public static final String URL_GOOGLE_CHANNEL_APP_IN_APPSTORE = ".//a[contains(@href,'apps.shopify.com/google')]";
    public static final String URL_SHOPIFY_EMAIL_APP_IN_APPSTORE = ".//a[contains(@href,'apps.shopify.com/shopify-email')]";
    public static final String URL_GEOLOCATION_IN_APPSTORE = ".//a[contains(@href,'apps.shopify.com/geolocation')]";
    public static final String URL_FACEBOOK_CHANNEL_APP_IN_APPSTORE = ".//a[contains(@href,'apps.shopify.com/facebook')]";

    //FREE OTHER APPS FOR VPS - INSTALL OBERLO (LIST 1)
    public static final String URL_CONTACT_FORM_BUILDER_FREE = ".//a[contains(@href,'apps.shopify.com/contact-form-by-qikify')]";
    public static final String URL_MULTI_ANNOUNCEMENT_BAR_TIMER = ".//a[contains(@href,'apps.shopify.com/announcement-bar-maker-by-apphero')]";
    public static final String URL_SEARCH_PRODUCT_FILTER = ".//a[contains(@href,'apps.shopify.com/search-filter-upsell-cross-sell')]";
    public static final String URL_ULTIMATE_GDPR_EU_COOKIE_BANNER = ".//a[contains(@href,'apps.shopify.com/ultimate-gdpr-eu-cookie-bar')]";
    public static final String URL_AVADA_SIZE_CHART_FREE = ".//a[contains(@href,'apps.shopify.com/avada-size-chart')]";
    public static final String URL_URGENCY_PACK_ULTIMATE = ".//a[contains(@href,'apps.shopify.com/urgency-pack-ultimate')]";
    public static final String URL_POPUP_EMAIL_EXIIT_POPUPS = ".//a[contains(@href,'apps.shopify.com/poptin')]";
    public static final String URL_EASY_GDPR_COOKIE_BAR = ".//a[contains(@href,'apps.shopify.com/easy-gdpr')]";
    public static final String URL_MASSFULFILL = ".//a[contains(@href,'apps.shopify.com/massfulfill')]";
    public static final String URL_THANK_YOU_EMAIL_MARKETING_TOOL = ".//a[contains(@href,'apps.shopify.com/email-with-love')]";
    public static final String URL_QUICK_ANNOUNCEMENT_BAR = ".//a[contains(@href,'apps.shopify.com/quick-announcement-bar-always-keep-your-customers-informed')]";
    public static final String URL_SNAPCHAT_ADS = ".//a[contains(@href,'apps.shopify.com/snapchat-ads')]";
    public static final String URL_EMAIL_MARKETING_BY_AUTOMIZELY = ".//a[contains(@href,'apps.shopify.com/automizely-messages')]";
    public static final String URL_TRUST_ME_FREE_TRUST_BADGES = ".//a[contains(@href,'apps.shopify.com/trust-badge-by-giraffly')]";
    public static final String URL_FACEBOOK_INSTAGRAM_AUTO_POST = ".//a[contains(@href,'apps.shopify.com/post-studio-social-media-auto-post')]";
    public static final String URL_KEEP_CART = ".//a[contains(@href,'apps.shopify.com/remember-my-cart')]";
    public static final String URL_ZENDROP = ".//a[contains(@href,'apps.shopify.com/zendrop')]";
    public static final String URL_MAILERLITE_EMAIL_MARKETING = ".//a[contains(@href,'apps.shopify.com/mailerlite-email-marketing')]";
    public static final String URL_DYNAMIC_BANNER_SUITE = ".//a[contains(@href,'apps.shopify.com/coupon-banner-with-countdown-carousel')]";
    public static final String URL_PHOTO_RESIZE = ".//a[contains(@href,'apps.shopify.com/photo-resize-by-pixc')]";
    public static final String URL_EZYSLIPS_SHIPPING_RETURN = ".//a[contains(@href,'apps.shopify.com/ezyslips-order-processing-made-easy')]";
    public static final String URL_CONTACT_FORM_FORM_BUILDER = ".//a[contains(@href,'apps.shopify.com/easy-contact-form-by-ndnapps-com')]";
    public static final String URL_DRAG_DROP_PDF_INVOICE = ".//a[contains(@href,'apps.shopify.com/pdf-invoice-3')]";

    //FREE OTHER APPS FOR VPS - INSTALL OBERLO (LIST 2)
    public static final String URL_SPIN_WHEEL_POP_UPS_EMAIL_POPUP = ".//a[contains(@href,'apps.shopify.com/woohoo')]";
    public static final String URL_VIDEO_AD_MACHINE = ".//a[contains(@href,'apps.shopify.com/product-hero-animations')]";
    public static final String URL_MULTI_PIXELS_FOR_FACEBOOK = ".//a[contains(@href,'apps.shopify.com/multi-facebook-pixels')]";
    public static final String URL_SMART_PUSH_MARKETING_WEBPUSH = ".//a[contains(@href,'apps.shopify.com/web-push-notification')]";
    public static final String URL_FORM_BUILDER_WITH_FILE_UPLOAD = ".//a[contains(@href,'apps.shopify.com/form-builder-by-hulkapps')]";
    public static final String URL_STORE_IMPORTER = ".//a[contains(@href,'apps.shopify.com/store-importer')]";
    public static final String URL_BULK_DISCOUNTS_NOW = ".//a[contains(@href,'apps.shopify.com/quantity-breaks-now')]";
    public static final String URL_COUNTDOWN_ANNOUNCEMENT_BAR = ".//a[contains(@href,'apps.shopify.com/announcement-bar-with-slider')]";
    public static final String URL_PUSHDADDY_COUNTDOWN_TIMER = ".//a[contains(@href,'apps.shopify.com/powerful-countdown-timer')]";
    public static final String URL_WHATSAPP_CHAT_CART_RECOVERY = ".//a[contains(@href,'apps.shopify.com/whatsapp-sharing')]";
    public static final String URL_OMNISEND_EMAIL_MARKETING = ".//a[contains(@href,'apps.shopify.com/omnisend')]";
    public static final String URL_BACK_INSTOCK_RESTOCK_ALERTS = ".//a[contains(@href,'apps.shopify.com/customer-back-in-stock-alert-user-notification-app')]";
    public static final String URL_DATA_EXPORT_REPORTS = ".//a[contains(@href,'apps.shopify.com/data-export')]";
    public static final String URL_EPROLO_DROPSHIPPING_BRANDING = ".//a[contains(@href,'apps.shopify.com/eprolo')]";
    public static final String URL_ZOORIX_UPSELL_CROSS_SELL = ".//a[contains(@href,'apps.shopify.com/zoorix')]";
    public static final String URL_FONTIFY_USE_ANY_FONT = ".//a[contains(@href,'apps.shopify.com/fontify-change-customize-font-for-your-store')]";
    public static final String URL_KIWI_SIZE_CHART_RECOMMENDER = ".//a[contains(@href,'apps.shopify.com/kiwi-sizing')]";
    public static final String URL_AFTERSHIP_RETURNS_CENTER = ".//a[contains(@href,'apps.shopify.com/returns-center-by-aftership')]";
    public static final String URL_SIMPLIO_SIMPLE_INVOICE = ".//a[contains(@href,'apps.shopify.com/simplio-simple-invoice')]";
    public static final String URL_QUANLITY_BREAK_DISCOUNTS = ".//a[contains(@href,'apps.shopify.com/pricing-by-quantity')]";
    public static final String URL_URGENCY_BEAR_COUNTDOWN_TIMER = ".//a[contains(@href,'apps.shopify.com/product-countdown-timer-1')]";
    public static final String URL_INSTANT_TRAFFIC_ADS = ".//a[contains(@href,'apps.shopify.com/free-traffic-exchange')]";
    public static final String URL_CUSTOM_FIELDS = ".//a[contains(@href,'apps.shopify.com/custom-fields-2')]";

    //FREE OTHER APPS (LIST 1)
    public static final String URL_MULTI_IMPORTER_APP_IN_APPSTORE = ".//a[contains(@href,'apps.shopify.com/ced-importer')]";
    public static final String URL_SPOCKET_DROPSHIPPING_APP_IN_APPSTORE = ".//a[contains(@href,'apps.shopify.com/spocket')]";
    public static final String URL_DSER_ALIEXPRESS_DROPSHIPPING_APP_IN_APPSTORE = ".//a[contains(@href,'apps.shopify.com/dsers')]";
    public static final String URL_CJDROPSHIPPING = ".//a[contains(@href,'apps.shopify.com/cucheng')]";
    public static final String URL_REPLAY_LIVE_SESSION_RECORDINGS = ".//a[contains(@href,'apps.shopify.com/replay')]";
    public static final String URL_SALE_KIT_BOOST_SALES_BUNDLE = ".//a[contains(@href,'apps.shopify.com/sale-kit')]";
    public static final String URL_FAQ_PAGE_ACCORDION = ".//a[contains(@href,'apps.shopify.com/easy-faqs-by-ndnapps-com')]";
    public static final String URL_SMARTMAIL_EMAIL_MARKETING = ".//a[contains(@href,'apps.shopify.com/smartrmail')]";
    public static final String URL_GDPR_CCPA_COOKIE_MANAGEMENT = ".//a[contains(@href,'apps.shopify.com/gdpr-backpack')]";
    public static final String URL_BULK_DISCOUNT_CODE_GENERATOR = ".//a[contains(@href,'apps.shopify.com/bulk-discount-generator')]";
    public static final String URL_EXCELIFY = ".//a[contains(@href,'apps.shopify.com/excel-export-import')]";
    public static final String URL_SHOPPING_FEED_FOR_GOOGLE = ".//a[contains(@href,'apps.shopify.com/google-express-integration')]";
    public static final String URL_SMART_MEGA_MENU_NAV = ".//a[contains(@href,'apps.shopify.com/smart-menu')]";
    public static final String URL_STOCK_SYNC_QTY_UPDATE_BY_SKU = ".//a[contains(@href,'apps.shopify.com/stock-sync')]";
    public static final String URL_CONVERSION_PLUS = ".//a[contains(@href,'apps.shopify.com/conversion')]";

    //FREE OTHER APPS (LIST 2)
    public static final String URL_COZY_ANTITHEFT = ".//a[contains(@href,'apps.shopify.com/cozy-antitheft-for-images-and-more')]";
    public static final String URL_FREE_TRUST_BADGE = ".//a[contains(@href,'apps.shopify.com/trust-badge')]";
    public static final String URL_BUY_ME_BUY_BUTTON = ".//a[contains(@href,'apps.shopify.com/mps-buy-me')]";
    public static final String URL_HELPCENTER_FAQ_HELPDESK = ".//a[contains(@href,'apps.shopify.com/helpcenter')]";
    public static final String URL_HONEYCOMB_UPSELL_CROSS_SELL = ".//a[contains(@href,'apps.shopify.com/honeycomb-upsell-funnels')]";
    public static final String URL_WISHLIST_PLUS = ".//a[contains(@href,'apps.shopify.com/swym-relay')]";
    public static final String URL_INSTAGRAM_FEED_STORIES = ".//a[contains(@href,'apps.shopify.com/instagram-stories-for-website')]";
    public static final String URL_PLUG_IN_SEO_OPTIMIZER = ".//a[contains(@href,'apps.shopify.com/plug-in-seo')]";
    public static final String URL_EASY_FAQ_FAST_FLEXIBLE = ".//a[contains(@href,'apps.shopify.com/faqs-plus')]";
    public static final String URL_METAFIELDS_GURU = ".//a[contains(@href,'apps.shopify.com/metafields-editor-2')]";
    public static final String URL_IN_CART_UPSELL_CROSS_SELL = ".//a[contains(@href,'apps.shopify.com/in-cart-upsell')]";
    public static final String URL_HYPERSKU = ".//a[contains(@href,'apps.shopify.com/hypersku')]";
    public static final String URL_GDPR_COOKIE_BAR_EPRIVATE_PAGE = ".//a[contains(@href,'apps.shopify.com/gdpr-cookie-consent')]";
    public static final String URL_CLICKSIT_RETURN_CENTER = ".//a[contains(@href,'apps.shopify.com/clicksit-return-center')]";
    public static final String URL_FREE_TRFFIC_ADS_BY_VARINODE = ".//a[contains(@href,'apps.shopify.com/ads')]";


    //FREE OTHER APP
    public static final String TRUSTEDSITE_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[(text()='TrustedSite - Trust Badges')]";
    public static final String FREE_TRUST_BADGE_IN_APPSTORE = "//h4[text()='Free Trust Badge']/ancestor::a";
    public static final String SHIPPO_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Shippo')]";
    public static final String PUSHOWL_WEB_PUSH_NOTIFICATION = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[(text()='PushOwl Web Push Notification')]";
    public static final String ULTIMATE_TRUST_BADGES_FREE = "//h4[text()='Ultimate Trust Badges']/ancestor::a";
    public static final String FACEBOOK_AND_INSTAGRAM_AUTO_POST = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[(text()='Facebook & Instagram Auto Post')]";
    public static final String PARCELPANNEL_ORDER_TRACKING_PRO = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'ParcelPanel Order Tracking Pro')]";
    public static final String WISHLIST_PLUS = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Wishlist Plus')]";
    public static final String ULTIMATE_COUNTDOWN_TIMER = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'ULTIMATE Countdown Timer')]";
    public static final String FREE_TRUST_BADGE_MASTER = "//h4[contains(text(), 'Free Trust Badge Master')]";
    public static final String VIDEOFY_PRODUCT_VIDEO_MAKER = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Vimeo Create ‑ Video Maker')]";
    public static final String SUPER_EFFECTS_HOLIDAY_BOOST = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Super Effects ‑ Holiday Boost')]";
    public static final String MASSFULFILL = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'MassFulfill')]";
    public static final String REVEAL_RFM_CUSTOMER_TAGS = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Reveal: RFM Customer Tags')]";
    public static final String THANK_YOU_EMAIL_MARKETING_TOOL = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Thank You Email Marketing Tool')]";

    public static final String CONTACT_FORM_BUILDER_FREE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Contact Form Builder ‑ FREE')]";
    public static final String MULTI_ANNOUNCEMENT_BAR_TIMER = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Multi‑Announcement Bar + Timer')]";
    public static final String SEARCH_PRODUCT_FILTER = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Search & Product Filter')]";
    public static final String ULTIMATE_GDPR_EU_COOKIE_BANNER = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Ultimate GDPR EU Cookie Banner')]";
    public static final String AVADA_SIZE_CHART_FREE = "//h4[contains(text(), 'AVADA Size Chart FREE!')]";
    public static final String URGENCY_PACK_ULTIMATE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Urgency Pack Ultimate')]";
    public static final String POPUP_EMAIL_EXIIT_POPUPS = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Pop Up, Email & Exit Pop Ups')]";
    public static final String EASY_GDPR_COOKIE_BAR = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Easy GDPR + Cookie Bar')]";

    public static final String SPIN_WHEEL_POP_UPS_EMAIL_POPUP = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Spin Wheel Pop ups Email Popup')]";
    public static final String VIDEO_AD_MACHINE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Video Ad Machine')]";
    public static final String MULTI_PIXELS_FOR_FACEBOOK = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Multi Pixels For Facebook')]";
    public static final String SMART_PUSH_MARKETING_WEBPUSH = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Smart Push Marketing ‑ WebPush')]";
    public static final String FORM_BUILDER_WITH_FILE_UPLOAD = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Form Builder with File Upload')]";
    public static final String STORE_IMPORTER = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Store Importer')]";
    public static final String BULK_DISCOUNTS_NOW = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Bulk Discounts Now')]";
    public static final String COUNTDOWN_ANNOUNCEMENT_BAR = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Countdown + Announcement Bar')]";
    public static final String PUSHDADDY_COUNTDOWN_TIMER = "//h4[contains(text(), 'Pushdaddy Countdown Timer')]";
    public static final String WHATSAPP_CHAT_CART_RECOVERY = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'WhatsApp Chat + Cart Recovery')]";

//    public static final String PRIVY_POPUPS = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Multi Pixels For Facebook')]";
//    public static final String FREE_SHIPPING_BAR = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Free Shipping Bar')]";
//    public static final String BEST_CURRENCY_CONVERTER = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Multi Pixels For Facebook')]";
//    public static final String MAILCHIMP_FORMS_BY_MAILMUNCH = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Multi Pixels For Facebook')]";
//    public static final String PLUG_IN_SEO = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Multi Pixels For Facebook')]";
//    public static final String SMILE_REWARDS_LOYALTY = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Multi Pixels For Facebook')]";
//    public static final String RYVIU_PRODUCT_REVIEW_APP_UGC = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Multi Pixels For Facebook')]";


    //Themes
    public static final String ONLINE_STORE_MENU = "//a[@href='/admin/themes?channel=true']";
    public static final String EXPLORE_FREE_THEMES_BUTTON = "//div/div[1]/div/div[2]/div/div[2]";


    //Login
    public static final String LOGIN_BUTTON = "//a[@href='/login' and @class='marketing-nav__item marketing-nav__item--user']";
    public static final String LOGIN_TO_ANOTHER_ACCOUNT = "//a[text()='Log in to another Shopify ID']";
    public static final String STORE_URL_TEXTBOX = "//input[@placeholder='myshop.myshopify.com']";
    public static final String EMAIL_PASSWORD_TEXTBOXES = "//input[@name='account[%s]']";
    public static final String DYNAMIC_BUTTON = "//button[text()='%s']";

    public static final String DELETE_APP_CONFIRMATION_TEXT = "//section[contains(text(), 'By deleting origin-app-dev')]";

    //Oberlo
    //public static final String NEW_PASSWORD ="//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/div[2]/input";
    //public static final String CONFIRM_NEW_PASSWORD = "//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/div[3]/input";
    //public static final String SAVE_PASSWORD ="//*[@id=\"app\"]/div/div[4]/div/div/div/div[3]/button";
    public static final String NEW_PASSWORD = "//*[@id=\"app\"]/div/div[4]/div/div/div/div/div[2]/div[2]/div[1]/input";
    public static final String CONFIRM_NEW_PASSWORD = "//*[@id=\"app\"]/div/div[4]/div/div/div/div/div[2]/div[3]/div[1]/input";
    public static final String SAVE_PASSWORD = "//*[@id=\"app\"]/div/div[4]/div/div/div/div/div[3]/button/span";
    public static final String SEARCH_PRODUCT_MENU = "//span[contains(text(),'Find products')]";
    public static final String CONNECT_OBERLO_WITH_SHOPIFY = "//h2[contains(text(),'Connect Oberlo with Shopify')]";
    public static final String CLICK_TO_CREATE_NEW_OBERLO_ACCOUNT = "//span[contains(text(),'Create new Oberlo account')]";
    public static final String INPUT_EMAIL_OBERLO = "//input[@name='email']";
    public static final String INPUT_PASSWORD_OBERLO ="//input[@name='password']";
    public static final String CLICK_TO_CREATE_FREE_ACCOUTN_BUTTON = "//span[contains(text(),'Create free account')]";

    //public static final String SEARCH_PRODUCT_TEXTBOX = "//*[@id=\"keywords\"]";
    public static final String SEARCH_PRODUCT_TEXTBOX = "//input[@id='keywords']";
    public static final String SEARCH_BUTTON = "//span[contains(text(),'Search')]";
    public static final String CLICK_TO_ORDER_TEXT1 = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[3]/div[3]/div[1]";
    public static final String CLICK_TO_ORDER_TEXT2 = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div/div[3]/div[2]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[3]/div[3]/div[1]";
    public static final String CLICK_TO_ORDER_TEXT3 = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div[2]/div/div[1]/div[3]/div[3]/div[1]";
    public static final String CLICK_TO_ORDER_TEXT4 = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div/div[3]/div[2]/div/div[4]/div/div[2]/div[2]/div/div[1]/div[3]/div[3]/div[1]";
    public static final String CLICK_TO_ORDER_TEXT5 = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div/div[3]/div[2]/div/div[5]/div/div[2]/div[2]/div/div[1]/div[3]/div[3]/div[1]";
    public static final String CLICK_TO_ORDER_TEXT6 = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div/div[3]/div[2]/div/div[6]/div/div[2]/div[2]/div/div[1]/div[3]/div[3]/div[1]";
    public static final String ADD_PRODUCT1_TO_IMPORT_LIST = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div/div[2]/button/span[2]";
    public static final String ADD_PRODUCT2_TO_IMPORT_LIST = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div/div[3]/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/button/span[2]";
    public static final String ADD_PRODUCT3_TO_IMPORT_LIST = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div[2]/div/div[2]/button/span[2]";
    public static final String ADD_PRODUCT4_TO_IMPORT_LIST = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div/div[3]/div[2]/div/div[4]/div/div[2]/div[2]/div/div[2]/button/span[2]";
    public static final String ADD_PRODUCT5_TO_IMPORT_LIST = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div/div[3]/div[2]/div/div[5]/div/div[2]/div[2]/div/div[2]/button/span[2]";
    public static final String ADD_PRODUCT6_TO_IMPORT_LIST = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div/div[3]/div[2]/div/div[6]/div/div[2]/div[2]/div/div[2]/button/span[2]";
    public static final String IMPORT_LIST = "//span[contains(text(),'Import List')]";
    //public static final String SELECT_ALL_PRODUCT_CHECKBOX ="//label[@class='bulk-actions__item btn-basic']";
    public static final String SELECT_ALL_PRODUCT_CHECKBOX = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/div/label/input";
    public static final String IMPORT_ALL_PRODUCT_TO_STORE = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div[2]/div[2]/div/div/div/div[1]/button/span";
    public static final String PUSH_PRODUCTS = "//span[contains(text(),'Yes')]";
    public static final String BACK_TO_SHOPIFY_ADMIN = "//span[contains(text(),'Shopify Admin')]";

    //product default Oberlo
    public static final String CLICK_TO_ORDER_TEXT_DEFAULT1 = "//*[@id=\"page-content\"]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/ul/li[1]/div/div/div[2]/div/div[1]/div[3]/div[4]/div[1]";
    public static final String CLICK_TO_ORDER_TEXT_DEFAULT2 = "//*[@id=\"page-content\"]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/ul/li[2]/div/div/div[2]/div/div[1]/div[3]/div[4]/div[1]";
    public static final String CLICK_TO_ORDER_TEXT_DEFAULT3 = "//*[@id=\"page-content\"]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/ul/li[3]/div/div/div[2]/div/div[1]/div[3]/div[4]/div[1]";
    public static final String CLICK_TO_ORDER_TEXT_DEFAULT4 = "//*[@id=\"page-content\"]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/ul/li[4]/div/div/div[2]/div/div[1]/div[3]/div[4]/div[1]";
    public static final String ADD_PRODUCT_DEFAULT1_TO_IMPORT_LIST = "//*[@id=\"page-content\"]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/ul/li[1]/div/div/div[2]/div/div[2]/button";
    public static final String ADD_PRODUCT_DEFAULT2_TO_IMPORT_LIST = "//*[@id=\"page-content\"]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/ul/li[2]/div/div/div[2]/div/div[2]/button";
    public static final String ADD_PRODUCT_DEFAULT3_TO_IMPORT_LIST = "//*[@id=\"page-content\"]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/ul/li[3]/div/div/div[2]/div/div[2]/button";
    public static final String ADD_PRODUCT_DEFAULT4_TO_IMPORT_LIST = "//*[@id=\"page-content\"]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/ul/li[4]/div/div/div[2]/div/div[2]/button";
    public static final String TITLE_REGISTER_OBERLO = "//h2[contains(text(),'Tell us a little about yourself')]";
    public static final String CLICK_TO_SKIP_BTN = "//span[contains(text(),'Skip')]";

}
