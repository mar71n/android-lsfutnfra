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
public class TableroJMActivity extends AppCompatActivity implements OnFichaClick, Handler.Callback, ITableroActivity {
    private List<Ficha> fichas;
    private MyAdapter adapterf;
    private Handler h;
    private int nivel; // nivel de dificultad
    private int kmostradas;
    private int[] parmostradas;
    private FloatingActionButton fabT;
    private TextView txtTiempo;
    private Thread tseg;  // thread cuenta segundos
    private int pares; // cuantas pares de fichas hay
    private int paresOk; // cuantos pares de fichas encontrados
    private int segundos; // segundos de juego
    private int vidas; // veces que se puede errar
    ImageView v1;
    ImageView v2;
    ImageView v3;
    Tablero tablero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);

        tablero = new Tablero(this);

        txtTiempo = (TextView) findViewById(R.id.textVTiempo);
        pares = 6;
        vidas = 3;

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
                tablero.iniciar();// iniciar();
            }
        });


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        this.nivel = extras.getInt("nivel");

        kmostradas = 0;
        parmostradas = new int[2];

        fichas = new ArrayList<Ficha>();
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_1));
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_1));
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_2));
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_2));
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_3));
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_3));
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_4));
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_4));
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_5));
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_5));
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_6));
        fichas.add(new Ficha(Ficha.TAPADA, R.drawable.img_6));


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
    public void clickEnFicha(int position) {
        Ficha f = fichas.get(position);
        if (!f.isClickable()){
            return;
        }
        //String t = "click en " + position + " stado : " + f.getEstado();
        //Toast.makeText(this, (CharSequence) t, Toast.LENGTH_SHORT).show();
        if (kmostradas < 2) {
            if (f.getEstado() == Ficha.TAPADA) {
                f.setEstado(Ficha.DESTAPADA);
                adapterf.notifyItemChanged(position);
                kmostradas++;
                parmostradas[kmostradas - 1] = position;
            }
        }
        if (kmostradas == 2) {
            Ficha f1 = fichas.get(parmostradas[0]);
            Ficha f2 = fichas.get(parmostradas[1]);
            if (f1.getImagen() == f2.getImagen()) {
                kmostradas = 0;
                paresOk++;
                Toast.makeText(this, (CharSequence) "BIEN !!!", Toast.LENGTH_SHORT).show();
            } else {
                vidas--;
                switch (vidas){
                    case 2 : v1.setImageResource(R.drawable.cuadrados);break;
                    case 1 : v2.setImageResource(R.drawable.cuadrados);break;
                    case 0 : v3.setImageResource(R.drawable.cuadrados);break;
                }
                String tarea;
                if(vidas == 0){
                    tseg.interrupt();
                    String gameover = " G A M E   O V E R ";
                    Toast.makeText(this, (CharSequence) gameover, Toast.LENGTH_LONG).show();
                    clickableTodas(false);
                    fabT.setClickable(true);
                }else{
                    h = new Handler(this);
                    EsperarYTareaThread eyt = new EsperarYTareaThread(h, 1, EsperarYTareaThread.taparDos);
                    Thread t = new Thread(eyt);
                    t.start();
                }
            }
            if(pares == paresOk){
                tseg.interrupt();
                String ganaste = "Bien !!! segundos: " + segundos;
                Toast.makeText(this, (CharSequence) ganaste, Toast.LENGTH_SHORT).show();
                EsperarYTareaThread eyt = new EsperarYTareaThread(h, 2, EsperarYTareaThread.pedirNombre);
                Thread t = new Thread(eyt);
                t.start();
                fabT.setClickable(true);
            }
        }
        //adapterf.notifyItemChanged(position);
        // cambiar el estado de la ficha y refrescar la pantalla
    }

    private void iniciar(){
        Collections.shuffle(fichas);
        kmostradas = 0;
        paresOk = 0;
        segundos = 0;
        vidas = 3;
        v1.setImageResource(R.drawable.androide);
        v2.setImageResource(R.drawable.androide);
        v3.setImageResource(R.drawable.androide);
        int pausa;
        switch (nivel){
            case 1 : pausa = 3; break;
            case 2 : pausa = 5; break;
            case 3 : pausa = 10; break;
            default: pausa = 3;
        }
        mostrarTodas();
        adapterf.notifyDataSetChanged();
        Log.d("theread", "muestra");
        h = new Handler(this);
        EsperarYTareaThread vt = new EsperarYTareaThread(h, pausa, EsperarYTareaThread.taparTodas);
        Thread t = new Thread(vt);
        t.start();
        fabT.setClickable(false);
    }

    private void mostrarTodas(){
        for(Ficha f : fichas) {
            f.setEstado(Ficha.DESTAPADA);
        }
    }

    private void taparTodas(){
        for(Ficha f : fichas) {
            f.setEstado(Ficha.TAPADA);
        }
    }

    private void clickableTodas(boolean clickable){
        for(Ficha f : fichas) {
            f.setClickable(clickable);
        }
    }

    @Override
    public boolean handleMessage(Message msg) {
        //Log.d("THREAD ", "a1 : " + msg.arg1 + " a2 : " + msg.arg2);
        switch (msg.arg1){
            case 1:
                String senal = (String) msg.obj;
                switch (senal) {
                    case EsperarYTareaThread.taparTodas:
                        taparTodas();arrancarSegundero();clickableTodas(true);
                        break;
                    case EsperarYTareaThread.taparDos:
                        taparDos();break;
                    case EsperarYTareaThread.pedirNombre:
                        pedirNombre();break;
                }
                adapterf.notifyDataSetChanged();
                return false;
            case 2:
                segundos = msg.arg2;
                String sSegundos = String.format("%04d", msg.arg2);
                txtTiempo.setText("Tiempo : " + sSegundos);
                adapterf.notifyDataSetChanged();
                return false;
            default: return false;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home : finish();break;
        }
        return true;
    }

    private void taparDos() {
        Ficha f1 = fichas.get(parmostradas[0]);
        Ficha f2 = fichas.get(parmostradas[1]);
        f1.setEstado(Ficha.TAPADA);
        f2.setEstado(Ficha.TAPADA);
        kmostradas = 0;
    }

    @Override
    protected void onDestroy() {
        if (tseg != null) {
            Log.d("th", "lo pare porque existe");
            tseg.interrupt();
        }else {Log.d("th", "NO existe");}
        super.onDestroy();
    }

    private void arrancarSegundero(){
        Handler h = new Handler(this);
        SegunderoThread segunderoThread = new SegunderoThread(h);
        tseg = new Thread(segunderoThread);
        tseg.start();

    }

    private void pedirNombre(){
        android.support.v4.app.DialogFragment dialogFragment = new IngreseNombreDialogFragment();
        Bundle b = new Bundle();
        segundos = tablero.segundos;
        b.putInt("segundos",segundos);
        dialogFragment.setArguments(b);
        dialogFragment.show(getSupportFragmentManager(), "nombre");
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
        pedirNombre();
    }

    @Override
    public void setTxtTiempo(String tiempo) {
        txtTiempo.setText(tiempo);
    }
}
