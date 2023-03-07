package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class BasePage {

    protected static AndroidDriver driver;
    protected static WebDriverWait wait;

    public static void driverSet(AndroidDriver webDriverdriver) {
        driver = webDriverdriver;
        wait = new WebDriverWait(webDriverdriver, Duration.ofSeconds(10));
    }

}
