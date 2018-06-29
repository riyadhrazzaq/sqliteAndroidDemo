package com.example.riyadh.databasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class filter extends AppCompatActivity {
    EditText e1;
    Button b1,b2,b3,b4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        e1= (EditText) findViewById(R.id.searchET);
        b1 = (Button) findViewById(R.id.byRegBT);
        b2 = (Button) findViewById(R.id.byCourseBT);
        b3 = (Button) findViewById(R.id.byMarkABT);
        b4 = (Button) findViewById(R.id.byMarkDBT);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showing.flag=1;
                showing.temp= e1.getText().toString();
                startActivity(new Intent(getApplicationContext(),showing.class));
            }
        });

    }
}
