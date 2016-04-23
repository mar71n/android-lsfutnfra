package com.cursoandroid.martin.lista_en_clase5;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by android on 19/04/16.
 */
public class MyAdapter extends RecyclerView.Adapter {
    List<Persona> lista;
    static Integer pasoXonCreateViewHolder = 0;
    static Integer pasoXonBindViewHolder = 0;
    static Integer pasoXgetItemCount = 0;

    public MyAdapter(List<Persona> lista){
        this.lista = lista;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        RecyclerView.ViewHolder vh = new MyViewHolder(v);
        pasoXonCreateViewHolder++;
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Persona p = lista.get(position);
        MyViewHolder mvh = (MyViewHolder) holder;
        mvh.tNombre.setText(p.getNombre());
        mvh.tApellido.setText(p.getApellido());
        pasoXonBindViewHolder++;
    }

    @Override
    public int getItemCount() {
        pasoXgetItemCount++;
        return lista.size();
    }
}
