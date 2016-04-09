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

    public ListenerBotones(TextView tview, EditText eText){
        textView = tview;
        editText = eText;
    }

    @Override
    public void onClick(View v) {
        textView.setText(editText.getText());
    }
}
