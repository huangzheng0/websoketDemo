package com.jrtech.android.widget.mNote;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import websoket.android.jr.com.mnotemenu.R;

/**
 * Author:zarle.
 * Created on 17-10-12.
 */

public class MNoteOptionalMenu extends FrameLayout {

    boolean optionalEnable;
    boolean checked;
    Drawable leftDrawable;
    CharSequence title;

    public MNoteOptionalMenu(@NonNull Context context) {
        super(context);
        init(null);
    }

    public MNoteOptionalMenu(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MNoteOptionalMenu(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MNoteOptionalMenu(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr,
            @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }


    private void init(@Nullable AttributeSet attrs) {
        inflate(getContext(), R.layout.widget_mnote_optional_menu, this);
        if (attrs == null) return;
        final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MNoteOptionalMenu);
        final int N = a.getIndexCount();
        for (int i = 0; i < N; i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.MNoteOptionalMenu_checked) {
                checked = a.getBoolean(attr, false);
            } else if (attr == R.styleable.MNoteOptionalMenu_title) {
                title = a.getString(attr);
            } else if (attr == R.styleable.MNoteOptionalMenu_image) {
                leftDrawable = a.getDrawable(attr);
            } else if (attr == R.styleable.MNoteOptionalMenu_optionalEnbale) {
                optionalEnable = a.getBoolean(attr, false);
            }
        }
        ((ImageView) findViewById(R.id.image_left)).setImageDrawable(leftDrawable);
        (findViewById(R.id.selected)).setVisibility(optionalEnable && checked ? VISIBLE : INVISIBLE);
        ((TextView) findViewById(R.id.title)).setText(title);
        a.recycle();
        setBackgroundResource(R.drawable.selector_white_pressed_gray);
        setClickable(true);
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        if (this.checked != checked) {
            this.checked = checked;
            (findViewById(R.id.selected)).setVisibility(optionalEnable && checked ? VISIBLE : INVISIBLE);
        }
    }

    public Drawable getLeftDrawable() {
        return leftDrawable;
    }

    public void setLeftDrawable(Drawable leftDrawable) {
        if (this.leftDrawable != leftDrawable) {
            this.leftDrawable = leftDrawable;
            ((ImageView) findViewById(R.id.image_left)).setImageDrawable(leftDrawable);
        }
    }

    public CharSequence getTitle() {
        return title;
    }

    public void setTitle(CharSequence title) {
        this.title = title;
        ((TextView) findViewById(R.id.title)).setText(title);
    }
}
