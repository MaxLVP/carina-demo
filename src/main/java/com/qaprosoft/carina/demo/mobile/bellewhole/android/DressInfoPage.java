package com.qaprosoft.carina.demo.mobile.bellewhole.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.bellewhole.common.DressInfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.apache.commons.lang3.StringUtils;
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

    @FindBy(id = "com.geeko.bellewholesale:id/tv_minPrice")
    private ExtendedWebElement priceLabel;

    @FindBy(id = "com.geeko.bellewholesale:id/iv_like_all")
    private ExtendedWebElement addToWishListButton;

    @FindBy(id = "com.geeko.bellewholesale:id/ib_mune")
    private ExtendedWebElement openMenuButton;

    public DressInfoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return priceLabel.isElementPresent();
    }

    public Double getPriceFromPage() {
        String price = StringUtils.remove(priceLabel.getText(), "$");
        return Double.valueOf(price);
    }

    public void addProductToWishList() {
        LOGGER.info("Adding product to wish list");
        clickOnAddToWishButton();
    }

    public void clickOnAddToWishButton() {
        addToWishListButton.click();
    }

    public HomePage openHomePage() {
        LOGGER.info("Opening Home page");
        clickOnMenuButton();
        findExtendedWebElement(By.id(MENU_HOMEPAGE_OPEN_BUTTON_ID)).click();
        return new HomePage(driver);
    }

    public void clickOnMenuButton() {
        openMenuButton.click();
    }
}
