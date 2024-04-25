import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private WebDriver driver;

    public TestListener(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Call the screenshot utility when a test fails
        ScreenshotUtil.takeScreenshot(driver, "screenshots/" + result.getName() + ".png");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Starting Test Suite " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Finished Test Suite " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starting Test " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // You can also define actions here if needed
    }
}
