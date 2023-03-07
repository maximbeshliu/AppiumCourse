package FirstTests;

import BaseTest.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static FirstTests.Utilities.*;

public class LongPress extends BaseTest {

    @Test
    public void makeLongPress() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
        longPress(driver,element);

        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());

        Thread.sleep(5000);
    }
}
