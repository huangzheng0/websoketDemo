package websoket.android.jr.com.websoketdemo;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import okhttp3.WebSocket;
import ua.naiksoftware.stomp.LifecycleEvent;
import ua.naiksoftware.stomp.Stomp;
import ua.naiksoftware.stomp.client.StompClient;

/**
 * Author:zarle.
 * Created on 17-9-25.
 */

class WebSocketServiceImp {
    private StompClient mStompClient;

    private String TAG = "WebSocketServiceImp";

    void connect() {
        mStompClient = Stomp.over(WebSocket.class, "ws://10.0.2.2:8080/example-endpoint/websocket");
        mStompClient.connect();
        mStompClient.lifecycle().subscribe(new Subscriber<LifecycleEvent>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(LifecycleEvent lifecycleEvent) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    void disConnect() {
        if (mStompClient != null && (mStompClient.isConnected()) || mStompClient.isConnecting()) {
            mStompClient.disconnect();
        }
    }
}
