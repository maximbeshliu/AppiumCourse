package pages.android;

import BaseTest.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static FirstTests.Utilities.scrollIntoView;

public class FormPage extends BasePage {

    public FormPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleRadioBtn;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement maleRadioBtn;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    private WebElement dropDown;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement submitBtn;

    public void setName(String name) {
        nameField.sendKeys(name);
        driver.hideKeyboard();
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("female")) {
            femaleRadioBtn.click();
        } else {
            maleRadioBtn.click();
        }
    }

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
