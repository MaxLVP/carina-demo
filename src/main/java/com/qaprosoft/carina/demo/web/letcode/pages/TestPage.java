package com.qaprosoft.carina.demo.web.letcode.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class TestPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a[@href='/alert']")
    private ExtendedWebElement alertsPageOpenButton;

    @FindBy(xpath = "//a[@href='/frame']")
    private ExtendedWebElement framesPageOpenButton;

    @FindBy(xpath = "//a[@href='/slider']")
    private ExtendedWebElement sliderPageOpenButton;

    public TestPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://letcode.in/test");
    }

    public AlertsPage openAlertPage() {
        LOGGER.info("Opening Alert Page");
        alertsPageOpenButton.click();
        return new AlertsPage(driver);
    }

    public FramePage openFramePage() {
        LOGGER.info("Opening Frame Page");
        framesPageOpenButton.click();
        return new FramePage(driver);
    }

    public SliderPage openSliderPage() {
        LOGGER.info("Opening Slider Page");
        sliderPageOpenButton.click();
        return new SliderPage(driver);
    }
}
