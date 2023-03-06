package com.qaprosoft.carina.demo.web.letcode.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SliderPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String COUNTRIES_XPATH = "//div[@class='card-content']//p";

    @FindBy(xpath = "//button[contains(@class, 'is-primary')]")
    private ExtendedWebElement getCountriesButton;

    @FindBy(xpath = "//input[@id='generate']")
    private ExtendedWebElement countOfCountriesInput;

    public SliderPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://letcode.in/slider");
    }

    public void getCountriesOpen() {
        getCountriesButton.click();
    }

    public void inputNumberToSlider(String number) {
        LOGGER.info("Set number " + number + " to slider");
        countOfCountriesInput.type(number);
    }

    public int returnSizeOfCountries() {
        String countries = findExtendedWebElement(By.xpath(COUNTRIES_XPATH)).getText();
        return (int) Arrays.stream(countries.split(" - ")).count();
    }
}
