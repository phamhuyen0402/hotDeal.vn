package hotDeal.vn.pages;
import hotDeal.vn.locator.ProductDetailLocator;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends PageBase{
    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickButtonAddCart(){
        click(ProductDetailLocator.BUTTON_ADD_CART);
    }
    public CartPage clickGoToButtonCartView(){
        click(ProductDetailLocator.BUTTON_CART_VIEW);
        return new CartPage(driver);
    }
    public HomePage goToHomePage(){
        back();
        return new HomePage(driver);
    }
    public String getNameProduct(){
        return getText(ProductDetailLocator.NAME_PRODUCT_PAGE_PRODUCT_DETAIL);
    }
    public String getPriceProduct(){
        return getText(ProductDetailLocator.PRICE_PRODUCT);
    }
}
