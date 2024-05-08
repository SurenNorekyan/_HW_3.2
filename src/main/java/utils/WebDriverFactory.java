package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class WebDriverFactory {
    private static final WebDriverFactory instance = new WebDriverFactory();
    private WebDriver driver;

    private WebDriverFactory() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebDriverFactory getInstance() {
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
