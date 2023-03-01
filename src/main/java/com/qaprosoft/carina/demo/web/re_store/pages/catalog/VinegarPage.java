package com.qaprosoft.carina.demo.web.re_store.pages.catalog;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.re_store.components.HeaderMenu;
import com.qaprosoft.carina.demo.web.re_store.components.ProductModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class VinegarPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[contains(@class, 'js_cat_list_item') and contains(@class, 'catalog-grid-item')]")
    private List<ProductModel> productModels;

    @FindBy()
    private HeaderMenu headerMenu;

    public VinegarPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://re-store.by/catalog/uksusy/");
    }

    public void addAllVinegarsToCart() {
        LOGGER.info("Adding vinegars to cart");
        for (ProductModel productModel: productModels) {
            productModel.addToCart();
        }
    }

    public int returnNumberOfProductsOnPage() {
        return productModels.size();
    }

    public int getProductsNumberInCart() {
        LOGGER.info("Getting number of products in cart");
        return headerMenu.returnNumberOfProductsInCart();
    }
}
