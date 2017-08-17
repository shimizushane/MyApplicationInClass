package com.dodoro.tw.myapplicationinclass;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NineActivity extends AppCompatActivity implements View.OnClickListener{
    boolean chks[] = new boolean[4];
    boolean chkstemp[] = new boolean[4];
    Integer choice,temp;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    FloatingActionButton fab ;
    AlertDialog cdiag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine);

        btn1 =(Button)findViewById(R.id.button1);
        btn2 =(Button)findViewById(R.id.button2);
        btn3 =(Button)findViewById(R.id.button3);
        btn4 =(Button)findViewById(R.id.save);
        btn5 =(Button)findViewById(R.id.read);
        btn6 =(Button)findViewById(R.id.button6);
        btn7 =(Button)findViewById(R.id.button7);
        fab = (FloatingActionButton)findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);


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
                Snackbar.make(v,String.valueOf(choice),Snackbar.LENGTH_INDEFINITE).setAction("測試按鍵", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
                new AlertDialog.Builder(NineActivity.this).setTitle("單選對話").setCancelable(true).setSingleChoiceItems(str,choice==null?-1:choice,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        temp = which;
                    }
                }).setPositiveButton("確認", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        choice = temp;
                        if(choice != null) {
//                            Toast.makeText(NineActivity.this, String.valueOf(which), Toast.LENGTH_SHORT).show();
                            TextView tv2 = (TextView) findViewById(R.id.textView2);
                            tv2.setText(str[choice]);
                        }
                        /*
                        else
                            Snackbar.make(v,"你沒點選喔!!",Snackbar.LENGTH_SHORT).show();*/
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        choice = null;
                        TextView tv2 = (TextView) findViewById(R.id.textView2);
                        tv2.setText("");
                    }
                }).show();
                break;
            case R.id.save:
                final String str1[] = {"可樂", "紅茶", "汽水", "果汁"};
                new AlertDialog.Builder(NineActivity.this).setTitle("列表對話框").setItems(str1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Snackbar.make(v,"列表對話",Snackbar.LENGTH_SHORT).setAction("顯示", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).show();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
                break;
            case R.id.read:
                final String str2[] = {"可樂", "紅茶", "汽水", "果汁"};
                final TextView tv4 = (TextView)findViewById(R.id.textView4);
                chkstemp = chks.clone();
                new AlertDialog.Builder(NineActivity.this).setTitle("多選題").setMultiChoiceItems(str2,chkstemp, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                }).setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String item = "";
                        chks = chkstemp.clone();
                        for(int i = 0;i< chks.length;i++) {
                            if (chks[i] == true)
                                item = item + str2[i] + ",";
                        }
                        tv4.setText(item);
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
                break;
            case R.id.button6:

//              重要: 解壓器，主因是在diag對話框的按鍵是存在於diag中，而非View
//              應用於動態View中
//              inflater 是用尋找 res/layout下的 xml 布局文件，并且实例化
//              LayoutInflater作用是將layout的xml布局文件實例化为View類對象。
                LayoutInflater inflater = LayoutInflater.from(NineActivity.this);
                View diagView = inflater.inflate(R.layout.diag_layout,null);
                Button btn_diag = (Button)diagView.findViewById(R.id.button1);
                final EditText ed_diag = (EditText)diagView.findViewById(R.id.editText1);

                btn_diag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(NineActivity.this,ed_diag.getText().toString(),Toast.LENGTH_SHORT).show();
                        cdiag.dismiss();
                    }
                });
//              加入diagView的設定
                cdiag = new AlertDialog.Builder(NineActivity.this).setTitle("自訂對話框").setView(diagView).show();
                break;
            case R.id.button7:
//              多執行緒作法
                final ProgressDialog pd = new ProgressDialog(NineActivity.this);
                pd.show();
                new Thread(){
                    public void run(){
                        super.run();
                        try {
                            Thread.sleep(1000);
                        }catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                        pd.dismiss();
                    }
                } .start();
        }

    }
}
