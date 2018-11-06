package eurobankdemo.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driverInstance;

    private static WebDriver initializeFirefox() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\executables\\chromedriver.exe");
        driverInstance = new ChromeDriver();
        driverInstance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driverInstance;
    }

    public static WebDriver getInstance() {
        if (driverInstance == null) {
            driverInstance = initializeFirefox();
        }
        return driverInstance;
    }

    private Driver() {
    }
}


