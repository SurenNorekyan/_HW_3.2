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
    public WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = WebDriverFactory.getInstance().getDriver();
        PageFactory.initElements(driver, this);
        Duration timeout = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, timeout);
    }

    public void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitUntilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void navigateTo(String url) {
        driver.get(url);
    }

    protected void click(By locator) {
        WebElement element = waitUntilClickable(locator);
        element.click();
    }

    public boolean isAt(String url) {
        return driver.getCurrentUrl().equals(url);
    }

    public boolean isUrlContains(String substring) {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains(substring);
    }


    public boolean assertElementExists(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
