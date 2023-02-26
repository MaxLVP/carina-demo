package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.web.sauce_demo.pages.AboutPage;
import com.qaprosoft.carina.demo.web.sauce_demo.pages.HomePage;
import com.qaprosoft.carina.demo.web.sauce_demo.pages.InventoryPage;
import com.qaprosoft.carina.demo.web.sauce_demo.components.Menu;
import org.testng.Assert;
import org.testng.annotations.Test;

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
}
