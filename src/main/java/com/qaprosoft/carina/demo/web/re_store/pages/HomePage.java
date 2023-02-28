package com.qaprosoft.carina.demo.web.re_store.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.re_store.components.AuthorizationForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a[contains(@class, 'hide')]")
    private ExtendedWebElement registerButton;

    @FindBy(xpath = "//a[@href = '/personal/' and contains(@class, 'page-header')]")
    private ExtendedWebElement personalButton;

    @FindBy(xpath = "//a[contains(@href, 'login')]")
    private ExtendedWebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://re-store.by/");
    }

    public AuthorizationForm openRegisterForm() {
        registerButton.click();
        return new AuthorizationForm(driver);
    }

    public AuthorizationForm openLoginForm() {
        loginButton.click();
        return new AuthorizationForm(driver);
    }

    public boolean checkIfPersonalPresented() {
        return personalButton.isElementPresent();
    }

    public PersonalPage openPersonalPage() {
        personalButton.click();
        return new PersonalPage(driver);
    }

    public boolean checkIfRegisterAvailable() {
        return registerButton.isElementPresent(1);
    }
}
