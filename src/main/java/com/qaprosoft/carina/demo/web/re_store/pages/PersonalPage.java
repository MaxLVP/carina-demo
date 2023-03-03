package com.qaprosoft.carina.demo.web.re_store.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.utils.StringUtils;
import com.qaprosoft.carina.demo.web.re_store.models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PersonalPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='gray-box_btn-row']//a[contains(@href, 'logout')]")
    private ExtendedWebElement logoutButton;

    @FindBy(xpath = "//li[1]//span[@class='dot-line-row_end']")
    private ExtendedWebElement userNameField;

    @FindBy(xpath = "//li[2]//span[@class='dot-line-row_end']")
    private ExtendedWebElement userPhoneField;

    @FindBy(xpath = "//li[3]//span[@class='dot-line-row_end']")
    private ExtendedWebElement userEmailField;

    public PersonalPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://re-store.by/personal/");
    }

    public HomePage logOut() {
        logoutButton.click();
        return new HomePage(driver);
    }

    public User getUserFromPage() {
        User user = new User();
        user.setFirstName(userNameField.getText());
        user.setEmail(userEmailField.getText());
        user.setPhone(StringUtils.parsePhone(userPhoneField.getText()));
        return user;
    }
}
