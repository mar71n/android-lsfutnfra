package utn.curso.mar71n.censotransito;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


/**
 * Created by Usuario on 2/4/2016.
 */
public class ListenerBoton implements OnClickListener {
    private TextView tt;

    public ListenerBoton(TextView txttot) {
        this.tt = txttot;
    }

    @Override
    public void onClick(View v) {
        Integer actual = Integer.parseInt( tt.getText().toString());
        actual++;
        tt.setText(actual.toString());
    }
}
