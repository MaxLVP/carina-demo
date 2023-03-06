package com.qaprosoft.carina.demo.web.letcode.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class FramePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//iframe[@id='firstFr']")
    private ExtendedWebElement frame;

    @FindBy(xpath = "//input[@name='fname']")
    private ExtendedWebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lname']")
    private ExtendedWebElement lastNameInput;

    @FindBy(xpath = "//iframe[@class='has-background-white']")
    private ExtendedWebElement innerFrame;

    @FindBy(xpath = "//input[@name='email']")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//footer[@class='card-footer']//a")
    private ExtendedWebElement linkToTutorial;

    public FramePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://letcode.in/frame");
    }

    public void switchToFrame() {
        LOGGER.info("Switching to frame");
        driver.switchTo().frame(frame.getElement());
    }

    public void switchToDefault() {
        LOGGER.info("Switch to default content");
        driver.switchTo().defaultContent();
    }

    public void switchToInnerFrame() {
        LOGGER.info("Switch to inner frame");
        driver.switchTo().frame(innerFrame.getElement());
    }

    public boolean checkIsInnerFrameOpen() {
        return emailInput.isElementPresent(1);
    }

    public boolean checkIsFrameVisible() {
        return firstNameInput.isElementPresent(1);
    }

    public void typeFirstName(String fName) {
        firstNameInput.type(fName);
    }

    public void typeLastName(String lName) {
        lastNameInput.type(lName);
    }

    public void typeEmail(String email) {
        emailInput.type(email);
    }
}
