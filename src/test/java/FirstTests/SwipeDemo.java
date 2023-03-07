package FirstTests;

import BaseTest.BaseTest;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.List;

public class SwipeDemo extends BaseTest {

    @Test
    public void swipeTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        List<WebElement> imageList= driver.findElements(By.xpath("//android.widget.ImageView"));
        System.out.println(imageList.size());
        for (int i= 1; i<=6;i++){
            WebElement image = driver.findElement(By.xpath(String.format("(//android.widget.ImageView)[%s]",i)));
//            Assert.assertEquals(image.getAttribute("focusable"), ("true"));
            ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) image).getId(),
                    "direction", "left",
                    "percent", 0.75
            ));

//            Assert.assertEquals(image.getAttribute("focusable"), ("false"));
        }

    }
}
