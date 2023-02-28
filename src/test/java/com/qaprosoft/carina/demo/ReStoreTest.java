package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.web.re_store.components.AuthorizationForm;
import com.qaprosoft.carina.demo.web.re_store.models.User;
import com.qaprosoft.carina.demo.web.re_store.models.UserBuilder;
import com.qaprosoft.carina.demo.web.re_store.pages.HomePage;
import com.qaprosoft.carina.demo.web.re_store.pages.PersonalPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReStoreTest implements IAbstractTest {

    @Test
    public void testRegistration() {
        User user = UserBuilder.getUser();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        AuthorizationForm authorizationForm = homePage.openRegisterForm();
        Assert.assertTrue(authorizationForm.isUIObjectPresent(), "Authorization form is not opened");
        authorizationForm.registration(user);
        Assert.assertTrue(homePage.checkIfPersonalPresented(), "Personal link is not presented");
        PersonalPage personalPage = homePage.openPersonalPage();
        Assert.assertTrue(personalPage.isPageOpened(), "Personal page is not opened");
        homePage = personalPage.logOut();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Assert.assertTrue(homePage.checkIfRegisterAvailable(), "Logout is failed");
    }

    @Test
    public void testAuthorization() {
        User user = UserBuilder.getUser();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        AuthorizationForm authorizationForm = homePage.openLoginForm();
        Assert.assertTrue(authorizationForm.isUIObjectPresent(), "Authorization form is not opened");
        authorizationForm.authorization(user);
        Assert.assertTrue(homePage.checkIfPersonalPresented(), "Personal link is not presented");
        PersonalPage personalPage = homePage.openPersonalPage();
        Assert.assertTrue(personalPage.isPageOpened(), "Personal page is not opened");
        homePage = personalPage.logOut();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Assert.assertTrue(homePage.checkIfRegisterAvailable(), "Logout is failed");
    }
}
