package com.dodoro.tw.myapplicationinclass.data;

/**
 * Created by YVTC on 2017/8/17.
 */

public interface StudentDAO {
    public void add(Student s);
    public Student[] getAllStudent();
    public Student getOneStudent(int ID);
}
