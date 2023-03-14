package com.qaprosoft.carina.demo.mobile.bellewhole.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.bellewhole.common.DressInfoPageBase;
import com.qaprosoft.carina.demo.mobile.bellewhole.models.DressModel;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DressInfoPageBase.class)
public class DressInfoPage extends DressInfoPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String PRODUCT_STYLE_XPATH = "";
    private static final String PRODUCT_MATERIAL_XPATH="";
    private static final String PRODUCT_LENGTH_XPATH="";

    @FindBy()
    private ExtendedWebElement priceLabel;

    @FindBy()
    private ExtendedWebElement productDetailsOpenButton;

    public DressInfoPage(WebDriver driver) {
        super(driver);
    }

    public DressModel getDressModelFromPage() {
        DressModel dressModel = new DressModel();
        dressModel.setPrice(getPriceFromPage());
        openProductDetails();
        dressModel.setStyle(getProductStyle());
        dressModel.setMaterial(getProductMaterial());
        dressModel.setLength(getProductLength());
        return dressModel;
    }

    public Double getPriceFromPage() {
        return Double.valueOf(priceLabel.getText());
    }

    public void openProductDetails() {
        productDetailsOpenButton.click();
    }

    public String getProductStyle() {
        return findExtendedWebElement(By.xpath(PRODUCT_STYLE_XPATH)).getText();
    }

    public String getProductMaterial() {
        return findExtendedWebElement(By.xpath(PRODUCT_MATERIAL_XPATH)).getText();
    }

    public String getProductLength() {
        return findExtendedWebElement(By.xpath(PRODUCT_LENGTH_XPATH)).getText();
    }
}
