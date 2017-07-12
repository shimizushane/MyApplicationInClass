package com.dodoro.tw.myapplicationinclass;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class TwelveActivity extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twelve);

        constraintLayout = (ConstraintLayout)findViewById(R.id.layout1);
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
}
