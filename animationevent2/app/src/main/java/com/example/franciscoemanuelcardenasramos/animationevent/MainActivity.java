package com.example.franciscoemanuelcardenasramos.animationevent;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private RelativeLayout canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.faceIcon);
        canvas = (RelativeLayout) findViewById(R.id.animationCanvas);





    }

    public void onButtonClick(View v) {

        int screenHeight2 = canvas.getHeight();
        int targetx2 = screenHeight2 - imageView.getHeight();




        ObjectAnimator animator2 = ObjectAnimator.ofFloat(
                imageView, "y", 0, targetx2)
                .setDuration(0000);



        //animator.setInterpolator(new BounceInterpolator());

        animator2.start();



    }



    public void onButtonClick2(View v) {



        int screenHeight2 = canvas.getHeight();
        int targetx2 = screenHeight2 - imageView.getHeight();




        ObjectAnimator animator2 = ObjectAnimator.ofFloat(
                imageView, "y", 0, targetx2)
                .setDuration(0000);



        //animator.setInterpolator(new BounceInterpolator());

        animator2.start();

        int screenHeight = canvas.getWidth();
        int targetx =  ( -imageView.getWidth()+screenHeight) -750  ;




        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", targetx)
                .setDuration(3000);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
    }


    public void onButtonClick3(View v) {



        int screenHeight2 = canvas.getHeight();
        int targetx2 = screenHeight2 - imageView.getHeight();




        ObjectAnimator animator2 = ObjectAnimator.ofFloat(
                imageView, "y", 0, targetx2)
                .setDuration(0000);



        //animator.setInterpolator(new BounceInterpolator());

        animator2.start();

        int screenHeight = canvas.getWidth();
        int targetx =  ( -imageView.getWidth()+screenHeight) -750  ;




        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", targetx)
                .setDuration(500);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.start();
    }


    public void onButtonClick4(View v) {



        int screenHeight2 = canvas.getHeight();
        int targetx2 = screenHeight2 - imageView.getHeight();




        ObjectAnimator animator2 = ObjectAnimator.ofFloat(
                imageView, "y", 0, targetx2)
                .setDuration(0000);



        //animator.setInterpolator(new BounceInterpolator());

        animator2.start();

        int screenHeight = canvas.getWidth();
        int targetx =  ( -imageView.getWidth()+screenHeight) -750  ;




        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", targetx)
                .setDuration(3000);
        animator.setInterpolator(new CycleInterpolator(3));
        animator.start();
    }

}
