package tests;


import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pages.ProductsPage.FindElementListByLocator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class ClassTest extends BaseTest{
    HomePage homePage = new HomePage();
    BasePage basePage = new BasePage() {};
    SelectedProductPage selectedProductPage = new SelectedProductPage();


    @Test
    public void searchForProduct() {
        basePage.waitForElementToBeVisible(By.cssSelector("body"));
        Assert.assertTrue(basePage.isAt("https://eldorado.am/"), AssertionMessages.INVALID_URL);
        Assert.assertNotNull(LocatorsConstants.INPUT_SEARCH_HOMEPAGE, AssertionMessages.SEARCH_BAR_NOT_EXIST);
        Assert.assertNotNull(LocatorsConstants.MAIN_LOGO, AssertionMessages.MAIN_LOGO_NOT_EXIST);
        Assert.assertNotNull(LocatorsConstants.ACTIONS_BLOCK, AssertionMessages.ACTIONS_BLOCK_NOT_EXIST);
        Assert.assertNotNull(LocatorsConstants.FAVORITE_BLOCK, AssertionMessages.FAVORITE_BLOCK_NOT_EXIST);
        Assert.assertNotNull(LocatorsConstants.BASKET_BLOCK, AssertionMessages.BASKET_BLOCK_NOT_EXIST);

        homePage.sendKeysToInput(By.cssSelector(LocatorsConstants.INPUT_SEARCH_HOMEPAGE), basePage, "Headphone");

    }
    @Test(dependsOnMethods = {"searchForProduct"})
    public void selectProduct() {
        basePage.waitForElementToBeVisible(By.cssSelector("body"));
        Assert.assertTrue(basePage.isAt("https://eldorado.am/am/catalogsearch/result/?q=Headphone"), AssertionMessages.INVALID_URL);
        Assert.assertNotNull(LocatorsConstants.LISTING_TOP, AssertionMessages.ELEMENT_DOES_NOT_EXIST);
        Assert.assertNotNull(LocatorsConstants.SORT_BLOCK, AssertionMessages.ELEMENT_DOES_NOT_EXIST);
        Assert.assertNotNull(LocatorsConstants.SORT_TITLE, AssertionMessages.ELEMENT_DOES_NOT_EXIST);
        Assert.assertNotNull(LocatorsConstants.SORT_LIST, AssertionMessages.ELEMENT_DOES_NOT_EXIST);
        List<WebElement> sortItems = FindElementListByLocator(LocatorsConstants.SORT_LIST, basePage);
        Assert.assertEquals(sortItems.size(), 1, AssertionMessages.LIST_COUNT_NOT_MATCH);

        List<WebElement> liElements = new ArrayList<>();
        for (WebElement sortItem : sortItems) {
            liElements.addAll(sortItem.findElements(By.tagName("li")));
        }

        Assert.assertEquals(liElements.size(), 3, AssertionMessages.LIST_COUNT_NOT_MATCH);
        ProductsPage.selectStoreByIndex(0, basePage);

    }

    @Test(dependsOnMethods = {"selectProduct"})
    public void addProductToCart() throws IOException, ParseException {
        basePage.waitForElementToBeVisible(By.cssSelector("body"));
        Assert.assertTrue(basePage.isAt("https://eldorado.am/am/xiaomi-mi-in-ear-headphones-basic-silver-zbw4355ty.html"), AssertionMessages.INVALID_URL);
        Assert.assertNotNull(LocatorsConstants.PRODUCT_DESCRIPTION_INNER, AssertionMessages.ELEMENT_DOES_NOT_EXIST);
        Assert.assertNotNull(LocatorsConstants.PRODUCT_SKU, AssertionMessages.ELEMENT_DOES_NOT_EXIST);
        Assert.assertNotNull(LocatorsConstants.RATE_ICON, AssertionMessages.ELEMENT_DOES_NOT_EXIST);

        FileReader reader = new FileReader("src/main/java/mock/product_info.json");
        JSONParser jsonParser = new JSONParser();
        JSONObject productInfo = (JSONObject) jsonParser.parse(reader);

        String productName = (String) productInfo.get("name");
        String productPrice = (String) productInfo.get("price");
        String productSKU = (String) productInfo.get("SKU");

        Assert.assertEquals(productName, "Ականջակալ Xiaomi Mi In-Ear Headphones Basic (Silver) ZBW4355TY",
                AssertionMessages.PRODUCT_JSON_MISMATCH);
        Assert.assertEquals(productPrice, "2 200", AssertionMessages.PRODUCT_JSON_MISMATCH);
        Assert.assertEquals(productSKU, "34287", AssertionMessages.PRODUCT_JSON_MISMATCH);

        selectedProductPage.addProductToCart();
    }

}
