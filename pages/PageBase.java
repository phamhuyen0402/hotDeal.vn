package hotDeal.vn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageBase {
    WebDriver driver;
    public By byXpath(String xpath){
        return By.xpath(xpath);
    }
    public WebElement findElement(String xpath){
        return this.driver.findElement(byXpath(xpath));
    }
    public void click(String xpath){
        findElement(xpath).click();
    }
    public void sendKey(String xpath, String key){
        findElement(xpath).sendKeys(key);
    }
    public void visibilityOfElement(String xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(xpath)));
    }
    public void select(String xpath, String key){
        Select select = new Select(findElement(xpath));
        select.selectByVisibleText(key);
    }
    public String getText(String xpath){
        return findElement(xpath).getText();
    }
    public boolean isElement(String xpath){
        try {
            findElement(xpath).isDisplayed();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
    public boolean enabled(String xpath){
        if(findElement(xpath).isEnabled()){
            click(xpath);
            return true;
        }
         return false;
    }
    public String getAttribute(String xpath, String attribute){
        return findElement(xpath).getAttribute(attribute);
    }
    public boolean isDisplay(String xpath){
        try {
            findElement(xpath).isDisplayed();
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }
    public void clear(String xpath){
        findElement(xpath).clear();
    }
    public List<WebElement> findElements(String xpath){
        return driver.findElements(byXpath(xpath));
    }
    public void back(){
        driver.navigate().back();
    }
    public void selectText(String xpath, String key){
        Select select = new Select(findElement(xpath));
        select.selectByVisibleText(key);
    }
}
