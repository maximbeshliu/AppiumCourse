package BaseTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import static BaseTest.BasePage.driverSet;

public class BaseTest {

    public static AndroidDriver driver;
    private static AppiumDriverLocalService service;

    public void setUp() {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\maxim.besliu\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("MaximDevice");
        options.setApp("C:\\Users\\maxim.besliu\\Desktop\\AppiumCourse\\src\\test\\resources\\app\\General-Store.apk");
        options.setChromedriverExecutable("C:\\Users\\maxim.besliu\\Desktop\\AppiumCourse\\src\\test\\resources\\drivers\\chromedriver.exe");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
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
