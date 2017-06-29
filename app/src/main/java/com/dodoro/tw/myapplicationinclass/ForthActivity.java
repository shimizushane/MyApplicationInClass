package com.dodoro.tw.myapplicationinclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ForthActivity extends AppCompatActivity implements View.OnClickListener{
    /*
    網路上的用法，直接實作View.OnClickListener就可以直接Override onClick()，而不用new View.OnClickListener再去Override onClick()
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);

        Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);
        /*
        btn1.setOnClickListener(btnlisten);
        btn2.setOnClickListener(btnlisten);
        btn3.setOnClickListener(btnlisten);
        */

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        /*
            推測this所帶入的是ForthActivity，主因在於ForthActivity有實作View.OnClickListener
         */
    }
    /*
    private Button.OnClickListener btnlisten = new View.OnClickListener() {
        */
        @Override
        public void onClick(View v) {
            TextView t2 = (TextView) findViewById(R.id.textView1);
            t2.setText(((TextView) v).getText().toString());
            //button物件會傳入View v，再由View v轉成子類別TextView後才能使用TextView的getText()取出Button的Text

                /*
                switch(v.getId()) {
                    case R.id.button1:
                        t2.setText("111");
                        break;
                    case R.id.button2:
                        t2.setText("222");
                        break;
                    case R.id.button3:
                        t2.setText("333");
                        break;
                    */
        }
        /*
    };
    */
}
