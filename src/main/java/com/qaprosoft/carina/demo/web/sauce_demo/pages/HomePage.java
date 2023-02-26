package com.qaprosoft.carina.demo.web.sauce_demo.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Random;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final Integer STANDARD_USER = 1;

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
        usernameInput.click();
        usernameInput.type(usernames[STANDARD_USER]);
        String[] passwords = password.getText().split("\n");
        int pass = new Random().nextInt(passwords.length - 1) + 1;
        LOGGER.info("Insert password");
        passwordInput.click();
        passwordInput.type(passwords[pass]);
        loginButton.click();
        return new InventoryPage(getDriver());
    }
}
