package com.qaprosoft.carina.demo.web.re_store.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.re_store.components.HeaderMenu;
import com.qaprosoft.carina.demo.web.re_store.models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class ProductInfoPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@class='catalog-item_descr-main']")
    private ExtendedWebElement productDescription;

    @FindBy(xpath = "//span[@class='catalog-item_name']")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//span[@class='catalog-item_manufacturer']")
    private ExtendedWebElement productBrand;

    @FindBy(xpath = "//div[@class='strong-price']//strong")
    private ExtendedWebElement strongPrice;

    @FindBy(xpath = "//div[@class='strong-price']//small")
    private ExtendedWebElement smallPrice;

    @FindBy(xpath = "//ul[contains(@class, 'dot-line-list')]//li[1]//span[@class='dot-line-row_end']")
    private ExtendedWebElement productID;

    @FindBy(xpath = "//div[@type='button' and contains(@class, 'to-fav')]")
    private ExtendedWebElement addToFavoriteButton;

    @FindBy(xpath = "//button[contains(@class, 'orderButton_submit')]")
    private ExtendedWebElement addToCart;

    @FindBy(xpath = "//div[contains(@class, 'page-header_middle ')]")
    private HeaderMenu headerMenu;

    public ProductInfoPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productDescription);
    }

    public String getProductBrand() {
        LOGGER.info("Get product brand from page");
        return productBrand.getText();
    }

    public String getProductId() {
        LOGGER.info("Get product id from page");
        return productID.getText();
    }

    public Double getProductPrice() {
        LOGGER.info("Get product price from page");
        return Double.valueOf(strongPrice.getText() + "." + smallPrice.getText());
    }

    public String getProductName() {
        LOGGER.info("Get product name from page");
        return productName.getText();
    }

    public void addToFavorite() {
        LOGGER.info("Add product " + getProductName() + " to favorite");
        addToFavoriteButton.click();
    }

    public Product getProductModel() {
        LOGGER.info("Get product model from page");
        Product product = new Product();
        product.setBrand(getProductBrand());
        product.setPrice(getProductPrice());
        product.setId(getProductId());
        return product;
    }

    public Integer getNumberOfFavoritesProducts() {
        return headerMenu.returnNumberOfFavoriteProducts();
    }

    public FavoritePage openFavoritePage() {
        LOGGER.info("Open favorite page");
        headerMenu.openFavoritePage();
        return  new FavoritePage(driver);
    }

    public void addToCart() {
        LOGGER.info("Add product " + getProductName() + " to cart");
        addToCart.click();
    }
}
