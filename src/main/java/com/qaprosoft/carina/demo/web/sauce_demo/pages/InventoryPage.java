package com.qaprosoft.carina.demo.web.sauce_demo.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.sauce_demo.components.Menu;
import com.qaprosoft.carina.demo.web.sauce_demo.components.ProductModel;
import com.qaprosoft.carina.demo.web.sauce_demo.pages.social.FacebookPage;
import com.qaprosoft.carina.demo.web.sauce_demo.pages.social.LinkedInPage;
import com.qaprosoft.carina.demo.web.sauce_demo.pages.social.TwitterAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "react-burger-menu-btn")
    private ExtendedWebElement menuOpenButton;

    @FindBy(xpath = "//div[@class = 'inventory_item']")
    private List<ProductModel> productModelList;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private ExtendedWebElement cartPageBtn;

    @FindBy(xpath = "//a[@class='shopping_cart_link']//span")
    private ExtendedWebElement cartItemsNumber;

    @FindBy(xpath = "//select[@class = 'product_sort_container']")
    private ExtendedWebElement selectFilter;

    @FindBy(xpath = "//li[@class='social_twitter']//a")
    private ExtendedWebElement twitterLink;

    @FindBy(xpath = "//li[@class='social_facebook']//a")
    private ExtendedWebElement facebookLink;

    @FindBy(xpath = "//li[@class='social_linkedin']//a")
    private ExtendedWebElement linkedinLink;

    public InventoryPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/inventory.html");
    }

    public Menu openMenu() {
        LOGGER.info("Open menu");
        menuOpenButton.click();
        return new Menu(getDriver());
    }

    public ProductModel selectModel(String modelName) {
        LOGGER.info("Get model " + modelName);
        for (ProductModel productModel : productModelList) {
            if (productModel.returnProductName().equalsIgnoreCase(modelName)) {
                return productModel;
            }
        }
        throw new RuntimeException("Unable to get model: " + modelName);
    }

    public void fillInCart() {
        LOGGER.info("Add all product to cart");
        for (ProductModel productModel : productModelList) {
            productModel.addToCart();
        }
    }

    public String getNumberOfItems() {
        LOGGER.info("Get number of items in cart");
        return cartItemsNumber.getText();
    }

    public boolean isNumberOfItemsPresent() {
        return cartItemsNumber.isElementPresent(1);
    }

    public CartPage openCartPage() {
        LOGGER.info("Open cart page");
        cartPageBtn.click();
        return new CartPage(driver);
    }

    public TwitterAccountPage openTwitter() {
        LOGGER.info("Open twitter account");
        twitterLink.click();
        return new TwitterAccountPage(driver);
    }

    public FacebookPage openFacebook() {
        LOGGER.info("Open facebook account");
        facebookLink.click();
        return new FacebookPage(driver);
    }

    public LinkedInPage openLinkedIn() {
        LOGGER.info("Open linkedIn account");
        linkedinLink.click();
        return new LinkedInPage(driver);
    }

    public void changeFilterToLoHi() {
        LOGGER.info("Change filter to lower-high");
        selectFilter.select(2);
    }

    public void changeFilterToHiLo() {
        LOGGER.info("Change filter to high-lower");
        selectFilter.select(3);
    }

    public void changeFilterToAZ() {
        LOGGER.info("Change filter to A-Z");
        selectFilter.select(0);
    }
    public void changeFilterToZA() {
        LOGGER.info("Change filter to Z-A");
        selectFilter.select(1);
    }

    public boolean checkIfSortAZCorrect() {
        List<String> names = new ArrayList<>();
        for (ProductModel productModel: productModelList) {
            names.add(productModel.returnProductName());
            return names.stream().sorted().collect(Collectors.toList()).equals(names);
        }
        return false;
    }

    public boolean checkIfSortZACorrect() {
        List<String> names = new ArrayList<>();
        for (ProductModel productModel: productModelList) {
            names.add(productModel.returnProductName());
            return names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).equals(names);
        }
        return false;
    }

    public boolean checkIfSortLoToHiCorrect() {
        List<Double> prices = new ArrayList<>();
        for (ProductModel productModel: productModelList) {
            String price = productModel.returnProductPrice().replace("$", "");
            prices.add(Double.valueOf(price));
            return prices.stream().sorted().collect(Collectors.toList()).equals(prices);
        }
        return false;
    }

    public boolean checkIfSortHiToLoCorrect() {
        List<Double> prices = new ArrayList<>();
        for (ProductModel productModel: productModelList) {
            String price = productModel.returnProductPrice().replace("$", "");
            prices.add(Double.valueOf(price));
            return prices.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).equals(prices);
        }
        return false;
    }
}
