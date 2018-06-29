package com.example.riyadh.databasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2, e3;
    Button b1, b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final base mybase = new base(getApplicationContext());

        e1 = (EditText) findViewById(R.id.reg);
        e2 = (EditText) findViewById(R.id.courseId);
        e3 = (EditText) findViewById(R.id.mark);
        b1 = (Button) findViewById(R.id.addBT);
        b2 = (Button) findViewById(R.id.delBT);
        b3 = (Button) findViewById(R.id.showBT);
        b4 = (Button) findViewById(R.id.moreBT);

        b1.setOnClickListener(new View.OnClickListener() {

                                  @Override
                                  public void onClick(View view) {
                                    String r= e1.getText().toString();
                                    String c= e2.getText().toString();
                                    String m= e3.getText().toString();
                                    datatemp dt = new datatemp(r,c,m);

                                    mybase.addData(dt);

                                      Toast.makeText(getApplicationContext(), "Added Successfully!", Toast.LENGTH_LONG).show();
                                  }
                              }
        );
        b2.setOnClickListener(new View.OnClickListener() {

                                  @Override
                                  public void onClick(View view) {
                                      Toast.makeText(getApplicationContext(), "Button Del works!", Toast.LENGTH_LONG).show();
                                  }
                              }
        );
        b3.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      showing.flag = 0;
                                      startActivity( new Intent(getApplicationContext(),showing.class));
                                  }
                              }


        );
        b4.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {

                                      startActivity( new Intent(getApplicationContext(),filter.class));
                                  }
                              }


        );

    }


}
