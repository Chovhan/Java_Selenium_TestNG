package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ScrewdriverPage extends BasePage {

    public ScrewdriverPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void showAllScrewdriversFromUSA() {
        List<WebElement> productsList = getAllProductsOnPage(By.cssSelector("li.col-xs-4"));
        for (WebElement product : productsList) {
            WebElement productCountry = getElementInElement(product, By.cssSelector("div.holder > div.image > div.item-brand-country > img"));
            if (productCountry.getAttribute("src").toLowerCase().contains("united_states")) {
                String productName = getTextFromSelector(getElementInElement(product, By.cssSelector("div > h4 > a > span")));
                System.out.println(productName);
            }
        }
    }

}
