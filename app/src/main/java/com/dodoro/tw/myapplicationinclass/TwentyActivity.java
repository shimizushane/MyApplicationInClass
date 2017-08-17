package com.dodoro.tw.myapplicationinclass;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


//AsyncTask介紹  目的是不使用多執行緒載圖

public class TwentyActivity extends AppCompatActivity {

    TextView tv, tv2;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twenty);
        tv = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        img = (ImageView) findViewById(R.id.imageView);
        MyTask task = new MyTask();
        task.execute("https://sdl-stickershop.line.naver.jp/stickershop/v1/sticker/8902029/android/sticker.png");

    }

    class MyTask extends AsyncTask<String, Integer, Bitmap>
    {
        @Override
//    在主執行緒上執行
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tv.setText(String.valueOf(values[0]));
        }

        @Override
//    副執行緒是不能改變主執行緒的內容，如: 在主執行緒上的tv.setText()
//    此函式是在另一個執行緒上運行，如要顯示其運行進度，需使用publishProgress(參數)，此方法會會將參數傳給onProgressUpdate()
        protected Bitmap doInBackground(String... params) {
            int length;
            int fullsize;
            byte[] result = null;
            int total = 0;

            String str_url = params[0];
            try {
                URL url = new URL(str_url);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();
                fullsize = conn.getContentLength();
                InputStream stream = conn.getInputStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] data = new byte[64];

                while ((length = stream.read(data)) != -1)
                {
                    outputStream.write(data, 0, length);
                    total += length;
                    int p = 100 * total / fullsize;
                    publishProgress(p);
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            tv2.setText(total + "/" + fullsize);
//                        }
//                    });

                };
                result = outputStream.toByteArray();



                stream.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            Bitmap bitmap = BitmapFactory.decodeByteArray(result, 0, total);

            return bitmap;

        }


        @Override
//    在主執行緒上執行
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            img.setImageBitmap(bitmap);
        }

    }


}