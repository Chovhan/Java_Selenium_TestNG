package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class GrinderPage extends BasePage {

    public GrinderPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkForPrice(int colOfProducts) {
        List<WebElement> grinderList = createRandomGrinderList(colOfProducts);
        for (WebElement webElement: grinderList) {
            String productName = getTextFromSelector(getElementInElement(webElement, By.cssSelector("div > h4 > a > span")));
            String discountInPercent = getTextFromSelector(getElementInElement(webElement, By.cssSelector("div > div.image > div.stick-list > div > span.stick-list__span"))).replaceAll("[^0-9]", "");
            String oldPrice = getTextFromSelector(getElementInElement(webElement, By.cssSelector("div > div.text-box > div.text-left > div.wrap > span.old-price"))).replaceAll("[^0-9]", "");
            String newPrice = getTextFromSelector(getElementInElement(webElement, By.cssSelector("div > div.text-box > div.text-left > div.wrap > span.price"))).replaceAll("[^0-9]", "");

            try {
                int expectedResult  = calculatePriceWithDiscount(Integer.parseInt(discountInPercent), Integer.parseInt(oldPrice));
                assertEqualsWithPrice(expectedResult, Integer.parseInt(newPrice), productName);
            } catch (NumberFormatException e) {
                continue;
            }

        }
    }

    public List<WebElement> createRandomGrinderList(int colOfProducts) {
        List<WebElement> grinderList = getAllProductsOnPage(By.cssSelector(".col-xs-4"));
        changeImplicitWait(1);
        grinderList.removeIf(grinder -> getElementsInElement(grinder, By.cssSelector("div > div.text-box > div.text-left > div.wrap > span.old-price")).isEmpty());

        while (grinderList.size() < 10) {
            changeImplicitWait(5);
            goToNextPage(By.xpath("//a[@class='btn-blue show-more-link']"));
            changeImplicitWait(1);
            List<WebElement> a = getAllProductsOnPage(By.cssSelector(".col-xs-4"));
            a.removeIf(grinder -> getElementsInElement(grinder, By.cssSelector("div > div.text-box > div.text-left > div.wrap > span.old-price")).isEmpty());
            grinderList.addAll(a);
        }
        return getRandomProducts(grinderList, colOfProducts);
    }

    public void assertEqualsWithPrice(int expectedResult, int actualResult, String productName) {
        try {
            Assert.assertEquals(actualResult, expectedResult, "Product name: " + productName + "\nActual result: " + actualResult + "\nExpected result: " + expectedResult);
        } catch (AssertionError e) {
            System.out.println(e);
        }
    }

}
