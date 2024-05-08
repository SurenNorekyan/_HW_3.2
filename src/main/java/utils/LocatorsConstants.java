package utils;

import org.openqa.selenium.By;

public class LocatorsConstants {
    public static final String ADDTOCART_BUTTON = "button[id='product-addtocart-button']";
    public static final String INPUT_SEARCH_HOMEPAGE = "input[type='text'][id='search']";
    public static final By MAIN_LOGO = By.cssSelector("div.main_logo");
    public static final By ACTIONS_BLOCK = By.cssSelector("div.actions_block");
    public static final By FAVORITE_BLOCK = By.cssSelector("div.favorite_block");
    public static final By BASKET_BLOCK = By.cssSelector("div[data-block='mini-cart']");
    public static final By STORE_ITEM = By.cssSelector("li[data-container='product-grid']");
    public static final By LISTING_TOP = By.cssSelector("div.listing_top");
    public static final By SORT_BLOCK = By.cssSelector("div.sort_block");
    public static final By SORT_TITLE = By.cssSelector("div.sort_title");
    public static final By SORT_LIST = By.cssSelector("ul.sort_list");
    public static final By PRODUCT_DESCRIPTION_INNER = By.cssSelector("div.description_inner");
    public static final By PRODUCT_SKU = By.cssSelector("div.productSku");
    public static final By RATE_ICON = By.cssSelector("div.rate_icon");
}