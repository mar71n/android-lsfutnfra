package utn.curso.mar71n.tpijuegomemoria.haigscores;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import utn.curso.mar71n.tpijuegomemoria.R;

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

        HScoresDBHelper hsdbHelper = new HScoresDBHelper(getActivity().getBaseContext());

        RecyclerView recyclerViewHS = (RecyclerView) rootView.findViewById(R.id.listaHS);

        LinearLayoutManager l = new LinearLayoutManager(container.getContext());
        recyclerViewHS.setLayoutManager(l);

        List<HaighScores> lhaighScores = hsdbHelper.getAll();

        /*for(HaighScores hs : lhaighScores){
            Log.d("HS", "id : " + hs.getId() + " tiempo : " + hs.getTiempo() + " nombre : " + hs.getNombre());
        }*/


        hsAdapter = new HSAdapter( lhaighScores);
        recyclerViewHS.setAdapter(hsAdapter);

        return rootView;
    }
}