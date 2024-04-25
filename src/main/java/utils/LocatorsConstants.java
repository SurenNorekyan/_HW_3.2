package utils;

import org.openqa.selenium.By;

public class LocatorsConstants {
    public static final String HREF_STORES = "https://dalma.am/stores";
    public static final String STORES_ELEMENT = "a[data-item='1']";
    public static final String BLOG_ELEMENT = "a[data-item='5']";
    public static final String HOME = "a[class='navbar-brand']";
    public static final String MENU_BAR = "div[class='menu-btn']";
    public static final String SEARCH_INPUT = "input[name='s']";
    public static final By STORE_ITEM = By.cssSelector("div.store-item");
    public static final By BLOG_ITEM = By.cssSelector("div.arrow-round.right.arrow-100");
    public static final By SEE_ON_MAP = By.cssSelector("a.go-to");
    public static final String INPUT_EMAIL_SUBSCRIBE = "input[type='email'][id='subscribe']";
    public static final By CLOSE_EMAIL = By.cssSelector("i.icon.icon-close");


}