package GeneralStore;

import BaseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class browserAutomation extends BaseTest {

    @Test
    public void browser() {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Hi there", Keys.ENTER);
    }
}
