package eurobankdemo.pageobjects;

import eurobankdemo.testbase.BasePO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MoneyTransferPO extends BasePO {

    @FindBy(xpath = "//*[@id=\"widget_1_transfer_receiver\"]")
    private WebElement recipientName;

    @FindBy(xpath = "//*[@id=\"widget_1_transfer_amount\"]")
    @CacheLookup
    private WebElement amountOfMoney;

    @FindBy(xpath = "//*[@id=\"widget_1_transfer_title\"]")
    @CacheLookup
    private WebElement transferTitle;

    @FindBy(xpath = "//*[@id=\"widget_transfer_1\"]/div[4]/div/button")
    @CacheLookup
    private WebElement acceptTransferButton;

    public void setRecipientName(String recipient) {
        Select recipientSelection = new Select(driver.findElement(By.id("widget_1_transfer_receiver")));
        recipientSelection.selectByVisibleText(recipient);
    }

    public void setAmountOfMoney(String amount) {
        amountOfMoney.click();
        amountOfMoney.clear();
        amountOfMoney.sendKeys(amount);
    }

    public void setTransferTitle(String title) {
        transferTitle.click();
        transferTitle.clear();
        transferTitle.sendKeys(title);
    }

    public void finalizeTransfer() {
        acceptTransferButton.click();
    }
}
