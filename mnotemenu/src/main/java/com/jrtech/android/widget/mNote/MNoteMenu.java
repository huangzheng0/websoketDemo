package com.jrtech.android.widget.mNote;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import websoket.android.jr.com.mnotemenu.R;
import websoket.android.jr.com.mnotemenu.databinding.WidgetMnoteStationaryMenuBinding;

/**
 * Author:zarle.
 * Created on 17-10-10.
 */

public class MNoteMenu extends LinearLayout implements IMNoteStationaryMenu {

    boolean mExpand;

    View mStationaryMenu;

    View mContent;

    final StationaryMenuViewModel mStationaryMenuViewModel = new StationaryMenuViewModel(this);


    public interface OnExpandStateChangedListener {
        void onExpandStateChanged(boolean expand);
    }


    public MNoteMenu(Context context) {
        super(context);
        setUpMenu();
    }

    public MNoteMenu(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setUpMenu();
    }

    public MNoteMenu(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setUpMenu();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MNoteMenu(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setUpMenu();
    }

    @Override
    public void onMenuClicked(Menu type) {
        if (type == Menu.KEY_BROAD)
            setExpand(!mExpand);
    }

    public void setExpand(boolean expand) {
        this.mExpand = expand;
        mContent.setVisibility(expand ? View.VISIBLE : GONE);
    }

    public boolean isExpand() {
        return mExpand;
    }


    private void setUpMenu() {
        inflate(getContext(), R.layout.widget_mnote_menu, this);
        mContent = findViewById(R.id.content);
        initStationaryMenu();
        initOperationMenu();
        setExpand(mExpand);
    }


    private void initStationaryMenu() {
        WidgetMnoteStationaryMenuBinding binding = DataBindingUtil.bind(mStationaryMenu = findViewById(R.id
                .stationary_menu));
        binding.setMNoteStationaryMenu(mStationaryMenuViewModel);
        binding.setModel(mStationaryMenuViewModel);
    }

    private void initOperationMenu() {

    }


}
