package eurobankdemo.testbase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import eurobankdemo.driver.Driver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BasePO {
    protected static WebDriver driver;
    protected static Logger logger;
    protected ExtentReports extent;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest report;

    public void initDriver() {
        driver = Driver.getInstance();
    }

    public void initLogger() {
        System.setProperty("LOG4J_CONFIGURATION_FILE", "log4j2.xml");
    }

    public void initReports() {
        System.setProperty("user.dir", "C:\\Users\\mizel\\Desktop\\Java Projects\\eurobankdemo\\src\\test\\resources\\reports\\ExtentReports.html");
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir"));
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Software Testing Material");
        extent.setSystemInfo("Environment", "Automation Testing");
        extent.setSystemInfo("User Name", "SomeUser");

        htmlReporter.config().setDocumentTitle("EuroBank Demo Report");
        htmlReporter.config().setReportName("EuroBank Demo Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
    }

    @BeforeSuite
    public void startUp() {
        initDriver();
        initLogger();
        initReports();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
