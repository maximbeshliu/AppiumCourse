package base;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.net.URL;
import java.time.Duration;

import static helpers.ConfigReader.readProperty;

@ParametersAreNonnullByDefault
public class AndroidDriverInit implements WebDriverProvider {
    public static AndroidDriver driver;

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setDeviceName(readProperty("DeviceName"));
        options.setApp(System.getProperty("user.dir") + readProperty("appPath"));
        options.setChromedriverExecutable(System.getProperty("user.dir") + readProperty("DriverPath"));
        options.setPlatformName(readProperty("platform"));
        options.setAppWaitForLaunch(false);
        options.setNewCommandTimeout(Duration.ofSeconds(30));
        try {
            driver = new AndroidDriver(new URL(readProperty("AppiumServerURL")), options);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return driver;
    }
}
