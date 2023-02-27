package com.qaprosoft.carina.demo.web.sauce_demo.pages.social;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class LinkedInPage extends AbstractPage {

    public LinkedInPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.linkedin.com/company/sauce-labs/?original_referer=");
    }
}
