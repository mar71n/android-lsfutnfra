package utn.curso.mar71n.tpijuegomemoria.haigscores;

import android.support.v7.widget.RecyclerView.Adapter;
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

    /*
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d("onBind N", "position : " + position);
        HaighScores hs = lista.get(position);
        HSViewHolder hsvholder = (HSViewHolder) holder;
        hsvholder.nombre.setText(hs.getNombre());
        //hsvholder.segundos.setText(hs.getTiempo());
    }*/

    /**/
    @Override
    public void onBindViewHolder(HSViewHolder holder, int position) {
        HaighScores hs = lista.get(position);
        holder.nombre.setText(hs.getNombre());
        //holder.segundos.setText(hs.getTiempo());
    }/**/

    @Override
    public int getItemCount() {
        return lista.size();
    }
}

