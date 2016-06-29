package utn.curso.mar71n.tpijuegomemoria.haigscores;

import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import utn.curso.mar71n.tpijuegomemoria.R;

/**
 * Created by Usuario on 20/6/2016.
 */
public class HSAdapter extends Adapter<HSViewHolder> {
    private List<HaighScores> lista;

    public HSAdapter(List<HaighScores> lista){
        this.lista = lista;
    }

    @Override
    public HSViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hscoreitem_layout,parent,false);
        HSViewHolder vh = new HSViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(HSViewHolder holder, int position) {
        HaighScores hs = lista.get(position);
        holder.nombre.setText(hs.getNombre());
        holder.segundos.setText(String.valueOf(hs.getTiempo()) + " segundos.");
        switch (position){
            case 0: holder.imagen.setImageResource(R.drawable.trofeo);break;
            case 1: holder.imagen.setImageResource(R.drawable.medalla);break;
            case 2: holder.imagen.setImageResource(R.drawable.signos);break;
            default: holder.imagen.setImageResource(R.drawable.darpalmas);
        }

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}

