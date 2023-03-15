package hotDeal.vn.pages;
import hotDeal.vn.locator.CartLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends PageBase{
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public List<String> getListNameProduct() {
        List<WebElement> list = findElements(CartLocator.NAME_PRODUCT_CART);
        List<String> listNameProductString = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listNameProductString.add(list.get(i).getText());
        }
        return  listNameProductString;
    }
    public List<String> getListPriceProduct() {
        List<WebElement> list = findElements(CartLocator.PRICE_PRODUCT_CART);
        List<String> listPriceProductString = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listPriceProductString.add(list.get(i).getText());
        }
        return  listPriceProductString;
    }
    public String getTextSubtotal(){
        return getText(CartLocator.SUBTOTAL);
    }
    public void getSelectQuantity(String key, int n){
        selectText("("+CartLocator.SELECT_QUANTITY+")["+n+"]",key);
    }
    public void clickButtonDelete(int n){
        click("("+CartLocator.ICON_DELETE+")[" + n +"]");
    }
    public void visibilityOfElementModalDelete(){
        visibilityOfElement(CartLocator.MODAL_DELETE);
    }
    public void acceptModalDelete(){
        click(CartLocator.CONFIRM_YES);
    }

}
