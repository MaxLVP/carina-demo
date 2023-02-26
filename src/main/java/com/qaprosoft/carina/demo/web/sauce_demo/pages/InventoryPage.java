package com.qaprosoft.carina.demo.web.sauce_demo.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.sauce_demo.components.Menu;
import com.qaprosoft.carina.demo.web.sauce_demo.components.ProductModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class InventoryPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "react-burger-menu-btn")
    private ExtendedWebElement menuOpenButton;

    @FindBy(xpath = "//div[@class = 'inventory_item']")
    private List<ProductModel> productModelList;

    public InventoryPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/inventory.html");
    }

    public Menu openMenu() {
        LOGGER.info("Open menu");
        menuOpenButton.click();
        return new Menu(getDriver());
    }

    public ProductModel selectModel(String modelName) {
        for (ProductModel productModel: productModelList) {
            if(productModel.returnProductName().equalsIgnoreCase(modelName)) {
                return productModel;
            }
        }
        throw new RuntimeException("Unable to get model: " + modelName);
    }
}
