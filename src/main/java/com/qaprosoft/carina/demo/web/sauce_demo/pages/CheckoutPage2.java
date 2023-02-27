package com.qaprosoft.carina.demo.web.sauce_demo.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class CheckoutPage2 extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//button[@id='finish']")
    private ExtendedWebElement finishButton;

    public CheckoutPage2(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/checkout-step-two.html");
    }

    public CheckoutComplete clickFinishButton() {
        LOGGER.info("Click finish button");
        finishButton.click();
        return new CheckoutComplete(driver);
    }
}
