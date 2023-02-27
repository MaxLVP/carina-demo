package com.qaprosoft.carina.demo.web.sauce_demo.pages.social;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class TwitterAccountPage extends AbstractPage {

    public TwitterAccountPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://twitter.com/saucelabs");
    }
}
