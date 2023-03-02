package com.qaprosoft.carina.demo.web.re_store.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class SearchForm extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//input[contains(@class, 'input__search')]")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//button[contains(@class, 'btn__close')]")
    private ExtendedWebElement closeSearchForm;

    @FindBy(xpath = "//button[contains(@class, 'btn-search')]")
    private ExtendedWebElement searchButton;

    public SearchForm(WebDriver driver) {
        super(driver);
    }

    public SearchForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void typeSearch(String value) {
        LOGGER.info("Type value " + value + " in field");
        searchInput.type(value);
    }

    public boolean isSearchOpen() {
        return searchInput.isElementPresent();
    }

    public void findValue() {
        LOGGER.info("Search");
        searchButton.click();
    }

    public void closeSearch() {
        LOGGER.info("Closing search");
        closeSearchForm.click();
    }
}
