package GeneralStore;

import FirstTests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static FirstTests.Utilities.scrollIntoView;

public class eCommerceForm extends BaseTest {
    @Test
    public void fillTheForm() {
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        scrollIntoView(driver,"Moldova, Republic of");
        WebElement country = driver.findElement(By.xpath("//android.widget.TextView[@text='Moldova, Republic of']"));
        country.click();
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Maxim Besliu");
    }
}
