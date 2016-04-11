package utn.curso.mar71n.ejerciciobotonesyeventos;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Usuario on 9/4/2016.
 */
public class ListenerBotones implements View.OnClickListener {
    private TextView textView;
    private EditText editText;
    private int[] idb;

    public ListenerBotones(TextView tview, EditText eText, int[] idbotones){
        textView = tview;
        editText = eText;
        idb = idbotones;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == idb[0]) {
            textView.setText(editText.getText());
        }
        if (v.getId() == idb[1]) {
            textView.setText("ingrese un texto abajo");
        }
    }
}
