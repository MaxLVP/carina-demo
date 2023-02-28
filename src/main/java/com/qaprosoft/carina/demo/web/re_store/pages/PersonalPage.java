package com.qaprosoft.carina.demo.web.re_store.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PersonalPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='gray-box_btn-row']//a[contains(@href, 'logout')]")
    private ExtendedWebElement logoutButton;

    public PersonalPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://re-store.by/personal/");
    }

    public HomePage logOut() {
        logoutButton.click();
        return new HomePage(driver);
    }
}
