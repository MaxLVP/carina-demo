package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.web.re_store.components.AuthorizationForm;
import com.qaprosoft.carina.demo.web.re_store.models.Product;
import com.qaprosoft.carina.demo.web.re_store.models.ProductBuilder;
import com.qaprosoft.carina.demo.web.re_store.models.User;
import com.qaprosoft.carina.demo.web.re_store.models.UserBuilder;
import com.qaprosoft.carina.demo.web.re_store.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReStoreTest implements IAbstractTest {

    @Test
    public void testRegistration() {
        User user = UserBuilder.getUser();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        AuthorizationForm authorizationForm = homePage.openRegisterForm();
        Assert.assertTrue(authorizationForm.isUIObjectPresent(), "Authorization form is not opened!");
        authorizationForm.registration(user);
        Assert.assertTrue(homePage.checkIfPersonalPresented(), "Personal link is not presented!");
        PersonalPage personalPage = homePage.openPersonalPage();
        Assert.assertTrue(personalPage.isPageOpened(), "Personal page is not opened!");
        homePage = personalPage.logOut();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        Assert.assertTrue(homePage.checkIfRegisterAvailable(), "Logout is failed!");
    }

    @Test
    public void testAuthorization() {
        User user = UserBuilder.getUser();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        AuthorizationForm authorizationForm = homePage.openLoginForm();
        Assert.assertTrue(authorizationForm.isUIObjectPresent(), "Authorization form is not opened!");
        authorizationForm.authorization(user);
        Assert.assertTrue(homePage.checkIfPersonalPresented(), "Personal link is not presented!");
        PersonalPage personalPage = homePage.openPersonalPage();
        Assert.assertTrue(personalPage.isPageOpened(), "Personal page is not opened!");
        homePage = personalPage.logOut();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        Assert.assertTrue(homePage.checkIfRegisterAvailable(), "Logout is failed!");
    }

    @Test
    public void testProductInfoAndOrder() {
        Product productTest = ProductBuilder.getProduct();
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
        SearchPage searchPage = homePage.searchProductById(productTest.getId());
        Assert.assertTrue(searchPage.isPageOpened(), "search page is not opened!");
        ProductInfoPage productInfoPage = searchPage.openFirstProduct();
        Assert.assertTrue(productInfoPage.isPageOpened(), "Product info page is not opened!");
        Product productFromPage = productInfoPage.getProductModel();
        Assert.assertEquals(productTest, productFromPage, "Models are not equal!");
    }

    @Test
    public void testFavoriteProducts() {
        Product productTest = ProductBuilder.getProduct();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        homePage.openSearch();
        Assert.assertTrue(homePage.isSearchFormOpen(), "search form is not opened!");
        SearchPage searchPage = homePage.searchProductById(productTest.getId());
        Assert.assertTrue(searchPage.isPageOpened(), "search page is not opened!");
        ProductInfoPage productInfoPage = searchPage.openFirstProduct();
        Assert.assertTrue(productInfoPage.isPageOpened(), "Product info page is not opened!");
        productInfoPage.addToFavorite();
        int numberOfFavoriteProducts = productInfoPage.getNumberOfFavoritesProducts();
        Assert.assertEquals(numberOfFavoriteProducts, 1,"Product is not added");
        FavoritePage favoritePage = productInfoPage.openFavoritePage();
        Assert.assertTrue(favoritePage.isPageOpened(), "Favorite page is not opened!");
        int productsOnFavoritePage = favoritePage.getNumberOfFavoriteProducts();
        Assert.assertEquals(1, productsOnFavoritePage, "Not all products on favorite page!");
    }
}
