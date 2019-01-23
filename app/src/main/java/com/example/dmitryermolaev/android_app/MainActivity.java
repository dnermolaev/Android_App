package com.example.dmitryermolaev.android_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView myTextView;
    Button myButton1;
    Button myButton2;
    Button myButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = (TextView) findViewById(R.id.myTextView);
        myButton1 = (Button) findViewById(R.id.myButton1);
        myButton2 = (Button) findViewById(R.id.myButton2);
        myButton3 = (Button) findViewById(R.id.myButton3);

        View.OnClickListener oMyButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.myButton1: setContentView(R.layout.calc_activity);
                        Intent intent = new Intent(MainActivity.this, Calc.class);
                        startActivity(intent);break;
                    case R.id.myButton2: setContentView(R.layout.snowman_activity);
                        Intent intent2 = new Intent(MainActivity.this, SnowManActivity.class);
                        startActivity(intent2); break;
                    case R.id.myButton3: myTextView.setText("Вы нажали на 3-ю кнопку"); break;
                }
            }
        };

        myButton1.setOnClickListener(oMyButton);
        myButton2.setOnClickListener(oMyButton);
        myButton3.setOnClickListener(oMyButton);
    }
}
