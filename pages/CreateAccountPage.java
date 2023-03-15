package hotDeal.vn.pages;
import hotDeal.vn.locator.CreateAccountLocator;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends PageBase{
    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public void sendKeyEmail(String key){
        sendKey(CreateAccountLocator.INPUT_EMAIL,key);
    }
    public void sendKeyPassWord(String key){
        sendKey(CreateAccountLocator.INPUT_PASSWORD,key);
    }
    public void sendKeyPassWord2(String key){
        sendKey(CreateAccountLocator.INPUT_PASSWORD2,key);
    }
    public void sendKeyPhone(String key){
        sendKey(CreateAccountLocator.INPUT_PHONE,key);
    }
    public void clickInputBirthday(){
        click(CreateAccountLocator.INPUT_BIRTHDAY);
    }
    public void clickDay(String day){
        click(CreateAccountLocator.SELECT_DAY(day));
    }
    public void selectMonth(String key){
        select(CreateAccountLocator.SELECT_MONTH,key);
    }
    public void selectYear(String key){
        select(CreateAccountLocator.SELECT_YEAR,key);
    }
    public void clickGender(){
        click(CreateAccountLocator.INPUT_GENDER);
    }
    public boolean clickButtonCreateAccount(){
        if(enabled(CreateAccountLocator.BUTTON_CREATE_ACCOUNT)){
            return true;
        }
        return false;
    }
    public void visibilityOfElementCalendar(){
        visibilityOfElement(CreateAccountLocator.CALENDAR_TABLE);
    }
    public boolean isElementError(String field, String validator){
        return isElement(CreateAccountLocator.error(field,validator));
    }
    public void isIconSuccess(){
        isElement(CreateAccountLocator.ICON_SUCCESS);
    }
}
