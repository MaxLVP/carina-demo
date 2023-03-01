package com.qaprosoft.carina.demo.web.re_store.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.re_store.pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HeaderMenu extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String SEARCH_INPUT_XPATH = "//input[contains(@class, 'input__search')]";
    private static final String CLOSE_SEARCH_BUTTON_XPATH = "//button[contains(@class, 'btn__close')]";
    private static final String FIND_BUTTON_XPATH = "//button[contains(@class, 'btn-search')]";
    private static final String SEARCH_BUTTON_XPATH = "//span[contains(@class, 'search_btn')]";

    @FindBy(xpath = "//span[contains(@class, 'search_btn')]")
    private ExtendedWebElement searchButton;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isSearchButtonPresented() {
        return findExtendedWebElement(By.xpath(SEARCH_BUTTON_XPATH)).isElementPresent();
    }

    public void openSearch() {
        LOGGER.info("Opening search");
        searchButton.click();
    }

    public void typeSearch(String value) {
        findExtendedWebElement(By.xpath(SEARCH_INPUT_XPATH)).type(value);
    }

    public boolean isSearchOpen() {
        return findExtendedWebElement(By.xpath(SEARCH_INPUT_XPATH)).isElementPresent();
    }

    public void findValue() {
        findExtendedWebElement(By.xpath(FIND_BUTTON_XPATH)).click();
    }

    public void closeSearch() {
        LOGGER.info("Closing search");
        findExtendedWebElement(By.xpath(CLOSE_SEARCH_BUTTON_XPATH)).click();
    }
}
