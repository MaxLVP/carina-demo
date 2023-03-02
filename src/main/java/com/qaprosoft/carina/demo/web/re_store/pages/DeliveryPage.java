package com.qaprosoft.carina.demo.web.re_store.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class DeliveryPage extends AbstractPage {

    public DeliveryPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://re-store.by/customers/delivery/");
    }
}
