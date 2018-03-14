package com.ejemplo.appcrud005;

/**
 * Created by franciscoemanuelcardenasramos on 13/03/18.
 */
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

public class ItemAdapter_Empleados  extends RecyclerView.Adapter<ItemAdapter_Empleados.MyViewHolder> {
    private Activity activity;
    private ArrayList<Item_Empleados> list;
    private AlertDialog dialog;

    public ItemAdapter_Empleados(Activity activity, ArrayList<Item_Empleados> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public ItemAdapter_Empleados.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Referencia para almacenar el contexto
        Context context;
        context = parent.getContext();

        // Referencia para el inflater
        LayoutInflater nuevo;
        nuevo = LayoutInflater.from(context);

        View itemView = nuevo.inflate(R.layout.item_list2,parent,false);


        return new MyViewHolder(itemView);
    }



    /*
    Vincula los datos con los datos con los elementos holder
     Establece listeners para los "botones" (que no son botones)

     */
    @Override
    public void onBindViewHolder(ItemAdapter_Empleados.MyViewHolder holder, int position) {

        final Item_Empleados item = list.get(position);



        holder.nombreem.setText("Nombre :" + item.getNombreem());
        //holder.direccion.setText("" + item.getDireccion());
        //holder.cel.setText("" + item.getCel());
        //holder.mail.setText("" + item.getMail());

        holder.actividad.setText("Descripcion : " + "\n" + item.getActividad());
        //holder.monto.setText("" + item.getMonto());
        holder.fechainicio.setText("Finalizo : " + item.getFechainicio());


        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final int id = item.getId();


                LayoutInflater layoutInflater = activity.getLayoutInflater();
                View view1 = layoutInflater.inflate(R.layout.activity_edit2,null);

                final EditText input_nombreem = (EditText) view1.findViewById(R.id.Nombreem);
                final EditText input_actividad = (EditText) view1.findViewById(R.id.Actividad);
                final EditText input_fechainicio = (EditText) view1.findViewById(R.id.Fechainicio);
                final EditText input_fechafinal = (EditText) view1.findViewById(R.id.Fechafinal);
                final EditText input_celu = (EditText) view1.findViewById(R.id.Celu);
                final EditText input_cantidad= (EditText) view1.findViewById(R.id.Cantidad);
                final EditText input_pago = (EditText) view1.findViewById(R.id.Pago);



                final Button btnSave = (Button) view1.findViewById(R.id.btnSave);


                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setView(view1).setTitle("Editar").setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialog.dismiss();
                    }
                });

                final Functions functions = new Functions(activity);
                final Item_Empleados  _items = functions.getSingleItem2(id);
                input_nombreem.setText(_items.getNombreem());
                input_actividad.setText(_items.getActividad());
                input_fechainicio.setText(_items.getFechainicio());
                input_fechafinal.setText(_items.getFechafinal());
                input_celu.setText(_items.getCelu());
                input_cantidad.setText(_items.getCantidad());
                input_pago.setText(_items.getPago());

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String nombreem = input_nombreem.getText().toString();
                        String actividad = input_actividad.getText().toString();
                        String fechainicio = input_fechainicio.getText().toString();
                        String fechafinal = input_fechafinal.getText().toString();
                        String celu = input_celu.getText().toString();
                        String cantidad = input_cantidad.getText().toString();
                        String pago= input_pago.getText().toString();



                        _items.setNombreem(nombreem);
                        _items.setActividad(actividad);
                        _items.setFechainicio(fechainicio);
                        _items.setFechafinal(fechafinal);
                        _items.setCelu(celu);
                        _items.setCantidad(cantidad);
                        _items.setPago(pago);



                        functions.Update2(_items);

                        Toast.makeText(activity, nombreem + " updated.", Toast.LENGTH_SHORT).show();
                        ((MainActivity_Empleados)activity).fetchRecords();//MainActivity
                        dialog.dismiss();
                    }
                });
                dialog = builder.create();
                dialog.show();


            }
        });
//EL otro

        holder.btnver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final int id = item.getId();


                LayoutInflater layoutInflater = activity.getLayoutInflater();
                View view1 = layoutInflater.inflate(R.layout.activity_edit2_2,null);

                final EditText input_nombreem = (EditText) view1.findViewById(R.id.Nombreem);
                final EditText input_actividad = (EditText) view1.findViewById(R.id.Actividad);
                final EditText input_fechainicio = (EditText) view1.findViewById(R.id.Fechainicio);
                final EditText input_fechafinal = (EditText) view1.findViewById(R.id.Fechafinal);
                final EditText input_celu = (EditText) view1.findViewById(R.id.Celu);
                final EditText input_cantidad= (EditText) view1.findViewById(R.id.Cantidad);
                final EditText input_pago = (EditText) view1.findViewById(R.id.Pago);



                final Button btnSave = (Button) view1.findViewById(R.id.btnSave);


                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setView(view1).setTitle("Editar").setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialog.dismiss();
                    }
                });

                final Functions functions = new Functions(activity);
                final Item_Empleados  _items = functions.getSingleItem2(id);
                input_nombreem.setText(_items.getNombreem());
                input_actividad.setText(_items.getActividad());
                input_fechainicio.setText(_items.getFechainicio());
                input_fechafinal.setText(_items.getFechafinal());
                input_celu.setText(_items.getCelu());
                input_cantidad.setText(_items.getCantidad());
                input_pago.setText(_items.getPago());

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String nombreem = input_nombreem.getText().toString();
                        String actividad = input_actividad.getText().toString();
                        String fechainicio = input_fechainicio.getText().toString();
                        String fechafinal = input_fechafinal.getText().toString();
                        String celu = input_celu.getText().toString();
                        String cantidad = input_cantidad.getText().toString();
                        String pago= input_pago.getText().toString();



                        _items.setNombreem(nombreem);
                        _items.setActividad(actividad);
                        _items.setFechainicio(fechainicio);
                        _items.setFechafinal(fechafinal);
                        _items.setCelu(celu);
                        _items.setCantidad(cantidad);
                        _items.setPago(pago);



                        functions.Update2(_items);

                        Toast.makeText(activity, nombreem + " updated.", Toast.LENGTH_SHORT).show();
                        ((MainActivity_Empleados)activity).fetchRecords();//MainActivity
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

        TextView nombreem;
        TextView actividad;
        TextView fechainicio;
        TextView fechafinal;
        TextView celu;
        TextView cantidad;
        TextView pago;
        TextView btnver;


        TextView btnEdit;
        TextView btnDelete;

        public MyViewHolder(View itemView) {
            super(itemView);

            nombreem = itemView.findViewById(R.id.nombreem);
            actividad= itemView.findViewById(R.id.actividad);
            fechainicio= itemView.findViewById(R.id.fechainicio);
          fechafinal= itemView.findViewById(R.id.fechafinal);
            celu = itemView.findViewById(R.id.celu);
            cantidad = itemView.findViewById(R.id.cantidad);
            pago = itemView.findViewById(R.id.pago);

            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            btnver= itemView.findViewById(R.id.btnver);

        }
    }
}
