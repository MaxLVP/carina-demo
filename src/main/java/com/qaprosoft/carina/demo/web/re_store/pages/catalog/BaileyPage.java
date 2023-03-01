package com.qaprosoft.carina.demo.web.re_store.pages.catalog;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class BaileyPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a[contains(@href, 'uksusy') and contains(@class, 'aside-navigation')]")
    private ExtendedWebElement vinegarPageLink;

    public BaileyPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://re-store.by/catalog/bakaleya/");
    }

    public VinegarPage openVinegarPage() {
        LOGGER.info("Open Vinegar Page");
        vinegarPageLink.click();
        return new VinegarPage(driver);
    }
}
