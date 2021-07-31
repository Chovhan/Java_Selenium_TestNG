package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    String PAGE_URL = "https://kulibin.com.ua/";

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        webDriver.get(PAGE_URL);
    }

    public void goToPageWithMenu(String menuName) {
        WebElement webElementToMove = findElementBy(By.xpath("//a[contains(@href, '/catalog/elektroinstrument/')]"));
        moveToElement(webElementToMove);
        WebElement webElementToClick = findElementBy(By.xpath("//a[contains(@href, '/catalog/"+ menuName +"/')]"));
        clickOnElement(webElementToClick);

    }
}
