package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.appium.java_client.android.Activity;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;

import static helpers.ConfigReader.readProperty;


public class BaseTest {
    private static AppiumDriverLocalService service;

    private Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");

    public void startAppiumServer() {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(System.getProperty("user.home") + readProperty("PathToMainJs")))
                .withIPAddress(readProperty("IPaddress"))
                .usingPort(Integer.parseInt(readProperty("Port")))
                .build();
        service.start();
        service.clearOutPutStreams();
    }

    public void setUp(){
        try {
            Process process = Runtime.getRuntime().exec("cmd.exe /c emulator -avd Pixel_2_API_30");
            process.waitFor();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));

        startAppiumServer();

        Configuration.browser = AndroidDriverInit.class.getName();
        Configuration.timeout = 10000;
        SelenideAppium.launchApp();
    }

    @BeforeClass
    public void init() {
      setUp();
    }



    @AfterClass
    public void close() {
        service.close();
    }

}
