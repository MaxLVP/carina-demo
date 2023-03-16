package com.qaprosoft.carina.demo.mobile.bellewhole.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.bellewhole.common.DressInfoPageBase;
import com.qaprosoft.carina.demo.utils.StringUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DressInfoPageBase.class)
public class DressInfoPage extends DressInfoPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String MENU_HOMEPAGE_OPEN_BUTTON_ID = "com.geeko.bellewholesale:id/cl_home";
    private static final String CONFIRM_BUTTON_BUY_ID = "com.geeko.bellewholesale:id/bt_buy";

    @FindBy(id = "com.geeko.bellewholesale:id/tv_minPrice")
    private ExtendedWebElement priceLabel;

    @FindBy(id = "com.geeko.bellewholesale:id/iv_like_all")
    private ExtendedWebElement addToWishListButton;

    @FindBy(id = "com.geeko.bellewholesale:id/ib_mune")
    private ExtendedWebElement openMenuButton;

    @FindBy(id = "com.geeko.bellewholesale:id/bt_add_to_cart")
    private ExtendedWebElement addToCartButton;

    @FindBy(id = "com.geeko.bellewholesale:id/iv_src")
    private ExtendedWebElement openCartButton;

    public DressInfoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return priceLabel.isElementPresent();
    }

    public double getPriceFromPage() {
        return StringUtils.parsePriceFromApp(priceLabel.getText());
    }

    public void addProductToWishList() {
        LOGGER.info("Adding product to wish list");
        clickOnAddToWishButton();
    }

    public void addProductToCart() {
        LOGGER.info("Adding product to cart");
        clickOnAddToCartButton();
        findExtendedWebElement(By.id(CONFIRM_BUTTON_BUY_ID)).click();
    }

    public HomePage openHomePage() {
        LOGGER.info("Opening Home page");
        clickOnMenuButton();
        findExtendedWebElement(By.id(MENU_HOMEPAGE_OPEN_BUTTON_ID)).click();
        return new HomePage(driver);
    }

    public CartPage openCartPage() {
        LOGGER.info("Opening Cart page");
        clickOnCardPageOpenButton();
        return new CartPage(driver);
    }

    public void clickOnAddToWishButton() {
        addToWishListButton.click();
    }

    public void clickOnMenuButton() {
        openMenuButton.click();
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public void clickOnCardPageOpenButton() {
        openCartButton.click();
    }
}
