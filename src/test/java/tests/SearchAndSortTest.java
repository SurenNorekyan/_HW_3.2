package tests;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import utils.*;


public class SearchAndSortTest extends BaseTest{
    HomePage homePage = new HomePage();
    BasePage basePage = new BasePage() {};


    @Test
    public void a_searchEmptyState(){
        ProductsPage productsPage = homePage.searchForProduct("");
        Assert.assertFalse(productsPage.isSearchButtonEnabled(), AssertionMessages.BUTTON_NOT_DISABLED);
    }
    @Test
    @Parameters("productName")
    public void a_searchInvalidProduct() {
        String productName = "asdzxc";
        ProductsPage productsPage = homePage.searchForProduct(productName);
        Assert.assertTrue(basePage.isAt(productsPage.generateSearchResultUrl(productName)), AssertionMessages.INVALID_URL);
        Assert.assertTrue(productsPage.getSearchResultText().toLowerCase().contains(productName.toLowerCase()), AssertionMessages.TEXT_MISMATCH);
        Assert.assertFalse(productsPage.getNoSearchResultText().isEmpty(), AssertionMessages.EMPTY_TEXT);
    }

    @Test
    @Parameters("productName")
    public void b_searchForProduct() {
        homePage.navigateToHomePage();
        String productName = "ipad";
        ProductsPage productsPage = homePage.searchForProduct(productName);
        Assert.assertTrue(basePage.isAt(productsPage.generateSearchResultUrl(productName)), AssertionMessages.INVALID_URL);
        for(int i = 0; i <= productsPage.getProductCount() - 20; i++) {
            Assert.assertTrue(productsPage.getProductTitle(i).toLowerCase().contains(productName.toLowerCase()));
            Assert.assertFalse(productsPage.getProductPrice(i).isEmpty());
        }

    }

    @Test
    @Parameters("productName")
    public void c_verifySortingHighToLow() {
        homePage.navigateToHomePage();
        String productName = "ipad";
        ProductsPage productsPage = homePage.searchForProduct(productName);
        Assert.assertTrue(basePage.isAt(productsPage.generateSearchResultUrl(productName)), AssertionMessages.INVALID_URL);
        productsPage.clickOnSortButton();
        int productCount = productsPage.getProductCount();
        for(int i = 0; i < productCount - 1; i++) {
            Double currentPrice = productsPage.parsePrice(productsPage.getProductPrice(i));
            Double nextPrice = productsPage.parsePrice(productsPage.getProductPrice(i + 1));
            Assert.assertTrue(productsPage.comparePrices(currentPrice, nextPrice), AssertionMessages.NOT_DESCENDING_ORDER);
        }
    }


}
