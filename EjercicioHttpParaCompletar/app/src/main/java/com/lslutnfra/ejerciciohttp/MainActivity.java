package com.lslutnfra.ejerciciohttp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements Handler.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler h = new Handler(this);

        // flag en true para recibir bytes
        ThreadConexion tc = new ThreadConexion(h,"http://www.lslutnfra.com/alumnos/practicas/ubuntu-logo.png",true);
        Thread t = new Thread(tc);
        t.start();
        //________________________________

        // flag en false para recibir un string
        ThreadConexion tc2 = new ThreadConexion(h,"http://www.lslutnfra.com/alumnos/practicas/listaPersonas.xml",false);
        Thread t2 = new Thread(tc2);
        t2.start();
        //_____________________________________

    }

    @Override
    public boolean handleMessage(Message msg) {

        switch(msg.arg1)
        {
            case 0:{
                Log.d("activity", "Error");
                break;
            }
            case 1:{
                Log.d("activity","Recibiendo bytes (imagen)");
                // Cargar imagen en imageview
                ImageView i = (ImageView) findViewById(R.id.imageView);
                byte[] data = (byte[]) msg.obj;
                Bitmap b = BitmapFactory.decodeByteArray(data, 0, data.length);
                i.setImageBitmap(b);
                break;
            }
            case 2:{
                Log.d("activity","Recibiendo string (json o XML)");
                // cargar texto en textView
                TextView t = (TextView) findViewById(R.id.textView);
                String s = (String) msg.obj;
                t.setText(s);
                break;
            }
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
