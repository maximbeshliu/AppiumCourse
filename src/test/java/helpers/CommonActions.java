package helpers;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class CommonActions {

    public static void longPress(AppiumDriver driver, String xpathElement, String byWhat) {
        WebElement element = null;
        switch (byWhat) {
            case "xpath":
                element =driver.findElement(By.xpath(xpathElement));
                break;
            case "id":
                element = driver.findElement(By.id(xpathElement));
                break;
            default:
                throw new RuntimeException("Wrong way of Element Identification");
        }

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
    }

    public static void scrollIntoView(AppiumDriver driver, String text) {
        driver.findElement(AppiumBy.androidUIAutomator(String.format("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"%s\"));", text)));
    }

    public static void swipe(AppiumDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "left",
                "percent", 0.75
        ));
    }


}
