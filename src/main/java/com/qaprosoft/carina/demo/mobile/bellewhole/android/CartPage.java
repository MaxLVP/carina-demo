package com.qaprosoft.carina.demo.mobile.bellewhole.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.bellewhole.common.CartPageBase;
import com.qaprosoft.carina.demo.utils.ParseStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class CartPage extends CartPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String EMPTY_CART_LABEL_ID = "com.geeko.bellewholesale:id/btShopNow";
    private static final String DELETE_CONFIRM_BUTTON_ID = "com.geeko.bellewholesale:id/confirm";

    @FindBy(id = "com.geeko.bellewholesale:id/img_minus")
    private ExtendedWebElement minusProductButton;

    @FindBy(id = "com.geeko.bellewholesale:id/tv_price")
    private ExtendedWebElement priceLabel;

    @FindBy(id = "com.geeko.bellewholesale:id/tv_bag")
    private ExtendedWebElement cartPageTitle;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return cartPageTitle.isElementPresent();
    }

    public double getPriceFromPage() {
        return ParseStringUtils.parsePriceFromApp(priceLabel.getText());
    }

    public boolean checkIsCartEmpty() {
        return findExtendedWebElement(By.id(EMPTY_CART_LABEL_ID)).isElementPresent();
    }

    public void deleteProductFromCart() {
        LOGGER.info("Delete product from cart");
        clickOnMinusProduct();
        findExtendedWebElement(By.id(DELETE_CONFIRM_BUTTON_ID)).click();
    }

    public void clickOnMinusProduct() {
        minusProductButton.click();
    }
}
