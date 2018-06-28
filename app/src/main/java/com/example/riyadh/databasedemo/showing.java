package com.example.riyadh.databasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class showing extends AppCompatActivity {


    TextView tv;
    String[] data;
    String s = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showing);
        tv = (TextView) findViewById(R.id.viewTV);
        base b = new base(getApplicationContext());
        data = b.getAll();

        for(int i = 0;i< data.length;i++){
            s+= data[i]+"\n\n";
        }
        tv.setText(s);

    }
}
