package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class PuncherPage extends BasePage {

    public PuncherPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void checkPriceAvailability() {
        List<WebElement> productsList = getAllProductsOnPage(By.cssSelector("li.col-xs-4"));
        for (WebElement product : productsList) {
            WebElement productPrice = getElementInElement(product, By.cssSelector("div > div.text-box > div.text-left > div.wrap > span.price"));
            String productName = getTextFromSelector(getElementInElement(product, By.cssSelector("div > h4 > a > span")));
            boolean priceAvailability = elementIsDisplayed(productPrice);
            Assert.assertTrue(priceAvailability, "Product: " + productName + " dont have a price");
        }
    }

}
