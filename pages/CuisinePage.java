package hotDeal.vn.pages;
import hotDeal.vn.locator.CuisineLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CuisinePage extends PageBase{
    public CuisinePage(WebDriver driver) {
        this.driver = driver;
    }
    public int getNumberLocation(int n){
        int numberLocation = Integer.parseInt(getText(CuisineLocator.NUMBER_LOCATION(n)));
        return numberLocation;
    }

    public void clickLocation(int n){
        click(CuisineLocator.CHECKBOX_LOCATION(n));
    }
    public int totalProduct(){
        List<WebElement> list = findElements(CuisineLocator.PRODUCT);
        List<String> listNumber = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listNumber.add(list.get(i).getText());
        }
        return listNumber.size();
    }
    public boolean isDisplayMessage(){
        return isElement(CuisineLocator.MESSAGE);
    }
}
