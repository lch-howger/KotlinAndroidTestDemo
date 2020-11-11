package com.lich.kotlinandroidtestdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * Created by lichhowger on 2020/10/30.
 */
class TestLayout  extends LinearLayout {

    public TestLayout(Context context) {
        super(context);
        initView();
    }

    public TestLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public TestLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
//        View view = LayoutInflater.inflate(R.layout.layout_test, this, false);
//        Log.e("howger", String.valueOf(view instanceof LinearLayout));
//        Log.e("howger", String.valueOf(view instanceof LinearLayout));
//        Log.e("howger", String.valueOf(view instanceof LinearLayout));
//        Log.e("howger", String.valueOf(view instanceof LinearLayout));
//        Log.e("howger", String.valueOf(view instanceof LinearLayout));
//        Log.e("howger", String.valueOf(view instanceof LinearLayout));
    }

}

