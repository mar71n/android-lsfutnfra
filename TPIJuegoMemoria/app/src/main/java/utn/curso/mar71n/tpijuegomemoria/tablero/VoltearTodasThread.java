package utn.curso.mar71n.tpijuegomemoria.tablero;

import android.os.Handler;
import android.os.Message;
import android.util.Log;


/**
 * Created by mrampoldi on 15/06/2016.
 */
public class VoltearTodasThread implements Runnable {
    private Handler h;

    public VoltearTodasThread(Handler h){
        this.h = h;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Log.d("theread", "salgo del theread");
            return;
        }
        sendMensage("pasaron 3");

    }

    private void sendMensage(String msg){
        Message message = new Message();
        message.arg1 = 1;
        h.sendMessage(message);
    }
}
