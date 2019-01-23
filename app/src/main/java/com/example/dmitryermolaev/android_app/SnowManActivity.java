package com.example.dmitryermolaev.android_app;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

public class SnowManActivity extends AppCompatActivity {
    ImageView schar[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snowman_activity);

        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.setTitle("Task1_SnowMan");

        // задание массива отображаемых объектов и их расположение
        schar = new ImageView[3];
        schar[0] = (ImageView) findViewById(R.id.s1);
        schar[1] = (ImageView) findViewById(R.id.s2);
        schar[2] = (ImageView) findViewById(R.id.s3);

        int dW = getResources().getDisplayMetrics().widthPixels;
        int dH = getResources().getDisplayMetrics().heightPixels;
        int x = dW / 2;
        int y = dH / 2;

        RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams(
                x / 3, x / 3);
        lp1.leftMargin = x - x / 4;
        lp1.topMargin = y + y / 2 - y / 8;
        schar[0].setLayoutParams(lp1);

        RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams(
                x / 3, x / 3);
        lp2.leftMargin = x - x / 4 - x / 3 - x / 10;
        lp2.topMargin = y + y / 2 - y / 8;
        schar[1].setLayoutParams(lp2);

        RelativeLayout.LayoutParams lp3 = new RelativeLayout.LayoutParams(
                x / 3, x / 3);
        lp3.leftMargin = x - x / 4 + x / 3 + x / 10;
        lp3.topMargin = y + y / 2 - y / 8;
        schar[2].setLayoutParams(lp3);

        run();
    }

    // реализация функционала кнопки "Назад"
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // потоки для смены цвета
    private void run() {
        Random r = new Random();
        Schar t1 = new Schar(schar[0], 800);
        Thread ts1 = new Thread(t1);
        ts1.start();
        Schar t2 = new Schar(schar[1], 1500+r.nextInt(1000));
        Thread ts2 = new Thread(t2);
        ts2.start();
        Schar t3 = new Schar(schar[2], 3000+r.nextInt(1000));
        Thread ts3 = new Thread(t3);
        ts3.start();
    }

    class Schar implements Runnable {
        ImageView iv;
        int sleep;
        Random r;

        public Schar(ImageView iv, int sleep) {
            this.iv = iv;
            this.sleep = sleep;
            r = new Random();

        }

        @Override
        public void run() {
            while (true) {
                SnowManActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        GradientDrawable oval = new GradientDrawable();
                        oval.setShape(GradientDrawable.OVAL);
                        oval.setColor(Color.rgb(r.nextInt(255), r.nextInt(255),
                                r.nextInt(255)));
                        iv.setImageDrawable(oval);

                    }
                });
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}

