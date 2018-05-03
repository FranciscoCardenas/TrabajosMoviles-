package com.example.franciscoemanuelcardenasramos.reloj;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;

import java.security.cert.Extension;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PapelView papel = new PapelView(this);
        setContentView(papel);

    }

    class PapelView extends View {

        private int width,height;
        private int padding = 0;
        private int fontSize = 0;
        private int numeralSpacing = 0;
        private int handTruncation,hourHandTruncation =0;
        private int radius = 0;
        private Paint paint;
        private boolean isInit;
        private int[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12};;
        private Rect rect = new Rect();
        public int hour,minute,second =0;
        private boolean started = false;

        public PapelView(Context context) {
            super(context);
        }

        private void initClock(){
            height = getHeight();
            width = getWidth();
            padding = numeralSpacing + 50;
            fontSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                    13,
                    getResources().getDisplayMetrics());
            int min = Math.min(height,width);
            radius =min/2 - padding;
            handTruncation = min/20;
            hourHandTruncation = min/7;
            paint = new Paint();
            isInit=true;

        }

        @Override
        protected void onDraw(final Canvas canvas) {
            super.onDraw(canvas);
            if(!isInit){
                initClock();
            }

            //Components of the clock
            canvas.drawColor(Color.BLACK);
            drawCircle(canvas);
            drawCenter(canvas);
            drawNumeral(canvas);
            drawHands(canvas,hour,minute,second);

            if(!started){
                started=true;
                new Thread() {
                    public void run() {
                        try{
                            for(hour=12;hour>=0;hour--){
                                for(minute=60;minute>=0;minute-=5){
                                    for(second=60;second>=0;second--){
                                        Thread.sleep(30);
                                    }
                                }
                                if(hour==0)hour=12;
                            }
                        }catch (Exception e){
                            System.out.println(e);
                        }
                    }
                }.start();
            }
            postInvalidateDelayed(30);
            System.out.println(hour+":"+minute+":"+second);
        }

        private void drawHands(Canvas canvas,int hour,int minute,int second) {
            drawHand(canvas,hour*5 - (60-minute)/60,true);
            drawHand(canvas,minute,false);
            drawHand(canvas,second,false,"");
        }

        private void drawHand(Canvas canvas,float num,boolean isHour){
            double angle = Math.PI*num /30-Math.PI/2;
            int handRadius = isHour ? radius - handTruncation - hourHandTruncation: radius-handTruncation;
            canvas.drawLine(width/2,height/2,
                    (float)(width/2 - Math.cos(angle)*handRadius),
                    (float)(height/2 + Math.sin(angle)*handRadius),
                    paint);
        }
        private void drawHand(Canvas canvas,float num,boolean isHour,String x){
            double angle = Math.PI*num /30-Math.PI/2;
            int handRadius = isHour ? radius - handTruncation - hourHandTruncation: radius-handTruncation;
            paint.setColor(Color.WHITE);
            canvas.drawLine(width/2,height/2,
                    (float)(width/2 - Math.cos(angle)*handRadius),
                    (float)(height/2 + Math.sin(angle)*handRadius),
                    paint);
        }

        private void drawNumeral(Canvas canvas) {
            paint.setTextSize(fontSize);

            for(int number:numbers){
                String tmp  = String.valueOf(number);
                paint.getTextBounds(tmp,0,tmp.length(),rect);
                Double angle = Math.PI/6 *(number-3);
                int x = (int)(width/2 + Math.cos(angle)*radius - rect.width()/2);
                int y = (int)(height/2 + Math.sin(angle)*radius + rect.height()/2);
                canvas.drawText(tmp,x,y,paint);
            }
        }

        private void drawCenter(Canvas canvas) {
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(width/2,height/2,15, paint);
        }

        private void drawCircle(Canvas canvas) {
            paint.reset();
            paint.setColor(Color.WHITE);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);
            canvas.drawCircle(width/2,height/2,radius+padding-10, paint);
            // canvas.restore();
        }

    }

}
