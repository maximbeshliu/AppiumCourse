package GeneralStore;

import BaseTest.BaseTest;
import org.testng.annotations.Test;
import pages.android.FormPage;
import pages.android.GoodsListPage;

public class eCommerceForm extends BaseTest {
    @Test
    public void fillTheForm() throws InterruptedException {
        FormPage formPage = new FormPage();

        formPage.setName("Max");
        formPage.selectGender("male");
        formPage.clickOnDropDownAndSelectCountry("Belgium");
        formPage.submiteForm();

        GoodsListPage goodsListPage = new GoodsListPage();

        goodsListPage.chooseItem("Jordan 6 Rings");
        goodsListPage.chooseItem("Nike SFB Jungle");

        goodsListPage.goToShoppingCart().calcTotalPriceAndValidate();

        goodsListPage.goToShoppingCart().checkAndAgreeWithTerms();


//        String modelName1 = "Jordan 6 Rings";
//        String xpath = "//android.widget.LinearLayout//android.widget.TextView[@text='%s']//following-sibling::android.widget.LinearLayout//android.widget.TextView[@text='ADD TO CART']";
//        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
//        scrollIntoView(driver, "Albania");
//        WebElement country = driver.findElement(By.xpath("//android.widget.TextView[@text='Albania']"));
//        country.click();
//        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Glasha");
//        driver.hideKeyboard();
//        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
//        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
////        String popUp=driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
////        System.out.println(popUp);
//        scrollIntoView(driver, modelName1);
//        driver.findElement(By.xpath(String.format(xpath,modelName1))).click();
////        scrollIntoView(driver, modelName2);
////        driver.findElement(By.xpath(String.format(xpath,modelName2))).click();
//
////        int numberOfProducts = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
////        for (int i = 0; i < numberOfProducts; i++) {
////            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
////            if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
////                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
////            }
////        }
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//        Thread.sleep(3000);
//        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
//        List<WebElement> priceList = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
//        float priceTotal = 0;
//        for (WebElement price:priceList){
//            String floatPrice = price.getText().replace("$","").trim();
//            priceTotal += Float.parseFloat(floatPrice);
//        }
//
//        String priceFromApp = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().replace("$"," ").trim();
//        Assert.assertEquals(Float.parseFloat(priceFromApp),priceTotal);
//        longPress(driver,driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")));
//        driver.findElement(By.id("android:id/button1")).click();
//        driver.findElement(By.xpath("//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']")).click();
//        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("com.androidsample.generalstore:id/pb"))));
//        Set<String>contextes =  driver.getContextHandles();
//        for (String context:contextes){
//            System.out.println(context);
//        }
//        driver.context("WEBVIEW_com.androidsample.generalstore");
//        driver.findElement(By.name("q")).sendKeys("Hi there", Keys.ENTER);
//        driver.pressKey(new KeyEvent(AndroidKey.BACK));
//        driver.context("NATIVE_APP");
//        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Заебись");
//        Thread.sleep(5000);
    }
}
