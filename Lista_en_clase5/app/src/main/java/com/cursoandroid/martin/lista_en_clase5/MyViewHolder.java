package com.cursoandroid.martin.lista_en_clase5;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by android on 19/04/16.
 */
public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView tNombre;
    public TextView tApellido;
    private MyOnItemClick listener;
    private int position;
    public MyViewHolder(View itemView, MyOnItemClick listener) {
        super(itemView);

        tNombre = (TextView) itemView.findViewById(R.id.txtNombre);
        tApellido = (TextView) itemView.findViewById(R.id.txtApellido);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        listener.onItemClick(position);
    }

    public void setPosition(int position){
        this.position = position;
    }
}
