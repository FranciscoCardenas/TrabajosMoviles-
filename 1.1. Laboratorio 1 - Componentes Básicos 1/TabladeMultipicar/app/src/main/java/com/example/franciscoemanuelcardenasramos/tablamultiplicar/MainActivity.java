package com.example.franciscoemanuelcardenasramos.tablamultiplicar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public Button btncalcular;
    EditText etnum,contenido ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btncalcular = (Button)findViewById(R.id.btncalcular);
        etnum= (EditText)findViewById(R.id.etnum);
        contenido= (EditText)findViewById(R.id.contenido);


        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contenido.setText(etnum.getText().toString() + " x   1  =  " +(Integer.parseInt(etnum.getText().toString())*1)+"\n"+
                        etnum.getText().toString() + " x   2  = " +(Integer.parseInt(etnum.getText().toString())*2)+"\n"+
                        etnum.getText().toString() + " x   3  = " +(Integer.parseInt(etnum.getText().toString())*3)+"\n"+
                        etnum.getText().toString() + " x   4  = " +(Integer.parseInt(etnum.getText().toString())*4)+"\n"+
                        etnum.getText().toString() + " x   5  = " +(Integer.parseInt(etnum.getText().toString())*5)+"\n"+
                        etnum.getText().toString() + " x   6  = " +(Integer.parseInt(etnum.getText().toString())*6)+"\n"+
                        etnum.getText().toString() + " x   7  = " +(Integer.parseInt(etnum.getText().toString())*7)+"\n"+
                        etnum.getText().toString() + " x   8  = " +(Integer.parseInt(etnum.getText().toString())*8)+"\n"+
                        etnum.getText().toString() + " x   9  = " +(Integer.parseInt(etnum.getText().toString())*9)+"\n"+
                        etnum.getText().toString() + " x  10  = " +(Integer.parseInt(etnum.getText().toString())*10)+"\n"



                )


                ;

            }
        });


    }
}
