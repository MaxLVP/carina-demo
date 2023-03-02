package com.qaprosoft.carina.demo.web.re_store.pages.recipes;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.utils.StringUtils;
import com.qaprosoft.carina.demo.web.re_store.pages.CartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class RecipeInfoPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@class = 'cook-item_table']")
    private ExtendedWebElement recipeInfo;

    @FindBy(xpath = "//a[@data-metricaction = 'buy_ingredients']")
    private ExtendedWebElement buyIngredientsButton;

    @FindBy(xpath = "//div[@class = 'popup_body']//button[@type='submit']")
    private ExtendedWebElement buyIngredientsInPopupButton;

    @FindBy(xpath = "//span[@class='strong-price']//strong")
    private ExtendedWebElement strongPrice;

    @FindBy(xpath = "//span[@class='strong-price']//small")
    private ExtendedWebElement smallPrice;

    public RecipeInfoPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(recipeInfo);
    }

    public CartPage buyIngredients() {
        LOGGER.info("Buying ingredients");
        buyIngredientsButton.click();
        waitUntil(ExpectedConditions.elementToBeClickable(buyIngredientsInPopupButton.getElement()), 1);
        buyIngredientsInPopupButton.click();
        return new CartPage(driver);
    }

    public double getPriceOfAllProducts() {
        LOGGER.info("Return price of products for this recipe");
        return StringUtils.parsePrice(strongPrice.getText(), smallPrice.getText());
    }
}
