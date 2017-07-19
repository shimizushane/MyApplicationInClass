package com.dodoro.tw.myapplicationinclass;

import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ThirteenActivity extends AppCompatActivity {

    ArrayList<HashMap<String,Object>> list2;
    ListView lv;
    ConstraintLayout constraintLayout;
    String cities[] = {"台北","台中","台南","高雄"};
    String codes[] = {"02","04","06","07"};
    int images[] = {R.drawable.tai,R.drawable.ch,R.drawable.na,R.drawable.ka};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirteen);


        list2 = new ArrayList<>();
        for(int i =0 ;i<4;i++) {
            HashMap<String, Object> m1 = new HashMap<>();
            m1.put("city", cities[i]);
            m1.put("code", codes[i]);
            m1.put("image",images[i]);
            list2.add(m1);
        }

        SimpleAdapter adapter2 = new SimpleAdapter(ThirteenActivity.this,list2,R.layout.listview_layout,new String[]{"city","code","image"},new int[]{R.id.textView1,R.id.textView2,R.id.imageView1});


        constraintLayout = (ConstraintLayout)findViewById(R.id.layout1) ;
        lv =(ListView)findViewById(R.id.listView);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ThirteenActivity.this,android.R.layout.simple_list_item_1,cities);
        lv.setAdapter(adapter2);
        /*
        Q.itemselected 與 itemclick 差異

        lv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(view,cities[position],Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Snackbar.make(constraintLayout,"沒有選擇",Snackbar.LENGTH_SHORT).show();

            }
        });
        */

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Snackbar.make(view,cities[position] +" "+ codes[position],Snackbar.LENGTH_SHORT).show();
            }
        });

    }
}
