package eurobankdemo.testbase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import eurobankdemo.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BasePO {
    protected static WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentHtmlReporter htmlReporter;

    public void initDriver() {
        driver = Driver.getInstance();
    }

    public void initReports() {
        System.setProperty("user.dir", "src\\test\\resources\\reports\\ExtentReports.html");
        extent = new ExtentReports();
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir"));
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
        initReports();
    }

    @AfterSuite
    public void tearDown() {
        extent.flush();
        driver.quit();
    }
}
