package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import static base.BasePage.driverSet;
import static helpers.ConfigReader.readProperty;

public class BaseTest {
    public static AndroidDriver driver;
    private static AppiumDriverLocalService service;

    public void setUp() {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(System.getProperty("user.home")+readProperty("PathToMainJs")))
                .withIPAddress(readProperty("IPaddress"))
                .usingPort(Integer.parseInt(readProperty("Port")))
                .build();
        service.start();
        service.clearOutPutStreams();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(readProperty("DeviceName"));
        options.setApp(System.getProperty("user.dir")+readProperty("app"));
        options.setChromedriverExecutable(System.getProperty("user.dir")+readProperty("DriverPath"));
        try {
            driver = new AndroidDriver(new URL(readProperty("AppiumServerURL")), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driverSet(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeClass
    public void init() {
        setUp();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
        service.stop();
    }


}
