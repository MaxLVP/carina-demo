package com.qaprosoft.carina.demo.web.sauce_demo.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.sauce_demo.pages.ProductInfoPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductModel extends AbstractUIObject {

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
        addCart.click();
    }

}
