package pages.android;

import BaseTest.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static FirstTests.Utilities.longPress;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productPrices;

    private final String  cartXpath = "com.androidsample.generalstore:id/toolbar_title";
    @AndroidFindBy(id = cartXpath)
    private WebElement cartSign;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement termAndConditions;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement termsOkBtn;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']")
    private WebElement termsAndConditionsCheckBox;

    public void calcTotalPriceAndValidate(){
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id(cartXpath))));
        wait.until(ExpectedConditions.attributeContains(cartSign,"text","Cart"));
        float priceTotal = 0;
        for (WebElement price: productPrices){
            String floatPrice = price.getText().replace("$","").trim();
            priceTotal += Float.parseFloat(floatPrice);
        }
        String priceFromApp = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().replace("$"," ").trim();
        Assert.assertEquals(Float.parseFloat(priceFromApp),priceTotal);
    }

    public void checkAndAgreeWithTerms(){
        longPress(driver,termAndConditions);
        termsOkBtn.click();
        termsAndConditionsCheckBox.click();
    }


}
