package com.qaprosoft.carina.demo.web.re_store.pages.catalog;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.re_store.components.HeaderMenu;
import com.qaprosoft.carina.demo.web.re_store.components.ProductModel;
import com.qaprosoft.carina.demo.web.re_store.pages.ProductInfoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class VinegarPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[contains(@class, 'js_cat_list_item') and contains(@class, 'catalog-grid-item')]")
    private List<ProductModel> productModels;

    @FindBy(xpath = "//div[contains(@class, 'page-header_middle ')]")
    private HeaderMenu headerMenu;

    @FindBy(xpath = "//li//a[text() = 'УКСУСЫ']")
    private ExtendedWebElement vinegarsLink;

    public VinegarPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://re-store.by/catalog/uksusy/");
    }

    public void addAllVinegarsToCart() {
        LOGGER.info("Adding vinegars to cart");
        for (ProductModel productModel : productModels) {
            ProductInfoPage productInfoPage = productModel.openProductInfoPage();
            productInfoPage.addToCart();
            vinegarsLink.click();
        }
    }

    public int returnNumberOfProductsOnPage() {
        return productModels.size();
    }

    public int getProductsNumberInCart() {
        LOGGER.info("Getting number of products in cart");
        return headerMenu.returnNumberOfProductsInCart();
    }

    public double getPriceOfAllVinegars() {
        LOGGER.info("Get all price of vinegars");
        double sum = 0;
        for (ProductModel productModel : productModels) {
            sum += productModel.returnPriceOfProduct();
            System.out.println(sum);
        }
        return sum;
    }

    public int getNumberOfProductsInCart() {
        return  headerMenu.returnNumberOfProductsInCart();
    }
}
