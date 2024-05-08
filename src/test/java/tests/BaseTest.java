package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.WebDriverFactory;

public class BaseTest {
    @BeforeClass
    public void setup() {
        WebDriverFactory.getInstance().getDriver().get("https://eldorado.am/");
    }

    @AfterClass
    public void tearDown() {
        WebDriverFactory.getInstance().getDriver().quit();
    }

}
