package hotDeal.vn.locator;

public class CreateAccountLocator {
    public static String INPUT_EMAIL = "//input[@id='email']";

    public static String INPUT_PASSWORD = "//div[@class='row form']//input[@id='password']";
    public static String INPUT_PASSWORD2 = "//input[@id='password2']";
    public static String INPUT_PHONE = "//input[@id='phone']";
    public static String INPUT_BIRTHDAY = "//input[@id='birthday']";
    public static String CALENDAR_TABLE = "//div[@class='calendar left single']//table";
    public static String SELECT_DAY(String day){
        return "//div[@class='calendar left single']//tbody//td[text()='"+day+"' and not(@class='weekend off available')]";
    }
    public static String SELECT_MONTH = "//div[@class='calendar left single']//select[@class='monthselect']";
    public static String SELECT_YEAR = "//div[@class='calendar left single']//select[@class='yearselect']";
    public static String INPUT_GENDER = "//input[@id='gender_f']";
    public static String BUTTON_CREATE_ACCOUNT = "//div[contains(@class,'form')]//div[contains(@class,'form-group-lg')]/button";
    public static String error(String field,String validator){
        return "//input[@id='"+field+"']/parent::div/following-sibling::small[@data-fv-validator='"+validator+"' and @data-fv-result='INVALID']";
    }
    public static String ICON_SUCCESS = "//i[contains(@class,'glyphicon glyphicon-ok')]";
}
