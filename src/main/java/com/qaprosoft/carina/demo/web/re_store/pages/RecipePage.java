package com.qaprosoft.carina.demo.web.re_store.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.utils.RandomUtils;
import com.qaprosoft.carina.demo.web.re_store.pages.recipes.RecipeInfoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class RecipePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a[@class='recipes-li']")
    List<ExtendedWebElement> listOfRecipes;

    public RecipePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://re-store.by/recipes/");
    }

    public RecipeInfoPage openRecipeInfoPage() {
        LOGGER.info("Opening recipe info page");
        ExtendedWebElement randomRecipe = RandomUtils.returnRandomObjectFromList(listOfRecipes);
        randomRecipe.click();
        return new RecipeInfoPage(driver);
    }
}
