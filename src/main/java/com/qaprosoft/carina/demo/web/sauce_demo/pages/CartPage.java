package com.qaprosoft.carina.demo.web.sauce_demo.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.sauce_demo.pages.checkout.CheckoutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class CartPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//button[@id='checkout']")
    private ExtendedWebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/cart.html");
    }

    public CheckoutPage openCheckoutPage() {
        LOGGER.info("Open checkout page");
        checkoutButton.click();
        return new CheckoutPage(driver);
    }
}
