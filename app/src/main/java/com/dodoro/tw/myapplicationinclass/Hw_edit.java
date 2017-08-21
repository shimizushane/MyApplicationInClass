package com.dodoro.tw.myapplicationinclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

public class Hw_edit extends AppCompatActivity {

    ListView lv;
    ArrayList list;
    SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw_edit);

        lv = (ListView)findViewById(R.id.listview_edit);
    }
}
