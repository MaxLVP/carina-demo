package com.qaprosoft.carina.demo.mobile.bellewhole.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.bellewhole.common.WorkDressesPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WorkDressesPageBase.class)
public class WorkDressesPage extends WorkDressesPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String PRICE_LOW_TO_HIGH_SORT_XPATH = "//android.widget.TextView[@text='Price Low To High']";

    @FindBy(id = "com.geeko.bellewholesale:id/tv_title")
    private ExtendedWebElement workDressesPageTitle;

    @FindBy(id = "com.geeko.bellewholesale:id/ll_sort")
    private ExtendedWebElement sortBySelect;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.geeko.bellewholesale:id/llContent'][1]//android.widget.TextView[@resource-id='com.geeko.bellewholesale:id/tv_minPrice']")
    private ExtendedWebElement priceOfFirstItem;

    public WorkDressesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return workDressesPageTitle.isElementPresent();
    }

    public String getPriceOfFirstItem() {
        return priceOfFirstItem.getText();
    }

    public void changeSortByLowToHighPrice() {
        LOGGER.info("Change sorting to low to high price");
        clickOnSortBy();
        findExtendedWebElement(By.xpath(PRICE_LOW_TO_HIGH_SORT_XPATH)).click();
    }

    public void clickOnSortBy() {
        sortBySelect.click();
    }
}
