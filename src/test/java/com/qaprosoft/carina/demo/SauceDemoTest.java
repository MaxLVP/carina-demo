package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.web.sauce_demo.components.ProductModel;
import com.qaprosoft.carina.demo.web.sauce_demo.pages.AboutPage;
import com.qaprosoft.carina.demo.web.sauce_demo.pages.HomePage;
import com.qaprosoft.carina.demo.web.sauce_demo.pages.InventoryPage;
import com.qaprosoft.carina.demo.web.sauce_demo.components.Menu;
import com.qaprosoft.carina.demo.web.sauce_demo.pages.ProductInfoPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SauceDemoTest implements IAbstractTest {

    @Test
    public void testLoginLogout() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        InventoryPage inventoryPage = homePage.authorization();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page is not opened!");
        Menu menu = inventoryPage.openMenu();
        Assert.assertTrue(menu.isUIObjectPresent(), "Menu is not opened");
        AboutPage aboutPage = menu.openAboutPage();
        Assert.assertTrue(aboutPage.isPageOpened(), "About page is not opened!");
        getDriver().navigate().back();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page is not opened!");
        menu.logout();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
    }

    @Test
    public void testBlockedUser() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        homePage.blockedAuthorization();
        Assert.assertTrue(homePage.isErrorDisplay(), "Error window is not displayed");
        homePage.closeErrorDisplay();
        Assert.assertFalse(homePage.isErrorDisplay(), "Error window is still display");
    }

    @Test
    public void testInfoAboutProduct() {
        String productName = "Sauce Labs Fleece Jacket";
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        InventoryPage inventoryPage = homePage.authorization();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page is not opened!");
        ProductModel productModel = inventoryPage.selectModel(productName);
        String productPrice = productModel.returnProductPrice();
        String productDesc = productModel.returnProductDesc();
        ProductInfoPage productInfoPage = productModel.openProductPage();
        Assert.assertTrue(productInfoPage.isPageOpened());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productInfoPage.readName(), productName);
        softAssert.assertEquals(productInfoPage.readPrice(), productPrice);
        softAssert.assertEquals(productInfoPage.readInfo(), productDesc);
        softAssert.assertAll();
    }
}
