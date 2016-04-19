package com.cursoandroid.martin.lista_en_clase5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

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
    }
}
