package com.dodoro.tw.myapplicationinclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class FourteenActivity extends AppCompatActivity {
    ListView listView;
    String cities[] = {"台北","台中","台南","高雄","台北1","台中1","台南1","高雄1","台北2","台中2","台南2","高雄2","台北3","台中3","台南3","高雄3","台北4","台中4","台南4","高雄4"};
    boolean ischeckeditem[];


    ArrayList<HashMap<String,String>> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourteen);

        ischeckeditem = new boolean[cities.length];
        listView = (ListView) findViewById(R.id.listview1);
        MyAdapter myadapter = new MyAdapter(cities,ischeckeditem,FourteenActivity.this);
        listView.setAdapter(myadapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.myadapter_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        StringBuilder sb = new StringBuilder();
        switch(item.getItemId())
        {
            case R.id.item1:
                for(int i = 0;i<cities.length;i++)
                {
                    if(ischeckeditem[i])
                        sb.append(cities[i] + ",");
                }
                Toast.makeText(FourteenActivity.this,sb.toString(),Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    /*
    class MyAdapter extends BaseAdapter{

            @Override
            public int getCount() {
                return cities.length;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            //只會執行螢幕所顯示的List
            public View getView(final int position, View convertView, ViewGroup parent) {

                Log.d("MyView", "getView position:" + position);


                LayoutInflater layoutInflater = LayoutInflater.from(FourteenActivity.this);
                View v = layoutInflater.inflate(R.layout.myadapter_layout,null);

                CheckBox chk =(CheckBox)v.findViewById(R.id.checkBox1);

                chk.setText(cities[position]);
                TextView tv = (TextView)v.findViewById(R.id.textView1);
                tv.setText(cities[position]);
                //避免滑動而消失
                chk.setChecked(ischeckeditem[position]);
                chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        ischeckeditem[position] = isChecked;
                    }
                });
                return v;
            }
        }
        */
}
