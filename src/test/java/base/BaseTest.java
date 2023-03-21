package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;

import static helpers.ConfigReader.readProperty;


public class BaseTest {
    private static AppiumDriverLocalService service;

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
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));

        startAppiumServer();

        Configuration.browser = AndroidDriverInit.class.getName();
        Configuration.timeout = 10000;
        SelenideAppium.launchApp();
    }

    @BeforeSuite
    public void init() {
      setUp();
    }

//    @BeforeMethod
//    public void retry(ITestContext context) {
//        Arrays.stream(context.getAllTestMethods()).forEach(x -> x.setRetryAnalyzerClass(RetryAnalyzer.class));
//        setUp();
//    }

    @AfterSuite
    public void close() {
        service.close();
    }

}
