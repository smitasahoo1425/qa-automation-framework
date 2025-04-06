// ExtentManager.java (Extent Reports for TestNG)
package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentTest test;
    
    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Tester", "QA Engineer");
        }
        return extent;
    }
    
    public static void createTest(String testName) {
        test = getInstance().createTest(testName);
    }
    
    public static ExtentTest getTest() {
        return test;
    }
}