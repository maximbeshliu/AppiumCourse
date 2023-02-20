package FirstTests;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest{

    @Test
    public void appiumtTest() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String text =driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(text,"WiFi settings");
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Maxim Wi-Fi");
        driver.findElement(AppiumBy.id("android:id/button1")).click();

        Thread.sleep(5000);
    }
}
