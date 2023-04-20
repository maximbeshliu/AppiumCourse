package pages.android;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.AppiumDriverRunner;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static helpers.CommonActions.longPress;

public class ShoppingCartPage  {

    private final ElementsCollection productPrices =$$(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
    private final String  cartXpath = "com.androidsample.generalstore:id/toolbar_title";
    private final SelenideElement cartSign =$(AppiumBy.id(cartXpath));
    private final String termAndConditions ="com.androidsample.generalstore:id/termsButton";
    private final SelenideElement termsOkBtn =$(AppiumBy.id("android:id/button1"));
    private final SelenideElement termsAndConditionsCheckBox =$(AppiumBy.xpath("//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']"));

    @Step("Customer validates total price")
    public void calcTotalPriceAndValidate(){
        new WebDriverWait(AppiumDriverRunner.getAndroidDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id(cartXpath))));
        new WebDriverWait(AppiumDriverRunner.getAndroidDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.attributeContains(cartSign,"text","Cart"));
        float priceTotal = 0;
        for (WebElement price: productPrices){
            String floatPrice = price.getText().replace("$","").trim();
            priceTotal += Float.parseFloat(floatPrice);
        }
        String priceFromApp = AppiumDriverRunner.getAndroidDriver().findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().replace("$"," ").trim();
        Assert.assertEquals(Float.parseFloat(priceFromApp),priceTotal);
    }

    @Step("Customer agrees with all terms and conditions")
    public void checkAndAgreeWithTerms(){
        longPress(AppiumDriverRunner.getAndroidDriver(),termAndConditions,"id");
        termsOkBtn.click();
        termsAndConditionsCheckBox.click();

    }



}
