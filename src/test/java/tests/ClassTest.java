package tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.ProductsPage;
import pages.SingleStorePage;
import utils.*;


public class ClassTest extends BaseTest{
    HomePage homePage = new HomePage();
    BasePage basePage = new BasePage() {};
    SingleStorePage singleStorePage = new SingleStorePage() {};


    @Test
    public void selectStore() {
        basePage.waitForElementToBeVisible(By.cssSelector("body"));
        Assert.assertTrue(basePage.isAt("https://dalma.am/"), AssertionMessages.INVALID_URL);

        homePage.goToStoresPage();

        Assert.assertTrue(basePage.isAt(LocatorsConstants.HREF_STORES), AssertionMessages.NAVIGATION_FAILED);
        basePage.waitForElementToBeVisible(By.cssSelector("body"));
        ProductsPage.searchForItem(By.cssSelector(LocatorsConstants.SEARCH_INPUT), basePage);
        ProductsPage.selectStoreByIndex(0, basePage);
        basePage.waitForElementToBeVisible(By.cssSelector("body"));
        Assert.assertTrue(basePage.isUrlContains("https://dalma.am/stores"), AssertionMessages.INVALID_URL);

    }

    @Test(dependsOnMethods = {"selectStore"})
    public void seeProductOnMap() {
        basePage.waitForElementToBeVisible(By.cssSelector("body"));

        Assert.assertTrue(basePage.assertElementExists(LocatorsConstants.SEE_ON_MAP), AssertionMessages.SEE_ON_MAP_FAILED);
        singleStorePage.SeeOnMap();

    }

    @Test(dependsOnMethods = {"seeProductOnMap"})
    public void selectBlogFromBlogsPage() {
        singleStorePage.goToBlogPage();
        singleStorePage.selectBlogByIndex(0,basePage);
        basePage.waitForElementToBeVisible(By.cssSelector("body"));
        Assert.assertTrue(basePage.isUrlContains("https://dalma.am/blog"), AssertionMessages.INVALID_URL);
        homePage.goToStoresPage();
    }

    @Test(dependsOnMethods = {"selectBlogFromBlogsPage"})
    public void sendEmailFromHomePage() {
        singleStorePage.goToHomePage();
        homePage.sendEmail(By.cssSelector(LocatorsConstants.INPUT_EMAIL_SUBSCRIBE), basePage, "asd@asd");
    }

    @Test(dependsOnMethods = {"sendEmailFromHomePage"})
    public void closeEmailAndSendAgain() {
        homePage.closeEmail();
        homePage.sendEmail(By.cssSelector(LocatorsConstants.INPUT_EMAIL_SUBSCRIBE), basePage, "exampleUsername@gmail.com");
    }


}
