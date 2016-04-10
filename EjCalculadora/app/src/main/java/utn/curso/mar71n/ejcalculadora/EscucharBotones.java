package utn.curso.mar71n.ejcalculadora;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Usuario on 10/4/2016.
 */
public class EscucharBotones implements View.OnClickListener {
    TextView txtdisplay;
    TextView txtcalculado;
    int[] lidbotones;
    Calculadorita calcu;
    public EscucharBotones(TextView display, TextView calculadora, int[] lidBotones) {
        txtdisplay  = display;
        txtcalculado = calculadora;
        lidbotones = lidBotones;
        calcu = new Calculadorita();
    }

    @Override
    public void onClick(View v) {

    }
}
