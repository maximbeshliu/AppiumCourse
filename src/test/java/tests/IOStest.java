package tests;

import base.BaseTestIOS;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.AppiumDriverRunner;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class IOStest extends BaseTestIOS {

    @Test
    public void testik(){

        System.out.println("Запустился");

        HashMap<Object,Object> scrollObject = new HashMap<>();
        scrollObject.put("direction","down");
        scrollObject.put("Attribute name","Toolbars");

        AppiumDriverRunner.getIosDriver().executeScript("mobile:scroll",scrollObject);
        SelenideElement button = $(AppiumBy.accessibilityId("AAPLDatePickerController"));
        button.click();
    }
}
