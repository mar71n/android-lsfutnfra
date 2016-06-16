package utn.curso.mar71n.tpijuegomemoria.tablero;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utn.curso.mar71n.tpijuegomemoria.R;
import utn.curso.mar71n.tpijuegomemoria.tablero.Ficha;
import utn.curso.mar71n.tpijuegomemoria.tablero.MyAdapter;
import utn.curso.mar71n.tpijuegomemoria.tablero.OnFichaClick;

/**
 * Created by Usuario on 6/6/2016.
 */
public class TableroJMActivity extends AppCompatActivity implements OnFichaClick, Handler.Callback {
    List<Ficha> fichas;
    MyAdapter adapterf;
    private Handler h;
    private int nivel;
    private int kmostradas;
    private int[] parmostradas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);

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
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_6));
        Collections.shuffle(fichas);

        RecyclerView list = (RecyclerView)findViewById(R.id.list);

        GridLayoutManager layoutManager = new GridLayoutManager(this,3);

        list.setLayoutManager(layoutManager);

        adapterf = new MyAdapter(fichas,this);
        list.setAdapter(adapterf);

        iniciar();


    }
    @Override
    public void clickEnFicha(int position) {
        Ficha f = fichas.get(position);
        //String t = "click en " + position + " stado : " + f.getEstado();
        //Toast.makeText(this, (CharSequence) t, Toast.LENGTH_SHORT).show();

        if (f.getEstado() == Ficha.TAPADA) {
            f.setEstado(Ficha.DESTAPADA);
            kmostradas++;
            parmostradas[kmostradas-1] =position;
        }
        if (kmostradas == 2){
            Ficha f1 = fichas.get(parmostradas[0]);
            Ficha f2 = fichas.get(parmostradas[1]);
            if(f1.getImagen() == f2.getImagen()){
                Toast.makeText(this, (CharSequence) "BIEN !!!", Toast.LENGTH_SHORT).show();
            }else {
                h = new Handler(this);
                EsperarYTaparThread eyt = new EsperarYTaparThread(h, 1);
                Thread t = new Thread(eyt);
                t.start();
            }
            kmostradas = 0;
        }
        adapterf.notifyItemChanged(position);
        // cambiar el estado de la ficha y refrescar la pantalla
    }

    private void iniciar(){
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
        VoltearTodasThread vt = new VoltearTodasThread(h, pausa);
        Thread t = new Thread(vt);
        t.start();
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

    @Override
    public boolean handleMessage(Message msg) {
        Log.d("recivi", String.valueOf(msg.arg1));
        String senal = (String) msg.obj;
        switch (senal){
            case "TaparTodas" : taparTodas();break;
            case "TaparDos" : taparDos();
        }
        adapterf.notifyDataSetChanged();
        return false;
    }

    private void taparDos() {
        Ficha f1 = fichas.get(parmostradas[0]);
        Ficha f2 = fichas.get(parmostradas[1]);
        f1.setEstado(Ficha.TAPADA);
        f2.setEstado(Ficha.TAPADA);
    }
}
