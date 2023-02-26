package com.qaprosoft.carina.demo.web.sauce_demo.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductInfoPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class,'inventory_details_name')]")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//div[contains(@class,'inventory_details_desc ')]")
    private ExtendedWebElement productDescription;

    @FindBy(xpath = "//div[@class = 'inventory_details_price']")
    private ExtendedWebElement productPrice;

    public ProductInfoPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productName);
    }

    public String readName() {
        assertElementPresent(productName);
        return productName.getText();
    }

    public String readPrice() {
        assertElementPresent(productPrice);
        return productPrice.getText();
    }

    public String readInfo() {
        assertElementPresent(productDescription);
        return productDescription.getText();
    }
}
