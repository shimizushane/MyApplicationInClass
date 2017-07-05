package com.dodoro.tw.myapplicationinclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class EightActivity extends AppCompatActivity {
    AutoCompleteTextView act;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight);

        act = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);

        String[] str = {"AA","AABB","ABC","BBB","BBC"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(EightActivity.this,android.R.layout.simple_spinner_item,str);
        act.setAdapter(adapter);
        act.setThreshold(1);
    }
}
