package com.example.mrampoldi.contadorclase7;

        import android.os.Handler;
        import android.os.Message;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Handler.Callback {
    private TextView txt2;
    private Hilo h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt = (TextView) findViewById(R.id.txtView);
        txt2 =  (TextView) findViewById(R.id.txtView);

        Handler hh = new Handler(this);

        h = new Hilo(hh);
        h.start();
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
}
