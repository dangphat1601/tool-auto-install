package commons;

import org.openqa.selenium.WebDriver;
import pageObject.*;

public class PageGeneratorManager {
    public static ShopifyPO getShopifyPage(WebDriver driver) {
        return new ShopifyPO(driver);
    }

    public static OriginalPO getOriginalPage(WebDriver driver){
        return new OriginalPO(driver);
    }

    public static WhatNewPO getWhatNewPage(WebDriver driver){
        return new WhatNewPO(driver);
    }

    public static WebsitePO getWebsitePage(WebDriver driver){
        return new WebsitePO(driver);
    }

    public static TranscyPO getTranscyPage(WebDriver driver){ return new TranscyPO(driver); }

    public static MessentPO getMessentPage(WebDriver driver){ return new MessentPO(driver); }

    public static OberloPO getOberloPO(WebDriver driver) {return new OberloPO(driver); }

    public static MultiImporterPO getMultiImporterPage(WebDriver driver) {return new MultiImporterPO(driver); }

    public static SynceeDropshippingPO getSynceeDropshippingPage(WebDriver driver) {return new SynceeDropshippingPO(driver); }

    public static SwiftPO getSwiftPage(WebDriver driver) {return new SwiftPO(driver); }

    public static ChatalystPO getChatalystPage(WebDriver driver) {return new ChatalystPO(driver); }
}
