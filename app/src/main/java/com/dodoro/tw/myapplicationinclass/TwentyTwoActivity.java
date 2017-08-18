package com.dodoro.tw.myapplicationinclass;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dodoro.tw.myapplicationinclass.data.*;

import java.util.ArrayList;

public class TwentyTwoActivity extends AppCompatActivity implements View.OnClickListener{

    final int REQUEST_CODE_NAME = 111;

    ListView lv;
    ArrayList<String> mylist_name;
    ArrayAdapter<String> adapter;
    ImageButton ibtn_add, ibtn_search;
    Button btn_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twenty_two);

        mylist_name = new ArrayList<>();
        lv = (ListView)findViewById(R.id.listview);

        ibtn_add = (ImageButton) findViewById(R.id.imageButton_add);
        ibtn_search = (ImageButton) findViewById(R.id.imageButton_search);
        btn_edit = (Button) findViewById(R.id.button_edit);

        ibtn_add.setOnClickListener(this);
        ibtn_search.setOnClickListener(this);
        btn_edit.setOnClickListener(this);

        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
        Student stu1 = new Student(1,"Bob","123123");
        Student stu2 = new Student(2,"Joe","456456");
        dao.add(stu1);
        dao.add(stu2);

        final Student[] students = dao.getAllStudent();
        for (Student s : students)
        {
//            Log.d("DAO",s.getName());
            mylist_name.add(s.getName());
        }

        adapter = new ArrayAdapter<String>(TwentyTwoActivity.this,android.R.layout.simple_list_item_1,mylist_name);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(TwentyTwoActivity.this,parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
                for (Student s : students)
                {
                    if (parent.getItemAtPosition(position) == s.getName())
                    {
                        LayoutInflater inflater = LayoutInflater.from(TwentyTwoActivity.this);
                        View diagView = inflater.inflate(R.layout.hw_diag_show,null);
                        TextView tv_id = (TextView) diagView.findViewById(R.id.textView_id);
                        TextView tv_name = (TextView) diagView.findViewById(R.id.textView_name);
                        TextView tv_tel = (TextView) diagView.findViewById(R.id.textView_tel);

                        tv_id.setText(String.valueOf(s.getID()));
                        tv_name.setText(s.getName());
                        tv_tel.setText(s.getTel());

                        new AlertDialog.Builder(TwentyTwoActivity.this).setTitle("學生資料").setCancelable(false).setView(diagView).setPositiveButton("確認", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();

                    }
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.imageButton_add:
                startActivityForResult(new Intent(TwentyTwoActivity.this,Hw_add.class),REQUEST_CODE_NAME);
                break;
            case R.id.imageButton_search:
                break;
            case R.id.button_edit:
                break;
        }

    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode == REQUEST_CODE_NAME) {
            if (resultCode == RESULT_OK) {

                StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
                Student stu = new Student(data.getIntExtra("id",0),data.getStringExtra("name"),data.getStringExtra("tel"));
                dao.add(stu);

                mylist_name.add(stu.getName());
                ArrayAdapter uradapterobj = lv.getAdapter();

                uradapterobj.notifyDataSetChanged();
/*
                ListAdapter uradapteobjr=listview.getAdapter();
                uradapterobj.notifyDataSetChanged();
*/
//                adapter.notifyDataSetChanged();

//                adapter = new ArrayAdapter<String>(TwentyTwoActivity.this,android.R.layout.simple_list_item_1,mylist_name);
//                lv.setAdapter(adapter);

            }
        }

    }
}
