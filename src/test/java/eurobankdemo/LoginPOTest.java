package eurobankdemo;

import eurobankdemo.drivers.Driver;
import eurobankdemo.pageobjects.LoginPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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
    @Parameters({"id", "password"})
    public void attemptLogin(String id, String password) {
        loginPO.enterId(id);
        loginPO.enterPassword(password);
    }
}