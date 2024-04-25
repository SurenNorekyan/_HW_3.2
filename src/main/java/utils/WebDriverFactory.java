package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    private static WebDriverFactory instance = new WebDriverFactory();
    private WebDriver driver;

    private WebDriverFactory() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver();
    }

    public static WebDriverFactory getInstance() {
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
