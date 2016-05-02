package com.lslutnfra.ejercicioparacompletarintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ingresarURL = (Button) findViewById(R.id.btnIngresarUrl);
        Button verPagina = (Button) findViewById(R.id.btnVerPagina);
        ingresarURL.setOnClickListener(this);
        verPagina.setOnClickListener(this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {




    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnIngresarUrl){
            Intent i = new Intent(this,Pantalla2Activity.class);
            startActivity(i);
        }
    }
}
