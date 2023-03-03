package com.qaprosoft.carina.demo.utils;

public class StringUtils {

    public static double parsePrice(String highPrice, String lowPrice) {
        return Double.parseDouble(highPrice + "." + lowPrice);
    }

    public static String parsePhone(String phone) {
        String correctPhone = phone.substring(6, 8) + phone.substring(10);
        return correctPhone.replace("-", "");
    }
}
