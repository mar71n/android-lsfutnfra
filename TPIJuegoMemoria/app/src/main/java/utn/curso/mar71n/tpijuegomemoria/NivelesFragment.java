package utn.curso.mar71n.tpijuegomemoria;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

/**
 * Created by android on 31/05/16.
 */
public class NivelesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle
            savedInstanceState) {

        // Creamos la View para este fragment y la devolvemos
        ViewGroup rootView = (ViewGroup)
                inflater.inflate(R.layout.layout_niveles,
                        container, false);

        // Cargamos la View con contenido, seteamos listeners, etc.
        //...

        RadioButton n1 = (RadioButton) rootView.findViewById(R.id.radioButtonN1);
        RadioButton n2 = (RadioButton) rootView.findViewById(R.id.radioButtonN2);
        RadioButton n3 = (RadioButton) rootView.findViewById(R.id.radioButtonN3);
        NivelesFragmentListener nfl = new NivelesFragmentListener(n1, n2, n3);
        n1.setOnClickListener(nfl);
        n2.setOnClickListener(nfl);
        n3.setOnClickListener(nfl);

        return rootView;
    }

}