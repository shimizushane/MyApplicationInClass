package com.dodoro.tw.myapplicationinclass;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

/**
 * Created by YVTC on 2017/7/19.
 */

class MyAdapter extends BaseAdapter {

    private String cities[];
    private boolean ischeckeditem[];
    Context context;
    public MyAdapter(String cities[],boolean ischeckeditem[],Context context)
    {
        this.cities = cities;
        this.ischeckeditem = ischeckeditem;
        this.context = context;
    }
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


        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.myadapter_layout,null);

        CheckBox chk =(CheckBox)v.findViewById(R.id.checkBox1);
        //避免滑動而消失
        chk.setText(cities[position]);
        TextView tv = (TextView)v.findViewById(R.id.textView1);
        tv.setText(cities[position]);

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
