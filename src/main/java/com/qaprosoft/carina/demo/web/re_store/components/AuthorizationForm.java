package com.qaprosoft.carina.demo.web.re_store.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.re_store.models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class AuthorizationForm extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//input[@name ='REGISTER[NAME]']")
    private ExtendedWebElement nameRegInput;

    @FindBy(xpath = "//input[@name ='REGISTER[EMAIL]']")
    private ExtendedWebElement emailRegInput;

    @FindBy(xpath = "//input[@name='USER_LOGIN']")
    private ExtendedWebElement emailAuthInput;

    @FindBy(xpath = "//input[@name ='REGISTER[PERSONAL_PHONE]']")
    private ExtendedWebElement phoneRegInput;

    @FindBy(xpath = "//input[@name ='REGISTER[PASSWORD]']")
    private ExtendedWebElement passwordRegInput;

    @FindBy(xpath = "//input[@name='REGISTER[CONFIRM_PASSWORD]']")
    private ExtendedWebElement passwordConfirmRegInput;

    @FindBy(xpath = "//input[@name='USER_PASSWORD']")
    private ExtendedWebElement passwordAuthInput;

    @FindBy(xpath = "//input[@name = 'register_submit_button']")
    private ExtendedWebElement registerButton;

    @FindBy(xpath = "//span[@data-tooltip='test']")
    private ExtendedWebElement privacyCheckbox;

    @FindBy(xpath = "//div[@data-tab='auth']//button[@type='submit']")
    private ExtendedWebElement authButton;

    public AuthorizationForm(WebDriver driver) {
        super(driver);
        setRootExtendedElement(nameRegInput);
    }

    public void registration(User user) {
        LOGGER.info("Registration user " + user);
        inputName(user.getFirstName());
        inputEmailReg(user.getEmail());
        inputPhone(user.getPhone());
        inputPasswordReg(user.getPassword());
        inputPasswordRegConfirm(user.getPassword());
        privacyCheckbox.click();
        registerButton.click();
    }

    public void authorization(User user) {
        LOGGER.info("Authentication user" + user);
        inputEmailAuth(user.getEmail());
        inputPasswordAuth(user.getPassword());
        authButton.click();
    }

    public void inputName(String name) {
        nameRegInput.type(name);
    }

    public void inputEmailReg(String email) {
        emailRegInput.type(email);
    }

    public void inputEmailAuth(String email) {
        emailAuthInput.type(email);
    }

    public void inputPhone(String phone) {
        phoneRegInput.type(phone);
    }

    public void inputPasswordReg(String password) {
        passwordRegInput.type(password);
    }

    public void inputPasswordRegConfirm(String confirmPassword) {
        passwordConfirmRegInput.type(confirmPassword);
    }

    public void inputPasswordAuth(String password) {
        passwordAuthInput.type(password);
    }
}
