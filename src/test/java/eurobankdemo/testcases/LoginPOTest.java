package eurobankdemo.testcases;

import eurobankdemo.pageobjects.LoginPO;
import eurobankdemo.testbase.BasePO;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPOTest extends BasePO {
    private LoginPO loginPO;

    @BeforeClass
    private void init() {
        loginPO = PageFactory.initElements(driver, LoginPO.class);
        driver.get("http://demo.eurobank.pl/logowanie_etap_1.html");
        logger = LogManager.getLogger(LoginPOTest.class);
        logger.trace("Application started");
    }

    @Test
    @Parameters({"id", "password"})
    public void attemptLogin(String id, String password) {
        logger.trace("Entering login");
        loginPO.enterId(id);
        logger.trace("Login entered: " + id);
        logger.trace("Entering password");
        loginPO.enterPassword(password);
        logger.trace("Entered password: " + password);
    }
}