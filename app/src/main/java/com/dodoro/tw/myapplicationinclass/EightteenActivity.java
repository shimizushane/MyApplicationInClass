package com.dodoro.tw.myapplicationinclass;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import static com.dodoro.tw.myapplicationinclass.R.id.imageView;

public class EightteenActivity extends AppCompatActivity {

    ImageView img ;
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eightteen);
        img = (ImageView) findViewById(R.id.imageView1);
        queue = Volley.newRequestQueue(EightteenActivity.this);
    }
//  volley 網路圖片存取
    public void click1(View v)
    {
        ImageRequest request = new ImageRequest("https://sdl-stickershop.line.naver.jp/stickershop/v1/sticker/8902029/android/sticker.png", new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                img.setImageBitmap(response);
            }
        }, 0, 0, ImageView.ScaleType.FIT_CENTER, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("VOLLEY",error.getMessage());
            }
        });
        queue.add(request);
        queue.start();
    }
//    picasso 網路圖片存取
    public void click2(View v)
    {
        Picasso.with(EightteenActivity.this)
                .load("https://sdl-stickershop.line.naver.jp/stickershop/v1/sticker/8902025/android/sticker.png")
                .into(img);
    }
}
