package com.example.franciscoemanuelcardenasramos.a115laboratorio1_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity  extends AppCompatActivity{


    ListView listView;

    String lenguajeProgramacion[]={
            "OnCreate" +"\n" + "se llama cuando se crea una actividad",
            "OnStart" +"\n" + " onStart se llama cuando regresa primer plano",
            "OnResume()"+"\n" +"Una actividad está visible y activa",
            "OnPause()"+"\n"+"Puede estar visible pero sin el “foco”",
            "OnStop()" +"\n" + "No visible",
            "OnDestroy()" +"\n" + "Es la última oportunidad para que se elimine por completo",
            "OnRestart()" +"\n" + "Vuele a cargar"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.lista);
        lista();
    }
    public void lista() {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, lenguajeProgramacion);

        listView.setAdapter(adapter);
    }

}
