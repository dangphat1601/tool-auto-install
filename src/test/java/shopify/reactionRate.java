package shopify;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.OriginalPO;
import pageObject.ShopifyPO;
import pageObject.WhatNewPO;

public class reactionRate extends AbstractTest {
    private WebDriver driver;
    private AbstractPage abstractPage;
    private WhatNewPO whatNewPO;
    private String url;

//    @Parameters("browser")
//    @BeforeTest
//    public void beforeTest(String browserName) {
//        driver = getBrowserDriver(browserName);
//        abstractPage = new AbstractPage(driver);
//        url= "https://beta.fireapps.io/whats-new";
//    }
    @Parameters("browser")
    @Test(invocationCount = 10)
    public void Reaction(String browserName){
        driver = getBrowserDriver(browserName);
        url= "https://beta.fireapps.io/whats-new";
        driver.get(url);
        whatNewPO = PageGeneratorManager.getWhatNewPage(driver);
        whatNewPO.clickToNeutralReaction("7 Reasons why Shopify is the best option for e-commerce stores");
        whatNewPO.clickToNeutralReaction("3 Proven strategies on how to find products for selling on Shopify?");
//        whatNewPO.clickToHappyReaction("Think Pop-ups are spam? This type of Pop-up proved you wrong");
//        whatNewPO.clickToHappyReaction("Ali Hunter 1.4 – What’s inside Sellers’ Choice feature?");
    }

    @AfterTest
    public void afterTest(){
        closeBrowserAndDriver(driver);
    }
}
