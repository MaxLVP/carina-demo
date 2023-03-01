package com.qaprosoft.carina.demo.web.re_store.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.re_store.components.ProductModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//div[@class = 'search-block_top']")
    private ExtendedWebElement searchDiv;

    @FindBy(xpath = "//div[contains(@class, 'js_cat_list_item') and contains(@class, 'catalog-grid-item')]")
    private List<ProductModel> products;

    public SearchPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(searchDiv);
    }

    public ProductInfoPage openFirstProduct() {
        return products.get(0).openProductInfoPage();
    }

}
