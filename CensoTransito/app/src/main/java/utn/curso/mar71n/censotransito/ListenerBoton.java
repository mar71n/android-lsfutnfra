package utn.curso.mar71n.censotransito;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


/**
 * Created by Usuario on 2/4/2016.
 */
public class ListenerBoton implements OnClickListener {
    private TextView tt;
    private Contador cont;

    public ListenerBoton(TextView txttot) {
        this.tt = txttot;
        cont = new Contador();
    }

    @Override
    public void onClick(View v) {
        cont.incTot();
        Integer actual = cont.getTot();
        tt.setText(actual.toString());
    }
}
