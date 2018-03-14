package com.ejemplo.appcrud005;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by lenovo on 07/03/2018.
 * Define RecyclerView.Adapter y RecyclerView.ViewHolder
 * Establece listener para los componentes
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private Activity activity;
    private Activity activity2;
    private ArrayList<Item> list;
    private AlertDialog dialog;

    private AlertDialog dialog2;

    public ItemAdapter(Activity activity, ArrayList<Item> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Referencia para almacenar el contexto
        Context context;
        context = parent.getContext();

        // Referencia para el inflater
        LayoutInflater nuevo;
        nuevo = LayoutInflater.from(context);

        View itemView = nuevo.inflate(R.layout.item_list,parent,false);


        return new MyViewHolder(itemView);
    }

    /*
    Vincula los datos con los datos con los elementos holder
     Establece listeners para los "botones" (que no son botones)

     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final Item item = list.get(position);



        holder.nombre.setText("Nombre :" + item.getNombre());
        //holder.direccion.setText("" + item.getDireccion());
        //holder.cel.setText("" + item.getCel());
        //holder.mail.setText("" + item.getMail());

        holder.descripcion.setText("Descripcion : " + "\n" + item.getDescripcion());
        //holder.monto.setText("" + item.getMonto());
        holder.fin.setText("Finalizo : " + item.getFin());






        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final int id = item.getId();


                LayoutInflater layoutInflater = activity.getLayoutInflater();
                View view1 = layoutInflater.inflate(R.layout.activity_edit,null);

                final EditText input_nombre = (EditText) view1.findViewById(R.id.Nombre);
                final EditText input_direccion = (EditText) view1.findViewById(R.id.Direccion);
                final EditText input_cel = (EditText) view1.findViewById(R.id.Cel);
                final EditText input_mail = (EditText) view1.findViewById(R.id.Mail);
                final EditText input_descripcion = (EditText) view1.findViewById(R.id.Descripcion);
                final EditText input_monto = (EditText) view1.findViewById(R.id.Monto);
                final EditText input_fin = (EditText) view1.findViewById(R.id.Fin);



                final Button btnSave = (Button) view1.findViewById(R.id.btnSave);


                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setView(view1).setTitle("Editar").setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialog.dismiss();
                    }
                });

                final Functions functions = new Functions(activity);
                final Item _items = functions.getSingleItem(id);
                input_nombre.setText(_items.getNombre());
                input_direccion.setText(_items.getDireccion());
                input_cel.setText(_items.getCel());
                input_mail.setText(_items.getMail());
                input_descripcion.setText(_items.getDescripcion());
                input_monto.setText(_items.getMonto());
                input_fin.setText(_items.getFin());

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String nombre = input_nombre.getText().toString();
                        String direccion = input_direccion.getText().toString();
                        String cel = input_cel.getText().toString();
                        String mail = input_mail.getText().toString();
                        String descripcion = input_descripcion.getText().toString();
                        String monto = input_monto.getText().toString();
                        String fin = input_fin.getText().toString();



                        _items.setNombre(nombre);
                        _items.setDireccion(direccion);
                        _items.setCel(cel);
                        _items.setMail(mail);
                        _items.setDescripcion(descripcion);
                        _items.setMonto(monto);
                        _items.setFin(fin);



                        functions.Update(_items);

                        Toast.makeText(activity, nombre + " updated.", Toast.LENGTH_SHORT).show();
                        ((MainActivity)activity).fetchRecords();
                        dialog.dismiss();
                    }
                });
                dialog = builder.create();
                dialog.show();


            }
        });

/// Boton ver
        holder.btnver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final int id = item.getId();


                LayoutInflater layoutInflater = activity.getLayoutInflater();
                View view1 = layoutInflater.inflate(R.layout.activity_edit1_2,null);

                final EditText input_nombre = (EditText) view1.findViewById(R.id.Nombre);
                final EditText input_direccion = (EditText) view1.findViewById(R.id.Direccion);
                final EditText input_cel = (EditText) view1.findViewById(R.id.Cel);
                final EditText input_mail = (EditText) view1.findViewById(R.id.Mail);
                final EditText input_descripcion = (EditText) view1.findViewById(R.id.Descripcion);
                final EditText input_monto = (EditText) view1.findViewById(R.id.Monto);
                final EditText input_fin = (EditText) view1.findViewById(R.id.Fin);



                final Button btnver = (Button) view1.findViewById(R.id.btnSave);


                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setView(view1).setTitle("Ver").setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialog.dismiss();
                    }
                });

                final Functions functions = new Functions(activity);
                final Item _items = functions.getSingleItem(id);
                input_nombre.setText(_items.getNombre());
                input_direccion.setText(_items.getDireccion());
                input_cel.setText(_items.getCel());
                input_mail.setText(_items.getMail());
                input_descripcion.setText(_items.getDescripcion());
                input_monto.setText(_items.getMonto());
                input_fin.setText(_items.getFin());


                btnver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String nombre = input_nombre.getText().toString();
                        String direccion = input_direccion.getText().toString();
                        String cel = input_cel.getText().toString();
                        String mail = input_mail.getText().toString();
                        String descripcion = input_descripcion.getText().toString();
                        String monto = input_monto.getText().toString();
                        String fin = input_fin.getText().toString();



                        _items.setNombre(nombre);
                        _items.setDireccion(direccion);
                        _items.setCel(cel);
                        _items.setMail(mail);
                        _items.setDescripcion(descripcion);
                        _items.setMonto(monto);
                        _items.setFin(fin);



                        functions.Update(_items);

                        Toast.makeText(activity, nombre + " updated.", Toast.LENGTH_SHORT).show();
                        ((MainActivity)activity).fetchRecords();
                        dialog.dismiss();
                    }
                });




                dialog = builder.create();
                dialog.show();


            }
        });















    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nombre;
        TextView direccion;
        TextView cel;
        TextView mail;
        TextView descripcion;
        TextView monto;
        TextView fin;
        TextView btnver;

        TextView btnEdit;
        TextView btnDelete;

        public MyViewHolder(View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.nombre);
           direccion = itemView.findViewById(R.id.direccion);
            cel = itemView.findViewById(R.id.cel);
            mail = itemView.findViewById(R.id.mail);
            descripcion = itemView.findViewById(R.id.descripcion);
            monto = itemView.findViewById(R.id.monto);
            fin = itemView.findViewById(R.id.fin);

            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            btnver=itemView.findViewById(R.id.btnver);

        }
    }
}
