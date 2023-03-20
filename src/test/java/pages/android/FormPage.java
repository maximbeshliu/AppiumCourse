package pages.android;

import base.BasePage;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static helpers.CommonActions.scrollIntoView;

public class FormPage extends BasePage{

    private SelenideElement nameField = $(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
    private SelenideElement femaleRadioBtn= $(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"));
    private SelenideElement maleRadioBtn= $(AppiumBy.id("com.androidsample.generalstore:id/radioMale"));
    private SelenideElement dropDown= $(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry"));
    private SelenideElement submitBtn= $(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));


    @Step("Customer introduces  name: {0}")
    public void setName(String name) {
        nameField.sendKeys(name);
    }


    @Step("Customer selects  gender: {0}")
    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("female")) {
            femaleRadioBtn.click();
        } else {
            maleRadioBtn.click();
        }
    }

    @Step("Customer selects country: {0}")
    public void clickOnDropDownAndSelectCountry(String country) {
        dropDown.click();
        scrollIntoView(driver, country);
        final String countryName = "//android.widget.TextView[@text='%s']";
        WebElement countryFromList = driver.findElement(By.xpath(String.format(countryName, country)));
        countryFromList.click();
    }

    public void submiteForm() {
        submitBtn.click();
    }
}
