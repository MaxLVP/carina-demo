package com.qaprosoft.carina.demo.mobile.bellewhole.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.bellewhole.common.MePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MePageBase.class)
public class MePage extends MePageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String GO_SHOPPING_BUTTON_XPATH = "//android.widget.TextView[@text='GO SHOPPING']";

    @FindBy(id = "com.geeko.bellewholesale:id/tv_viewall")
    private ExtendedWebElement viewAllOrdersButton;

    @FindBy(xpath = "//android.widget.TextView[@text='SIGN IN']")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Home']")
    private ExtendedWebElement homePageButton;

    public MePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return viewAllOrdersButton.isElementPresent();
    }

    public SignInPage openSignInPage() {
        LOGGER.info("Open signIn page");
        clickOnSignInButton();
        return new SignInPage(driver);
    }

    public HomePage openHomePage() {
        LOGGER.info("Opening Home Page");
        clickOnHomePageButton();
        return new HomePage(driver);
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public boolean checkIfSignedIn() {
        return findExtendedWebElement(By.xpath(GO_SHOPPING_BUTTON_XPATH)).isElementPresent();
    }

    public void clickOnHomePageButton() {
        homePageButton.click();
    }
}
