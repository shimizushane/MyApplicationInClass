package com.dodoro.tw.myapplicationinclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ImageActivity extends AppCompatActivity implements Button.OnClickListener {

    ImageButton ibtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        ibtn = (ImageButton)findViewById(R.id.imageButton);
        ibtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(ImageActivity.this,String.valueOf(v.getId()),Toast.LENGTH_SHORT).show();

    }
}
