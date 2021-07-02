package pageObject;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.ReadDataCSV;
import org.openqa.selenium.WebDriver;
import pageUI.WhatNewPageUI;

public class WhatNewPO extends AbstractPage {
    WebDriver driver;
    public String storeURL;
    AbstractTest abstractTest = new AbstractTest();

    public WhatNewPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToHappyReaction(String title){
        scrollToElement(WhatNewPageUI.HAPPY_REACTION, title);
        waitToElementVisible(WhatNewPageUI.HAPPY_REACTION, title);
        clickToElementByJS(WhatNewPageUI.HAPPY_REACTION, title); ;
    }

    public void clickToNeutralReaction(String title){
        scrollToElement(WhatNewPageUI.NEUTRAL_REACTION, title);
        waitToElementVisible(WhatNewPageUI.NEUTRAL_REACTION, title);
        clickToElementByJS(WhatNewPageUI.NEUTRAL_REACTION, title);
    }

    public void clickToUnHappyReaction(String title){
        scrollToElement(WhatNewPageUI.UNHAPPY_REACTION, title);
        waitToElementVisible(WhatNewPageUI.UNHAPPY_REACTION, title);
        clickToElementByJS(WhatNewPageUI.UNHAPPY_REACTION, title);
    }

}
