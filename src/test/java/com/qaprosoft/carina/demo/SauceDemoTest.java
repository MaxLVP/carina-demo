package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.web.sauce_demo.components.ProductModel;
import com.qaprosoft.carina.demo.web.sauce_demo.pages.*;
import com.qaprosoft.carina.demo.web.sauce_demo.components.Menu;
import com.qaprosoft.carina.demo.web.sauce_demo.pages.checkout.CheckoutComplete;
import com.qaprosoft.carina.demo.web.sauce_demo.pages.checkout.CheckoutPage;
import com.qaprosoft.carina.demo.web.sauce_demo.pages.checkout.CheckoutPage2;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SauceDemoTest implements IAbstractTest {

    @Test
    public void testLoginAndAboutPage() {
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

    @Test
    public void testCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        InventoryPage inventoryPage = homePage.authorization();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page is not opened!");
        inventoryPage.fillInCart();
        Assert.assertTrue(inventoryPage.isNumberOfItemsPresent(), "The cart is not fill in");
        Assert.assertEquals(inventoryPage.getNumberOfItems(), "6", "Number of items is not valid");
        Menu menu = inventoryPage.openMenu();
        Assert.assertTrue(menu.isUIObjectPresent(), "Menu is not opened");
        menu.resetCart();
        Assert.assertFalse(inventoryPage.isNumberOfItemsPresent(), "The cart is not reset");
    }

    @Test
    public void testOrder() {
        String productName = "Sauce Labs Fleece Jacket";
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        InventoryPage inventoryPage = homePage.authorization();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page is not opened!");
        ProductModel productModel = inventoryPage.selectModel(productName);
        productModel.addToCart();
        Assert.assertTrue(productModel.isRemoveButtonDisplay(), "The item is not add to cart");
        Assert.assertTrue(inventoryPage.isNumberOfItemsPresent(), "The cart is not fill in");
        Assert.assertEquals(inventoryPage.getNumberOfItems(), "1", "Number of items is not valid");
        CartPage cartPage = inventoryPage.openCartPage();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened!");
        Assert.assertEquals(cartPage.getItemsInCart(), 1, "Items in cart are not match with order");
        CheckoutPage checkoutPage = cartPage.openCheckoutPage();
        Assert.assertTrue(checkoutPage.isPageOpened(), "Checkout page is not open");
        checkoutPage.fillInCheckoutForm();
        CheckoutPage2 checkoutPage2 = checkoutPage.openCheckoutStepTwo();
        Assert.assertTrue(checkoutPage2.isPageOpened(), "Checkout page step two is not opened");
        CheckoutComplete checkoutComplete = checkoutPage2.clickFinishButton();
        Assert.assertTrue(checkoutComplete.isPageOpened(), "Checkout complete page is not open");
        inventoryPage = checkoutComplete.backToInventoryPage();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page is not opened");
    }

    @Test
    public void testCartWithLogout() {
        String productName = "Sauce Labs Fleece Jacket";
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        InventoryPage inventoryPage = homePage.authorization();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page is not opened!");
        ProductModel productModel = inventoryPage.selectModel(productName);
        productModel.addToCart();
        Assert.assertTrue(productModel.isRemoveButtonDisplay(), "The item is not add to cart");
        Assert.assertTrue(inventoryPage.isNumberOfItemsPresent(), "The cart is not fill in");
        Assert.assertEquals(inventoryPage.getNumberOfItems(), "1", "Number of items is not valid");
        Menu menu = inventoryPage.openMenu();
        Assert.assertTrue(menu.isUIObjectPresent(), "Menu is not opened");
        menu.logout();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        inventoryPage = homePage.authorization();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page is not opened!");
        Assert.assertEquals(inventoryPage.getNumberOfItems(), "1", "Number of items is not valid");
    }

    @Test
    public void testProductFilter() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        InventoryPage inventoryPage = homePage.authorization();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page is not opened!");
        inventoryPage.changeFilterToLoHi();
        Assert.assertTrue(inventoryPage.checkIfSortLoToHiCorrect(), "Models are not filter");
        inventoryPage.changeFilterToHiLo();
        Assert.assertTrue(inventoryPage.checkIfSortHiToLoCorrect(), "Models are not filter");
        inventoryPage.changeFilterToAZ();
        Assert.assertTrue(inventoryPage.checkIfSortAZCorrect(), "Models are not filter");
        inventoryPage.changeFilterToZA();
        Assert.assertTrue(inventoryPage.checkIfSortZACorrect(), "Models are not filter");
    }
}
