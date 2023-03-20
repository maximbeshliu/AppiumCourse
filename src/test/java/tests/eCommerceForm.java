package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.android.FormPage;


public class eCommerceForm extends BaseTest {

    @Test
    public void fillTheForm() {
        FormPage formPage = new FormPage();
        formPage.setName("Max");
        formPage.selectGender("male");
        formPage.clickOnDropDownAndSelectCountry("Belgium");
        formPage.submiteForm();

//        GoodsListPage goodsListPage = new GoodsListPage();
//
//        goodsListPage.chooseItem("Jordan 6 Rings");
//        goodsListPage.chooseItem("Nike SFB Jungle");
//        goodsListPage.goToShoppingCart();
//
//        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
//
//        shoppingCartPage.calcTotalPriceAndValidate();
//        shoppingCartPage.checkAndAgreeWithTerms();
    }
}
