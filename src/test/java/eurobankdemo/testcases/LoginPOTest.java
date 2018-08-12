package eurobankdemo.testcases;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import eurobankdemo.pageobjects.LoginPO;
import eurobankdemo.testbase.BasePO;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPOTest extends BasePO {
    private LoginPO loginPO;
    private String url = "http://demo.eurobank.pl/logowanie_etap_1.html";
    private ExtentTest test;

    @BeforeClass
    private void init() {
        loginPO = PageFactory.initElements(driver, LoginPO.class);
        driver.get(url);
    }

    @Test
    @Parameters({"id", "password"})
    public void attemptLogin(String id, String password) throws IOException {
        test = extent.createTest("Login attempt");

        if (driver.getCurrentUrl().equals(url)) {
            test.log(Status.PASS, MarkupHelper.createLabel(url + " has been opened.", ExtentColor.GREEN));
        }

        loginPO.enterId(id);

        if (loginPO.getIdentityEditBox().getText().equals(id)) {
            test.log(Status.PASS, MarkupHelper.createLabel("Login entered successfully.", ExtentColor.GREEN));
        } else {
            test.log(Status.FAIL, MarkupHelper.createLabel("Failed to enter login!", ExtentColor.RED));
        }

        loginPO.clickLoginButton();
        loginPO.enterPassword(password);

        if (loginPO.getPasswordEditBox().getText().equals(password)) {
            test.log(Status.PASS, MarkupHelper.createLabel("Password entered successfully.", ExtentColor.GREEN));
        } else {
            test.log(Status.FAIL, MarkupHelper.createLabel("Failed to enter password!", ExtentColor.RED));
        }

        loginPO.clickLoginButton();
    }
}