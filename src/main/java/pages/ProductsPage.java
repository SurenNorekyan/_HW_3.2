package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.LocatorsConstants;
import utils.UrlConstants;

import java.util.List;

public class ProductsPage extends BasePage {
    public String getSearchResultText(){
        return driver.findElement(LocatorsConstants.SEARCH_RESULT).getText();
    }
    public String getNoSearchResultText(){
        return driver.findElement(LocatorsConstants.NO_RESULT).getText();
    }
    public String getProductTitle(int index){
        return driver.findElements(LocatorsConstants.PRODUCT_NAME).get(index).getText();
    }

    public String getProductPrice(int index){
        return driver.findElements(LocatorsConstants.PRODUCT_PRICE).get(index).getText();
    }

    public int getProductCount(){
        return driver.findElements(LocatorsConstants.PRODUCT_NAME).size();
    }

    public void clickOnSortButton(){
        driver.findElements(LocatorsConstants.SORT_ITEM).get(2).click();
    }

    public boolean comparePrices(Double price1, Double price2) {
        return price1 >= price2;
    }

    public double parsePrice(String price) {
        String numericPart = price.replaceAll("[^0-9]", "").replace("\u00a0", "");
        return Double.parseDouble(numericPart);
    }

    public boolean isSearchButtonEnabled() {
        WebElement searchButton = driver.findElement(LocatorsConstants.SEARCH_BUTTON);
        return searchButton.isEnabled();
    }


    public SelectedProductPage selectStoreByIndex(int index) {
        WebElement[] storeElements = driver.findElements(LocatorsConstants.STORE_ITEM).toArray(new WebElement[0]);

        if (index >= 0 && index < storeElements.length) {
            storeElements[index].click();
            return new SelectedProductPage();
        } else {
            throw new IllegalArgumentException("Invalid index provided: " + index);
        }
    }

    public boolean verifyBasketCount(int index) {
        String basketCountStr = driver.findElement(LocatorsConstants.BASKET_COUNTER).getText();
        return Integer.parseInt(basketCountStr) == index;
    }


    public List<WebElement> FindElementListByLocator(By locator){
        return driver.findElements(locator);
    }

    public String findInnerTextByLocator(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    public String generateSearchResultUrl(String searchKeyWord) {
        return UrlConstants.searchResultUrl + searchKeyWord;
    }



}
