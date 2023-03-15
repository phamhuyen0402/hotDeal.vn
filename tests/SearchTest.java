package hotDeal.vn.tests;
import hotDeal.vn.pages.HomePage;
import hotDeal.vn.pages.ProductSuggestPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchTest {
    WebDriver driver;
    HomePage homePage;
    ProductSuggestPage productSuggestPage;
    String textSearch = "Đà nẵng";
    int numberSuggest = 6;
    String textSearchNoResult = "data";
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
    }
    @Test
    public void checkSearchBoxExist(){
        Assert.assertEquals(homePage.getAttributePlaceholder(),"Tìm kiếm sản phẩm / khuyến mãi");
        homePage.sendKeysSearchBox(textSearch);
        homePage.clickButtonSearch();
        Assert.assertEquals(homePage.getAttributeValue(),textSearch);
        homePage.clearTextInSearchBox();
    }
    @Test
    public void checkSuggestSearchBox(){
        homePage.sendKeysSearchBox(textSearch);
        homePage.isDisplayListTextSuggest();
        homePage.getTextSuggest();
        homePage.isKeyEqualsSuggest(textSearch);
        System.out.println(homePage.isKeyEqualsSuggest(textSearch));
    }
    @Test
    public void checkSelectSuggestSearchBox(){
        homePage.sendKeysSearchBox(textSearch);
        homePage.isDisplayListTextSuggest();
        homePage.getTextSuggest();
        homePage.isKeyEqualsSuggest(textSearch);
        System.out.println(homePage.isKeyEqualsSuggest(textSearch));
        String suggest = homePage.getTextSelectSuggest(numberSuggest);
        productSuggestPage = homePage.goToProductWithSuggest(numberSuggest);
        Assert.assertEquals(suggest,productSuggestPage.getNameProductSuggest());
    }
    @Test
    public void checkResultSearch(){
        homePage.sendKeysSearchBox(textSearch);
        homePage.isDisplayListTextSuggest();
        List<String> list = homePage.getTextSuggest();
        homePage.isKeyEqualsSuggest(textSearch);
        homePage.clickButtonSearch();
        homePage.getTextNameProduct();
        homePage.getTextNameProduct();
        System.out.println(list.retainAll(homePage.getTextNameProduct()));
    }
    @Test
    public void checkNoResultSearch(){
        homePage.sendKeysSearchBox(textSearchNoResult);
        homePage.clickButtonSearch();
        homePage.isTextNoResult();
        System.out.println(homePage.isTextNoResult());

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
