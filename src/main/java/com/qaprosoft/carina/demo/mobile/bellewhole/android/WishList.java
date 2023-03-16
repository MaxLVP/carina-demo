package com.qaprosoft.carina.demo.mobile.bellewhole.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.bellewhole.common.WishListPageBase;
import com.qaprosoft.carina.demo.utils.ParseStringUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WishListPageBase.class)
public class WishList extends WishListPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "com.geeko.bellewholesale:id/tv_minPrice")
    private ExtendedWebElement priceLabel;

    @FindBy(id = "com.geeko.bellewholesale:id/iv_product")
    private ExtendedWebElement productInfoButton;

    public WishList(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return priceLabel.isElementPresent();
    }

    public double getPrice() {
        return ParseStringUtils.parsePriceFromApp(priceLabel.getText());
    }

    public DressInfoPage openDressInfoPage() {
        LOGGER.info("Opening dress info page");
        clickOnProduct();
        return new DressInfoPage(driver);
    }

    public void clickOnProduct() {
        productInfoButton.click();
    }
}
