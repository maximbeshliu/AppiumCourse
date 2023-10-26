package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.logevents.SelenideLogger;
import customListeners.RetryAnalyzer;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.Arrays;

import static helpers.ConfigReader.readProperty;

public class BaseTestIOS {

    private static AppiumDriverLocalService service;
    @BeforeSuite
    public void init(ITestContext context) {
        Arrays.stream(context.getAllTestMethods()).forEach(x->x.setRetryAnalyzerClass(RetryAnalyzer.class));
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(readProperty("PathToMainJs")))
                .withIPAddress(readProperty("IPaddress"))
                .usingPort(Integer.parseInt(readProperty("Port")))
                .build();
        service.start();
        service.clearOutPutStreams();

        Configuration.browser = IOSDriverInit.class.getName();
        Configuration.timeout = 10000;
        SelenideAppium.launchApp();
    }

    @AfterSuite
    public void close() {
        service.close();
    }
}
