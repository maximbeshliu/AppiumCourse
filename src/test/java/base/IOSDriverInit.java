package base;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.URL;
import java.time.Duration;


import static helpers.ConfigReader.readProperty;

public class IOSDriverInit implements WebDriverProvider {
    public static IOSDriver driver;

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        XCUITestOptions options = new XCUITestOptions();
        options.merge(capabilities);
        options.setDeviceName(readProperty("DeviceNameIos"));
        options.setApp(readProperty("iosApp"));
        options.setPlatformVersion(readProperty("iosVersion"));
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));
        try {
            driver=new IOSDriver(new URL(readProperty("AppiumServerURL")),options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return driver;
    }
}
