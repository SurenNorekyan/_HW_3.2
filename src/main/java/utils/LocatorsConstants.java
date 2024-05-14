package utils;

import org.openqa.selenium.By;

public class LocatorsConstants {
    public static final String ADDTOCART_BUTTON = "button[id='product-addtocart-button']";
    public static final String INPUT_SEARCH_HOMEPAGE = "input[type='text'][id='search']";
    public static final By MAIN_LOGO = By.cssSelector("div.main_logo");
    public static final By BASKET_BUTTON = By.cssSelector("a.basket_btn");
    public static final By STORE_ITEM = By.cssSelector("li[data-container='product-grid']");
    public static final By SELECTED_PRODUCT_DESCRIPTION_INNER = By.cssSelector("div.product_title > div.description_inner");
    public static final By SELECTED_PRODUCT_PRICE = By.cssSelector("span[data-price-type=\"finalPrice\"] > span.price");


    public static final By SEARCH_BUTTON = By.cssSelector("#search_mini_form > button.icon_search");
    public static final By PRODUCT_NAME = By.cssSelector("a[class=\"product_name combo_link\"]");
    public static final By PRODUCT_PRICE = By.cssSelector("span[data-price-type=\"finalPrice\"] > span.price");

    public static final By SEARCH_RESULT = By.cssSelector("div.breadcrumbs > div.custom_container > ul > li > div");
    public static final By NO_RESULT = By.cssSelector("div.message > div");
    public static final By SORT_ITEM = By.cssSelector("ul.sort_list > li > a.icon_list_filtre");
    public static final By BASKET_COUNTER = By.cssSelector("span.basket-counter-number");
    public static final By CART_ITEM = By.cssSelector("#shopping-cart-table");
    public static final By CART_ITEM_TITLE = By.cssSelector("div.info_block > a.product_title");
    public static final By CART_ITEM_PRICE = By.cssSelector("span.price-excluding-tax > span.cart-price > span.price");

    public static final By CART_REMOVE_BUTTON = By.cssSelector("div.product_links > a.action-delete");

    public static final By SUBMENU_BUTTON = By.cssSelector("ul.catalog_menu > li > a.submenu_btn");
    public static final By FILTER_ITEM = By.cssSelector("div.filter_inner > div.filter_block");
    public static final By OPTIONS_LIST = By.cssSelector("div.options_list > ol.items > li.item");
    public static final By PRICE_LIMITS = By.cssSelector("div.options_list > ul.price_limits > li");
    public static final By FILTER_SUBMIT_BUTTON = By.cssSelector("div.options_list > button");
    public static final By INPUT_FROM = By.cssSelector("input.price_from");
    public static final By INPUT_TO = By.cssSelector("input.price_to");

    public static final By FILTER_PRODUCT_PRICE = By.cssSelector("span[data-price-type=\"finalPrice\"] > span.price");
    public static final By FILTER_PRODUCT_TITLE = By.cssSelector("div.info_block > a.product_name");
}