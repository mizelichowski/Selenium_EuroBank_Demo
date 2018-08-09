package eurobankdemo.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferVerificationPO {

    @FindBy(xpath = "//*[@id=\"transfer_new_out\"]/div[1]/div[1]/div[2]/div/div/span[2]/strong")
    private WebElement availableFunds;

    private int availableFundsStringToInt(String funds) {
        funds = availableFunds.getText();
        int fundsToInt = Integer.parseInt(funds);
        return fundsToInt;
    }
}
