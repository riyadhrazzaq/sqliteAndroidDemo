package com.example.riyadh.databasedemo;

/**
 * Created by riyadh on 28-Jun-18.
 */

public class datatemp {
    private String reg;
    private String course;
    private String mark;

    public datatemp(String reg,String course,String mark){
        this.reg= reg;
        this.course= course;
        this.mark= mark;

    }
    public String getReg(){
        return reg;
    }
    public String getCourse(){
        return course;
    }
    public String getMark(){
        return mark;
    }


}
