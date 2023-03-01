package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.web.re_store.components.AuthorizationForm;
import com.qaprosoft.carina.demo.web.re_store.models.Product;
import com.qaprosoft.carina.demo.web.re_store.models.ProductBuilder;
import com.qaprosoft.carina.demo.web.re_store.models.User;
import com.qaprosoft.carina.demo.web.re_store.models.UserBuilder;
import com.qaprosoft.carina.demo.web.re_store.pages.HomePage;
import com.qaprosoft.carina.demo.web.re_store.pages.PersonalPage;
import com.qaprosoft.carina.demo.web.re_store.pages.SearchPage;
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

    @Test
    public void testProductInfoAndOrder() {
        Product product = ProductBuilder.getProduct();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        //Assert.assertTrue(homePage.isMenuPresented(), "Menu is not presented!");
        homePage.openSearch();
        Assert.assertTrue(homePage.isSearchFormOpen(), "search form is not opened!");
        homePage.closeSearch();
        Assert.assertTrue(homePage.isSearchButtonPresented(), "Search form is not opened!");
        homePage.openSearch();
        Assert.assertTrue(homePage.isSearchFormOpen(), "search form is not opened!");
        SearchPage searchPage = homePage.searchProductById(product.getId());
        Assert.assertTrue(searchPage.isPageOpened(), "search page is not opened!");

    }
}
