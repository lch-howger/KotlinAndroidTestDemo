package com.lich.kotlinandroidtestdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;

import com.lich.kotlinandroidtestdemo.R;
import com.lich.kotlinandroidtestdemo.utils.ColorUtil;

/**
 * Created by lichhowger on 2020/11/26.
 */
class CircleView extends View {

    private Paint paint;
    private int radius = 0;
    private int max = 2000;
    private float centerX;
    private float centerY;

    public CircleView(Context context) {
        super(context);
        initView();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(ColorUtil.getColor(R.color.c_3700B3));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (radius < max) {
            radius += 20;
            canvas.drawCircle(centerX, centerY, radius, paint);
            postInvalidateDelayed(10);
        } else {
            canvas.drawCircle(centerX, centerY, max, paint);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;
    }
}
