package com.example.franciscoemanuelcardenasramos.a16proyectorecyclerview_cardview;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter adapter;

    List<DataProvider> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productList = new ArrayList<>();

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Aquí va la adición de elementos a la lista
        productList.add(
                new DataProvider("Titulo1", "Otro1", 4.3,R.drawable.imagen1)
        );
        productList.add(
                new DataProvider("Titulo2", "Otro2", 4.3,R.drawable.imagen2)
        );
        productList.add(
                new DataProvider("Titulo3", "Otro3", 4.3,R.drawable.imagen3)
        );
        productList.add(
                new DataProvider("Titulo4", "Otro4", 4.3,R.drawable.imagen4)
        );

        adapter = new ProductAdapter(this,productList);
        recyclerView.setAdapter(adapter);





    }
}
