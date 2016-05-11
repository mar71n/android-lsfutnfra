package com.lslutnfra.ejerciciohttp;


import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class ThreadConexion implements Runnable{

    private String url;
    private boolean flagBytesString;

    /*	Recibimos un Handler, la URL y un flag que indica si leemos bytes o String
     *
     */
    public ThreadConexion(String url,boolean flagBytesString)
    {
        this.url = url;
        this.flagBytesString=flagBytesString;
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
            }
            else
            {
                String strRespuesta;
                strRespuesta = httpManager.getStrDataByGET();
                // cargar respuesta en mensaje
            }

        }catch(Exception e)
        {
            Log.d("http","ERROR");
            msg.arg1=0;
        }

        // Enviar mensaje
    }



}
