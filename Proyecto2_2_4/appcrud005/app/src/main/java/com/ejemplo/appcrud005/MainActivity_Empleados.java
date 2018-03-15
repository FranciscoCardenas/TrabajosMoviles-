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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity_Empleados extends AppCompatActivity {

    private static final String TAG = MainActivity_Empleados.class.getSimpleName();

    private ArrayList<Item_Empleados> list = new ArrayList<Item_Empleados>();
    private ItemAdapter_Empleados adapter;
    private RecyclerView recyclerView;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
     //   Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
  //      setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        fetchRecords();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                View mView1 = inflater.inflate(R.layout.activity_add2,null);

                final EditText input_nombreem = (EditText) mView1.findViewById(R.id.Nombre);
                final EditText input_actividad= (EditText) mView1.findViewById(R.id.Actividad);
                final EditText input_fechainicio = (EditText) mView1.findViewById(R.id.Fechainicio);
                final EditText input_fechafinal = (EditText) mView1.findViewById(R.id.Fechafinal);
                final EditText input_celu = (EditText) mView1.findViewById(R.id.Celu);
                final EditText input_cantidad = (EditText) mView1.findViewById(R.id.Cantidad);
                final EditText input_pago = (EditText) mView1.findViewById(R.id.Pago);


                final Button btnSave = (Button) mView1.findViewById(R.id.btnSave);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity_Empleados.this);
                builder.setView(mView1).setTitle("Ingresar Empleado")
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialog.dismiss();
                            }
                        });

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String nombreem = input_nombreem.getText().toString();
                        String actividad= input_actividad.getText().toString();
                        String fechainicio = input_fechainicio.getText().toString();
                        String fechafinal = input_fechafinal.getText().toString();
                        String celu = input_celu.getText().toString();
                        String cantidad = input_cantidad.getText().toString();
                        String pago = input_pago.getText().toString();



                        if (nombreem.equals("") && actividad.equals("") &&  fechainicio.equals("") && fechafinal.equals("") && celu.equals("") && cantidad.equals("")  && pago.equals(""))  {
                            Snackbar.make(view,"Incompleto",Snackbar.LENGTH_SHORT).show();

                        }else {
                            Save(nombreem,actividad,fechainicio,fechafinal,celu,cantidad,pago);
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
        adapter = new ItemAdapter_Empleados (this,list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity_Empleados.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        list.clear();

        Functions functions = new Functions(MainActivity_Empleados.this);

        ArrayList<Item_Empleados> data = functions.getAllRecords2();

        if (data.size()>0){
            for (int i = 0; i<data.size(); i++){

                int id = data.get(i).getId();
                String nom = data.get(i).getNombreem();
                String act = data.get(i).getActividad();
                String fcini = data.get(i).getFechainicio();
                String  fcfin = data.get(i).getFechafinal();
                String  celu = data.get(i).getCelu();
                String cant = data.get(i).getCantidad();
                String pago = data.get(i).getPago();


                Item_Empleados item = new Item_Empleados();

                item.setId(id);
                item.setNombreem(nom);
                item.setActividad(act);
                item.setFechainicio(fcini);
                item.setFechafinal(fcfin);
                item.setCelu(celu);
                item.setCantidad(cant);
                item.setPago(pago);



                list.add(item);

            }adapter.notifyDataSetChanged();

        }else {
            Toast.makeText(MainActivity_Empleados.this, "No Records found.", Toast.LENGTH_SHORT).show();
        }
    }

    private void Save(String nombre, String direccion, String cel, String mail ,String des, String mon , String fin) {


        Functions functions = new Functions(MainActivity_Empleados.this);
        Item_Empleados item = new Item_Empleados();

        item.setNombreem(nombre);
        item.setActividad(direccion);
        item.setFechainicio(cel);
        item.setFechafinal(mail);
        item.setCelu(des);
        item.setCantidad(mon);
        item.setPago(fin);




        functions.Insert2(item);
        Toast.makeText(MainActivity_Empleados.this, "Saved...", Toast.LENGTH_SHORT).show();
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

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity_Empleados.this);
            builder.setTitle("You want to delete all records")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Functions functions = new Functions(MainActivity_Empleados.this);
                            functions.DeleteAll2();
                            fetchRecords();
                            Toast.makeText(MainActivity_Empleados.this, "Delete Success.", Toast.LENGTH_SHORT).show();

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

            Intent intent= new Intent(MainActivity_Empleados.this,MainActivity.class);
            startActivityForResult(intent,0);

        }

        return super.onOptionsItemSelected(item);
    }




}
