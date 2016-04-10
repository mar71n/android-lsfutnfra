package utn.curso.mar71n.ejcalculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainECActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ec);
        int[] lidBotones = new int[]{R.id.bt0, R.id.bt1, R.id.bt2, R.id.bt3, R.id.bt4, R.id.bt5,
                R.id.bt6, R.id.bt7, R.id.bt8, R.id.bt9, R.id.btad, R.id.btsus,
                R.id.btmul, R.id.btdiv, R.id.btigual, R.id.btC};
        TextView display = (TextView)findViewById(R.id.textViewDisplay);
        TextView calculadora = (TextView)findViewById(R.id.textViewCalcu);
        EscucharBotones listener = new EscucharBotones(display, calculadora, lidBotones);
        for( int i = 0 ; i <lidBotones.length; i++){
            Button b = (Button)findViewById(lidBotones[i]);
            b.setOnClickListener(listener);
        }
    }
}
