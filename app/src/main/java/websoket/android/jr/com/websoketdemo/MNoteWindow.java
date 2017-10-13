package websoket.android.jr.com.websoketdemo;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

/**
 * Author:zarle.
 * Created on 17-10-12.
 */

public class MNoteWindow {

    PopupWindow window;

    Activity parent;


    public MNoteWindow(Activity parent) {
        this.parent = parent;
        window = new PopupWindow(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams
                .MATCH_PARENT);
        View content = parent.getLayoutInflater().inflate(R.layout.window_mnote_menu, null, false);
        window.setContentView(content);
    }

    public void show() {
        if (parent.getWindow().getDecorView().getWindowToken() != null)
            window.showAtLocation(parent.getWindow().getDecorView(), Gravity.CENTER, 0, 0);
    }

}
