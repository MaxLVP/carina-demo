package com.qaprosoft.carina.demo.mobile.bellewhole.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.bellewhole.common.PermissionWidgetBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PermissionWidgetBasePage.class)
public class PermissionWidgetPage extends PermissionWidgetBasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "")
    private ExtendedWebElement denyButton;

    @FindBy(id = "")
    private ExtendedWebElement acceptButton;

    public PermissionWidgetPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return denyButton.isElementPresent();
    }

    public HomePage denyPermission() {
        LOGGER.info("Deny permission");
        denyButton.click();
        return new HomePage(driver);
    }

    public HomePage acceptPermission() {
        LOGGER.info("Accept permission");
        acceptButton.click();
        return new HomePage(driver);
    }
}
