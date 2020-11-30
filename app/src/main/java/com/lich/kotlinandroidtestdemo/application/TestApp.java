package com.lich.kotlinandroidtestdemo.application;

import android.app.Application;

import androidx.appcompat.app.AppCompatDelegate;

/**
 * Created by lichhowger on 2020/11/26.
 */
public class TestApp extends Application {

    private static TestApp app;

    public static TestApp getInstance() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
