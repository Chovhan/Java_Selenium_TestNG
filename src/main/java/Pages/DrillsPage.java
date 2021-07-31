package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DrillsPage extends BasePage {

    public DrillsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkDrillPrice() {
        List<WebElement> list = getAllProductsOnPage(By.className("col-xs-4"));
        WebElement webElement = getRandomProduct(list);
        clickOnElement(webElement);
        }

}
