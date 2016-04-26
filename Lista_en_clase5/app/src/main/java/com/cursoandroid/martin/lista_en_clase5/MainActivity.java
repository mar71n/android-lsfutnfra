package com.cursoandroid.martin.lista_en_clase5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyOnItemClick {

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

        MyAdapter adapter = new MyAdapter(lista, this, this);

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

    public void seMostroFinLista(){
        // paginando
        // aca habria que pedir el siguiente bloque de datos a algun servicio
        Toast.makeText(this,"ultimo dato, aguarde...",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(int position) {
        String t = "click en " + position;
        Toast.makeText(this,(CharSequence) t,Toast.LENGTH_SHORT).show();
        // lanzo la otra activity
        Intent i = new Intent(this, Pantalla2Activity.class);
        startActivity(i);
    }
}
