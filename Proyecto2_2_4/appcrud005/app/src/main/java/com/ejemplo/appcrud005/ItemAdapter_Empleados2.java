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

public class ItemAdapter_Empleados2 extends RecyclerView.Adapter<ItemAdapter_Empleados2.MyViewHolder> {
    private Activity activity;
    private ArrayList<Item_Tabla> list;
    private AlertDialog dialog;

    public ItemAdapter_Empleados2(Activity activity, ArrayList<Item_Tabla> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public ItemAdapter_Empleados2.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        Context context;
        context = parent.getContext();


        LayoutInflater nuevo;
        nuevo = LayoutInflater.from(context);

        View itemView = nuevo.inflate(R.layout.item_list3,parent,false);


        return new MyViewHolder(itemView);
    }



    /*
    Vincula los datos con los datos con los elementos holder
     Establece listeners para los "botones" (que no son botones)

     */
    @Override
    public void onBindViewHolder(ItemAdapter_Empleados2.MyViewHolder holder, int position) {

        final Item_Tabla item = list.get(position);



        holder.nombreem.setText("Nombre Empleado:  " + item.getNombreem());
        holder.nombrecl.setText("Nombre Cliente:   " + item.getNombrecl());

      ;













    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nombreem;
        TextView nombrecl;
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
            nombrecl=itemView.findViewById(R.id.nombrecl);

        }
    }
}
