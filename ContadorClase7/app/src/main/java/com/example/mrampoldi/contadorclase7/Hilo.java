package com.example.mrampoldi.contadorclase7;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class Hilo extends Thread {
    private Handler hh;
    private boolean flagPausa = false;
    public Hilo(Handler hh){
        this.hh = hh;
    }
    @Override
    public void run() {
        int i = 0;
        while (true){
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Log.d("thread", "salgo del thread");
                return;
            }
            if (flagPausa){
                flagPausa = false;
                try {
                    synchronized (this){
                        Log.d("1","Entro en PAUSA");
                        wait();
                    }
                } catch (InterruptedException e) {
                    Log.d("thread", "salgo del thread");
                    return;
                }
            }
            Log.d("thread", "contador : " + i);
            Message msg = new Message();
            msg.arg1 = i;
            msg.obj = "contador = " + i;
            hh.sendMessage(msg);
        }
    }
    public void pausar(){
        flagPausa = true;
    }
}