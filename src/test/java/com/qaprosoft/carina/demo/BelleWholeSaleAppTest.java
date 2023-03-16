package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.bellewhole.android.*;
import com.qaprosoft.carina.demo.mobile.bellewhole.models.DressBuilder;
import com.qaprosoft.carina.demo.mobile.bellewhole.models.DressModel;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BelleWholeSaleAppTest implements IAbstractTest {

    @Test
    public void testAuthentication() {
        PermissionWidgetPage authWidgetPage = new PermissionWidgetPage(getDriver());
        Assert.assertTrue(authWidgetPage.isPageOpened(), "Permission widget is not opened!");
        HomePage homePage = authWidgetPage.denyPermission();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        MePage mePage = homePage.openMePage();
        Assert.assertTrue(mePage.isPageOpened(), "Me page is not opened!");
        SignInPage signInPage = mePage.openSignInPage();
        Assert.assertTrue(signInPage.isPageOpened(), "Sign in page is not opened!");
        mePage = signInPage.signIn(R.TESTDATA.get("belle_email"), R.TESTDATA.get("belle_password"));
        Assert.assertTrue(mePage.isPageOpened(), "Me page is not opened!");
        Assert.assertTrue(mePage.checkIfSignedIn(), "We are not signed in!");
    }

    @Test
    public void testCategoriesMenu() {
        PermissionWidgetPage authWidgetPage = new PermissionWidgetPage(getDriver());
        Assert.assertTrue(authWidgetPage.isPageOpened(), "Permission widget is not opened!");
        HomePage homePage = authWidgetPage.denyPermission();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        CategoriesPage categoriesPage = homePage.openCategories();
        Assert.assertTrue(categoriesPage.isPageOpened(), "Categories page is not opened!");
        WorkDressesPage workDressesPage = categoriesPage.openWorkDressesPage();
        Assert.assertTrue(workDressesPage.isPageOpened(), "Work dresses page is not opened!");
        String firstItem = workDressesPage.getPriceOfFirstItem();
        workDressesPage.changeSortByLowToHighPrice();
        Assert.assertNotEquals(firstItem, workDressesPage.getPriceOfFirstItem(), "First item is not change!");
    }

    @Test
    public void testSearchProductById() {
        DressModel testDressModel = DressBuilder.getTestDress();
        PermissionWidgetPage authWidgetPage = new PermissionWidgetPage(getDriver());
        Assert.assertTrue(authWidgetPage.isPageOpened(), "Permission widget is not opened!");
        HomePage homePage = authWidgetPage.denyPermission();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        SearchPage searchPage = homePage.openSearch();
        Assert.assertTrue(searchPage.isPageOpened(), "Search page is not opened!");
        searchPage.searchItem(testDressModel.getId());
        DressInfoPage dressInfoPage = searchPage.openDressPageBySearch();
        Assert.assertTrue(dressInfoPage.isPageOpened(), "Dress info page is not opened!");
        Assert.assertEquals(testDressModel.getPrice(), dressInfoPage.getPriceFromPage(), "Models of products are not equals!");
    }

    @Test
    public void testAddProductToFavorite() {
        String productId = R.TESTDATA.get("belle_dress_to_check_id");
        PermissionWidgetPage authWidgetPage = new PermissionWidgetPage(getDriver());
        Assert.assertTrue(authWidgetPage.isPageOpened(), "Permission widget is not opened!");
        HomePage homePage = authWidgetPage.denyPermission();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        MePage mePage = homePage.openMePage();
        Assert.assertTrue(mePage.isPageOpened(), "Me page is not opened!");
        SignInPage signInPage = mePage.openSignInPage();
        Assert.assertTrue(signInPage.isPageOpened(), "Sign in page is not opened!");
        mePage = signInPage.signIn(R.TESTDATA.get("belle_email"), R.TESTDATA.get("belle_password"));
        Assert.assertTrue(mePage.isPageOpened(), "Me page is not opened!");
        Assert.assertTrue(mePage.checkIfSignedIn(), "We are not signed in!");
        homePage = mePage.openHomePage();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        SearchPage searchPage = homePage.openSearch();
        Assert.assertTrue(searchPage.isPageOpened(), "Search page is not opened!");
        searchPage.searchItem(productId);
        DressInfoPage dressInfoPage = searchPage.openDressPageBySearch();
        Assert.assertTrue(dressInfoPage.isPageOpened(), "Dress info page is not opened!");
        double productPrice = dressInfoPage.getPriceFromPage();
        dressInfoPage.addProductToWishList();
        homePage = dressInfoPage.openHomePage();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        WishList wishList = homePage.openWishListPage();
        Assert.assertTrue(wishList.isPageOpened(), "Wish list is not opened!");
        Assert.assertEquals(productPrice, wishList.getPrice(), "Price od product ias different!");
        dressInfoPage = wishList.openDressInfoPage();
        Assert.assertTrue(dressInfoPage.isPageOpened(), "Dress info page is not opened!");
        dressInfoPage.clickOnAddToWishButton();
    }

    @Test
    public void testCart() {
        PermissionWidgetPage authWidgetPage = new PermissionWidgetPage(getDriver());
        Assert.assertTrue(authWidgetPage.isPageOpened(), "Permission widget is not opened!");
        HomePage homePage = authWidgetPage.denyPermission();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        MePage mePage = homePage.openMePage();
        Assert.assertTrue(mePage.isPageOpened(), "Me page is not opened!");
        SignInPage signInPage = mePage.openSignInPage();
        Assert.assertTrue(signInPage.isPageOpened(), "Sign in page is not opened!");
        mePage = signInPage.signIn(R.TESTDATA.get("belle_email"), R.TESTDATA.get("belle_password"));
        Assert.assertTrue(mePage.isPageOpened(), "Me page is not opened!");
        Assert.assertTrue(mePage.checkIfSignedIn(), "We are not signed in!");

    }
}
