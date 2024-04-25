package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.LocatorsConstants;

public class SingleStorePage extends BasePage {

    public void goToBlogPage() {
        click(By.cssSelector(LocatorsConstants.MENU_BAR));
        click(By.cssSelector(LocatorsConstants.BLOG_ELEMENT));
    }

    public void goToHomePage() {
        click(By.cssSelector(LocatorsConstants.HOME));
    }

    public void SeeOnMap() {
        click(LocatorsConstants.SEE_ON_MAP);
    }

    public void selectBlogByIndex(int index, BasePage basePage) {
        WebElement[] blogElement = basePage.driver.findElements(LocatorsConstants.STORE_ITEM).toArray(new WebElement[0]);

        if (index >= 0 && index < blogElement.length) {
            blogElement[index].click();
        } else {
            System.out.println("Invalid index provided.");
        }
    }



}
