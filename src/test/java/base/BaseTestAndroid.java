package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.CmdCommandRunner;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;

import static helpers.ConfigReader.readProperty;


public class BaseTestAndroid {
    private final CmdCommandRunner cmdCommandRunner= new CmdCommandRunner();
    private static AppiumDriverLocalService service;

    public void startAppiumServer() {
//        cmdCommandRunner.runCommand("emulator @Pixel_3a_API_30");

        String deviceLine;
//        do {
////            deviceLine = cmdCommandRunner.runCommand("adb devices").toString();
//        } while(deviceLine.contains("offline"));

        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(readProperty("PathToMainJs")))
                .withIPAddress(readProperty("IPaddress"))
                .usingPort(Integer.parseInt(readProperty("Port")))
                .build();
        service.start();
        service.clearOutPutStreams();
    }

    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));

        startAppiumServer();

        Configuration.browser = AndroidDriverInit.class.getName();
        Configuration.timeout = 10000;
        SelenideAppium.launchApp();
    }

    @BeforeClass
    public void init() throws InterruptedException {
        setUp();
    }



    @AfterClass
    public void close() {
        service.close();
//        cmdCommandRunner.runCommand("adb emu kill");
    }

}
