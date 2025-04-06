package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;
    private By dashboardText = By.id("dashboard");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardDisplayed() {
        return driver.findElements(dashboardText).size() > 0;
    }
}
