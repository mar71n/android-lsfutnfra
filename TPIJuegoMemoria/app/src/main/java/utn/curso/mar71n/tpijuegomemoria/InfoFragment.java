package utn.curso.mar71n.tpijuegomemoria;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import utn.curso.mar71n.tpijuegomemoria.R;

/**
 * Created by android on 31/05/16.
 */
public class InfoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle
            savedInstanceState) {

        // Creamos la View para este fragment y la devolvemos
        ViewGroup rootView = (ViewGroup)
                inflater.inflate(R.layout.layout_informacion,
                        container, false);

        // Cargamos la View con contenido, seteamos listeners, etc.
        //...

        return rootView;
    }
}