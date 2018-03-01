package com.example.franciscoemanuelcardenasramos.recyclerbd;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {

    ArrayList<Item> ListaDatos;
    BDHandler bdHandler;
    Adapter adapter;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler=(RecyclerView) findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        recycler.setHasFixedSize(true);

        ListaDatos=new ArrayList<>();
        bdHandler=new BDHandler(this);

        ListaDatos=bdHandler.consulta();

        adapter=new Adapter(this,ListaDatos);

        recycler.setAdapter(adapter);



    }
}
