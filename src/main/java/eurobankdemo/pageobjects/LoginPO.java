package eurobankdemo.pageobjects;

import eurobankdemo.drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPO {
    private WebDriver driver;

    @FindBy(id = "login_id")
    private WebElement identityEditBox;

    @FindBy(id = "login_password")
    private WebElement passwordEditBox;

    @FindBy(id = "login_next")
    private WebElement loginButton;

    public void enterId(String id) {
        identityEditBox.click();
        identityEditBox.clear();
        identityEditBox.sendKeys(id);
        driver = Driver.getInstance();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_next")));
        loginButton.click();
    }

    public void enterPassword(String password) {
        passwordEditBox.click();
        passwordEditBox.clear();
        passwordEditBox.sendKeys(password);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_password")));
        loginButton.click();
    }
}
