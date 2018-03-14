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
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ArrayList<Item> list = new ArrayList<Item>();
    private ItemAdapter adapter;
    private RecyclerView recyclerView;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        fetchRecords();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                View mView1 = inflater.inflate(R.layout.activity_add,null);

                final EditText input_nombre = (EditText) mView1.findViewById(R.id.Nombre);
                final EditText input_direccion= (EditText) mView1.findViewById(R.id.Direccion);
                final EditText input_cel = (EditText) mView1.findViewById(R.id.Cel);
                final EditText input_mail = (EditText) mView1.findViewById(R.id.Mail);
                final EditText input_descripcion = (EditText) mView1.findViewById(R.id.Descripcion);
                final EditText input_monto = (EditText) mView1.findViewById(R.id.Monto);
                final EditText input_fin = (EditText) mView1.findViewById(R.id.Fin);


                final Button btnSave = (Button) mView1.findViewById(R.id.btnSave);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(mView1).setTitle("Ingresar Cliente")
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialog.dismiss();
                            }
                        });

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String nombre = input_nombre.getText().toString();
                        String direccion= input_direccion.getText().toString();
                        String cel = input_cel.getText().toString();
                        String mail = input_mail.getText().toString();
                        String descripccion = input_descripcion.getText().toString();
                        String monto = input_monto.getText().toString();
                        String fin = input_fin.getText().toString();



                        if (nombre.equals("") && direccion.equals("") && cel.equals("") && mail.equals("") && descripccion.equals("") && monto.equals("")  && fin.equals(""))  {
                            Snackbar.make(view,"Incompleto",Snackbar.LENGTH_SHORT).show();

                        }else {
                            Save(nombre,direccion,cel,mail,descripccion,monto,fin);
                            dialog.dismiss();
                            Snackbar.make(view,"Guardando",Snackbar.LENGTH_SHORT).show();
                        }
                    }
                });

                dialog = builder.create();
                dialog.show();
            }


        });

    }


    // ----- Obtener todos los registros y pasarlos al RecyclerView
    public void fetchRecords() {

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        adapter = new ItemAdapter(this,list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        list.clear();

        Functions functions = new Functions(MainActivity.this);

        ArrayList<Item> data = functions.getAllRecords();

        if (data.size()>0){
            for (int i = 0; i<data.size(); i++){

                int id = data.get(i).getId();
                String nom = data.get(i).getNombre();
                String dir = data.get(i).getDireccion();
                String cel = data.get(i).getCel();
                String  mail = data.get(i).getMail();
                String des = data.get(i).getDescripcion();
                String mon = data.get(i).getMonto();
                String fin = data.get(i).getFin();


                Item item = new Item();

                item.setId(id);
                item.setNombre(nom);
                item.setDireccion(dir);
                item.setCel(cel);
                item.setMail(mail);
                item.setDescripcion(des);
                item.setMonto(mon);
                item.setFin(fin);



                list.add(item);

            }adapter.notifyDataSetChanged();

        }else {
            Toast.makeText(MainActivity.this, "No Records found.", Toast.LENGTH_SHORT).show();
        }
    }

    private void Save(String nombre, String direccion, String cel, String mail ,String des, String mon , String fin) {


        Functions functions = new Functions(MainActivity.this);
        Item item = new Item();

        item.setNombre(nombre);
        item.setDireccion(direccion);
        item.setCel(cel);
        item.setMail(mail);
        item.setDescripcion(des);
        item.setMonto(mon);
        item.setFin(fin);




        functions.Insert(item);
        Toast.makeText(MainActivity.this, "Saved...", Toast.LENGTH_SHORT).show();
        fetchRecords();
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

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("You want to delete all records")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Functions functions = new Functions(MainActivity.this);
                            functions.DeleteAll();
                            fetchRecords();
                            Toast.makeText(MainActivity.this, "Delete Success.", Toast.LENGTH_SHORT).show();

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

        if(id == R.id.agregar_empleado){

            Intent intent= new Intent(MainActivity.this,MainActivity_Empleados.class);
            startActivityForResult(intent,0);

        }





        return super.onOptionsItemSelected(item);
    }
}
