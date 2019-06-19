package com.ecut.gymonlineshopping.utils;

import java.util.Random;

/**
 * @Author: Selune
 * @Date: 2019/6/18 16:01
 */

public class KeyUtil {

    public static synchronized Integer getRandom() {
        return new Random().nextInt(9000) + 1000;
    }

    public static synchronized String getOrderId() {

        Random random = new Random();
        long time = System.currentTimeMillis();
        int number = random.nextInt(900) + 100;
        return String.valueOf(time + number);
    }
}
