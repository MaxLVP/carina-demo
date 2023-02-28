package com.qaprosoft.carina.demo.web.sauce_demo.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Random;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String ERROR_WINDOW_XPATH = "//h3[@data-test='error']";
    private static final String ERROR_WINDOW_CLOSE_BUTTON_XPATH = "//button[@class='error-button']";
    private static final Integer STANDARD_USER = 1;
    private static final Integer LOCKED_OUT_USER = 2;

    @FindBy(id = "user-name")
    private ExtendedWebElement usernameInput;

    @FindBy(id = "password")
    private ExtendedWebElement passwordInput;

    @FindBy(id = "login-button")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//div[@class='login_credentials']")
    private ExtendedWebElement loginText;

    @FindBy(xpath = "//div[@class='login_password']")
    private ExtendedWebElement password;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/");
    }

    public InventoryPage authorization() {
        LOGGER.info("Authorization on site");
        String[] usernames = loginText.getText().split("\n");
        LOGGER.info("Insert username");
        usernameInput.type(usernames[STANDARD_USER]);
        String[] passwords = password.getText().split("\n");
        int pass = new Random().nextInt(passwords.length - 1) + 1;
        LOGGER.info("Insert password");
        passwordInput.type(passwords[pass]);
        loginButton.click();
        return new InventoryPage(getDriver());
    }

    public void blockedAuthorization() {
        LOGGER.info("Authorization on site");
        String[] usernames = loginText.getText().split("\n");
        LOGGER.info("Insert locked out username");
        usernameInput.type(usernames[LOCKED_OUT_USER]);
        String[] passwords = password.getText().split("\n");
        int pass = new Random().nextInt(passwords.length - 1) + 1;
        LOGGER.info("Insert password");
        passwordInput.type(passwords[pass]);
        loginButton.click();
    }

    public boolean isErrorDisplay() {
        ExtendedWebElement errorWindow = findExtendedWebElement(By.xpath(ERROR_WINDOW_XPATH));
        if (errorWindow == null) {
            return false;
        }
        return errorWindow.isElementPresent(1);
    }

    public void closeErrorDisplay() {
        LOGGER.info("Close error window");
        ExtendedWebElement closeErrorWindowBtn = findExtendedWebElement(By.xpath(ERROR_WINDOW_CLOSE_BUTTON_XPATH));
        closeErrorWindowBtn.click();
    }
}
