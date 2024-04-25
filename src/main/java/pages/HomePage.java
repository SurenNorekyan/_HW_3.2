package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.LocatorsConstants;


public class HomePage extends BasePage {
    public void goToStoresPage() {
        click(By.cssSelector(LocatorsConstants.MENU_BAR));
        WebElement storesLink = waitUntilClickable(By.cssSelector(LocatorsConstants.STORES_ELEMENT));
        storesLink.click();
    }

    public void goToBlogPage() {
        click(By.cssSelector(LocatorsConstants.MENU_BAR));
        WebElement blogLink = waitUntilClickable(By.cssSelector(LocatorsConstants.BLOG_ELEMENT));
        blogLink.click();
    }

    public void sendEmail(By item, BasePage basePage, String email) {
        basePage.waitUntilClickable(item);
        basePage.driver.findElement(item).sendKeys(email);
        basePage.driver.findElement(item).submit();
    }

    public void closeEmail() {
        click(LocatorsConstants.CLOSE_EMAIL);
    }

}
