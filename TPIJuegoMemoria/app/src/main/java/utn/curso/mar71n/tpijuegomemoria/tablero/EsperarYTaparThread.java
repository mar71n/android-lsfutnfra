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

    public EsperarYTaparThread(Handler h, int pausa){
        this.h = h;
        this.pausa = pausa;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(pausa * 1000);
        } catch (InterruptedException e) {
            Log.d("theread", "salgo del theread");
            return;
        }
        sendMensage("TaparDos");

    }

    private void sendMensage(String msg){
        Message message = new Message();
        message.arg1 = 2;
        message.obj = msg;
        h.sendMessage(message);
    }

}
