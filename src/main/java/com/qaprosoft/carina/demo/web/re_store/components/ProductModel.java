package com.qaprosoft.carina.demo.web.re_store.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.re_store.pages.ProductInfoPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class ProductModel extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@class='catalog-price_inner']//small")
    private ExtendedWebElement smallPrice;

    @FindBy(xpath = "//div[@class='catalog-price_inner']//strong")
    private ExtendedWebElement strongPrice;

    @FindBy(xpath = "//div[@class='catalog-grid-item_title']")
    private ExtendedWebElement brand;

    @FindBy(xpath = "//div[@class='catalog-grid-item_descr']")
    private ExtendedWebElement name;

    @FindBy(xpath = "//div[contains(@class, 'catalog-grid-item_price')]//following-sibling::a")
    private ExtendedWebElement linkToProductPage;

    @FindBy(xpath = "//button[contains(@class, 'js_favorite')]")
    private ExtendedWebElement addToFavoriteButton;

    @FindBy(xpath = "//button[@data-gaaction='put_cart']")
    private ExtendedWebElement addToCartFromCatalogButton;

    public ProductModel(WebDriver driver) {
        super(driver);
    }

    public ProductModel(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ProductInfoPage openProductInfoPage() {
        linkToProductPage.click();
        return new ProductInfoPage(driver);
    }

    public void addToCart() {
        LOGGER.info("Add product " + name.getText() + " to cart");
        addToCartFromCatalogButton.click();
    }

    public void addToFavorite(){
        LOGGER.info("Add product " + name.getText() + " to favorite");
        addToFavoriteButton.click();
    }

    public void removeFromFavorite() {
        LOGGER.info("Remove product " + name.getText() + " to favorite");
        addToFavoriteButton.click();
    }
}
