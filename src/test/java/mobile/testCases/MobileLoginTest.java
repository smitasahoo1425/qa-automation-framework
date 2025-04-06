package testCases;

import base.MobileBaseTest;
import pages.MobileLoginPage;
import org.testng.annotations.Test;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.*;


public class MobileLoginTest extends MobileBaseTest {
	static ExtentReports extent;
    static ExtentTest test;
    
    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/Mobile_Login_Report.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

	@Test
	public void testMobileLogin() {
	    MobileLoginPage loginPage = new MobileLoginPage(driver);
	    loginPage.login("testuser", "password123");
	}
	
	 @AfterSuite
	    public void tearDownReport() {
	        extent.flush();
	    }

}


