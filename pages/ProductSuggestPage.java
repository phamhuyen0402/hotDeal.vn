package hotDeal.vn.pages;

import hotDeal.vn.locator.ProductSuggestLocator;
import org.openqa.selenium.WebDriver;

public class ProductSuggestPage extends PageBase{
    public ProductSuggestPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getNameProductSuggest(){
        return getText(ProductSuggestLocator.NAME_PRODUCT);
    }
}
