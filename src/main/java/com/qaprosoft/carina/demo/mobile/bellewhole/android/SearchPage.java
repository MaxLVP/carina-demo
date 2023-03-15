package com.qaprosoft.carina.demo.mobile.bellewhole.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.bellewhole.common.SearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchPageBase.class)
public class SearchPage extends SearchPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String SEARCHED_DRESS_ID = "com.geeko.bellewholesale:id/iv_product";

    @FindBy(id = "com.geeko.bellewholesale:id/iv_clearall")
    private ExtendedWebElement clearSearchInput;

    @FindBy(id = "com.geeko.bellewholesale:id/et_search")
    private ExtendedWebElement searchInput;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return searchInput.isElementPresent();
    }

    public void searchItem(String itemId) {
        LOGGER.info("Search dress by id");
        clickOnSearchInput();
        clearSearchField();
        clickOnSearchInput();
        typeToSearchInput(itemId);
    }

    public DressInfoPage openDressPageBySearch() {
        LOGGER.info("Opening search dress");
        findExtendedWebElement(By.id(SEARCHED_DRESS_ID)).click();
        return new DressInfoPage(driver);
    }

    public void clearSearchField() {
        clearSearchInput.click();
    }

    public void clickOnSearchInput() {
        searchInput.click();
    }

    public void typeToSearchInput(String text) {
        searchInput.type(text);
    }
}
