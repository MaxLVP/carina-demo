package com.qaprosoft.carina.demo.web.re_store.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.re_store.components.AuthorizationForm;
import com.qaprosoft.carina.demo.web.re_store.components.HeaderMenu;
import com.qaprosoft.carina.demo.web.re_store.components.ProductModel;
import com.qaprosoft.carina.demo.web.re_store.pages.catalog.BaileyPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a[contains(@class, 'hide')]")
    private ExtendedWebElement registerButton;

    @FindBy(xpath = "//a[@href = '/personal/' and contains(@class, 'page-header')]")
    private ExtendedWebElement personalButton;

    @FindBy(xpath = "//a[contains(@href, 'login')]")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//div[contains(@class, 'js_cat_list_item') and contains(@class, 'product-slider_item')]")
    private List<ProductModel> productsOnHomePage;

    @FindBy(xpath = "//div[contains(@class, 'page-header_middle ')]")
    private HeaderMenu headerMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://re-store.by/");
    }

    public AuthorizationForm openRegisterForm() {
        registerButton.click();
        return new AuthorizationForm(driver);
    }

    public AuthorizationForm openLoginForm() {
        loginButton.click();
        return new AuthorizationForm(driver);
    }

    public boolean checkIfPersonalPresented() {
        return personalButton.isElementPresent();
    }

    public PersonalPage openPersonalPage() {
        personalButton.click();
        return new PersonalPage(driver);
    }

    public boolean checkIfRegisterAvailable() {
        return registerButton.isElementPresent(1);
    }

    public boolean isSearchButtonPresented() {
        return headerMenu.isSearchButtonPresented();
    }

    public SearchPage searchProductById(String value) {
        LOGGER.info("Searching product");
        headerMenu.typeSearch(value);
        headerMenu.findValue();
        return new SearchPage(driver);
    }

    public void closeSearch() {
        headerMenu.closeSearch();
    }

    public void openSearch() {
        headerMenu.openSearch();
    }

    public boolean isSearchFormOpen() {
        return headerMenu.isSearchOpen();
    }

    public boolean isMenuPresented() {
        return headerMenu.isUIObjectPresent();
    }

    public BaileyPage openBaileyPage() {
        LOGGER.info("Open catalog of bailey");
        headerMenu.openBakaleya();
        return  new BaileyPage(driver);
    }

    public boolean isAnyProductInCart() {
        return headerMenu.isAnyProductInCart();
    }

    public int getNumberOfProductsInCart() {
        return headerMenu.returnNumberOfProductsInCart();
    }

    public CartPage openCartPage() {
        LOGGER.info("Open cart page");
        headerMenu.openCartPage();
        return new CartPage(driver);
    }

    public PaymentPage openPaymentPage() {
        LOGGER.info("Open payment page");
        headerMenu.openPaymentPage();
        return new PaymentPage(driver);
    }

    public DeliveryPage openDeliveryPage() {
        LOGGER.info("Open delivery page");
        headerMenu.openDeliveryPage();
        return new DeliveryPage(driver);
    }

    public RecipePage openRecipePage() {
        LOGGER.info("Open recipe page");
        headerMenu.openRecipesPage();
        return new RecipePage(driver);
    }

}
