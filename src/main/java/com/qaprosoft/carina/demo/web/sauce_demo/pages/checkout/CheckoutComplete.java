package com.qaprosoft.carina.demo.web.sauce_demo.pages.checkout;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.sauce_demo.pages.InventoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class CheckoutComplete extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//button[@id='back-to-products']")
    private ExtendedWebElement homeButton;

    public CheckoutComplete(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/checkout-complete.html");
    }

    public InventoryPage backToInventoryPage() {
        LOGGER.info("Back to Inventory page");
        homeButton.click();
        return new InventoryPage(driver);
    }
}
