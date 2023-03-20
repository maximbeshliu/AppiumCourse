package customListeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int counter = 0;
    private int retryLimit = 1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess() && counter < retryLimit) {
            counter++;
            return true;
        }
        return false;
    }
}
