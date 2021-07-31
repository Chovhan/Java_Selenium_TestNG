package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver webDriver;
    public BasePage basePage;
    public MainPage mainPage;
    public DrillsPage drillsPage;
    public ProductPage productPage;
    public PuncherPage puncherPage;
    public ScrewdriverPage screwdriverPage;
    public GrinderPage grinderPage;


    @BeforeTest
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        basePage = PageFactory.initElements(webDriver, BasePage.class);
        mainPage = PageFactory.initElements(webDriver, MainPage.class);
        drillsPage = PageFactory.initElements(webDriver, DrillsPage.class);
        productPage = PageFactory.initElements(webDriver, ProductPage.class);
        puncherPage = PageFactory.initElements(webDriver, PuncherPage.class);
        screwdriverPage = PageFactory.initElements(webDriver, ScrewdriverPage.class);
        grinderPage = PageFactory.initElements(webDriver, GrinderPage.class);
    }


    @AfterTest
    public void tearDown() {
        webDriver.quit();
    }


}
