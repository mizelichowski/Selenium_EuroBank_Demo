package eurobankdemo.testcases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import eurobankdemo.pageobjects.LoginPO;
import eurobankdemo.testbase.BasePO;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPOTest extends BasePO {
    private LoginPO loginPO;
    private String url = "http://demo.eurobank.pl/logowanie_etap_1.html";

    @BeforeClass
    private void init() {
        loginPO = PageFactory.initElements(driver, LoginPO.class);
        driver.get(url);
    }

    @Parameters({"id", "password"})
    @Test
    public void attemptLogin(String id, String password) {
        test = extent.createTest("Login attempt");

        if (driver.getCurrentUrl().equals(url)) {
            test.log(Status.PASS, MarkupHelper.createLabel(url + " has been opened.", ExtentColor.GREEN));
        }

        loginPO.enterId(id);
        loginPO.clickLoginButton();
        loginPO.enterPassword(password);
        loginPO.clickLoginButton();
    }
}