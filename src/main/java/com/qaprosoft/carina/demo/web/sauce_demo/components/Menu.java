package com.qaprosoft.carina.demo.web.sauce_demo.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.sauce_demo.pages.AboutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class Menu extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "inventory_sidebar_link")
    private ExtendedWebElement inventoryPageOpen;

    @FindBy(id = "about_sidebar_link")
    private ExtendedWebElement aboutPageOpen;

    @FindBy(id = "logout_sidebar_link")
    private ExtendedWebElement logoutButton;

    @FindBy(id = "reset_sidebar_link")
    private ExtendedWebElement resetButton;

    public Menu(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        LOGGER.info("Logout from site");
        logoutButton.click();
    }

    public AboutPage openAboutPage() {
        LOGGER.info("Open about page");
        aboutPageOpen.click();
        return new AboutPage(driver);
    }
}
