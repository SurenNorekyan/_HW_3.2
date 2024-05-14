package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ComputerEquipmentsPage;
import pages.HomePage;
import utils.AssertionMessages;

public class FilterTest extends BaseTest{

    HomePage homePage = new HomePage();
    BasePage basePage = new BasePage() {};

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

}
