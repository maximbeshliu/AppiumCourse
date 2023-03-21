package pages.android;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.AppiumDriverRunner;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static helpers.CommonActions.scrollIntoView;

public class FormPage {

    private final SelenideElement nameField = $(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
    private final SelenideElement femaleRadioBtn= $(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"));
    private final SelenideElement maleRadioBtn= $(AppiumBy.id("com.androidsample.generalstore:id/radioMale"));
    private final SelenideElement dropDown= $(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry"));
    private final SelenideElement submitBtn= $(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));


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
        scrollIntoView(AppiumDriverRunner.getAndroidDriver(), country);
        final String countryName = "//android.widget.TextView[@text='%s']";
        WebElement countryFromList = AppiumDriverRunner.getAndroidDriver().findElement(By.xpath(String.format(countryName, country)));
        countryFromList.click();
    }
    @Step("Customer clicks let's shop button")
    public void submiteForm() {
        submitBtn.click();
    }
}
