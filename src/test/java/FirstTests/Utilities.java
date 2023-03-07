package FirstTests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class Utilities {

    public static void longPress(WebDriver driver, WebElement element){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"duration",2000));
    }

    public static void scrollIntoView(WebDriver driver,String text){
        driver.findElement(AppiumBy.androidUIAutomator(String.format("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"%s\"));",text)));
    }
}
