package com.dodoro.tw.myapplicationinclass;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NineteenActivity extends AppCompatActivity {

    TextView tv, tv1, tv2;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nineteen);

        tv = (TextView)findViewById(R.id.textView1);
        tv1 = (TextView)findViewById(R.id.textView2);
        tv2 = (TextView)findViewById(R.id.textView3);
        img = (ImageView)findViewById(R.id.imageView);
    }
    public void click1(View v)
    {
        new GetData().start();
    }
    public void click2(View v)
    {
        new GetData2().start();
    }
    public void click3(View v)
    {
        new GetImage().start();
    }

//    多執行續抓資料
    class GetData extends Thread
    {
        @Override
        public void run(){
            super.run();

            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Log.d("0809","test");
//            tv.setText("test2");          TextView 的建立只能在主執行續被執行，在其他執行續執行會有錯誤
//            因此，在副執行續執行後，要傳回主執行續做修改

//          下面會在主執行續執行
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tv.setText("test2");
                }
            });
        }
    }

    class GetData2 extends Thread
    {
        String str;
        @Override
        public void run() {
            super.run();
            String str_url = "http://data.ntpc.gov.tw/od/data/api/BF90FA7E-C358-4CDA-B579-B6C84ADC96A1?$format=json";
            try {
                URL url = new URL(str_url);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();
                InputStream stream = conn.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(stream));
                str = br.readLine();
                br.close();
                stream.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tv1.setText(str);
                }
            });

        }
    }

    class GetImage extends Thread
    {
        String str;
        int length;
        int fullsize;
        byte[] result;
        int total;
        @Override
        public void run() {
            super.run();
            String str_url = "https://sdl-stickershop.line.naver.jp/stickershop/v1/sticker/8902029/android/sticker.png";
            try {
                URL url = new URL(str_url);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();
                fullsize = conn.getContentLength();
                InputStream stream = conn.getInputStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] data = new byte[64];
                total = 0;
                while ((length = stream.read(data)) != -1)
                {
                    outputStream.write(data, 0, length);
                    total += length;

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv2.setText(total + "/" + fullsize);
                        }
                    });
                };
                result = outputStream.toByteArray();

                stream.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(result, 0, total);
                    ImageView img = (ImageView) findViewById(R.id.imageView);
                    img.setImageBitmap(bitmap);
                }
            });

        }
    }
}
