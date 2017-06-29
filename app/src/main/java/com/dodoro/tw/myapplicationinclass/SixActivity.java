package com.dodoro.tw.myapplicationinclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SixActivity extends AppCompatActivity {

    Spinner spinner;
    Spinner spinner2;
    Button btn1,btn2;
    TextView t2;
    ArrayList<String> mylist;
    EditText ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);

        spinner2 =(Spinner)findViewById(R.id.spinner2);
        spinner =(Spinner)findViewById(R.id.spinner);
        t2 = (TextView)findViewById(R.id.textView2);
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        ed1 = (EditText)findViewById(R.id.editText1);
/*
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                Toast.makeText(SixActivity.this,tv.getText().toString(),Toast.LENGTH_SHORT).show();
//                用view取得spinner的選單

                TextView tv1 =(TextView)findViewById(R.id.textView1);
                tv1.setText(tv.getText().toString());

//                String cityArray[] = getResources().getStringArray(R.array.city);
//                Toast.makeText(SixActivity.this,cityArray[position],Toast.LENGTH_SHORT).show();
//                先建立一個array取得res中的StringArrayy資料，再依position取得spinner的資訊

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
*/
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //重點再重新抓取spinner被選擇的item
                int sel = spinner.getSelectedItemPosition();
                //多了取得spinner陣列資源
                String cityArray[] = getResources().getStringArray(R.array.city);
                t2.setText(cityArray[sel]);
            }
        });

        mylist = new ArrayList<>();
        mylist.add("蘋果");
        mylist.add("香蕉");
        mylist.add("鳳梨");
        mylist.add("芭樂");
//        String[] arr2 = {"蘋果","香蕉","鳳梨","芭樂"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SixActivity.this,android.R.layout.simple_spinner_item,/*arr2*/mylist);
        spinner2.setAdapter(adapter);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mylist.add(ed1.getText().toString());
            }
        });
    }
}
