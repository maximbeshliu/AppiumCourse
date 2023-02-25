package GeneralStore;

import FirstTests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static FirstTests.Utilities.scrollIntoView;

public class eCommerceForm extends BaseTest {
    @Test
    public void fillTheForm() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        scrollIntoView(driver, "Albania");
        WebElement country = driver.findElement(By.xpath("//android.widget.TextView[@text='Albania']"));
        country.click();
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Glasha");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//        String popUp=driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
//        System.out.println(popUp);
        scrollIntoView(driver, "Jordan 6 Rings");
        driver.findElement(By.xpath("//android.widget.LinearLayout//android.widget.TextView[@text='Jordan 6 Rings']//following-sibling::android.widget.LinearLayout//android.widget.TextView[@text='ADD TO CART']")).click();
//        int numberOfProducts = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
//        for (int i = 0; i < numberOfProducts; i++) {
//            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
//            if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
//                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
//            }
//        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
        String productName = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(productName, "Jordan 6 Rings");
        Thread.sleep(5000);
    }
}
