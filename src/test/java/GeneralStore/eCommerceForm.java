package GeneralStore;

import FirstTests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static FirstTests.Utilities.scrollIntoView;

public class eCommerceForm extends BaseTest {
    @Test
    public void fillTheForm() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        scrollIntoView(driver, "Moldova, Republic of");
        WebElement country = driver.findElement(By.xpath("//android.widget.TextView[@text='Moldova, Republic of']"));
        country.click();
//        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Glasha");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String popUp=driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
        System.out.println(popUp);
        Thread.sleep(5000);
    }
}
