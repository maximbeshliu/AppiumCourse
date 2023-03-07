package customListeners;

import base.BasePage;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class TestListener extends BasePage implements TestLifecycleListener {


    @Override
    public void beforeTestStop(TestResult result){
        if (result.getStatus().name().equalsIgnoreCase("FAILED") ||
                result.getStatus().name().equalsIgnoreCase("BROKEN")) {
            Allure.addAttachment(result.getName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
    }

}
