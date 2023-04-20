package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.CmdCommandRunner;
import io.appium.java_client.android.Activity;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;

import static helpers.ConfigReader.readProperty;


public class BaseTest {
    private final CmdCommandRunner cmdCommandRunner= new CmdCommandRunner();
    private static AppiumDriverLocalService service;


    private Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");

    public void startAppiumServer() throws InterruptedException {
        cmdCommandRunner.runCommand("cmd /c cd c:\\Users\\Maxim\\AppData\\Local\\Android\\Sdk\\emulator && emulator -avd MaximPhone -wipe-data");
        Thread.sleep(15000);
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(System.getProperty("user.home") + readProperty("PathToMainJs")))
                .withIPAddress(readProperty("IPaddress"))
                .usingPort(Integer.parseInt(readProperty("Port")))
                .build();
        service.start();
        service.clearOutPutStreams();
    }

    public void setUp() throws InterruptedException {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));

        startAppiumServer();

        Configuration.browser = AndroidDriverInit.class.getName();
        Configuration.timeout = 10000;
        SelenideAppium.launchApp();
    }

    @BeforeSuite
    public void init() throws InterruptedException {
        setUp();
    }



    @AfterSuite
    public void close() {
        service.close();
        cmdCommandRunner.runCommand("cmd /c  adb emu kill");
    }

}
