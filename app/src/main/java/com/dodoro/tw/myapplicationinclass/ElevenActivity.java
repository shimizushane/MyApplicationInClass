package com.dodoro.tw.myapplicationinclass;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ElevenActivity extends AppCompatActivity implements  View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleven);

        Button btn1 = new Button(ElevenActivity.this);
        btn1.setText("Click Me!!");
        btn1.setId(View.generateViewId());
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Click Me!!", Snackbar.LENGTH_SHORT).show();
            }
        });
        Button btn2 = new Button(ElevenActivity.this);
        btn2.setText("222");
        btn2.setId(View.generateViewId());
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"2222", Snackbar.LENGTH_SHORT).show();
            }
        });
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.layout1);

        LinearLayout.LayoutParams params =  new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        btn2.setLayoutParams(params);

        linearLayout.addView(btn1);
        linearLayout.addView(btn2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {


        }
    }
}
