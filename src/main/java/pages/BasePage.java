package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;
import java.time.Duration;

public abstract class BasePage {
    public static WebDriver driver;
    protected static WebDriverWait wait;

    public BasePage() {
        driver = WebDriverFactory.getInstance().getDriver();
        PageFactory.initElements(driver, this);
        Duration timeout = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, timeout);
    }

    public boolean waitForElementToBeVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static WebElement getByIndex(By locator, int index){
        return driver.findElements(locator).get(index);
    }


    public static WebElement waitUntilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    protected static void waitAndClick(By locator) {
        WebElement element = waitUntilClickable(locator);
        element.click();
    }

    protected void click(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public boolean isAt(String url) {
        return driver.getCurrentUrl().equals(url);
    }

    public boolean isUrlContains(String substring) {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains(substring);
    }

}
