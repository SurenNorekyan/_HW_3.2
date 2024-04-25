package listeners;

import org.apache.commons.io.FileUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import utils.WebDriverFactory;

public class TestNGListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        captureScreenshot(result);
    }

    private void captureScreenshot(ITestResult result) {
        WebDriver driver = WebDriverFactory.getInstance().getDriver();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotName = result.getName() + "_" + System.currentTimeMillis() + ".png";
        String screenshotPath = "screenshots/" + screenshotName;
        File destination = new File(screenshotPath);
        try {
            FileUtils.copyFile(screenshot, destination);
            Reporter.log("Screenshot captured: <a href='" + destination.getAbsolutePath() + "'>screenshot</a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}