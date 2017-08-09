package com.dodoro.tw.myapplicationinclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SeventeenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventeen);
    }
    public void click1 (View v) throws JSONException {
        JSONArray array = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("temerature","30.5");
        obj.put("humi","80");
        array.put(obj);
        JSONObject obj1 = new JSONObject();
        obj1.put("temerature","35");
        obj1.put("humi","50");
        array.put(obj1);


        Log.d("JSON",array.toString());

    }
//  gson to json arraylist 物件轉Json
    public void click2 (View v)
    {
        MyData myData = new MyData();
        myData.temp = 32.5;
        myData.humi = 45;

        Gson gson = new Gson();
        Log.d("GSON",gson.toJson(myData));
    }
//    gson to json arraylist 物件轉Json 陣列形式
    public void click3 (View v)
    {
        ArrayList<MyData> mylist = new ArrayList<>();
        MyData myData = new MyData();
        myData.temp = 32.5;
        myData.humi = 45;
        mylist.add(myData);

        MyData myData2 = new MyData();
        myData2.temp = 28.5;
        myData2.humi = 65;
        mylist.add(myData2);

        Gson gson = new Gson();
        Log.d("GSON",gson.toJson(mylist));
    }
    public void click4 (View v)
    {
        String str = "{\"humi\":45,\"temp\":32.5}";
        Gson gson = new Gson();
        MyData data = gson.fromJson(str, MyData.class);
        Log.d("JSON","data:" + data.temp);
    }
    public void click5 (View v)
    {
        String str = "[{\"humi\":45,\"temp\":32.5},{\"humi\":65,\"temp\":28.5}]";
        Gson gson = new Gson();
        ArrayList<MyData> mylist = gson.fromJson(str, new TypeToken<List<MyData>>(){}.getType());
        Log.d("JSON", String.valueOf(mylist.get(0).temp));
    }
}
