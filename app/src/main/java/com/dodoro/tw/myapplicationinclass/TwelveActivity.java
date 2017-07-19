package com.dodoro.tw.myapplicationinclass;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class TwelveActivity extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twelve);

        constraintLayout = (ConstraintLayout)findViewById(R.id.layout1);

        tv1 = (TextView)findViewById(R.id.textView1);
        registerForContextMenu(tv1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        for(int i = 3 ; i < 6 ; i++)
            menu.add(Menu.NONE,Menu.FIRST + i,Menu.NONE , "item " +i);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_setting:
                Snackbar.make(constraintLayout,"設定",Snackbar.LENGTH_SHORT).show();
                break;
            case Menu.FIRST + 3:
                Snackbar.make(constraintLayout,"item 3",Snackbar.LENGTH_SHORT).show();
                break;
            case Menu.FIRST + 4:
                Snackbar.make(constraintLayout,"item 4",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.menu_about:
                Snackbar.make(constraintLayout,"關於",Snackbar.LENGTH_SHORT).show();
                break;
            case Menu.FIRST + 5:
                Snackbar.make(constraintLayout,"item 5",Snackbar.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add("aaa");
        menu.add("bbb");
        menu.add("ccc");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getTitle().toString()) {
            case "aaa":
                Snackbar.make(constraintLayout,"測試contextmenu AAA",Snackbar.LENGTH_SHORT).show();
                break;
            case "bbb":
                Snackbar.make(constraintLayout,"測試contextmenu BBB",Snackbar.LENGTH_SHORT).show();
                break;
            case "ccc":
                Snackbar.make(constraintLayout,"測試contextmenu CCC",Snackbar.LENGTH_SHORT).show();
                break;

        }
        /*
        if(item.getTitle().equals("aaa"))
        {
            Snackbar.make(constraintLayout,"測試contextmenu",Snackbar.LENGTH_SHORT).show();
        }
        */
        return super.onContextItemSelected(item);
    }
}
