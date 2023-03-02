package com.qaprosoft.carina.demo.utils;

public class StringUtils {

    public static double parsePrice(String highPrice, String lowPrice) {
        return Double.parseDouble(highPrice + "." + lowPrice);
    }
}
