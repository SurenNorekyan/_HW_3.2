package tests;

import junit.framework.Assert;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;


import java.io.FileWriter;
import java.io.IOException;

import static utils.Utils.readProductInfoFromJSON;

public class AddToCartTest extends BaseTest{
    HomePage homePage = new HomePage();

    @Test
    @Parameters("productName")
    public void a_addProductsToCart() throws InterruptedException {
        homePage.navigateToHomePage();
        String productName = "ipad";
        ProductsPage productsPage = homePage.searchForProduct(productName);

        JSONArray productsArray = new JSONArray();

        for (int i = 0; i < 3; i++) {
            SelectedProductPage selectedProductPage = productsPage.selectStoreByIndex(i);
            String productTitle = selectedProductPage.getProductTitle();
            String productPriceStr = selectedProductPage.getProductPrice();
            double productPrice = selectedProductPage.parsePrice(productPriceStr);

            JSONObject productObj = new JSONObject();
            productObj.put("title", productTitle);
            productObj.put("price", productPrice);

            productsArray.add(productObj);
            selectedProductPage.addProductToCart();
            selectedProductPage.navigateBack();
        }

        try (FileWriter file = new FileWriter("src/main/java/mock/product_info.json")) {
            file.write(productsArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(productsPage.verifyBasketCount(3));
    }

    @Test
    @Parameters("productName")
    public void b_verifyProducts() throws IOException, ParseException {
        homePage.navigateToHomePage();
        String productName = "ipad";
        ProductsPage productsPage = homePage.searchForProduct(productName);
        SelectedProductPage selectedProductPage = productsPage.selectStoreByIndex(0);
        CartPage cartPage = selectedProductPage.clickToBasket();
        String[] productInfo = readProductInfoFromJSON("src/main/java/mock/product_info.json");

        for (int i = 0; i <= cartPage.getCartProductCount(); i++) {
            String actualTitle = cartPage.getProductTitle(i);
            double actualPrice = cartPage.parsePrice(cartPage.getProductPrice(i));
            String expectedTitle = productInfo[i * 2];
            double expectedPrice = Double.parseDouble(productInfo[i * 2 + 1]);
            Assert.assertEquals(actualTitle, expectedTitle);
            Assert.assertEquals(actualPrice, expectedPrice);
        }
    }

    @Test
    @Parameters("productName")
    public void c_removeFromCart() {
        homePage.navigateToHomePage();
        String productName = "ipad";
        ProductsPage productsPage = homePage.searchForProduct(productName);
        SelectedProductPage selectedProductPage = productsPage.selectStoreByIndex(0);
        CartPage cartPage = selectedProductPage.clickToBasket();

        int initialProductCount = cartPage.getCartProductCount() + 1;

        for (int i = 0; i < initialProductCount; i++) {
            String actualTitle = cartPage.getProductTitle(i);
            cartPage.removeProductFromCart(i);
            Assert.assertFalse(cartPage.isProductInCartContainingKeyword(actualTitle));
        }
    }
}
