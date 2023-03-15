package com.qaprosoft.carina.demo.mobile.bellewhole.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.bellewhole.common.CategoriesPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CategoriesPageBase.class)
public class CategoriesPage extends CategoriesPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//android.widget.TextView[@text='Work Dresses']")
    private ExtendedWebElement workDressesPageButton;

    @FindBy(xpath = "//android.widget.TextView[@text='CATEGORIES']")
    private ExtendedWebElement categoriesMenuButton;

    public CategoriesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return categoriesMenuButton.isElementPresent();
    }

    public WorkDressesPage openWorkDressesPage() {
        LOGGER.info("Opening work dresses page");
        clickOnWorkDressesPage();
        return new WorkDressesPage(driver);
    }

    public void clickOnWorkDressesPage() {
        workDressesPageButton.click();
    }
}
