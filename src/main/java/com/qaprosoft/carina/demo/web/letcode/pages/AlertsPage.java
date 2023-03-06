package com.qaprosoft.carina.demo.web.letcode.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class AlertsPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//button[@id='accept']")
    private ExtendedWebElement simpleAlertOpenButton;

    @FindBy(xpath = "//button[@id='confirm']")
    private ExtendedWebElement confirmAlertOpenButton;

    @FindBy(xpath = "//button[@id='prompt']")
    private ExtendedWebElement promptAlertOpenButton;

    @FindBy(xpath = "//button[@id='modern']")
    private ExtendedWebElement modernAlertOpenButton;

    public AlertsPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://letcode.in/alert");
    }

    public void openSimpleAlert() {
        LOGGER.info("Open simple Alert");
        simpleAlertOpenButton.click();
    }

    public void confirmAlert() {
        LOGGER.info("Confirm Alert");
        acceptAlert();
    }

    public void cancelAlerts() {
        LOGGER.info("Cancel Alert");
        cancelAlert();
    }

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    public boolean checkIsAlertPresented() {
        return isAlertPresent();
    }

    public void openConfirmAlert() {
        LOGGER.info("Open confirm Alert");
        confirmAlertOpenButton.click();
    }

    public void openPromptAlert() {
        LOGGER.info("Open prompt Alert");
        promptAlertOpenButton.click();
    }

    public void typePromptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("asasd");
    }
}
