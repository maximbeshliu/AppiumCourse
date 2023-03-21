package pages.android;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.AppiumDriverRunner;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.appium.SelenideAppium.$;
import static helpers.CommonActions.scrollIntoView;

public class GoodsListPage {

    private final SelenideElement shoppingCartIcon= $(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"));

    @Step("Customer picks item from list: {0}")
    public void chooseItem(String name) {
        String xpath = "//android.widget.LinearLayout//android.widget.TextView[@text='%s']//following-sibling::android.widget.LinearLayout//android.widget.TextView[@text='ADD TO CART']";
        scrollIntoView(AppiumDriverRunner.getAndroidDriver(), name);
        AppiumDriverRunner.getAndroidDriver().findElement(By.xpath(String.format(xpath, name))).click();
    }

    @Step("Customer goes to shopping cart")
    public void goToShoppingCart(){
        shoppingCartIcon.click();
    }


}
