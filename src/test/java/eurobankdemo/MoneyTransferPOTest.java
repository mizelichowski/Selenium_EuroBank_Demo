package eurobankdemo;

import eurobankdemo.drivers.Driver;
import eurobankdemo.pageobjects.MoneyTransferPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MoneyTransferPOTest {
    private WebDriver driver;
    private MoneyTransferPO moneyTransferPO;

    @BeforeClass
    private void init() {
        driver = Driver.getInstance();
        moneyTransferPO = PageFactory.initElements(driver, MoneyTransferPO.class);
    }

    @Test
    @Parameters({"recipient", "amount", "title"})
    private void fillInTransferData(String recipient, String amount, String title) {
        moneyTransferPO.fillInTransferData(recipient, amount, title);
    }

    @Test
    private void makeTransfer() {
        moneyTransferPO.finalizeTransfer();
    }
}