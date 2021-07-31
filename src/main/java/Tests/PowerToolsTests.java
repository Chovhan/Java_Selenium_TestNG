package Tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class PowerToolsTests extends TestBase{

    @Test()
    public void drillsTest() {
        mainPage.openPage();
        mainPage.goToPageWithMenu("dreli");
        basePage.checkPageIsCorrect("https://kulibin.com.ua/catalog/dreli/");
        drillsPage.checkDrillPrice();
        productPage.checkProductDiscountAvailability(true);
        productPage.checkProductPriceAvailability(true);
    }

    @Test
    public void puncherTest() {
        mainPage.openPage();
        mainPage.goToPageWithMenu("perforatory");
        basePage.checkPageIsCorrect("https://kulibin.com.ua/catalog/perforatory/");
        puncherPage.checkPriceAvailability();
        for (int i = 0; i < 1; i++) {
            basePage.goToNextPage(By.cssSelector(".next"));
            puncherPage.checkPriceAvailability();
        };
    }

    @Test
    public void screwdriverTest() {
        mainPage.openPage();
        mainPage.goToPageWithMenu("shurupoverty");
        basePage.checkPageIsCorrect("https://kulibin.com.ua/catalog/shurupoverty/");
        screwdriverPage.showAllScrewdriversFromUSA();
        for (int i = 0; i < 2; i++) {
            basePage.goToNextPage(By.cssSelector(".next"));
            screwdriverPage.showAllScrewdriversFromUSA();
        };
    }

    @Test
    public void grinderTest() {
        mainPage.openPage();
        mainPage.goToPageWithMenu("bolgarki");
        basePage.checkPageIsCorrect("https://kulibin.com.ua/catalog/bolgarki/");
        grinderPage.checkForPrice(10);
    }

}
