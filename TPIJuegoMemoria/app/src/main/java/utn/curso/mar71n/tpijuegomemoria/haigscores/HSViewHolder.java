package utn.curso.mar71n.tpijuegomemoria.haigscores;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import utn.curso.mar71n.tpijuegomemoria.R;

/**
 * Created by Usuario on 20/6/2016.
 */
public class HSViewHolder extends RecyclerView.ViewHolder {
    public TextView nombre;
    public TextView segundos;
    public ImageView imagen;

    public HSViewHolder(View itemView) {
        super(itemView);
        nombre = (TextView) itemView.findViewById(R.id.textViewNombre);
        segundos = (TextView) itemView.findViewById(R.id.textViewSegundos);
        imagen = (ImageView) itemView.findViewById(R.id.imageViewHS);
    }

}
