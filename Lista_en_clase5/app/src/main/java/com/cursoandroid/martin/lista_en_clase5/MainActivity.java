package com.cursoandroid.martin.lista_en_clase5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Persona> lista = new ArrayList<Persona>();
        Persona p1 = new Persona("Juan", "Perez");
        Persona p2 = new Persona("Luis", "Gomez");
        Persona p3 = new Persona("Luis", "Gomez");

        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);

        RecyclerView rv = (RecyclerView) findViewById(R.id.list);

        MyAdapter adapter = new MyAdapter(lista);

        rv.setAdapter(adapter);

        LinearLayoutManager l = new LinearLayoutManager(this);
        rv.setLayoutManager(l);
    }

    @Override
    protected void onStop(){
        Log.d("paso x onCreateViewHolder",MyAdapter.pasoXonCreateViewHolder.toString() );
        Log.d("paso x onBindViewHolder", MyAdapter.pasoXonBindViewHolder.toString());
        Log.d("paso x getItemCount", MyAdapter.pasoXgetItemCount.toString());
        super.onStop();
    }
}
