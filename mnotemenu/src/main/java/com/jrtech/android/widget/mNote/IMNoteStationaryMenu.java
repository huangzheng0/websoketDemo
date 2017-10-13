package com.jrtech.android.widget.mNote;

/**
 * Author:zarle.
 * Created on 17-10-11.
 */

public interface IMNoteStationaryMenu {


    void onMenuClicked(Menu type);

    enum Menu {
        ABC, TYPE, ADD_COMMENT, INSERT, UNDO, REDO, KEY_BROAD
    }


}
