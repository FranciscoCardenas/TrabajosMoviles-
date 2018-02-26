package com.example.franciscoemanuelcardenasramos.recyclerclases;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by franciscoemanuelcardenasramos on 21/02/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {


    private String[] nombres;
    private  String[] carreras;
    private  String[] numc;

    public RecyclerAdapter(String[] nombres ,String[] carreras , String[] numc) {
        this.nombres = nombres;
        this.carreras= carreras;
        this.numc = numc;
    }



    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,null,false);
        //RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.campo_nombre.setText(nombres[position]);
        holder.campo_carreras.setText(carreras[position]);
        holder.campo_numc.setText(numc[position]);
    }

    @Override
    public int getItemCount() {
        return nombres.length + carreras.length + numc.length;

    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView campo_nombre;
        TextView campo_carreras;
        TextView campo_numc;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            campo_carreras=itemView.findViewById(R.id.idcarrera);
            campo_nombre = itemView.findViewById(R.id.alumno_id);
            campo_numc = itemView.findViewById(R.id.idNc);


        }
    }
}
