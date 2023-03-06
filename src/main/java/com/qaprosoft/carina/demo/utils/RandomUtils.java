package com.qaprosoft.carina.demo.utils;

import java.util.List;
import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static <T> T returnRandomObjectFromList(List<T> list) {
        return list.get(RANDOM.nextInt(list.size()));
    }

    public static int returnRandomInRange(int min, int max) {
        return RANDOM.nextInt((max - min) + 1) + min;
    }

}
