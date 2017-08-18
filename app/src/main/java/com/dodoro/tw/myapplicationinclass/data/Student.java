package com.dodoro.tw.myapplicationinclass.data;

/**
 * Created by YVTC on 2017/8/17.
 */

public class Student {
    public int ID;
    public String name;
    public String tel;
    public Student(int ID, String name, String tel)
    {
        this.ID = ID;
        this.name = name;
        this.tel = tel;
    }
    public String toString()
    {
        return ID + "," + name + "," + tel;
    }
    public String getName() {return name;}
    public int getID(){return ID;}
    public String getTel(){return tel;}
}
