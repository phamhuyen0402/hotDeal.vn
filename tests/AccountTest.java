package hotDeal.vn.tests;
import hotDeal.vn.pages.CreateAccountPage;
import hotDeal.vn.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import techpanda.util.ReadExcel;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class AccountTest {
    WebDriver driver;
    HomePage homePage;
    CreateAccountPage createAccountPage;
    @BeforeMethod
    public void openBrowen(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        driver.get("https://www.hotdeal.vn/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.visibilityOfElementModal();
        homePage.selectLocation();
        homePage.clickSubmitLocation();
        createAccountPage = homePage.goToAccount();
    }
    @Test(dataProvider = "Authentication")
    public void emailInvalid(String email, String pass, String pass2, String phone, String birthday, String error, String validator){
        createAccountPage.sendKeyEmail(email);
        createAccountPage.sendKeyPassWord(pass);
        createAccountPage.sendKeyPassWord2(pass2);
        createAccountPage.sendKeyPhone(phone);
        createAccountPage.clickInputBirthday();
        createAccountPage.visibilityOfElementCalendar();
        List<String> list = Arrays.asList(birthday.split("-"));
        createAccountPage.selectYear(list.get(2));
        createAccountPage.selectMonth("Th0"+list.get(1));
        createAccountPage.clickDay(list.get(0));
        createAccountPage.clickGender();
        createAccountPage.clickButtonCreateAccount();
        if (error == "" && validator == "") {
            createAccountPage.isIconSuccess();
        } else {
            createAccountPage.isElementError(error,validator);
        }
    }
    @DataProvider
    public Object[][] Authentication() throws Exception {

        Object[][] testObjArray = ReadExcel.getTableArray("src/test/java/hotDeal/vn/util/579B1730.xlsx", "Create Account");

        return (testObjArray);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
