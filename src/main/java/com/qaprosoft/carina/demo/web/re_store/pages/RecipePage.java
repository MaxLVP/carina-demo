package com.qaprosoft.carina.demo.web.re_store.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class RecipePage extends AbstractPage {

    public RecipePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://re-store.by/recipes/");
    }
}
