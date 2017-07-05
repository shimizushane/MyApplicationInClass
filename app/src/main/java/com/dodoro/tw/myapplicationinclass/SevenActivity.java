package com.dodoro.tw.myapplicationinclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SevenActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener ,View.OnClickListener,SeekBar.OnSeekBarChangeListener{

    CheckBox ck1;
    CheckBox ck2;
    RadioButton rb1;
    RadioButton rb2;
    RadioGroup rg1;
    Button bt1,btn2;
    Switch sw1;
    ArrayList<CheckBox> chklist;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven);

        ck1 = (CheckBox)findViewById(R.id.checkBox1);
        ck2 = (CheckBox)findViewById(R.id.checkBox2);
        rb1 = (RadioButton)findViewById(R.id.radioButton1);
        rb2 = (RadioButton)findViewById(R.id.radioButton2);
        rg1 = (RadioGroup)findViewById(R.id.RadioGroup1);
        bt1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        sw1 = (Switch)findViewById(R.id.switch1);
        seekBar = (SeekBar)findViewById(R.id.seekBar1);

        chklist = new ArrayList<>();

        chklist.add(ck1);
        chklist.add(ck2);

        ck1.setOnCheckedChangeListener(this);
        ck2.setOnCheckedChangeListener(this);
        rb1.setOnCheckedChangeListener(this);
        rb2.setOnCheckedChangeListener(this);
        sw1.setOnCheckedChangeListener(this);
        bt1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        seekBar.setOnSeekBarChangeListener(this);


    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch(buttonView.getId())
        {
            case R.id.checkBox1:
                Toast.makeText(SevenActivity.this,buttonView.getText().toString() +isChecked,Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBox2:
                Toast.makeText(SevenActivity.this,buttonView.getText().toString() +isChecked,Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton1:
                Toast.makeText(SevenActivity.this,buttonView.getText().toString() +isChecked,Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton2:
                Toast.makeText(SevenActivity.this,buttonView.getText().toString() +isChecked,Toast.LENGTH_SHORT).show();
                break;
            case R.id.switch1:
                Toast.makeText(SevenActivity.this,buttonView.getText().toString() + isChecked,Toast.LENGTH_SHORT).show();
                break;

        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button2)
        {
            ProgressBar pb1 = (ProgressBar)findViewById(R.id.progressBar2);
            pb1.setProgress(pb1.getProgress()+10);
        }

        else
        {
            for (CheckBox chk : chklist) {
                if (chk.isChecked())
                    Toast.makeText(SevenActivity.this, chk.getText().toString() + " foreach ", Toast.LENGTH_SHORT).show();
            }
        }
        switch (rg1.getCheckedRadioButtonId())
        {
            case R.id.radioButton1:
                Toast.makeText(SevenActivity.this,"R1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton2:
                Toast.makeText(SevenActivity.this,"R2",Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        TextView tv1 = (TextView)findViewById(R.id.textView1);
        tv1.setText(String.valueOf(progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
