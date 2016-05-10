package com.example.mrampoldi.contadorclase7;

        import android.os.Handler;
        import android.os.Message;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Handler.Callback, View.OnClickListener {
    private TextView txt2;
    private Hilo h;
    private boolean parado = false;
    private Button pulsador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pulsador = (Button) findViewById(R.id.botonPulsador);

        txt2 =  (TextView) findViewById(R.id.txtView);

        Handler hh = new Handler(this);

        h = new Hilo(hh);
        h.start();

        pulsador.setOnClickListener(this);
    }

    @Override
    public boolean handleMessage(Message msg) {
        String s = (String) msg.obj;
        txt2.setText(s);
        return false;
    }

    @Override
    protected void onDestroy() {
        h.interrupt();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if(parado){
            parado = false;
            pulsador.setText("PARAR");
            synchronized (h){
                h.notify();
            }
        }else{
            parado = true;
            pulsador.setText("ARRANCAR");
            synchronized (h){
                h.pausar();
            }
        }
    }
}
