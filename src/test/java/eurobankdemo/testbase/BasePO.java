package eurobankdemo.testbase;

import eurobankdemo.driver.Driver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BasePO {
    protected static WebDriver driver;
    protected static Logger log;

    public void initDriver() {
        driver = Driver.getInstance();
    }

    @BeforeSuite
    public void startUp() {
        initDriver();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
