package eurobankdemo.pageobjects;

import eurobankdemo.testbase.BasePO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPO extends BasePO {

    @FindBy(id = "login_id")
    private WebElement identityEditBox;

    @FindBy(id = "login_password")
    private WebElement passwordEditBox;

    @FindBy(id = "login_next")
    private WebElement loginButton;

    public WebElement getIdentityEditBox() {
        return identityEditBox;
    }

    public WebElement getPasswordEditBox() {
        return passwordEditBox;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public void enterId(String id) {
        identityEditBox.click();
        identityEditBox.clear();
        identityEditBox.sendKeys(id);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_next")));
//        loginButton.click();
    }

    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_password")));
        passwordEditBox.click();
        passwordEditBox.clear();
        passwordEditBox.sendKeys(password);
//        loginButton.click();
    }
}
