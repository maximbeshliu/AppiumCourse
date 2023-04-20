package tests;

import base.BaseTest;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.appium.AppiumDriverRunner;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.android.FormPage;
import pages.android.GoodsListPage;
import pages.android.ShoppingCartPage;


public class eCommerceForm extends BaseTest {
    @BeforeMethod
    public void backToMainPage() {
        Selenide.sleep(3000);
        if (!AppiumDriverRunner.getAndroidDriver().currentActivity().equals(".MainActivity")) {
            do {
                AppiumDriverRunner.getAndroidDriver().pressKey(new KeyEvent(AndroidKey.BACK));
            } while (!AppiumDriverRunner.getAndroidDriver().currentActivity().equals(".MainActivity"));
        }
    }

    @Test
    public void fillTheForm() {
        FormPage formPage = new FormPage();
        formPage.setName("Max");
        formPage.selectGender("male");
        formPage.clickOnDropDownAndSelectCountry("Belgium");
        formPage.submiteForm();

        GoodsListPage goodsListPage = new GoodsListPage();

        goodsListPage.chooseItem("Jordan 6 Rings");
        goodsListPage.goToShoppingCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

        shoppingCartPage.calcTotalPriceAndValidate();
        shoppingCartPage.checkAndAgreeWithTerms();
    }


    @Test
    public void fillTheForm2() {
        FormPage formPage = new FormPage();
        formPage.setName("Mahmud");
        formPage.selectGender("female");
        formPage.clickOnDropDownAndSelectCountry("Austria");
        formPage.submiteForm();

        GoodsListPage goodsListPage = new GoodsListPage();

        goodsListPage.chooseItem("PG 3");
        goodsListPage.goToShoppingCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

        shoppingCartPage.calcTotalPriceAndValidate();
        shoppingCartPage.checkAndAgreeWithTerms();
    }
}
