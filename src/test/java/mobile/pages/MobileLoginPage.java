package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileElement;

public class MobileLoginPage {
    private AndroidDriver<MobileElement> driver;

    public MobileLoginPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    String usernameFieldId = prop.getProperty("mobile.username.id");
    String passwordFieldId = prop.getProperty("mobile.password.id");
    String loginButtonId  = prop.getProperty("mobile.loginBtn.id");

    driver.findElement(By.id(usernameFieldId)).sendKeys("testuser");
    driver.findElement(By.id(passwordFieldId)).sendKeys("password");
    driver.findElement(By.id(loginButtonId)).click();
    
    
    public void enterUsername(String username) {
        driver.findElementById("com.example.app:id/username").sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElementById("com.example.app:id/password").sendKeys(password);
    }

    public void clickLogin() {
        driver.findElementById("com.example.app:id/loginBtn").click();
    }
}



