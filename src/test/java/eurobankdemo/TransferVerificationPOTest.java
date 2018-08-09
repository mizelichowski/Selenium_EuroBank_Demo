package eurobankdemo;

import eurobankdemo.drivers.Driver;
import eurobankdemo.pageobjects.TransferVerificationPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TransferVerificationPOTest {
    private WebDriver driver;
    private TransferVerificationPO transferVerificationPO;

    @BeforeClass
    private void init() {
        driver = Driver.getInstance();
        transferVerificationPO = PageFactory.initElements(driver, TransferVerificationPO.class);
    }

//    @Test
//    @Parameters()
//    private void
}