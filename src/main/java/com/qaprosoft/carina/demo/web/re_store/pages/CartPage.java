package com.qaprosoft.carina.demo.web.re_store.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.utils.StringUtils;
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

    @FindBy(xpath = "//a[contains(@href, 'login')]")
    private ExtendedWebElement loginButton;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://re-store.by/order/");
    }

    public double getAllPrice() {
        LOGGER.info("Get all price from order");
        return StringUtils.parsePrice(strongPrice.getText(), smallPrice.getText());
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

    public boolean isRemoveButtonDisplayed() {
        return removeButton.isElementPresent(1);
    }

    public boolean isLoginButtonDisplayed() { return loginButton.isElementPresent(1); }
}
