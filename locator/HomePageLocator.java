package hotDeal.vn.locator;

public class HomePageLocator {
    public static String ELEMENT_MODAL_FIRST = "//div[@id='location-selector']//div[@class='modal-content']";
    public static String BUTTON_SIGN_IN = "//li/i[@class='hd hd-user']/following-sibling::a";
    public static String SELECT_LOCATION = "//select[@name='location']";
    public static String BUTTON_SUBMIT_LOCATION = "//form[@id='formCity']//div[contains(@class,'form-group-lg')]/button";
    public static String SEARCH_BOX = "//input[@id='search_all']";
    public static String BUTTON_SEARCH = "//button[@class='btn btn-danger']";
    public static String LIST_TEXT_SUGGEST = "//div[contains(@class,'tt-open')]";
    public static String TEXT_SUGGEST = "//div[contains(@class,'tt-menu')]//a";
    public static String TEXT_NAME_PRODUCT = "//h3/a";
    public static String TEXT_NO_RESULT = "//p[@class='well']";
    public static String PRODUCT_1_TAB_1 = "(//a[text()='Deal Nổi bật']/ancestor::div[contains(@class,'tab-style-1')]//div[contains(@class,'product-wrapper')])[1]";
    public static String PRODUCT_2_TAB_1 = "(//a[text()='Deal Nổi bật']/ancestor::div[contains(@class,'tab-style-1')]//div[contains(@class,'product-wrapper')])[2]";
    public static String PRODUCT_3_TAB_1 = "(//a[text()='Deal Nổi bật']/ancestor::div[contains(@class,'tab-style-1')]//div[contains(@class,'product-wrapper')])[4]";
    public static String pricePromotion(int promotion, int n){
        return "(//span[@class='price__discount' and text()='-"+promotion+"%']/preceding-sibling::span[@class='price__value'])["+n+"]";
    }
    public static String price(int promotion, int n){
        return "(//span[@class='price__discount' and text()='-"+promotion+"%']/ancestor::div[contains(@class,'product__price')]/following-sibling::div//span[@class='price__value'])["+n+"]";
    }
    public static String CUISINE = "//a[text()=' Ẩm Thực']";
}
