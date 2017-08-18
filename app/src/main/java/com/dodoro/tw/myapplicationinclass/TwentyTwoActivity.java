package com.dodoro.tw.myapplicationinclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.dodoro.tw.myapplicationinclass.data.*;

import java.util.List;

public class TwentyTwoActivity extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twenty_two);

        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
        Student stu1 = new Student(1,"Bob","123123");
        Student stu2 = new Student(2,"Joe","456456");
        dao.add(stu1);
        dao.add(stu2);

        Student[] students = dao.getAllStudent();
        for (Student s : students)
        {
            Log.d("DAO",s.toString());
        }
    }
}
