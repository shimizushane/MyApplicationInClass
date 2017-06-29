package com.dodoro.tw.myapplicationinclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }
    public void click2(View v)
    {
        EditText ed1 = (EditText)findViewById(R.id.editText1);
        Intent it = new Intent();
        it.putExtra("username",ed1.getText().toString());

        setResult(RESULT_OK,it);
        finish();
    }
}
