package com.jinlin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.jinlin.util.MD5;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 待加密
        String strText = "J!nl!n";
        EditText et = (EditText) findViewById(R.id.et);
        et.setText(strText);

        // java
        final TextView tv2 = (TextView) findViewById(R.id.tv2);
        tv2.setText("java:   " + MD5.getMD5(strText));
        // ndk c
        final TextView tv3 = (TextView) findViewById(R.id.tv3);
        tv3.setText("ndk c: " + MD5.encryptByMD5(strText));

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                tv2.setText("java:   " + MD5.getMD5(s.toString()));
                tv3.setText("ndk c: " + MD5.encryptByMD5(s.toString()));
            }
        });
    }

    static {
        System.loadLibrary("md5");
    }
}

