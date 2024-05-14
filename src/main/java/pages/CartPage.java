package pages;

import org.openqa.selenium.WebElement;
import utils.LocatorsConstants;

import java.util.List;

public class CartPage extends BasePage{
    public int getCartProductCount(){
        return driver.findElements(LocatorsConstants.CART_ITEM).size();
    }
    public String getProductTitle(int index){
        return getByIndex(LocatorsConstants.CART_ITEM_TITLE,index).getText();
    }

    public String getProductPrice(int index){
        return getByIndex(LocatorsConstants.CART_ITEM_PRICE,index).getText();
    }

    public void removeProductFromCart(int index){
        getByIndex(LocatorsConstants.CART_REMOVE_BUTTON,index).click();
    }

    public double parsePrice(String price) {
        String numericPart = price.replaceAll("[^0-9]", "").replace("\u00a0", "");
        return Double.parseDouble(numericPart);
    }

    public boolean isProductInCartContainingKeyword(String keyword) {
        List<WebElement> cartItems = driver.findElements(LocatorsConstants.CART_ITEM_TITLE);
        for (WebElement cartItem : cartItems) {
            if (cartItem.getText().toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
