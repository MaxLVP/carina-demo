package com.qaprosoft.carina.demo.web.re_store.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HeaderMenu extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

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

    @FindBy(xpath = "//li[contains(@class, 'header-search')]")
    private SearchForm searchForm;

    @FindBy(xpath = "//a[contains(@href, 'payment') and contains(@class, 'page-header')]")
    private ExtendedWebElement paymentPageLink;

    @FindBy(xpath = "//a[contains(@href, 'delivery') and contains(@class, 'page-header-mid')]")
    private ExtendedWebElement deliveryPageLink;

    @FindBy(xpath = "//a[contains(@href, 'recipes') and contains(@class, 'page-header')]")
    private ExtendedWebElement recipesPageLink;

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
        searchForm.typeSearch(value);
    }

    public boolean isSearchOpen() {
        return searchForm.isSearchOpen();
    }

    public void findValue() {
        searchForm.findValue();
    }

    public void closeSearch() {
        searchForm.closeSearch();
    }

    public void openFavoritePage() {
        favoriteLink.click();
    }

    public int returnNumberOfFavoriteProducts() {
        waitUntil(ExpectedConditions.textToBePresentInElement(numberOfFavoriteProducts.getElement(), "regex:[//d]"), 1);
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

    public void openPaymentPage() {
        paymentPageLink.click();
    }

    public void openDeliveryPage() {
        deliveryPageLink.click();
    }

    public void openRecipesPage() {
        recipesPageLink.click();
    }
}
