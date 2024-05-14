package pages;

import org.openqa.selenium.WebElement;
import utils.LocatorsConstants;

public class ComputerEquipmentsPage extends BasePage {
    public void sortByNotebooks() throws InterruptedException {
        WebElement notebookType = getByIndex(LocatorsConstants.FILTER_ITEM, 6);
        notebookType.click();
        Thread.sleep(1000);
        waitForElementToBeVisible(LocatorsConstants.OPTIONS_LIST);
        WebElement secondOption = notebookType.findElements(LocatorsConstants.OPTIONS_LIST).get(1);
        secondOption.click();
    }

    public void sortByProducer(int index) throws InterruptedException {
        WebElement producerType = getByIndex(LocatorsConstants.FILTER_ITEM, 0);
        producerType.click();
        Thread.sleep(1000);
        waitForElementToBeVisible(LocatorsConstants.OPTIONS_LIST);
        WebElement option = producerType.findElements(LocatorsConstants.OPTIONS_LIST).get(index);
        option.click();

    }

    public void sortByPriceRange(String firstPrice, String secondPrice) {
        WebElement priceRangeBlock = getByIndex(LocatorsConstants.FILTER_ITEM, 4);
        priceRangeBlock.click();

        waitForElementToBeVisible(LocatorsConstants.PRICE_LIMITS);

        WebElement priceFromInput = priceRangeBlock.findElement(LocatorsConstants.INPUT_FROM);
        WebElement priceToInput = priceRangeBlock.findElement(LocatorsConstants.INPUT_TO);

        priceFromInput.clear();
        priceFromInput.sendKeys(firstPrice);
        priceToInput.clear();
        priceToInput.sendKeys(secondPrice);

        driver.findElement(LocatorsConstants.FILTER_SUBMIT_BUTTON).click();
    }

    public int getProductCount(){
        return driver.findElements(LocatorsConstants.FILTER_PRODUCT_TITLE).size();
    }
    public String getProductTitle(int index){
        return driver.findElements(LocatorsConstants.FILTER_PRODUCT_TITLE).get(index).getText();
    }
    public String getProductProducer(){
        return driver.findElement(LocatorsConstants.FILTER_VALUE).getText();
    }

    public String getProductPrice(int index){
        return driver.findElements(LocatorsConstants.FILTER_PRODUCT_PRICE).get(index).getText();
    }
    public double parsePrice(String price) {
        String numericPart = price.replaceAll("[^0-9]", "").replace("\u00a0", "");
        return Double.parseDouble(numericPart);
    }

}
