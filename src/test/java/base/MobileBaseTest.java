package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.URL;

public class MobileBaseTest {
    public AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/app/app-debug.apk");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
