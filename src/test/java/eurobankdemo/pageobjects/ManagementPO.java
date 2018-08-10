package eurobankdemo.pageobjects;

import eurobankdemo.testbase.BasePO;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagementPO extends BasePO {

    @FindBy(className = "show-page-loader")
    private WebElement userName;


}
