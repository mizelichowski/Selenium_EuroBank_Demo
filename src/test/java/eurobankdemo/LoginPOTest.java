package eurobankdemo;

import eurobankdemo.drivers.Driver;
import eurobankdemo.pageobjects.LoginPO;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPOTest {
    private WebDriver driver;
    private LoginPO loginPO;

    @BeforeClass
    private void init() {
        driver = Driver.getInstance();
        loginPO = PageFactory.initElements(driver, LoginPO.class);
        driver.get("http://demo.eurobank.pl/logowanie_etap_1.html");
    }

    @Test
    @Parameters("id")
    public void loginInputTest(String id) {
        loginPO.enterId(id);
    }

    @Test
    @Parameters("password")
    public void passwordInputTest(String password) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login_password\"]")));
        try {
            loginPO.enterPassword(password);
        } catch (NoSuchElementException ex) {
//            ReportGenerator code
        }
    }
}