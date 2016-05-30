package com.example.android.navdrawclase10;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by android on 24/05/16.
 */
public class Contenido extends Fragment {

    private int idL = R.layout.layout_contenido1;

    public void setIdL(int idL) {
        this.idL = idL;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(idL, container,false);

        ImageView img = (ImageView)v.findViewById(R.id.imgPlaneta);
        TextView txtTitulo = (TextView)v.findViewById(R.id.txtTitulo);
        TextView txtInfo = (TextView)v.findViewById(R.id.txtInfo);

        Bundle args = getArguments();
        int idPlaneta = args.getInt("idPlaneta");
        switch(idPlaneta)
        {
            case 0:
                img.setImageResource(R.drawable.mercurio);
                txtTitulo.setText(getText(R.string.titulo_mercurio));
                txtInfo.setText(getText(R.string.info_mercurio));
                break;
            case 1:
                img.setImageResource(R.drawable.venus);
                txtTitulo.setText(getText(R.string.titulo_venus));
                txtInfo.setText(getText(R.string.info_venus));
                break;
            case 2:
                img.setImageResource(R.drawable.tierra);
                txtTitulo.setText(getText(R.string.titulo_tierra));
                txtInfo.setText(getText(R.string.info_tierra));
                break;
            case 3:
                img.setImageResource(R.drawable.marte);
                txtTitulo.setText(getText(R.string.titulo_marte));
                txtInfo.setText(getText(R.string.info_marte));
                break;
            case 4:
                img.setImageResource(R.drawable.jupiter);
                txtTitulo.setText(getText(R.string.titulo_jupiter));
                txtInfo.setText(getText(R.string.info_jupiter));
                break;
        }

        return v;
    }
}