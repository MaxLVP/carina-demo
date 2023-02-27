package com.qaprosoft.carina.demo.web.sauce_demo.pages.checkout;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class CheckoutPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final Integer STRING_COUNT = 5;

    @FindBy(xpath = "//input[@id='first-name']")
    private ExtendedWebElement firstNameInput;

    @FindBy(xpath = "//input[@id='last-name']")
    private ExtendedWebElement lastNameInput;

    @FindBy(xpath = "//input[@id='postal-code']")
    private ExtendedWebElement postalInput;

    @FindBy(xpath = "//input[@id='continue']")
    private ExtendedWebElement buttonContinue;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/checkout-step-one.html");
    }

    public void fillInCheckoutForm() {
        LOGGER.info("Input first name");
        firstNameInput.type(RandomStringUtils.randomAlphabetic(STRING_COUNT));
        LOGGER.info("Input last name");
        lastNameInput.type(RandomStringUtils.randomAlphabetic(STRING_COUNT));
        LOGGER.info("Input postal code");
        postalInput.type(RandomStringUtils.randomNumeric(STRING_COUNT));
    }

    public CheckoutPage2 openCheckoutStepTwo() {
        LOGGER.info("Open step two");
        buttonContinue.click();
        return new CheckoutPage2(driver);
    }
}
