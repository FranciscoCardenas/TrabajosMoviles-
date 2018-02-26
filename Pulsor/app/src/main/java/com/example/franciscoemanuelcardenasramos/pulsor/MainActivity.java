package com.example.franciscoemanuelcardenasramos.pulsor;


import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public TextView cinta,numal;
    public Button btnpul;
    public double random = 1;
    public double random3;
    public Handler handler = new Handler();
    DecimalFormat df = new DecimalFormat("#.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cinta = (TextView) findViewById(R.id.txtcinta);
        numal = (TextView) findViewById(R.id.txtnumaleatorio);
        btnpul = (Button) findViewById(R.id.btnpulsar);
        random3 = (Math.random() * 2.3) + 1;

        numal.setText(df.format(random3));
        handler.postDelayed(runnable, 140);
        //inicia();

        btnpul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pulsar();
            }
        });



    }

    public void setea(){
        DecimalFormat df = new DecimalFormat("#.0");
        cinta.setText(df.format(random));
        double temp = Double.parseDouble(cinta.getText().toString());
        if(temp == 3.0){
            random = 1;
        }
        random = random+.1;

    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {

            setea();

            handler.postDelayed(this, 200);
        }
    };


    public static void reiniciarActivity(Activity actividad){
        Intent intent=new Intent();
        intent.setClass(actividad, actividad.getClass());
        actividad.startActivity(intent);
        actividad.finish();
    }




    public void pulsar(){
        double temporal = Double.parseDouble(cinta.getText().toString());
        double tempora2 = Double.parseDouble(numal.getText().toString());

        if(temporal == tempora2){
            Toast.makeText(MainActivity.this,"Buen Pulso!", Toast.LENGTH_LONG).show();
            reiniciarActivity(this);



        }else {  Toast.makeText(MainActivity.this,"Mal Pulso!", Toast.LENGTH_LONG).show();
            reiniciarActivity(this);
        }


    }
}
