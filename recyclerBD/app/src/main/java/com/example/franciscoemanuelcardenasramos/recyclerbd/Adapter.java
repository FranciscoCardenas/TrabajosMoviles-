package com.example.franciscoemanuelcardenasramos.recyclerbd;

/**
 * Created by franciscoemanuelcardenasramos on 28/02/18.
 */


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ListaViewHolder> {

    Context context;
    ArrayList<Item> listadatos;

    public Adapter(Context context, ArrayList<Item> listadatos) {
        this.context = context;
        this.listadatos = listadatos;
    }

    @Override
    public ListaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_layout,null);
        return new ListaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListaViewHolder holder, int position) {
        Item item=listadatos.get(position);

        holder.txtId.setText(item.getId());
        holder.txtNombre.setText(item.getNombre());
        holder.txtApellido.setText(item.getApellido());
        holder.txtSalario.setText(item.getSalario());

    }

    @Override
    public int getItemCount() {
        return listadatos.size();
    }


    public class ListaViewHolder extends RecyclerView.ViewHolder {
        TextView txtId,txtNombre,txtApellido,txtSalario;

        public ListaViewHolder(View itemView) {
            super(itemView);

            txtId=itemView.findViewById(R.id.txtId);
            txtNombre=itemView.findViewById(R.id.txtNombre);
            txtApellido=itemView.findViewById(R.id.txtApellido);
            txtSalario=itemView.findViewById(R.id.txtSalario);
        }
    }
}
