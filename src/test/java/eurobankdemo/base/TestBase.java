package eurobankdemo.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    protected static WebDriver driver;

    public void initProperties() throws IOException {
        Properties config = new Properties();
        FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\" +
                "resources\\properties\\Config.properties");
        config.load(fis1);
        System.out.println(config.getProperty("browser"));
    }

    @BeforeSuite
    public void setUp() throws IOException {
        initProperties();
    }

    @AfterSuite
    public void tearDown() {

    }
}
