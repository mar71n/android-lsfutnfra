package com.cursoandroid.martin.lista_en_clase5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Pantalla2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        int position = b.getInt("p");

        //int position = getIntent().getExtras().getInt("p");

        Persona p = MainActivity.lista.get(position);

        Log.d("activity2",p.getNombre());
    }
}
