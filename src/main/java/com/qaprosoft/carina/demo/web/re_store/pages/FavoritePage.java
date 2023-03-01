package com.qaprosoft.carina.demo.web.re_store.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.re_store.components.ProductModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FavoritePage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'js_cat_list_item') and contains(@class, 'catalog-grid-item')]")
    private List<ProductModel> favoriteProducts;

    public FavoritePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://re-store.by/favorite/");
    }

    public Integer getNumberOfFavoriteProducts() {
        return favoriteProducts.size();
    }

    public void removeFirstProductFromFavorite() {
        favoriteProducts.get(0).removeFromFavorite();
    }
}
