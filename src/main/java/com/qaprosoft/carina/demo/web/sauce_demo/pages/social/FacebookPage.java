package com.qaprosoft.carina.demo.web.sauce_demo.pages.social;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class FacebookPage extends AbstractPage {

    public FacebookPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.facebook.com/saucelabs");
    }
}
