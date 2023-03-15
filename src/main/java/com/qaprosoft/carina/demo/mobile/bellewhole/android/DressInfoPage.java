package com.qaprosoft.carina.demo.mobile.bellewhole.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.bellewhole.common.DressInfoPageBase;
import com.qaprosoft.carina.demo.mobile.bellewhole.models.DressModel;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DressInfoPageBase.class)
public class DressInfoPage extends DressInfoPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String PRODUCT_STYLE_XPATH = "//android.view.View[@text='Style:']//following-sibling::android.view.View";
    private static final String PRODUCT_MATERIAL_XPATH="//android.view.View[@text='Material:']//following-sibling::android.view.View";
    private static final String PRODUCT_LENGTH_XPATH="//android.view.View[@text='Length:']//following-sibling::android.view.View";
    private static final String PRODUCT_DESCRIPTION_OPEN_BUTTON_ID = "com.geeko.bellewholesale:id/ib_description";

    @FindBy(id = "com.geeko.bellewholesale:id/tv_minPrice")
    private ExtendedWebElement priceLabel;


    public DressInfoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return priceLabel.isElementPresent();
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
        String price = StringUtils.remove(priceLabel.getText(), "$");
        return Double.valueOf(price);
    }

    public void openProductDetails() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        HashMap<String, String> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        js.executeScript("mobile: scroll", scrollObject);
        findExtendedWebElement(By.id(PRODUCT_DESCRIPTION_OPEN_BUTTON_ID)).click();
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
