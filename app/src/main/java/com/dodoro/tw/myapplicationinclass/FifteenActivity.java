package com.dodoro.tw.myapplicationinclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FifteenActivity extends AppCompatActivity {

    ArrayList<String> mylist;
    ListView lv;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifteen);

        mylist = new ArrayList<>();
        lv = (ListView)findViewById(R.id.listview1);
        arrayAdapter = new ArrayAdapter<String>(FifteenActivity.this,android.R.layout.simple_list_item_1,mylist);
        lv.setAdapter(arrayAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("get data");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RequestQueue queue = Volley.newRequestQueue(FifteenActivity.this);
        StringRequest request = new StringRequest("http://data.ntpc.gov.tw/od/data/api/BF90FA7E-C358-4CDA-B579-B6C84ADC96A1?$format=json", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("NET", response);
                try {
                    mylist.clear();
                    JSONArray array = new JSONArray(response);
                    for(int i = 0;i < array.length();i++)
                    {
                        JSONObject obj = array.getJSONObject(i);
                        String str = obj.get("district").toString();
                        Log.d("NET",str);
                        mylist.add(str);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                arrayAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);
        queue.start();

        return super.onOptionsItemSelected(item);
    }

}
