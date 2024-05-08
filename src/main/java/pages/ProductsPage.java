package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.LocatorsConstants;

import java.util.List;

public class ProductsPage extends BasePage {
    public static void searchForItem(By item, BasePage basePage) {
        waitUntilClickable(item);
        basePage.driver.findElement(item).sendKeys("Store");
        basePage.driver.findElement(item).submit();
    }

    public static void selectStoreByIndex(int index, BasePage basePage) {
        WebElement[] storeElements = basePage.driver.findElements(LocatorsConstants.STORE_ITEM).toArray(new WebElement[0]);

        if (index >= 0 && index < storeElements.length) {
            storeElements[index].click();
        } else {
            throw new IllegalArgumentException("Invalid index provided: " + index);
        }
    }

    public static List<WebElement> FindElementListByLocator(By locator, BasePage basePage){
        return basePage.driver.findElements(locator);
    }

}
