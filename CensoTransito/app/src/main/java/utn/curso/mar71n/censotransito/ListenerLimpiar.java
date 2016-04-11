package utn.curso.mar71n.censotransito;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


/**
 * Created by Usuario on 2/4/2016.
 */
public class ListenerLimpiar implements OnClickListener {
    private TextView tt;
    private Contador cont;

    public ListenerLimpiar(TextView txttot){
        this.tt = txttot;
        cont = Contador.getContador();
    }

    @Override
    public void onClick(View v) {
        cont.delTot();
        Integer actual = cont.getTot();
        String sActual =  String.format("%03d", actual);
        tt.setText(sActual);
    }
}
