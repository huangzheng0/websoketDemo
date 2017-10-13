package com.jrtech.android.databinding;

import android.databinding.BaseObservable;

/**
 * Created by zarle on 2017/6/25.
 */

public class BindableString extends BaseObservable {
    private String value;

    public String get() {
        return value != null ? value : "";
    }

    public void set(String value) {
        if (!(!(this.value == null || value == null) && this.value.equals(value))) {
            this.value = value;
            notifyChange();
        }
    }

    public boolean isEmpty() {
        return value == null || value.isEmpty();
    }
}