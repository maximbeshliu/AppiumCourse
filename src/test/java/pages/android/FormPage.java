package pages.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static FirstTests.Utilities.scrollIntoView;

public class FormPage {
    AndroidDriver driver;

    public FormPage(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleRadioBtn;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement maleRadioBtn;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    private WebElement dropDown;

    private final String countryName = "//android.widget.TextView[@text='%s']";

    @AndroidFindBy(xpath = countryName)
    private WebElement countryFromList;

    public void setName(String name){
        nameField.sendKeys(name);
    }

    public void selectGender(String gender){
        if (gender.equalsIgnoreCase("female")){
            femaleRadioBtn.click();
        }else {
            maleRadioBtn.click();
        }
    }

    public void clickOnDropDownAndSelectCountry(String country){
        dropDown.click();
        scrollIntoView(driver, country);
        String.format(countryName,country);
        countryFromList.click();
    }
}
