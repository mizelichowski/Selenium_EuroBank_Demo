package eurobankdemo.pageobjects;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import eurobankdemo.testbase.BasePO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPO extends BasePO {

    @FindBy(id = "login_id")
    private static WebElement identityEditBox;

    @FindBy(xpath = "//*[@id=\"login_password\"]")
    private static WebElement passwordEditBox;

    @FindBy(id = "login_next")
    private static WebElement loginButton;

    public static WebElement getIdentityEditBox() {
        return identityEditBox;
    }

    public static WebElement getPasswordEditBox() {
        return passwordEditBox;
    }

    public static void enterId(String id) {
        identityEditBox.click();
        identityEditBox.clear();
        identityEditBox.sendKeys(id);
        test.log(Status.PASS, MarkupHelper.createLabel("Login entered successfully.", ExtentColor.GREEN));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_next")));
        loginButton.click();
    }

    public static void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_password")));
        passwordEditBox.click();
        passwordEditBox.clear();
        passwordEditBox.sendKeys(password);
        test.log(Status.PASS, MarkupHelper.createLabel("Password entered successfully.", ExtentColor.GREEN));
        loginButton.click();
    }

    public static void clickLoginButton() {
        loginButton.click();
    }
}
