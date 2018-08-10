package eurobankdemo.testcases;

import eurobankdemo.pageobjects.MoneyTransferPO;
import eurobankdemo.testbase.BasePO;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MoneyTransferPOTest extends BasePO {
    private MoneyTransferPO moneyTransferPO;

    @BeforeClass
    private void init() {
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