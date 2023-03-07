package pages.android;

import base.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static helpers.CommonActions.scrollIntoView;

public class GoodsListPage extends BasePage {

    public GoodsListPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement shoppingCartIcon;

    @Step("Customer picks item from list: {0}")
    public void chooseItem(String name) {
        String xpath = "//android.widget.LinearLayout//android.widget.TextView[@text='%s']//following-sibling::android.widget.LinearLayout//android.widget.TextView[@text='ADD TO CART']";
        scrollIntoView(driver, name);
        driver.findElement(By.xpath(String.format(xpath, name))).click();
    }

    @Step("Customer goes to shopping cart")
    public void goToShoppingCart(){
        shoppingCartIcon.click();
    }


}
