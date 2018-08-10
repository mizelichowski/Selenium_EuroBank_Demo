package eurobankdemo.utils;

import com.aventstack.extentreports.ExtentReports;

public class ExtentReportsManager {
    private static ExtentReports extent;

    private ExtentReportsManager() {
    }

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = new ExtentReports();
            extent.config();
        }
        return extent;
    }
}
