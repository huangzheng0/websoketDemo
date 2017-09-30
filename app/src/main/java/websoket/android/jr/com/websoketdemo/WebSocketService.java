package websoket.android.jr.com.websoketdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class WebSocketService extends Service {
    public WebSocketService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    private void connect(){

    }



}
