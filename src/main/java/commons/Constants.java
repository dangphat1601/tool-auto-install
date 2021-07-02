package commons;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class Constants {

    static String rootFolder = System.getProperty("user.dir");
    public static final String URL = "https://shopify.com/";
    public static final String URL_APP = "https://app.shopify.com/";
    public static final String ORIGINAL_URL = "https://origin-dev.fireapps.io/install";
    public static final String TRANSCY_URL = "https://translate-dev.fireapps.io/install";
    public static final String WELCOME_TRANSCY_URL = "https://translate-dev.fireapps.io/onboarding/welcome";
    public static final int RAMDOM_BOUND = 100000;

    //REGISTER
    public static final String SHOPIFY_PASSWORD = "Abc123";
    //TELLING US A LITTLE ABOUT YOURSELF
    public static final String ALREADY_SELLING = "I’m just playing around";
    public static final String CURRENT_REVENUE = "₫0 VND (I'm just getting started)";
    public static final String INDUSTRY = "Beauty";

    //ADDRESS INFO
//    public static final String FIRST_NAME = faker.name().firstName();
//    public static final String LAST_NAME = faker.name().lastName();
//    public static final String ADDRESS = faker.address().streetAddress();
//    public static final String CITY = "Da Nang";
    public static final String ZIPCODE = "55000";
    public static String PHONE_NUMBER = "";

    //WRITE DATA
    public static final String WRITE_CSV_FILE_PATH = rootFolder + "/src/test/resources/storeData.csv";
    public static final String COMMA_DELIMITER = ",";
    public static final String NEW_LINE_SEPARATOR = "\n";
    public static final String FILE_HEADER = "URL, Store Link, Email, Store Name, Store Type, Password, Address, City, Country, Created Date";

    //READ DATA
    public static final String READ_CSV_FILE_PATH = rootFolder + "/src/test/resources/storeData.csv";
    public static String STORE_URL_CSV = null;
    public static String STORE_EMAIL_CSV = null;
    public static String STORE_PASSWORD_CSV = null;
    public static String STORE_NAME_CSV = null;
    public static String STORE_TYPE_CSV = null;

    //PLAN TYPES
    public static final String PREMIUM_PLAN = "Premium";
    public static final String ESSENTIAL_PLAN = "Essential";
    public static final String STARTER_PLAN = "Starter";
    public static final String FREE_PLAN = "Free";
    public static final String NO_PLAN = "No-plan";

    //DELETE APP
    public static final String DELETE_SUCCESS_MESSAGE = "You successfully deleted origin-app-dev.";



    //WEBSITE CHECK FUNCTIONS
    public static final String WEBSITE_URL = "https://beta.fireapps.io";
    public static final String WEBSITE_HOME_BUTTON = "Home";
    public static final String WEBSITE_SHOPIFY_APPS = "https://beta.fireapps.io/shopify-apps";
    public static final String WEBSITE_ALI_REVIEW_URL = "https://fireapps.io/shopify-apps/ali-reviews/";
    public static final String WEBSITE_ALI_ORDERS_URL = "https://fireapps.io/shopify-apps/ali-orders/";
    public static final String WEBSITE_SALES_BOX_URL = "https://fireapps.io/shopify-apps/sales-box/";
    public static final String WEBSITE_ALI_HUNTER_URL = "https://fireapps.io/shopify-apps/ali-hunter/";
    public static final String HOME_PAGE_TITLE = "Home Page - FireApps";
    public static final String HELP_PAGE_TITLE = "FireApps";
    public static final String ALI_REVIEW_GET_APP = "alireviews";
    public static final String ALI_HUNTER_GET_APP = "alihunter";
    public static final String ALI_ORDERS_GET_APP = "aliorders";
    public static final String SALES_BOX_GET_APP = "salesbox";


    public static final String BLOG_POST_TITLE1 = "Things to know about Shopify apps when you are doing a dropshipping business in 2020";
    public static final String BLOG_POST_TITLE2 = "10 Best Shopify apps that you must know before starting an e-commerce";
    public static final String BLOG_POST_TITLE3 = "What are Shopify Apps? Pro tips to choose best apps for your store";

    //SOCIAL LINKS
    public static final String FOOTER_FACEBOOK_URL = "https://www.facebook.com/fireapps.io/";
    public static final String FOOTER_INSTAGRAM_URL = "https://www.instagram.com/accounts/login/?next=/fireapps.shopify/";
    public static final String FOOTER_TWITTER_URL = "https://twitter.com/Fireapps_io";
    public static final String FOOTER_YOUTUBE_URL = "https://www.youtube.com/channel/UCTLlWKPKBlHnJA8CYrIEWGg";
    public static final String FACEBOOK_TITLE = "FireApps - Premium Apps for Shopify Stores - Home";
    public static final String INSTAGRAM_TITLE = "Fireapps.io (@fireapps.shopify) • Instagram photos and videos";
    public static final String TWITTER_TITLE = "FireApps (@Fireapps_io) / Twitter";
    public static final String YOUTUBE_TITLE = "FireApps - Premium Apps for Shopify Stores - YouTube";

    //BLOG CATEGORIES
    public static final String BLOG_ECOMMERCE = "eCommerce Marketing";
    public static final String BLOG_SUPERTOOLS = "Super Tools";
    public static final String BLOG_CASESTUDIES = "Case Studies";
    public static final String BLOG_EXTRATALK = "Extra Talk";
    public static final String BANNER_AT_SEARCHRESULT_URL = "https://apps.shopify.com/ali-reviews";
    public static final String BLOG_SLIDE_BANNER_URL = "https://apps.shopify.com/ali-reviews";


    //WHATS NEW
    public static final String WHATSNEW_URL = "https://beta.fireapps.io/whats-new";
    public static final String WHATSNEW_ALIREVIEWS = "ali-reviews";
    public static final String WHATSNEW_ALIORDERS = "ali-orders";
    public static final String WHATSNEW_SALESBOX = "sales-box";
    public static final String WHATSNEW_ALIHUNTER = "ali-hunter";
    public static final String APP_ALIREVIEWS = "Ali Reviews";
    public static final String APP_ALIORDERS = "Ali Orders";
    public static final String APP_SALESBOX = "Sales Box";
    public static final String APP_ALIHUNTER = "Ali Hunter";












}
