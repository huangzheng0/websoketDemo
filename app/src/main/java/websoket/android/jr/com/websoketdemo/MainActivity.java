package websoket.android.jr.com.websoketdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import websoket.android.jr.com.websoketdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private final String host = "";


    private final int port = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mainBinding.webPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WebActivity.class);
                startActivity(intent);
            }
        });
        mainBinding.monoteMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MNoteWindow window = new MNoteWindow(MainActivity.this);
                window.show();
            }
        });
    }
}
