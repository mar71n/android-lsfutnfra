package utn.curso.mar71n.tpijuegomemoria.tablero;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utn.curso.mar71n.tpijuegomemoria.R;
import utn.curso.mar71n.tpijuegomemoria.tablero.entidades.Ficha;
import utn.curso.mar71n.tpijuegomemoria.tablero.entidades.OnFichaClick;
import utn.curso.mar71n.tpijuegomemoria.tablero.threads.EsperarYTareaThread;
import utn.curso.mar71n.tpijuegomemoria.tablero.threads.SegunderoThread;

/**
 * Created by Usuario on 6/6/2016.
 */
public class TableroJMActivity extends AppCompatActivity implements  ITableroActivity {
    private MyAdapter adapterf;
    private int nivel; // nivel de dificultad
    private FloatingActionButton fabT;
    private TextView txtTiempo;
    private int segundos; // segundos de juego
    ImageView v1;
    ImageView v2;
    ImageView v3;
    Tablero tablero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        this.nivel = extras.getInt("nivel");

        tablero = new Tablero(this, nivel);

        txtTiempo = (TextView) findViewById(R.id.textVTiempo);

        Toolbar toolbart = (Toolbar) findViewById(R.id.toolbarT);
        toolbart.setTitle("Memo Test");
        setSupportActionBar(toolbart);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        fabT = (FloatingActionButton) findViewById(R.id.fabT);
        fabT.setClickable(true);
        fabT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabT.setClickable(false);
                tablero.iniciar();
            }
        });

        RecyclerView list = (RecyclerView)findViewById(R.id.list);

        GridLayoutManager layoutManager = new GridLayoutManager(this,3);

        list.setLayoutManager(layoutManager);

        adapterf = new MyAdapter(tablero.fichas,tablero);
        list.setAdapter(adapterf);

        v1 = (ImageView) findViewById(R.id.imgvida1);
        v2 = (ImageView) findViewById(R.id.imgvida2);
        v3 = (ImageView) findViewById(R.id.imgvida3);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home : finish();break;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        tablero.paraThread();
        super.onDestroy();
    }

    @Override
    public ImageView getImagen(int ni) {
        switch (ni){
            case 1: return v1;
            case 2: return v2;
            case 3: return v3;
            default: return null;
        }
    }

    @Override
    public void redibujar(int position) {
        adapterf.notifyItemChanged(position);
    }

    public void redibujar() {
        adapterf.notifyDataSetChanged();
    }

    @Override
    public void lanzarToast(CharSequence mensage, int duracion) {
        Toast.makeText(this, mensage, duracion).show();
    }

    @Override
    public void clickableFAB(boolean clickable) {
        fabT.setClickable(clickable);
    }

    @Override
    public void lanzarDialogoPedirNombre() {
        android.support.v4.app.DialogFragment dialogFragment = new IngreseNombreDialogFragment();
        Bundle b = new Bundle();
        segundos = tablero.segundos;
        b.putInt("segundos",segundos);
        dialogFragment.setArguments(b);
        dialogFragment.show(getSupportFragmentManager(), "nombre");
    }

    @Override
    public void setTxtTiempo(String tiempo) {
        txtTiempo.setText(tiempo);
    }
}
