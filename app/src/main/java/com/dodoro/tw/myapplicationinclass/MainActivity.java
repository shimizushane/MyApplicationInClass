package com.dodoro.tw.myapplicationinclass;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int REQUEST_CODE_NAME = 321;

    private Button btn;
    private TextView t1;
    private EditText ed1,ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("測試","這是onCreate");

        inital();
        /*
        btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v)
            {
                Integer sum = Integer.valueOf(ed1.getText().toString())+Integer.valueOf((ed2.getText().toString()));
                t1.setText(sum.toString());
            }
        });
        */
    }

    public void inital()
    {
        btn = (Button)findViewById(R.id.button);
        t1 = (TextView)findViewById(R.id.textView2);
        ed1 = (EditText)findViewById(R.id.editText1);
        ed2 = (EditText)findViewById(R.id.editText2);
    }
    public void click2(View v)
    {
        startActivity(new Intent(MainActivity.this,SecActivity.class));
    }

    public void click3(View v)
    {
        startActivity(new Intent().setAction("test123"));
    }


    public void click1(View v)
    {
        Intent it = new Intent(MainActivity.this,SecActivity.class);
/*
        int a = Integer.valueOf(ed1.getText().toString());
        int b = Integer.valueOf(ed2.getText().toString());
*/
        Bundle bun = new Bundle();
        bun.putInt("va",Integer.valueOf(ed1.getText().toString()));
        bun.putInt("vb",Integer.valueOf(ed2.getText().toString()));
        it.putExtras(bun);

        startActivity(it);
        /*
        Integer sum = Integer.valueOf(ed1.getText().toString())+Integer.valueOf((ed2.getText().toString()));
        t1.setText(sum.toString());
        */
    }

    public void toPage3(View v)
    {
        startActivityForResult((new Intent(MainActivity.this,ThirdActivity.class)),REQUEST_CODE_NAME);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == REQUEST_CODE_NAME) {
            if (resultCode == RESULT_OK) {
                TextView tv2 = (TextView) findViewById(R.id.textView3);
                tv2.setText(data.getStringExtra("username"));
            }
        }
    }
    public void clickweb(View v)
    {
        Uri uri = Uri.parse("http://tw.yahoo.com");
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
    public void clicktel(View v)
    {
        Uri uri = Uri.parse("tel:0912345678");
        startActivity(new Intent(Intent.ACTION_DIAL,uri));
    }
    public void clickmap(View v)
    {
        Uri uri = Uri.parse("geo:0,0?q=中壢火車站");
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
    public void clickshare(View v)
    {
        Intent intentshare = new Intent();
        intentshare.setAction(Intent.ACTION_SEND);
        intentshare.setType("text/plain");
        EditText ed1 = (EditText)findViewById(R.id.editText3);
        intentshare.putExtra(Intent.EXTRA_TEXT,ed1.getText().toString());
        startActivity(Intent.createChooser(intentshare,"選擇分享對象"));
    }
    public void clickforth(View v)
    {
        startActivity(new Intent().setAction("forthpage"));
    }
    public void clickfive(View v)
    {
        startActivity(new Intent().setAction("fivepage"));
    }
    public void clicksix(View v)
    {
        startActivity(new Intent().setAction("sixpage"));
    }
    public void clickseven(View v)
    {
        startActivity(new Intent().setAction("sevenpage"));
    }
    public void clickeight(View v)
    {
        startActivity(new Intent().setAction("eightpage"));
    }

    public void clickimage(View v)
    {
        startActivity(new Intent().setAction("imagepage"));
    }
    public void clickwebvideo(View v)
    {
        startActivity(new Intent().setAction("webvideopage"));
    }
    public void clicknine(View v)
    {
        startActivity(new Intent().setAction("ninepage"));
    }
    public void clickten(View v)
    {
        startActivity(new Intent(MainActivity.this,TenActivity.class));
    }
    public void clickeleven(View v)
    {
        startActivity(new Intent(MainActivity.this,ElevenActivity.class));
    }

    public void clicktwelve(View v)
    {
        startActivity(new Intent(MainActivity.this,TwelveActivity.class));
    }
    public void clickthirteen(View v)
    {
        startActivity(new Intent(MainActivity.this,ThirteenActivity.class));
    }

    public void clickfourteen(View v)
    {
        startActivity(new Intent(MainActivity.this,FourteenActivity.class));
    }

    public void clickfifteen(View v)
    {
        startActivity(new Intent(MainActivity.this,FifteenActivity.class));
    }

    public void clicksixteen(View v)
    {
        startActivity(new Intent(MainActivity.this,SixteenActivity.class));
    }

    public void clickdrawerlayout(View v)
    {
        startActivity(new Intent(MainActivity.this,DrawerLayoutActivity.class));
    }

    public void clickseventeen(View v)
    {
        startActivity(new Intent(MainActivity.this,SeventeenActivity.class));
    }
    public void clickeightteen(View v)
    {
        startActivity(new Intent(MainActivity.this,EightteenActivity.class));
    }
    public void clicknineteen(View v)
    {
        startActivity(new Intent(MainActivity.this,NineteenActivity.class));
    }
    public void clicktwenty(View v)
    {
        startActivity(new Intent(MainActivity.this,TwentyActivity.class));
    }
    public void clicktwentyone(View v)
    {
        startActivity(new Intent(MainActivity.this,TwentyOneActivity.class));
    }
    public void clicktwentytwo(View v)
    {
        startActivity(new Intent(MainActivity.this,TwentyTwoActivity.class));
    }

}
