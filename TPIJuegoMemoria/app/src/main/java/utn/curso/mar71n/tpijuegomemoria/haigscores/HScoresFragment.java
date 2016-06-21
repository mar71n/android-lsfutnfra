package utn.curso.mar71n.tpijuegomemoria.haigscores;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import utn.curso.mar71n.tpijuegomemoria.R;
import utn.curso.mar71n.tpijuegomemoria.main.MainActivity;

/**
 * Created by android on 31/05/16.
 */
public class HScoresFragment extends Fragment {

    HSAdapter hsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle
            savedInstanceState) {

        // Creamos la View para este fragment y la devolvemos
        ViewGroup rootView = (ViewGroup)
                inflater.inflate(R.layout.layout_hscores,
                        container, false);

        // Cargamos la View con contenido, seteamos listeners, etc.
        //...
        Log.d("fragmet HS","PASO!!!");

        HScoresDBHelper hsdbHelper = new HScoresDBHelper(this.getActivity());

        /*
        HaighScores unhs = new HaighScores();
        unhs.setTiempo(77);
        unhs.setNombre("Martin");
        hsdbHelper.saveHS(unhs);
        */

        ArrayList<HaighScores> lhaighScores = hsdbHelper.getAll();

        for(HaighScores hs : lhaighScores){
            Log.d("HS", "id : " + hs.getId() + " tiempo : " + hs.getTiempo() + " nombre : " + hs.getNombre());
        }



        hsAdapter = new HSAdapter( lhaighScores);

        RecyclerView recyclerViewHS = (RecyclerView) rootView.findViewById(R.id.listaHS);
        recyclerViewHS.setAdapter(hsAdapter);

        LinearLayoutManager l = new LinearLayoutManager(getActivity());
        recyclerViewHS.setLayoutManager(l);

        return rootView;
    }
}