package pages;

import org.openqa.selenium.By;
import utils.LocatorsConstants;

public class SelectedProductPage extends BasePage {

    public CartPage addProductToCart() {
        click(By.cssSelector(LocatorsConstants.ADDTOCART_BUTTON));
        return new CartPage();
    }

    public CartPage clickToBasket() {
        driver.findElement(LocatorsConstants.BASKET_BUTTON).click();
        return new CartPage();
    }

    public void navigateBack() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().back();
    }

    public String getProductTitle(){
        return driver.findElement(LocatorsConstants.SELECTED_PRODUCT_DESCRIPTION_INNER).getText();
    }

    public String getProductPrice(){
        return driver.findElement(LocatorsConstants.SELECTED_PRODUCT_PRICE).getText();
    }

    public double parsePrice(String price) {
        String numericPart = price.replaceAll("[^0-9]", "").replace("\u00a0", "");
        return Double.parseDouble(numericPart);
    }

}
