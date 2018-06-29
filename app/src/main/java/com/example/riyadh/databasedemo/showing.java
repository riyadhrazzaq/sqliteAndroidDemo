package com.example.riyadh.databasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class showing extends AppCompatActivity {

    static int flag = 0; // 0= showAll 1=searchbyReg 2= seachbyCourse
    static String temp = "";
    TextView tv;
    String[] data;
    String s = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showing);
        if (flag == 0) {
            tv = (TextView) findViewById(R.id.viewTV);
            base b = new base(getApplicationContext());
            data = b.getAll();

            for (int i = 0; i < data.length; i++) {
                s += data[i] + "\n\n";
            }
            tv.setText(s);

        }
        else if(flag==1) {
            tv = (TextView) findViewById(R.id.viewTV);
            base b = new base(getApplicationContext());
            data = b.getByReg(Integer.parseInt(temp));

            for (int i = 0; i < data.length; i++) {
                s += data[i] + "\n\n";
            }
            tv.setText(s);
        }

    }
}
