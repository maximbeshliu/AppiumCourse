package pages.android;

import BaseTest.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static FirstTests.Utilities.scrollIntoView;

public class GoodsListPage extends BasePage {

    public GoodsListPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement shoppingCartIcon;

    public void chooseItem(String name) {
        String xpath = "//android.widget.LinearLayout//android.widget.TextView[@text='%s']//following-sibling::android.widget.LinearLayout//android.widget.TextView[@text='ADD TO CART']";
        scrollIntoView(driver, name);
        driver.findElement(By.xpath(String.format(xpath, name))).click();
    }

    public ShoppingCartPage goToShoppingCart(){
        shoppingCartIcon.click();
        return new ShoppingCartPage();
    }


}
