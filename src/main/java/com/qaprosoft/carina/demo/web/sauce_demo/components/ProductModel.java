package com.qaprosoft.carina.demo.web.sauce_demo.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.sauce_demo.pages.ProductInfoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class ProductModel extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final static String REMOVE_BUTTON_XPATH = ".//button[contains(@id, 'remove')]";

    @FindBy(xpath = ".//div[@class = 'inventory_item_name']")
    private ExtendedWebElement productName;

    @FindBy(xpath = ".//a[contains(@id, 'title_link')]")
    private ExtendedWebElement productPageOpen;

    @FindBy(xpath = ".//div[@class = 'inventory_item_desc']")
    private ExtendedWebElement productDescription;

    @FindBy(xpath = ".//div[@class='inventory_item_price']")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = ".//button[contains(@id, 'add-to-cart')]")
    private ExtendedWebElement addCart;

    public ProductModel(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String returnProductName() {
        return productName.getText();
    }

    public ProductInfoPage openProductPage() {
        productPageOpen.click();
        return new ProductInfoPage(driver);
    }

    public String returnProductDesc() {
        return productDescription.getText();
    }

    public String returnProductPrice() {
        return productPrice.getText();
    }

    public void addToCart() {
        LOGGER.info("Add product to cart");
        addCart.click();
    }

    public boolean isRemoveButtonDisplay() {
        ExtendedWebElement removeButton = findExtendedWebElement(By.xpath(REMOVE_BUTTON_XPATH));
        if (removeButton == null) {
            return false;
        }
        return removeButton.isElementPresent();
    }

    public void removeFromCart() {
        ExtendedWebElement removeButton = findExtendedWebElement(By.xpath(REMOVE_BUTTON_XPATH));
        removeButton.click();
    }
}
