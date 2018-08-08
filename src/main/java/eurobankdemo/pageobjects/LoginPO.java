package eurobankdemo.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPO {

    @FindBy(xpath = "//*[@id=\"login_id\"]")
    @CacheLookup
    private WebElement identityEditBox;

    @FindBy(xpath = "//*[@id=\"login_password\"]")
    @CacheLookup
    private WebElement passwordEditBox;

    @FindBy(xpath = "//*[@id=\"login_next\"]")
    private WebElement loginButton;

    public void enterId(String id) {
        identityEditBox.click();
        identityEditBox.clear();
        identityEditBox.sendKeys(id);
        loginButton.click();
    }

    public void enterPassword(String password) {
        passwordEditBox.click();
        passwordEditBox.clear();
        passwordEditBox.sendKeys(password);
        loginButton.click();
    }
}
