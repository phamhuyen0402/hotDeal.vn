package hotDeal.vn.tests;

import hotDeal.vn.pages.CuisinePage;
import hotDeal.vn.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class CuisineTest {
    WebDriver driver;
    HomePage homePage;
    CuisinePage cuisinePage;
    int numberLocation = 1;
    @BeforeMethod
    public void openBrowen(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        driver.get("https://www.hotdeal.vn/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.visibilityOfElementModal();
        homePage.selectLocation();
        homePage.clickSubmitLocation();
        cuisinePage = homePage.clickCuisine();
    }
    @Test
    public void catalogFilter(){
        cuisinePage.clickLocation(numberLocation);
        cuisinePage.isDisplayMessage();
        Assert.assertEquals(cuisinePage.totalProduct(), cuisinePage.getNumberLocation(numberLocation));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
