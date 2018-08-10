package eurobankdemo.testbase;

import com.aventstack.extentreports.ExtentReports;
import eurobankdemo.driver.Driver;
import eurobankdemo.utils.ExtentReportsManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BasePO {
    protected static WebDriver driver;
    protected static Logger logger;
    protected static ExtentReports extent;

    public void initDriver() {
        driver = Driver.getInstance();
    }

    public void initLogger() {
        System.setProperty("LOG4J_CONFIGURATION_FILE", "C:\\Users\\mizel\\Desktop\\Java Projects\\eurobankdemo\\log4j2.xml");
    }

    public void initExtent() {
        extent = ExtentReportsManager.getInstance();
    }

    @BeforeSuite
    public void startUp() {
        initDriver();
        initLogger();
        initExtent();
    }

    @AfterSuite
    public void tearDown() {
//        driver.quit();
    }
}
