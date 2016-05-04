package com.example.mrampoldi.contadorclase7;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class Hilo extends Thread {
    //TextView tv;
    Handler hh;
    public Hilo(Handler hh){
        //this.tv = tv;
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
                //e.printStackTrace();
                return;
            }
            Log.d("thread", "contador : " + i);
            //tv.setText( "seg: ");
            //MainActivity.txt2.setText("segundosi" + i);
            //MainActivity.cont = i;
            Message msg = new Message();
            msg.arg1 = i;
            msg.obj = "contador = " + i;
            hh.sendMessage(msg);
        }
    }
}