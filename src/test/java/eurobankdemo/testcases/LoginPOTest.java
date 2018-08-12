package eurobankdemo.testcases;

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

    @BeforeClass
    private void init() {
        loginPO = PageFactory.initElements(driver, LoginPO.class);
        driver.get(url);
        report = extent.createTest("Login attempt");
    }

    @Test
    @Parameters({"id", "password"})
    public void attemptLogin(String id, String password) throws IOException {
        if (driver.getCurrentUrl().equals(url)) {
            report.log(Status.PASS, MarkupHelper.createLabel(url + " has been opened.", ExtentColor.GREEN));
        }

        loginPO.enterId(id);

        if (loginPO.getIdentityEditBox().getText().equals(id)) {
            report.log(Status.PASS, MarkupHelper.createLabel("Login entered successfully.", ExtentColor.GREEN));
        } else {
            report.log(Status.FAIL, MarkupHelper.createLabel("Failed to enter login!", ExtentColor.RED));
        }

        loginPO.getLoginButton().click();
        loginPO.enterPassword(password);

        if (loginPO.getPasswordEditBox().getText().equals(password)) {
            report.log(Status.PASS, MarkupHelper.createLabel("Password entered successfully.", ExtentColor.GREEN));
        } else {
//            report.log(Status.FAIL, MarkupHelper.createLabel("Failed to enter password!", ExtentColor.RED));
            report.fail("Failed to enter password", MediaEntityBuilder.createScreenCaptureFromPath("fail.png").build());
        }

        loginPO.getLoginButton().click();
    }
}