package pageUI;

public class InstallAppUI {

    public static final String STORE_NAME_TEXTBOX = "//input[@placeholder='Store name']";
    public static final String LOGIN_BUTTON = "//button[@type='submit']";
//    public static final String LOGIN_TO_ANOTHER_ACCOUNT = "//div[@class='account-picker__item-content account-picker__action']";
    public static final String LOGIN_TO_ANOTHER_ACCOUNT = "//span[text()='Log in to a different account']";
    public static final String LOGIN_TEXTBOXES = "//input[@name='account[%s]']";  //email/password
//    public static final String DYNAMIC_BUTTONS = "//button[text()='%s']";
	public static final String DYNAMIC_BUTTONS = "//button[@id='proceed_cta']";
    public static final String INSTALL_LABEL = "//h2[text()='You are about to install origin-app-dev']";

    //SELECT PLAN
    public static final String SELECT_PLAN_BUTTONS = "//span[contains(text(),'%s')]/parent::div";
    public static final String SELECT_PLAN_BUTTONS_NEW_DESIGN = "//div[contains(@class, 'desktop')]//div[@class='plan-name' and text()='%s']/following-sibling::form/button";
    public static final String START_FREE_BUTTON = "//span[text()='Start Free']/parent::button";
    public static final String START_TRIAL_BUTTON = "//button[@class='a-btn a-btn-primary']";
    public static final String START_FREE_TRIAL_BUTTON = "//button[@id='approve-charges-button']";

    //ORIGINAL APP
    public static final String LOGO = "//div[@class='a-logo-text']";
    public static final String PRICING_MENU = "//a[@href='/pricing']";
    public static final String YOU_ARE_HERE_BUTTON = "//span[text()='YOU ARE HERE']/parent::button";
}
