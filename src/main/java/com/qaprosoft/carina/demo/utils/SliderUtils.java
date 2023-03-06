package com.qaprosoft.carina.demo.utils;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.Keys;

public class SliderUtils {

    public static void moveSlider(int start_num, int end_num, ExtendedWebElement slider) {
        if (start_num > end_num) {
            int diff = start_num - end_num;
            for (int i = 0; i < diff; i++) {
                slider.sendKeys(Keys.ARROW_DOWN);
            }
        } else if (start_num < end_num) {
            int diff = end_num - start_num;
            for (int i = 0; i < diff; i++) {
                slider.sendKeys(Keys.ARROW_UP);
            }
        }
    }
}
