package utn.curso.mar71n.tpijuegomemoria.tablero.entidades;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utn.curso.mar71n.tpijuegomemoria.R;
import utn.curso.mar71n.tpijuegomemoria.tablero.threads.EsperarYTareaThread;
import utn.curso.mar71n.tpijuegomemoria.tablero.threads.SegunderoThread;

/**
 * Created by mrampoldi on 29/06/2016.
 */
public class Tablero implements OnFichaClick,  Handler.Callback {
    public List<Ficha> fichas;
    private int nivel; // nivel de dificultad
    private int kmostradas;
    private int[] parmostradas;
    private Thread tseg;  // thread cuenta segundos
    private int pares; // cuantas pares de fichas hay
    private int paresOk; // cuantos pares de fichas encontrados
    public int segundos; // segundos de juego
    private int vidas; // veces que se puede errar
    private ITableroActivity tableroActivity;
    ImageView v1;
    ImageView v2;
    ImageView v3;
    private Handler h;
    private boolean permitirclicks;


    public Tablero(ITableroActivity tableroActivity, int nivel){
        this.nivel = nivel;
        pares = 6;
        vidas = 3;
        kmostradas = 0;
        permitirclicks = false;
        parmostradas = new int[2];
        this.tableroActivity = tableroActivity;
        v1 = tableroActivity.getImagen(1);
        v2 = tableroActivity.getImagen(2);
        v3 = tableroActivity.getImagen(3);
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

    }

    @Override
    public void clickEnFicha(int position) {
        // TODO implementar sonidos en las fichas y si gana o pierde
        Ficha f = fichas.get(position);
        if (!permitirclicks){
            return;
        }
        if (kmostradas < 2) {
            if (f.getEstado() == Ficha.TAPADA) {
                f.setEstado(Ficha.DESTAPADA);
                tableroActivity.redibujar(position);
                kmostradas++;
                parmostradas[kmostradas - 1] = position;
            }
        }
        if (kmostradas == 2) {
            permitirclicks = false;
            Ficha f1 = fichas.get(parmostradas[0]);
            Ficha f2 = fichas.get(parmostradas[1]);
            if (f1.getImagen() == f2.getImagen()) {
                kmostradas = 0;
                paresOk++;
                permitirclicks = true;
                tableroActivity.lanzarToast((CharSequence) "BIEN !!!", Toast.LENGTH_SHORT);
            } else {
                vidas--;
                switch (vidas){
                    // TODO esto pasarlo al activity. ITableroActivity.sacarVidasImagenes(int vidas)
                    // Son elementos visuales.
                    case 2 : v1.setImageResource(R.drawable.cuadrados);break;
                    case 1 : v2.setImageResource(R.drawable.cuadrados);break;
                    case 0 : v3.setImageResource(R.drawable.cuadrados);break;
                }
                if(vidas == 0){
                    tseg.interrupt();
                    String gameover = " G A M E   O V E R ";
                    tableroActivity.lanzarToast((CharSequence) gameover, Toast.LENGTH_LONG);
                    permitirclicks = false;
                    tableroActivity.clickableFAB(true);
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
                tableroActivity.lanzarToast((CharSequence) ganaste, Toast.LENGTH_SHORT);
                EsperarYTareaThread eyt = new EsperarYTareaThread(h, 2, EsperarYTareaThread.pedirNombre);
                Thread t = new Thread(eyt);
                t.start();
                tableroActivity.clickableFAB(true);
            }
        }
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.arg1){
            case 1:
                String senal = (String) msg.obj;
                switch (senal) {
                    case EsperarYTareaThread.taparTodas:
                        taparTodas();arrancarSegundero();permitirclicks = true;
                        break;
                    case EsperarYTareaThread.taparDos:
                        taparDos();permitirclicks = true;break;
                    case EsperarYTareaThread.pedirNombre:
                        tableroActivity.lanzarDialogoPedirNombre();
                        break;
                }
                tableroActivity.redibujar();
                return false;
            case 2:
                segundos = msg.arg2;
                String sSegundos = String.format("%04d", msg.arg2);
                tableroActivity.setTxtTiempo("Tiempo : " + sSegundos);
                tableroActivity.redibujar();
                return false;
            default: return false;
        }
    }
    private void taparTodas(){
        for(Ficha f : fichas) {
            f.setEstado(Ficha.TAPADA);
        }
    }
    private void arrancarSegundero(){
        Handler h = new Handler(this);
        SegunderoThread segunderoThread = new SegunderoThread(h);
        tseg = new Thread(segunderoThread);
        tseg.start();

    }
    private void taparDos() {
        Ficha f1 = fichas.get(parmostradas[0]);
        Ficha f2 = fichas.get(parmostradas[1]);
        f1.setEstado(Ficha.TAPADA);
        f2.setEstado(Ficha.TAPADA);
        kmostradas = 0;
        permitirclicks = true;
    }
    public void iniciar(){
        Collections.shuffle(fichas);
        kmostradas = 0;
        paresOk = 0;
        segundos = 0;
        vidas = 3;
        // TODO esto va en el activity. ITableroActivity.ponerVidasImagenes()
        v1 = tableroActivity.getImagen(1);
        v2 = tableroActivity.getImagen(2);
        v3 = tableroActivity.getImagen(3);
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
        tableroActivity.redibujar();
        Log.d("theread", "muestra");
        h = new Handler(this);
        EsperarYTareaThread vt = new EsperarYTareaThread(h, pausa, EsperarYTareaThread.taparTodas);
        Thread t = new Thread(vt);
        t.start();
        tableroActivity.clickableFAB(false);
    }
    private void mostrarTodas(){
        for(Ficha f : fichas) {
            f.setEstado(Ficha.DESTAPADA);
        }
    }

    public void paraThread(){
        if (tseg != null) {
            Log.d("th", "lo pare porque existe");
            tseg.interrupt();
        }else {Log.d("th", "NO existe");}

    }
}
