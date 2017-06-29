package com.dodoro.tw.myapplicationinclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

//注意這一行
import static com.dodoro.tw.myapplicationinclass.R.id.button3;

public class FiveActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);


        Button btn1 = (Button)findViewById(R.id.button1);
        Button btn2 = (Button)findViewById(R.id.button2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        LinearLayout layout = (LinearLayout)findViewById(R.id.layout1);

        Button btn3 = new Button(FiveActivity.this);
        btn3.setText("BTN3");
        btn3.setId(button3);
        layout.addView(btn3);

        btn3.setOnClickListener(this);

        ToggleButton tb = (ToggleButton)findViewById(R.id.toggleButton1);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(FiveActivity.this,"現在的狀態: " + isChecked,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button1:
                Toast.makeText(FiveActivity.this,"這是第5頁",Toast.LENGTH_LONG).show();
                break;
            case R.id.button2:
                Button btn1 = (Button)findViewById(R.id.button1);
                if(btn1.getVisibility() == View.VISIBLE)
                    btn1.setVisibility(View.INVISIBLE);
                else
                    btn1.setVisibility(View.VISIBLE);
                Log.d("CLI","這是第5頁的 Click2");
                break;
            case R.id.button3:
                Toast.makeText(FiveActivity.this,"這是Button3",Toast.LENGTH_LONG).show();
                break;
        }

    }
}
