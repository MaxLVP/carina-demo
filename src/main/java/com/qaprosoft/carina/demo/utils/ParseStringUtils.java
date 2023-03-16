package com.qaprosoft.carina.demo.utils;

public class ParseStringUtils {

    public static double parsePrice(String highPrice, String lowPrice) {
        return Double.parseDouble(highPrice + "." + lowPrice);
    }

    public static String parsePhone(String phone) {
        String correctPhone = phone.substring(6, 8) + phone.substring(10);
        return correctPhone.replace("-", "");
    }

    public static double parsePriceFromApp(String price)
    {
        return Double.parseDouble(org.apache.commons.lang3.StringUtils.remove(price, "$"));
    }
}
