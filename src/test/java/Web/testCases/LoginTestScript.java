package testCases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import com.aventstack.extentreports.Status;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, boolean shouldPass) {
        test.log(Status.INFO, "Starting login test with username: " + username);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        test.log(Status.INFO, "Clicked login button");

        DashboardPage dashboardPage = new DashboardPage(driver);

        if (shouldPass) {
            Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Login failed!");
            test.log(Status.PASS, "Login successful for " + username);
        } else {
            test.log(Status.FAIL, "Login failed as expected for " + username);
        }
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"validUser", "validPass", true},
                {"invalidUser", "wrongPass", false}
        };
    }
}
