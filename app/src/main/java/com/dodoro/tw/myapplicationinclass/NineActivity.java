package com.dodoro.tw.myapplicationinclass;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NineActivity extends AppCompatActivity implements View.OnClickListener{

    Integer choice;
    Button btn1,btn2,btn3;
    FloatingActionButton fab ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine);

        btn1 =(Button)findViewById(R.id.button1);
        btn2 =(Button)findViewById(R.id.button2);
        btn3 =(Button)findViewById(R.id.button3);
        fab = (FloatingActionButton)findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);



    }

    @Override
    public void onClick(final View v) {
        switch (v.getId())
        {
            case R.id.button1:
                new AlertDialog.Builder(NineActivity.this).setTitle("對話框標題").setMessage("第一個對話框").setCancelable(false).setPositiveButton("確認", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Snackbar.make(v,"按下確認鍵了",Snackbar.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Snackbar.make(v,"按下取消鍵了",Snackbar.LENGTH_SHORT).show();
                    }
                }).setNeutralButton("略過", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Snackbar.make(v,"按下了略過鈕",Snackbar.LENGTH_SHORT).show();
                    }
                }).show();
                break;
            case R.id.button2:
                final EditText ed = new EditText(NineActivity.this);
                new AlertDialog.Builder(NineActivity.this).setTitle("對話標題2").setMessage("輸入訊息").setView(ed).setPositiveButton("確認", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TextView tv1 = (TextView)findViewById(R.id.textView1);
                        tv1.setText(ed.getText().toString());
                    }
                }).show();

                break;
            case R.id.floatingActionButton:
                Snackbar.make(v, "由下方跑出訊息", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                break;
            case R.id.button3:
                final String str[] = {"可樂", "紅茶", "汽水", "果汁"};
                Snackbar.make(v,String.valueOf(choice),Snackbar.LENGTH_SHORT).show();
                new AlertDialog.Builder(NineActivity.this).setTitle("單選對話").setCancelable(false).setSingleChoiceItems(str, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        choice = which;
                    }
                }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(choice != null) {
                            Toast.makeText(NineActivity.this, String.valueOf(which), Toast.LENGTH_SHORT).show();
                            TextView tv2 = (TextView) findViewById(R.id.textView2);
                            tv2.setText(str[choice]);
                        }
                    }
                }).show();
                break;
        }

    }
}
