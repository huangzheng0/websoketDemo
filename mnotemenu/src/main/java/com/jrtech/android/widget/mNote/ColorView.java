package com.jrtech.android.widget.mNote;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import websoket.android.jr.com.mnotemenu.R;

/**
 * Author:zarle.
 * Created on 17-10-11.
 */

public class ColorView extends View {
    private int mColor;

    private boolean pressed;

    private Paint mPaint = new Paint();

    public ColorView(Context context) {
        super(context);
        init(null);
    }

    public ColorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs == null) {
            mPaint.setColor(mColor);
            return;
        }
        final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ColorView);
        mColor = a.getColor(a.getIndex(R.styleable.ColorView_color), 0);
        a.recycle();
        mPaint.setColor(mColor);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void dispatchSetPressed(boolean pressed) {
        this.pressed = pressed;
        mPaint.setColor(pressed ? mColor == 0xffffffff ? 0x90000000 : 0x77ffffff & mColor : mColor);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, mPaint);
        canvas.save();
    }
}
