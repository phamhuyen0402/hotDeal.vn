package hotDeal.vn.pages;
import hotDeal.vn.locator.HomePageLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public CreateAccountPage goToAccount(){
        click(HomePageLocator.BUTTON_SIGN_IN);
        return new CreateAccountPage(driver);
    }
    public void visibilityOfElementModal(){
        visibilityOfElement(HomePageLocator.ELEMENT_MODAL_FIRST);
    }
    public void selectLocation(){
        select(HomePageLocator.SELECT_LOCATION,"Hà Nội");
    }
    public void clickSubmitLocation(){
        click(HomePageLocator.BUTTON_SUBMIT_LOCATION);
    }
    public void sendKeysSearchBox(String key){
        sendKey(HomePageLocator.SEARCH_BOX,key);
    }
    public void clickButtonSearch(){
        click(HomePageLocator.BUTTON_SEARCH);
    }
    public String getAttributePlaceholder(){
        return getAttribute(HomePageLocator.SEARCH_BOX,"placeholder");
    }
    public String getAttributeValue(){
        return getAttribute(HomePageLocator.SEARCH_BOX,"value");
    }
    public void clearTextInSearchBox(){
        clear(HomePageLocator.SEARCH_BOX);
    }
    public boolean isDisplayListTextSuggest(){
        return isDisplay(HomePageLocator.LIST_TEXT_SUGGEST);
    }
    public List<String> getTextSuggest(){
        List<String> listSuggest = new ArrayList<>();
        List<WebElement> listElements = findElements(HomePageLocator.TEXT_SUGGEST);
        for (WebElement element:listElements) {
            listSuggest.add(element.getText());
        }
        return listSuggest;
    }
    public boolean isKeyEqualsSuggest(String key){
        for (int i = 0; i < getTextSuggest().size(); i++) {
            if(getTextSuggest().get(i).contains(key)){
                return true;
            }
        }
        return false;
    }
    public ProductSuggestPage goToProductWithSuggest(int n){

        click("("+HomePageLocator.TEXT_SUGGEST+")["+n+"]");
        return new ProductSuggestPage(driver);
    }
    public String getTextSelectSuggest(int n){
        String suggest= getText("("+HomePageLocator.TEXT_SUGGEST+")["+n+"]");
        return suggest;
    }
    public List<String> getTextNameProduct(){
        List<String> listSuggest = new ArrayList<>();
        List<WebElement> listElements = findElements(HomePageLocator.TEXT_NAME_PRODUCT);
        for (WebElement element:listElements) {
            listSuggest.add(element.getText());
        }
        return listSuggest;
    }
    public boolean isTextNoResult(){
        return isElement(HomePageLocator.TEXT_NO_RESULT);
    }
    public ProductDetailPage clickGoToProduct1Tab1(){
        click(HomePageLocator.PRODUCT_1_TAB_1);
        return new ProductDetailPage(driver);
    }
    public ProductDetailPage clickGoToProduct2Tab1(){
        click(HomePageLocator.PRODUCT_2_TAB_1);
        return new ProductDetailPage(driver);
    }
    public ProductDetailPage clickGoToProduct3Tab1(){
        click(HomePageLocator.PRODUCT_3_TAB_1);
        return new ProductDetailPage(driver);
    }
    public String getPriceProductPromotion(int promotion, int n){
        return getText(HomePageLocator.pricePromotion(promotion,n));
    }
    public String getPriceProduct(int promotion, int n){
        return getText(HomePageLocator.price(promotion,n));
    }
    public CuisinePage clickCuisine(){
        click(HomePageLocator.CUISINE);
        return new CuisinePage(driver);
    }
}
