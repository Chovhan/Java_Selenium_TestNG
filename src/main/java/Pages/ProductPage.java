package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkProductPriceAvailability(boolean availability) {
        boolean priceAvailability = findElementBy(By.xpath("//div[@class='item-print-block']/div[@class='price-row']/span[@class='item_old_price old-price']")).isDisplayed();
        System.out.println(priceAvailability);
        Assert.assertEquals(priceAvailability, availability, "Price was not found! " +
                getTextFromSelector(findElementBy(By.xpath("//h1[@itemprop='name']"))) +
                " - don`t have price!\nActual result is - " + priceAvailability +
                ";\n Expected result is - " + availability);
    }

    public void checkProductDiscountAvailability(boolean availability) {
        boolean discountAvailability = findElementBy(By.xpath("//div[@class='item-print-block']/div[@class='price-row']/span[@class='item_old_price old-price']")).isDisplayed();
        System.out.println(discountAvailability);
        Assert.assertEquals(discountAvailability, availability, "Discount was not found! " +
                getTextFromSelector(findElementBy(By.xpath("//h1[@itemprop='name']"))) +
                " - don`t have discount! \nActual result is - " + discountAvailability +
                ";\n Expected result is - " + availability);
    }
}
