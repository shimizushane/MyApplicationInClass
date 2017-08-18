package com.dodoro.tw.myapplicationinclass;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class TwentyOneActivity extends AppCompatActivity implements Button.OnClickListener{

    Button btn,btn2,btn3,save,read,share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twenty_one);
        btn = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        save = (Button)findViewById(R.id.save);
        read = (Button)findViewById(R.id.read);
        share = (Button)findViewById(R.id.readshare);
        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        save.setOnClickListener(this);
        read.setOnClickListener(this);
        share.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Setting");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(TwentyOneActivity.this,SettingsActivity.class));
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                File f = new File(getFilesDir().getAbsolutePath() + File.separator + "test1.txt");
                try {
                    FileWriter fw = new FileWriter(f);
                    fw.write("Hello World!!");
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button2:
                File f1 = new File(getExternalFilesDir("Data").getAbsolutePath() + File.separator + "test2.txt");
                try {
                    FileWriter fw = new FileWriter(f1);
                    fw.write("Hello World!!");
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button3:
                int permission = ActivityCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE);
                if (permission != PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(this, new String[] {WRITE_EXTERNAL_STORAGE,READ_EXTERNAL_STORAGE},
                            123
                    );
                }
                else
                {
                    writeFile();
                }
                break;
            case R.id.save:
                SharedPreferences sp = getSharedPreferences("MYDATA", MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("DATA","123123");
                ed.commit();
                break;
            case R.id.read:
                SharedPreferences sp1 = getSharedPreferences("MYDATA",MODE_PRIVATE);
                String str = sp1.getString("DATA","000");
                Toast.makeText(TwentyOneActivity.this,str,Toast.LENGTH_SHORT).show();
                break;
            case R.id.readshare:
                SharedPreferences sp2 = getSharedPreferences(getPackageName() + "_preferences" , MODE_PRIVATE);
                String str1 = sp2.getString("example_text","000");
                Toast.makeText(TwentyOneActivity.this,str1,Toast.LENGTH_SHORT).show();
                break;

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode) {
            case 123:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //取得權限，進行檔案存取
                    writeFile();
                } else {
                    //使用者拒絕權限，停用檔案存取功能
                }
                return;
        }
    }

    private void writeFile()
    {
        Log.d("PERM", "test 123");
        File f3 = Environment.getExternalStorageDirectory();
        Log.d("EFILE",f3.getAbsolutePath());
        File ft = new File(f3.getAbsolutePath() + File.separator + "test3.txt");
        try {
            FileWriter fw = new FileWriter(ft);
            fw.write("Hello World!!");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
