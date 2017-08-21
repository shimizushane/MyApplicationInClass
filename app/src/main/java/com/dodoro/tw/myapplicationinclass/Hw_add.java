package com.dodoro.tw.myapplicationinclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dodoro.tw.myapplicationinclass.data.*;
public class Hw_add extends AppCompatActivity {

    EditText edId, edName, edTel;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw_add);

        edId = (EditText)findViewById(R.id.editText_id_input);
        edName = (EditText)findViewById(R.id.editText_name_input);
        edTel = (EditText)findViewById(R.id.editText_tel_input);
        btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.putExtra("id",edId.getText().toString());
                it.putExtra("name",edName.getText().toString());
                it.putExtra("tel",edTel.getText().toString());

                setResult(RESULT_OK,it);
                finish();
            }
        });

    }
}
