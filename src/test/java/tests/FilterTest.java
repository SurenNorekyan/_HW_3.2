package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComputerEquipmentsPage;
import pages.HomePage;
import utils.AssertionMessages;

public class FilterTest extends BaseTest{

    HomePage homePage = new HomePage();

    @Test
    public void a_navigateToNoteBooks() throws InterruptedException {
        ComputerEquipmentsPage computerEquipmentsPage = homePage.navigateToComputerEquipmentsPage();
        computerEquipmentsPage.sortByNotebooks();
    }

    @Test
    public void b_sortByPriceRange() throws InterruptedException {
        ComputerEquipmentsPage computerEquipmentsPage = homePage.navigateToComputerEquipmentsPage();
        computerEquipmentsPage.sortByNotebooks();
        computerEquipmentsPage.sortByPriceRange("400000", "600000");
        int productCount = computerEquipmentsPage.getProductCount();
        Assert.assertTrue(productCount > 0, AssertionMessages.NO_PRODUCTS_FOUND_FILTER);
        for (int i = 0; i < productCount; i++) {
            double productPrice = computerEquipmentsPage.parsePrice(computerEquipmentsPage.getProductPrice(i));
            Assert.assertTrue(productPrice >= 400000 && productPrice <= 600000,
                    AssertionMessages.NOT_IN_RANGE + i);
        }
    }

    @Test
    public void c_sortByProducer() throws InterruptedException {
        ComputerEquipmentsPage computerEquipmentsPage = homePage.navigateToComputerEquipmentsPage();
        computerEquipmentsPage.sortByNotebooks();
        computerEquipmentsPage.sortByProducer(0);
        String producer = computerEquipmentsPage.getProductProducer();
        int productCount = computerEquipmentsPage.getProductCount();
        Assert.assertTrue(productCount > 0, AssertionMessages.NO_PRODUCTS_FOUND_FILTER);
        for (int i = 0; i < productCount; i++) {
            String productTitle = computerEquipmentsPage.getProductTitle(i);
            Assert.assertTrue(productTitle.contains(producer), "Product title at index " + i + " does not contain the producer: " + producer);
        }
    }

}
