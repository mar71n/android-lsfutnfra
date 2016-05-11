package com.lslutnfra.ejerciciohttp;


import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class ThreadConexion implements Runnable{

    private String url;
    private boolean flagBytesString;
    private Handler h;

    /*	Recibimos un Handler, la URL y un flag que indica si leemos bytes o String
     *
     */
    public ThreadConexion(Handler h, String url,boolean flagBytesString)
    {
        this.url = url;
        this.flagBytesString=flagBytesString;
        this.h = h;
    }

    /*
     * Metodo run del thread, se conecta a la url y recupera los datos que envio por el handler
     *
     */
    public void run() {

        Message msg = new Message();

        HttpManager httpManager = new HttpManager(url);
        try{

            if(flagBytesString)
            {
                byte[] bytesRespuesta;
                bytesRespuesta = httpManager.getBytesDataByGET();
                // cargar respuesta en mensaje
                msg.obj = bytesRespuesta;
                msg.arg1 = 1;
            }
            else
            {
                String strRespuesta;
                strRespuesta = httpManager.getStrDataByGET();
                // cargar respuesta en mensaje
                msg.obj = strRespuesta;
                msg.arg1 = 2;
            }

        }catch(Exception e)
        {
            Log.d("http","ERROR");
            msg.arg1=0;
        }

        // Enviar mensaje
        h.sendMessage(msg);
    }



}
