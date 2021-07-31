package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public WebDriver webDriver;
    public WebDriverWait wait;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 15);
    }

    public void checkPageIsCorrect(String expectedUrl) {
        assert getPageUrl().equals(expectedUrl);
    }

    public void moveToElement(WebElement webElementToMove) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElementToMove).perform();
    }

    public WebElement findElementBy(By elementBy) {
        return webDriver.findElement(elementBy);
    }

    public void clickOnElement(WebElement webElement) {
        webElement.click();
    }

    public String getPageUrl() {
        return webDriver.getCurrentUrl();
    }

    public List<WebElement> getAllProductsOnPage(By elementBy) {
        return webDriver.findElements(elementBy);
    }

    public WebElement getRandomProduct(List<WebElement> productList) {
        Random random = new Random();
        int randomIndex = random.nextInt(productList.size());
        return productList.get(randomIndex);
    }

    public List<WebElement> getRandomProducts(List<WebElement> productList, int numberOfProducts) {
        Random random = new Random();
        List<WebElement> randomList = new ArrayList<>();
        for (int i = 0; i < numberOfProducts; i++) {
            int randomIndex = random.nextInt(productList.size());
            WebElement randomElement = productList.get(randomIndex);
            productList.remove(randomIndex);
            randomList.add(randomElement);
        }
        return randomList;
    }

    public boolean elementIsDisplayed(WebElement webElement) {
        return webElement.isDisplayed();
    }

    public String getTextFromSelector(WebElement webElement) {
        return webElement.getText();
    }

    public WebElement getElementInElement(WebElement webElement, By elementBy) {
        return webElement.findElement(elementBy);
    }

    public List<WebElement> getElementsInElement(WebElement webElement, By elementBy) {
        return webElement.findElements(elementBy);
    }

    public void goToNextPage(By elementBy) {
        clickOnElement(findElementBy(elementBy));
    }

    public int calculatePriceWithDiscount(int discount, int defaultPrice) {
        return defaultPrice - ((defaultPrice * discount) / 100);
    }

    public void changeImplicitWait(int seconds) {
        webDriver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

}
