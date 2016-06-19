package utn.curso.mar71n.tpijuegomemoria.niveles;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.security.AccessControlContext;

import utn.curso.mar71n.tpijuegomemoria.R;
import utn.curso.mar71n.tpijuegomemoria.main.INiveles;
import utn.curso.mar71n.tpijuegomemoria.main.MainActivity;

/**
 * Created by android on 31/05/16.
 */
public class NivelesFragment extends Fragment {
    private int nivel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle
            savedInstanceState) {

        // Creamos la View para este fragment y la devolvemos
        ViewGroup rootView = (ViewGroup)
                inflater.inflate(R.layout.layout_niveles,
                        container, false);

        // Cargamos la View con contenido, seteamos listeners, etc.
        //...
        INiveles mainAct = (INiveles) this.getActivity();
        int nivel = mainAct.getNivel();
        Log.d("Nivel Fragm","nivel:" + nivel);


        RadioButton n1 = (RadioButton) rootView.findViewById(R.id.radioButtonN1);
        RadioButton n2 = (RadioButton) rootView.findViewById(R.id.radioButtonN2);
        RadioButton n3 = (RadioButton) rootView.findViewById(R.id.radioButtonN3);
        RadioGroup rbg = (RadioGroup) rootView.findViewById(R.id.rdId);
        switch (nivel){
            case 1 : rbg.check(R.id.radioButtonN1);break;
            case 2 : rbg.check(R.id.radioButtonN2);break;
            case 3 : rbg.check(R.id.radioButtonN3);break;
        }
        NivelesFragmentListener nfl = new NivelesFragmentListener(n1, n2, n3, mainAct);
        n1.setOnClickListener(nfl);
        n2.setOnClickListener(nfl);
        n3.setOnClickListener(nfl);

        return rootView;
    }

}