package pages;

import org.openqa.selenium.By;
import utils.LocatorsConstants;


public class HomePage extends BasePage {

    public HomePage navigateToHomePage(){
        waitAndClick(LocatorsConstants.MAIN_LOGO);
        return new HomePage();
    }

    public ComputerEquipmentsPage navigateToComputerEquipmentsPage(){
        waitForElementToBeVisible(LocatorsConstants.SUBMENU_BUTTON);
        driver.findElements(LocatorsConstants.SUBMENU_BUTTON).get(3).click();
        return new ComputerEquipmentsPage();
    }


    public ProductsPage searchForProduct(String productName) {
        By item = By.cssSelector(LocatorsConstants.INPUT_SEARCH_HOMEPAGE);
        waitUntilClickable(item);
        driver.findElement(item).sendKeys(productName);
        driver.findElement(item).submit();
        return new ProductsPage();
    }


}
