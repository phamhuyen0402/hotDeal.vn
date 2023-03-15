package hotDeal.vn.tests;
import hotDeal.vn.pages.CartPage;
import hotDeal.vn.pages.ProductDetailPage;
import hotDeal.vn.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BuyProductTest {
    WebDriver driver;
    HomePage homePage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
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
    public void checkSelectProductAndCheckCart() {
        productDetailPage = homePage.clickGoToProduct1Tab1();
        String product1 = productDetailPage.getNameProduct();
        Float price1 = Float.valueOf(productDetailPage.getPriceProduct().replace(",",""));
        productDetailPage.clickButtonAddCart();
        homePage = productDetailPage.goToHomePage();
        productDetailPage = homePage.clickGoToProduct2Tab1();
        String product2 = productDetailPage.getNameProduct();
        Float price2 = Float.valueOf(productDetailPage.getPriceProduct().replace(",",""));
        productDetailPage.clickButtonAddCart();
        homePage = productDetailPage.goToHomePage();
        productDetailPage = homePage.clickGoToProduct3Tab1();
        String product3 = productDetailPage.getNameProduct();
        Float price3 = Float.valueOf(productDetailPage.getPriceProduct().replace(",",""));
        productDetailPage.clickButtonAddCart();
        cartPage = productDetailPage.clickGoToButtonCartView();
        List<String> list = new ArrayList<>();
        list.add(product1);
        list.add(product2);
        list.add(product3);
        cartPage.getListNameProduct();
        List<Float> listPrice = new ArrayList<>();
        listPrice.add(price1);
        listPrice.add(price2);
        listPrice.add(price3);
        System.out.println(listPrice.retainAll(cartPage.getListPriceProduct()));
        Assert.assertEquals(price1 + price2 + price3,Float.valueOf(cartPage.getTextSubtotal().replace(",","").replace("đ","")));
    }
    @Test
    public void checkChangeNumberProductAndCheckCart() {
        productDetailPage = homePage.clickGoToProduct1Tab1();
        String product1 = productDetailPage.getNameProduct();
        Float price1 = Float.valueOf(productDetailPage.getPriceProduct().replace(",",""));
        productDetailPage.clickButtonAddCart();
        homePage = productDetailPage.goToHomePage();
        productDetailPage = homePage.clickGoToProduct2Tab1();
        String product2 = productDetailPage.getNameProduct();
        Float price2 = Float.valueOf(productDetailPage.getPriceProduct().replace(",",""));
        productDetailPage.clickButtonAddCart();
        homePage = productDetailPage.goToHomePage();
        productDetailPage = homePage.clickGoToProduct3Tab1();
        String product3 = productDetailPage.getNameProduct();
        Float price3 = Float.valueOf(productDetailPage.getPriceProduct().replace(",",""));
        productDetailPage.clickButtonAddCart();
        cartPage = productDetailPage.clickGoToButtonCartView();
        List<String> list = new ArrayList<>();
        list.add(product1);
        list.add(product2);
        list.add(product3);
        cartPage.getListNameProduct();
        cartPage.getSelectQuantity("2",1);
        cartPage.getSelectQuantity("3",2);
        cartPage.getSelectQuantity("4",3);
        List<Float> listPrice = new ArrayList<>();
        listPrice.add(price1*4);
        listPrice.add(price2*3);
        listPrice.add(price3*2);
        System.out.println(listPrice.retainAll(cartPage.getListPriceProduct()));
        Assert.assertEquals((price1 * 4 + price2 * 3 + price3 * 2),Float.valueOf(cartPage.getTextSubtotal().replace(",","").replace("đ","")));
        cartPage.clickButtonDelete(2);
        cartPage.visibilityOfElementModalDelete();
        cartPage.acceptModalDelete();
        Assert.assertEquals((price1 * 4 + price3 * 2),Float.valueOf(cartPage.getTextSubtotal().replace(",","").replace("đ","")));
    }
    @Test
    public void checkProductPromotion(){
        int promotion = 36;
        int n = 1;
        Float priceProductPromotion = Float.valueOf(homePage.getPriceProductPromotion(promotion,n).replace(",",""));
        Float priceProduct = Float.valueOf(homePage.getPriceProduct(promotion,n).replace(",",""));
        Assert.assertEquals(priceProductPromotion, (float) (priceProduct - priceProduct * 0.36));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
