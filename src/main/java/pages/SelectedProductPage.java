package pages;

import org.openqa.selenium.By;
import utils.LocatorsConstants;

public class SelectedProductPage extends BasePage {

    public void addProductToCart() {
        click(By.cssSelector(LocatorsConstants.ADDTOCART_BUTTON));
    }



}
