package com.qaprosoft.carina.demo.web.re_store.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class CartPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//span[@class='strong-price']//strong")
    private ExtendedWebElement strongPrice;

    @FindBy(xpath = "//span[@class='strong-price']//small")
    private ExtendedWebElement smallPrice;

    @FindBy(xpath = "//a[contains(@class, 'remove')]")
    private ExtendedWebElement removeButton;

    @FindBy(xpath = "//a[contains(@class, 'logo-wrap')]")
    private ExtendedWebElement homeLink;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://re-store.by/order/");
    }

    public double getAllPrice() {
        LOGGER.info("Get all price from order");
        return Double.parseDouble(strongPrice + "." + smallPrice);
    }

    public void removeFirstItem() {
        LOGGER.info("Remove first item from order");
        removeButton.click();
    }

    public HomePage openHomePage() {
        LOGGER.info("Return to home page");
        homeLink.click();
        return new HomePage(driver);
    }
}
