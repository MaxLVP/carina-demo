package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.utils.RandomUtils;
import com.qaprosoft.carina.demo.web.letcode.pages.AlertsPage;
import com.qaprosoft.carina.demo.web.letcode.pages.FramePage;
import com.qaprosoft.carina.demo.web.letcode.pages.SliderPage;
import com.qaprosoft.carina.demo.web.letcode.pages.TestPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class LetCodeTest implements IAbstractTest {

    @Test
    public void testAlerts() {
        TestPage testPage = new TestPage(getDriver());
        testPage.open();
        Assert.assertTrue(testPage.isPageOpened(), "Test page is not opened!");
        AlertsPage alertsPage = testPage.openAlertPage();
        Assert.assertTrue(alertsPage.isPageOpened(), "Alert page is not opened!");
        alertsPage.openSimpleAlert();
        alertsPage.confirmAlert();
        Assert.assertFalse(alertsPage.checkIsAlertPresented(), "Alert is presented!");
        alertsPage.openConfirmAlert();
        alertsPage.cancelAlerts();
        Assert.assertFalse(alertsPage.checkIsAlertPresented(), "Alert is presented!");
        alertsPage.openPromptAlert();
    }

    @Test
    public void testFrames() {
        TestPage testPage = new TestPage(getDriver());
        testPage.open();
        Assert.assertTrue(testPage.isPageOpened(), "Test page is not opened!");
        FramePage framePage = testPage.openFramePage();
        Assert.assertTrue(framePage.isPageOpened(), "Frame page is not opened!");
        Assert.assertFalse(framePage.checkIsFrameVisible(), "Frame was open!");
        framePage.switchToFrame();
        Assert.assertTrue(framePage.checkIsFrameVisible(), "Frame is not opened!");
        framePage.typeFirstName("first name");
        framePage.typeLastName("last name");
        framePage.switchToInnerFrame();
        Assert.assertTrue(framePage.checkIsInnerFrameOpen(), "Inner frame is not opened!");
        framePage.typeEmail("email");
        framePage.switchToDefault();
        Assert.assertFalse(framePage.checkIsFrameVisible(), "Frame is still open!");
    }

    @Test
    public void testSlider() {
        int countOfCountries = 26;
        TestPage testPage = new TestPage(getDriver());
        testPage.open();
        Assert.assertTrue(testPage.isPageOpened(), "Test page is not opened!");
        SliderPage sliderPage = testPage.openSliderPage();
        Assert.assertTrue(sliderPage.isPageOpened(), "Slider page is not opened!");
        sliderPage.inputNumberToSlider(String.valueOf(countOfCountries));
        sliderPage.getCountriesOpen();
        Assert.assertEquals(countOfCountries, sliderPage.returnSizeOfCountries(),
                "Count of countries is not equal");
    }
}
