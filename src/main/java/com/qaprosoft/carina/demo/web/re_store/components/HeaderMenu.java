package com.qaprosoft.carina.demo.web.re_store.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.re_store.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HeaderMenu extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String SEARCH_INPUT_XPATH = "//input[contains(@class, 'input__search')]";
    private static final String CLOSE_SEARCH_BUTTON_XPATH = "//button[contains(@class, 'btn__close')]";
    private static final String FIND_BUTTON_XPATH = "//button[contains(@class, 'btn-search')]";
    private static final String SEARCH_BUTTON_XPATH = "//span[contains(@class, 'search_btn')]";

    @FindBy(xpath = "//span[contains(@class, 'search_btn')]")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//a[@href='/favorite/' and contains(@class, 'page-header')]")
    private ExtendedWebElement favoriteLink;

    @FindBy(xpath = "//a[@href='/favorite/' and contains(@class, 'page-header')]//span[@class='badge']")
    private ExtendedWebElement numberOfFavoriteProducts;

    @FindBy(xpath = "//a[contains(@class, 'logo__re-store')]")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = "//a[contains(@href, 'bakaleya') and contains(@class, 'page-header')]")
    private ExtendedWebElement bakaleyaPageLink;

    @FindBy(xpath = "//a[@data-gaaction='into_cart']//span[contains(@class, 'badge')]")
    private ExtendedWebElement productNumberInCart;

    @FindBy(xpath = "//div[contains(@class, 'js_small_basket')]")
    private ExtendedWebElement cartPageLink;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isSearchButtonPresented() {
        return searchButton.isElementPresent();
    }

    public void openSearch() {
        LOGGER.info("Opening search");
        searchButton.click();
    }

    public void typeSearch(String value) {
        findExtendedWebElement(By.xpath(SEARCH_INPUT_XPATH)).type(value);
    }

    public boolean isSearchOpen() {
        return findExtendedWebElement(By.xpath(SEARCH_INPUT_XPATH)).isElementPresent();
    }

    public void findValue() {
        findExtendedWebElement(By.xpath(FIND_BUTTON_XPATH)).click();
    }

    public void closeSearch() {
        LOGGER.info("Closing search");
        findExtendedWebElement(By.xpath(CLOSE_SEARCH_BUTTON_XPATH)).click();
    }

    public void openFavoritePage() {
        favoriteLink.click();
    }

    public int returnNumberOfFavoriteProducts() {
        return Integer.parseInt(numberOfFavoriteProducts.getText());
    }

    public void openHomePage() {
        homeLink.click();
    }

    public void openBakaleya() {
        bakaleyaPageLink.click();
    }

    public int returnNumberOfProductsInCart() {
        return Integer.parseInt(productNumberInCart.getText());
    }

    public boolean isAnyProductInCart() {
        return productNumberInCart.isElementPresent(1);
    }

    public void openCartPage() {
        cartPageLink.click();
    }
}
