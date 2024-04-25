import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pages.BasePage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotListener extends BasePage implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        captureScreenshot(result);
    }

    private void captureScreenshot(ITestResult result) {
        WebDriver driver = this.driver;

        TakesScreenshot screenshot = (TakesScreenshot) driver;

        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        Path destPath = Paths.get("screenshots", generateScreenshotFileName(result));

        try {
            Files.copy(srcFile.toPath(), destPath);
            System.out.println("Screenshot captured: " + destPath.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String generateScreenshotFileName(ITestResult result) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

        return result.getMethod().getMethodName() + "_" + formatter.format(currentTime) + ".png";
    }
}
