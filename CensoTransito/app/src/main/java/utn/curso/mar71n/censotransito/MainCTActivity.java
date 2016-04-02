package utn.curso.mar71n.censotransito;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainCTActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ct);
        // totalizador
        TextView txtTotal = (TextView) findViewById(R.id.txtTot);
        // boton contar
        Button bcontar = (Button) findViewById(R.id.button);
        ListenerBoton lb1 = new ListenerBoton(txtTotal);
        bcontar.setOnClickListener(lb1);
        // boton limpiar
        Button blimpiar = (Button) findViewById(R.id.btnLimpiar);
        ListenerLimpiar ll1 = new ListenerLimpiar(txtTotal);
        blimpiar.setOnClickListener(ll1);
    }
}
