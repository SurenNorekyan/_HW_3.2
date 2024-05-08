package pages;

import org.openqa.selenium.By;


public class HomePage extends BasePage {

    public void sendKeysToInput(By item, BasePage basePage, String email) {
        waitUntilClickable(item);
        basePage.driver.findElement(item).sendKeys(email);
        basePage.driver.findElement(item).submit();
    }


}
