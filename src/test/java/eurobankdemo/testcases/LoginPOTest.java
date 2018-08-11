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

    @BeforeClass
    private void init() {
        loginPO = PageFactory.initElements(driver, LoginPO.class);
        driver.get("http://demo.eurobank.pl/logowanie_etap_1.html");
    }

    @Test
    @Parameters({"id", "password"})
    public void attemptLogin(String id, String password) {
        loginPO.enterId(id);
        report = extent.createTest("Attempt to enter login");
        report.log(Status.PASS, MarkupHelper.createLabel("Login entered successfully", ExtentColor.GREEN));
        loginPO.enterPassword(password);
        report = extent.createTest("Attempt to enter password");
        report.log(Status.PASS, MarkupHelper.createLabel("Password entered successfully", ExtentColor.GREEN));
        extent.flush();
    }
}