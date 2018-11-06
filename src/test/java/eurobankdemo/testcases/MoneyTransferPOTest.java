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

    @Parameters({"recipient", "amount", "title"})
    @Test
    private void fillInTransferData(String recipient, String amount, String title) throws InterruptedException {
//        report = extent.createTest("Fill in transfer data");
        moneyTransferPO.setRecipientName(recipient);

//        report.log(Status.PASS, MarkupHelper.createLabel("The recipient selected is: " + recipient, ExtentColor.GREEN));
        moneyTransferPO.setAmountOfMoney(amount);

//        report.log(Status.PASS, MarkupHelper.createLabel("The amount has been set to: " + amount, ExtentColor.GREEN));
        moneyTransferPO.setTransferTitle(title);

//        report.log(Status.PASS, MarkupHelper.createLabel("The title has been set to: " + title, ExtentColor.GREEN));
    }

    @Test
    private void makeTransfer() throws InterruptedException {
//        report = extent.createTest("Make the transfer");
        moneyTransferPO.finalizeTransfer();

//        report.log(Status.PASS, MarkupHelper.createLabel("The transfer has been made successfully", ExtentColor.GREEN));
    }
}