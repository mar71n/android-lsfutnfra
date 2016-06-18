package utn.curso.mar71n.tpijuegomemoria.tablero;

import android.os.Handler;
import android.os.Message;

/**
 * Created by Usuario on 18/6/2016.
 */
public class SegunderoThread implements Runnable {
    private Handler hh;
    public SegunderoThread(Handler hh){
        this.hh = hh;
    }
    @Override
    public void run() {
        int i = 0;
        while (true){
            i++;
            if(i > 300){
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
            Message msg = new Message();
            msg.arg1 = 2;
            msg.arg2 = i;
            hh.sendMessage(msg);
        }
    }
}
