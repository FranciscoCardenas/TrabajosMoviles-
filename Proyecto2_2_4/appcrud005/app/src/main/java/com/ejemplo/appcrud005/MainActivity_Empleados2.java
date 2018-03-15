package com.ejemplo.appcrud005;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity_Empleados2 extends AppCompatActivity {

    private static final String TAG = MainActivity_Empleados2.class.getSimpleName();

    private ArrayList<Item_Tabla> list = new ArrayList<Item_Tabla>();
    private ItemAdapter_Empleados2 adapter;
    private RecyclerView recyclerView;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.importar);








        final Bundle datos = this.getIntent().getExtras();
        int idcliente= datos.getInt("id");
        fetchRecords(idcliente);




    }


    // ----- Obtener todos los registros y pasarlos al RecyclerView
    public void fetchRecords(int idc) {

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        adapter = new ItemAdapter_Empleados2 (this,list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity_Empleados2.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        list.clear();

        Functions functions = new Functions(MainActivity_Empleados2.this);

        ArrayList<Item_Tabla> data = functions.getAllRecords3(idc);



        int cre=0;
        if (data.size()>0){
            for (int i = 0; i<data.size(); i++){

                int id = data.get(i).getId();

                String nombrea = data.get(i).getNombreem();
                String nombreb = data.get(i).getNombrecl();


                Item_Tabla item = new Item_Tabla();

                item.setId(id);

                item.setNombreem(nombrea);
                item.setNombrecl(nombreb);


                list.add(item);


            }adapter.notifyDataSetChanged();

        }else {
            Toast.makeText(MainActivity_Empleados2.this, "No Records found.", Toast.LENGTH_SHORT).show();
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.delete_all) {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity_Empleados2.this);
            builder.setTitle("You want to delete all records")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Functions functions = new Functions(MainActivity_Empleados2.this);
                            functions.DeleteAll2();

                            Toast.makeText(MainActivity_Empleados2.this, "Delete Success.", Toast.LENGTH_SHORT).show();

                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialog.dismiss();
                }
            });
            dialog = builder.create();
            dialog.show();


            return true;
        }


        if(id == R.id.agregar_clientes){

            Intent intent= new Intent(MainActivity_Empleados2.this,MainActivity.class);
            startActivityForResult(intent,0);

        }

        return super.onOptionsItemSelected(item);
    }




}
