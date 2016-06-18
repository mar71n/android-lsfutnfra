package utn.curso.mar71n.tpijuegomemoria.tablero;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by mrampoldi on 16/06/2016.
 */
public class EsperarYTaparThread implements Runnable {
    private Handler h;
    private int pausa;
    private String msgcallBack;
    public static final String taparTodas = "TaparTodas";
    public static final String taparDos = "TaparDos";

    public EsperarYTaparThread(Handler h, int pausa, String msgcallBack){
        this.h = h;
        this.pausa = pausa;
        this.msgcallBack = msgcallBack;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(pausa * 1000);
        } catch (InterruptedException e) {
            Log.d("theread", "salgo del theread");
            return;
        }
        sendMensage(msgcallBack);

    }

    private void sendMensage(String msg){
        Message message = new Message();
        message.obj = msg;
        message.arg1 = 1;
        h.sendMessage(message);
    }

}
