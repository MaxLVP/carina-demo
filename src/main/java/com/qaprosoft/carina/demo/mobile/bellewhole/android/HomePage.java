package com.qaprosoft.carina.demo.mobile.bellewhole.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.bellewhole.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//android.widget.TextView[@text='Category']")
    private ExtendedWebElement categoriesOpenButton;

    @FindBy(id = "com.geeko.bellewholesale:id/tvTitle")
    private ExtendedWebElement searchOpenButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Me']")
    private ExtendedWebElement mePageOpenButton;

    @FindBy(id = "com.geeko.bellewholesale:id/iv_like")
    private ExtendedWebElement wishListPageOpenButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return searchOpenButton.isElementPresent();
    }

    public CategoriesPage openCategories() {
        LOGGER.info("Open categories");
        clickOnCategoriesButton();
        return new CategoriesPage(driver);
    }

    public SearchPage openSearch() {
        LOGGER.info("Open search");
        clickOnSearchOpenButton();
        return new SearchPage(driver);
    }

    public MePage openMePage() {
        LOGGER.info("Opening Me page");
        clickOnMePageButton();
        return new MePage(driver);
    }

    public WishList openWishListPage() {
        LOGGER.info("Opening wish list page");
        clickOnWishListButton();
        return new WishList(driver);
    }

    public void clickOnCategoriesButton() {
        categoriesOpenButton.click();
    }

    public void clickOnSearchOpenButton() {
        searchOpenButton.click();
    }

    public void clickOnMePageButton() {
        mePageOpenButton.click();
    }

    public void clickOnWishListButton() {wishListPageOpenButton.click();}
}
