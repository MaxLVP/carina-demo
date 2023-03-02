package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.web.re_store.components.AuthorizationForm;
import com.qaprosoft.carina.demo.web.re_store.models.Product;
import com.qaprosoft.carina.demo.web.re_store.models.ProductBuilder;
import com.qaprosoft.carina.demo.web.re_store.models.User;
import com.qaprosoft.carina.demo.web.re_store.models.UserBuilder;
import com.qaprosoft.carina.demo.web.re_store.pages.*;
import com.qaprosoft.carina.demo.web.re_store.pages.catalog.BaileyPage;
import com.qaprosoft.carina.demo.web.re_store.pages.catalog.VinegarPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
    public void testProductInfo() {
        Product productTest = ProductBuilder.getProduct();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        Assert.assertTrue(homePage.isMenuPresented(), "Menu is not presented!");
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

    @Test
    public void testAddProductsToCart() {
        User user = UserBuilder.getUser();
        Product productTest = ProductBuilder.getProduct();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        AuthorizationForm authorizationForm = homePage.openLoginForm();
        Assert.assertTrue(authorizationForm.isUIObjectPresent(), "Authorization form is not opened!");
        authorizationForm.authorization(user);
        Assert.assertTrue(homePage.checkIfPersonalPresented(), "Personal link is not presented!");
        homePage.openSearch();
        Assert.assertTrue(homePage.isSearchFormOpen(), "search form is not opened!");
        SearchPage searchPage = homePage.searchProductById(productTest.getId());
        Assert.assertTrue(searchPage.isPageOpened(), "search page is not opened!");
        ProductInfoPage productInfoPage = searchPage.openFirstProduct();
        Assert.assertTrue(productInfoPage.isPageOpened(), "Product info page is not opened!");
        productInfoPage.addToCart();
        double sum_of_first_product = productInfoPage.getProductPrice();
        int productsInCart = productInfoPage.getNumbersOfProductsInCart();
        Assert.assertEquals(productsInCart, 1, "Product is not added to cart!");
        homePage = productInfoPage.openHomePage();
        BaileyPage baileyPage = homePage.openBaileyPage();
        Assert.assertTrue(baileyPage.isPageOpened(), "Bailey page is not opened!");
        VinegarPage vinegarPage = baileyPage.openVinegarPage();
        Assert.assertTrue(vinegarPage.isPageOpened(), "Vinegar catalog is not opened");
        productInfoPage = vinegarPage.openFirstVinegarPage();
        Assert.assertTrue(productInfoPage.isPageOpened(), "Product info page is not opened");
        productInfoPage.addToCart();
        double sum_of_second_product = productInfoPage.getProductPrice();
        productsInCart = productInfoPage.getNumbersOfProductsInCart();
        Assert.assertEquals(productsInCart, 2, "Product is not added to cart!");
        homePage = productInfoPage.openHomePage();
        CartPage cartPage = homePage.openCartPage();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened!");
        Assert.assertEquals(sum_of_first_product + sum_of_second_product, cartPage.getAllPrice(), "Total sum of order is not correct!");
        cartPage.removeFirstItem();
        Assert.assertEquals(sum_of_first_product, cartPage.getAllPrice(), "Total sum of order is not correct");
        cartPage.removeFirstItem();
        Assert.assertFalse(cartPage.isRemoveButtonDisplayed(), "Items are not deleted!");
    }

    @Test
    public void testCartLogout() {
        Product productTest = ProductBuilder.getProduct();
        User user = UserBuilder.getUser();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        AuthorizationForm authorizationForm = homePage.openLoginForm();
        Assert.assertTrue(authorizationForm.isUIObjectPresent(), "Authorization form is not opened!");
        authorizationForm.authorization(user);
        Assert.assertTrue(homePage.checkIfPersonalPresented(), "Personal link is not presented!");
        homePage.openSearch();
        Assert.assertTrue(homePage.isSearchFormOpen(), "search form is not opened!");
        SearchPage searchPage = homePage.searchProductById(productTest.getId());
        Assert.assertTrue(searchPage.isPageOpened(), "search page is not opened!");
        ProductInfoPage productInfoPage = searchPage.openFirstProduct();
        Assert.assertTrue(productInfoPage.isPageOpened(), "Product info page is not opened!");
        productInfoPage.addToCart();
        int productsInCart = productInfoPage.getNumbersOfProductsInCart();
        Assert.assertEquals(productsInCart, 1, "Product is not added to cart!");
        homePage = productInfoPage.openHomePage();
        PersonalPage personalPage = homePage.openPersonalPage();
        Assert.assertTrue(personalPage.isPageOpened(), "Personal page is not opened!");
        homePage = personalPage.logOut();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        Assert.assertTrue(homePage.checkIfRegisterAvailable(), "Logout is failed!");
        Assert.assertFalse(homePage.isAnyProductInCart(), "There is still product in cart");
        authorizationForm = homePage.openLoginForm();
        Assert.assertTrue(authorizationForm.isUIObjectPresent(), "Authorization form is not opened!");
        authorizationForm.authorization(user);
        Assert.assertTrue(homePage.checkIfPersonalPresented(), "Personal link is not presented!");
        Assert.assertEquals(homePage.getNumberOfProductsInCart(), 1, "Product is disappeared from cart!");
        CartPage cartPage = homePage.openCartPage();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened");
        cartPage.removeFirstItem();
        homePage = cartPage.openHomePage();
        Assert.assertFalse(homePage.isAnyProductInCart(), "Product is not removed from cart!");
    }

    @Test
    public void testPagesFromMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        Assert.assertTrue(homePage.isMenuPresented(), "Menu is not presented!");
        PaymentPage paymentPage = homePage.openPaymentPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(paymentPage.isPageOpened(), "Payment page is not opened!");
        DeliveryPage deliveryPage = homePage.openDeliveryPage();
        softAssert.assertTrue(deliveryPage.isPageOpened(), "Delivery page is not opened!");
        RecipePage recipePage = homePage.openRecipePage();
        softAssert.assertTrue(recipePage.isPageOpened(), "Recipe page is not opened!");
        softAssert.assertAll();
    }
}
