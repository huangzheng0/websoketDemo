package com.jrtech.android.databinding;

import android.content.res.ColorStateList;
import android.databinding.BindingAdapter;
import android.databinding.Observable;
import android.databinding.ObservableBoolean;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import websoket.android.jr.com.databing.R;

/**
 * Author:zarle.
 * Created on 17-10-11.
 */

public class DataBindingUtil {


    @BindingAdapter("html")
    public static void setHtmlText(TextView v, String html) {
        if (!TextUtils.isEmpty(html))
            v.setText(Html.fromHtml(html.replaceAll("\\n", "\n")));
    }

    @BindingAdapter("htmlbinding")
    public static void setHtmlText(TextView view, final BindableCharSequence html) {
        if (view.getTag(R.id.databinding_binded) == null) {
            view.setTag(R.id.databinding_binded, true);
            view.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s instanceof String) {
                        html.set(Html.fromHtml((String) s));
                    } else
                        html.set(s);
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }
        CharSequence newValue = html.get();
        if (!view.getText().toString().equals(newValue)) {
            if (newValue instanceof String) {
                view.setText(Html.fromHtml((String) newValue));
            } else
                view.setText(newValue);
        }
    }


    @BindingAdapter("phoneTextHidden")
    public static void setHiddenPhoneText(TextView v, String phone) {
        if (!TextUtils.isEmpty(phone) && phone.length() > 7) {
            StringBuilder sb = new StringBuilder();
            sb.append(phone.substring(0, 3)).append("****").append(phone.substring(7, phone.length()));
            v.setText(sb.toString());
        }
    }

    @BindingAdapter("cardTextHidden")
    public static void setHiddenCardText(TextView v, String card) {
        if (!TextUtils.isEmpty(card) && card.length() > 8) {
            StringBuilder sb = new StringBuilder();
            sb.append(card.substring(0, 4)).append(" **** **** ").append(card.substring(card.length() - 4, card
                    .length()));
            v.setText(sb.toString());
        }
    }

    @BindingAdapter("IDCardTextHidden")
    public static void setHiddenIDCardText(TextView v, String card) {
        if (!TextUtils.isEmpty(card) && card.length() > 8) {
            StringBuilder sb = new StringBuilder();
            sb.append(card.substring(0, 3)).append("********").append(card.substring(card.length() - 4, card
                    .length()));
            v.setText(sb.toString());
        }
    }


    @BindingAdapter("binding")
    public static void bindEditText(TextView view, final BindableString bindableString) {
        if (view.getTag(R.id.databinding_binded) == null) {
            view.setTag(R.id.databinding_binded, true);
            view.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    bindableString.set(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }
        String newValue = bindableString.get();
        if (!view.getText().toString().equals(newValue)) {
            view.setText(newValue);
        }
    }


    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, int resId) {
        view.setImageResource(resId);
    }


    @BindingAdapter("textColor")
    public static void setTextColor(TextView v, int textColor) {
        v.setTextColor(ColorStateList.valueOf(textColor));
    }

    @BindingAdapter("backgroundColor")
    public static void setBgColor(View v, int textColor) {
        v.setBackgroundColor(textColor);
    }

    @BindingAdapter("drawable")
    public static void setImageDrawable(ImageView imageView, Drawable drawable) {
        if (imageView != null && drawable != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    @BindingAdapter("bitmap")
    public static void setImageBitmap(ImageView imageView, Bitmap drawable) {
        if (imageView != null && drawable != null) {
            imageView.setImageBitmap(drawable);
        }
    }

    @BindingAdapter("checkedBind")
    public static void bindCheckBox(final CheckBox checkBox, final ObservableBoolean observableBoolean) {
        checkBox.setChecked(observableBoolean.get());
        observableBoolean.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                checkBox.setChecked(observableBoolean.get());
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b != observableBoolean.get())
                    observableBoolean.set(b);
            }
        });

    }

    @BindingAdapter("enable")
    public static void enable(final View view, final ObservableBoolean enable) {
        view.setEnabled(enable.get());
        enable.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                view.setEnabled(enable.get());
            }
        });
    }

}
