package com.dodoro.tw.myapplicationinclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);


        int a = getIntent().getIntExtra("va",0);
        int b = getIntent().getExtras().getInt("vb",0);

        TextView text1 = (TextView)findViewById(R.id.textView);
        text1.setText(String.valueOf(a+b));
    }
}
