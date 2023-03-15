package hotDeal.vn.locator;

public class CuisineLocator {
    public static String NUMBER_LOCATION(int n){
        return "(//div[@class='filter__body']//input/following-sibling::span)["+ n +"]";}
    public static String CHECKBOX_LOCATION(int n){
        return "(//label[@class='filter__button '])["+ n +"]";
    }
    public static String PRODUCT = "//div[@id='block-main']/div";
    public static String MESSAGE = "//div[@class='filter--inline current-filter']";
    public static String LOCATION = "//i[@class='fa fa-map-marker']/following-sibling::div";
    public static String SORT_PRICE = "//a[contains(@class,'sorting--price')]";
}
