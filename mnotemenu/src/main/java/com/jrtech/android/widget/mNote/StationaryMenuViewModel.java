package com.jrtech.android.widget.mNote;

import android.databinding.ObservableBoolean;

/**
 * Author:zarle.
 * Created on 17-10-11.
 */

public class StationaryMenuViewModel implements IMNoteStationaryMenu {

    public final ObservableBoolean abcEnable = new ObservableBoolean(true);

    public final ObservableBoolean typeEnable = new ObservableBoolean(true);

    public final ObservableBoolean addCommentEnable = new ObservableBoolean(true);

    public final ObservableBoolean insertEnable = new ObservableBoolean(true);

    public final ObservableBoolean undoEnable = new ObservableBoolean(true);

    public final ObservableBoolean redoEnable = new ObservableBoolean(true);

    public final ObservableBoolean keyBoardEnable = new ObservableBoolean(true);

    private final IMNoteStationaryMenu mNoteStationaryMenu;

    StationaryMenuViewModel(IMNoteStationaryMenu menu) {
        this.mNoteStationaryMenu = menu;
    }

    @Override
    public void onMenuClicked(Menu type) {
        mNoteStationaryMenu.onMenuClicked(type);
    }
}