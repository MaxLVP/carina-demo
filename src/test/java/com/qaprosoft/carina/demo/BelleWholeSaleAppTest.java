package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.bellewhole.android.*;
import com.qaprosoft.carina.demo.mobile.bellewhole.models.DressBuilder;
import com.qaprosoft.carina.demo.mobile.bellewhole.models.DressModel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BelleWholeSaleAppTest implements IAbstractTest {

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
        Assert.assertEquals(testDressModel, dressInfoPage.getDressModelFromPage(), "Models of products are not equals!");
    }

    @Test
    public void testAddProductToFavorite() {

    }

    @Test
    public void testCart() {

    }

    @Test
    public void testAuthentication() {

    }

    @Test
    public void testDifferentFiltersOnHomePage() {
        
    }
}
