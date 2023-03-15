package com.qaprosoft.carina.demo.mobile.bellewhole.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.bellewhole.common.SignInPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SignInPageBase.class)
public class SignInPage extends SignInPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String EMAIL_INPUT_FIELD_ID = "com.geeko.bellewholesale:id/etEmail";
    private static final String PASSWORD_INPUT_FIELD_ID = "com.geeko.bellewholesale:id/et_password";
    private static final String LOGIN_BUTTON_ID = "com.geeko.bellewholesale:id/bt_login";

    @FindBy(id = "com.geeko.bellewholesale:id/signIn")
    private ExtendedWebElement signInFormButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public MePage signIn(String email, String password) {
        LOGGER.info("Signing in");
        clickOnSignInForm();
        typeOnEmailField(email);
        typeOnPasswordField(password);
        clickOnLoginButton();
        return new MePage(driver);
    }

    @Override
    public boolean isPageOpened() {
        return signInFormButton.isElementPresent();
    }

    public void clickOnSignInForm() {
        signInFormButton.click();
    }

    public void clickOnLoginButton() {
        findExtendedWebElement(By.id(LOGIN_BUTTON_ID)).click();
    }

    public void typeOnEmailField(String email) {
        findExtendedWebElement(By.id(EMAIL_INPUT_FIELD_ID)).type(email);
    }

    public void typeOnPasswordField(String password) {
        findExtendedWebElement(By.id(PASSWORD_INPUT_FIELD_ID)).type(password);
    }
}
