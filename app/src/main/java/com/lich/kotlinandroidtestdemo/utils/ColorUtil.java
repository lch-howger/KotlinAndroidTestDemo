package com.lich.kotlinandroidtestdemo.utils;

import androidx.core.content.ContextCompat;

import com.lich.kotlinandroidtestdemo.application.TestApp;

/**
 * Created by lichhowger on 2020/2/4.
 */
public class ColorUtil {

    public static int getColor(int colorId) {
        int color = ContextCompat.getColor(TestApp.getInstance(), colorId);
        return color;
    }
}
