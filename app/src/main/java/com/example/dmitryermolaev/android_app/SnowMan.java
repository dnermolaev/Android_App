package com.example.dmitryermolaev.android_app;

import android.content.Context;
import android.graphics.Canvas;

import android.graphics.Path;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;

public class SnowMan extends View {
    GradientDrawable[] snow;
    Path nos;
    int x,y,dW,dH;

    public SnowMan(Context v, AttributeSet as) {
        super(v, as);
        snow=new GradientDrawable[3];
        drawSnowMan(as);
    }

    public void drawSnowMan(AttributeSet ast) {
        dW = getResources().getDisplayMetrics().widthPixels;
        dH = getResources().getDisplayMetrics().heightPixels;
        x = 7*dW/18;
        y = 5*dH/9;

        for (int i=0;i<3;i++){
            snow[i]=new GradientDrawable();
            snow[i].setShape(GradientDrawable.OVAL);
            snow[i].setColor(Color.parseColor("#ffffff"));
            snow[i].setStroke(2, Color.parseColor("#4c94e0"));
        }
        snow[0].setBounds(41*x/60, 3*y/20+y/10,x*33/20, y/2+y/10);
        snow[1].setBounds(x*13/24-x/10, y/2, 43*x/24+x/10, y);
        snow[2].setBounds(x/5, 4*y/5, 2*x+x/5, 3*y/2);
        nos = new Path();
        nos.moveTo(x+x/7, y/3+y/16);
        nos.lineTo(x-2*x/7,  y/2-y/16+y/16);
        nos.lineTo(x+x/7,  y/3+y/25+y/16);
        nos.close();
    }

    protected void onDraw(Canvas canvas) {
        Paint pp1 = new Paint();
        Paint pp2 = new Paint();
        pp1.setColor(Color.parseColor("#4a3b34"));
        pp2.setColor(Color.RED);
        pp1.setStrokeWidth(8);
        pp2.setStrokeWidth(5);
        canvas.drawLine(0,y-y/2,x,y, pp1);
        canvas.drawLine(x,y+y/3,2*x+x/4,y-y/2, pp1);
        pp1.setColor(Color.BLACK);
        pp1.setColor(Color.parseColor("#66391c"));
        pp1.setStrokeWidth(15);
        pp1.setStrokeWidth(10);

        snow[2].draw(canvas);
        snow[1].draw(canvas);
        snow[0].draw(canvas);
        canvas.drawPath(nos, pp2);

        canvas.drawCircle(x, y/3, x/15, pp1);
        canvas.drawCircle(x+x/3, y/3, x/15, pp1);
        pp1.setStrokeWidth(3);
        canvas.drawLine(x+x/15,y/2+y/25,x+x/4+x/15,y/2-y/25+y/25, pp1);
        //pp1.setColor(Color.WHITE);
        //pp1.setColor(Color.WHITE);
        invalidate();
    }


}

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Draw(this));

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.setTitle("Task2_Snowman");
    }

    public class Draw extends View {

        public Draw(Context context) {
            super(context);
        }

        @Override
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Paint mPaint = new Paint();
            mPaint.setAntiAlias(true);
            mPaint.setColor(Color.YELLOW);
            canvas.drawCircle(540, 420, 70, mPaint);

            Paint mPaint1 = new Paint();
            mPaint1.setAntiAlias(true);
            mPaint1.setColor(Color.GREEN);
            canvas.drawCircle(540, 590, 100, mPaint1);

            Paint mPaint2 = new Paint();
            mPaint2.setAntiAlias(true);
            mPaint2.setColor(Color.RED);
            canvas.drawCircle(540, 825, 140, mPaint2);
     }

        CountDownTimer countDownTimer=new CountDownTimer(5000, 1000) {

            public void onTick (long millisUntilFinished) {
                invalidate();
            }
            public void onFinish() {
                this.start();
            }
        }
                .start();

    }


}*/

            /*canvas.drawCircle(x+x/6, y-y/3, x/10, pp1);
        canvas.drawCircle(x+x/6, y-y/3+y/10, x/10, pp1);
        canvas.drawCircle(x+x/6, y-y/3+y/5, x/10, pp1);*/
//canvas.drawRect(x-x/10,y/3+3,x+x/8,y/3+y/25+3,pp1);
//canvas.drawRect(x-x/10+x/5,y/3+3,x+x/8+x/3,y/3+y/25+3,pp1);




