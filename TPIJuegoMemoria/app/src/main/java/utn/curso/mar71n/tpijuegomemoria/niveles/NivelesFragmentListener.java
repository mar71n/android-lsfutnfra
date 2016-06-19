package utn.curso.mar71n.tpijuegomemoria.niveles;

import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import utn.curso.mar71n.tpijuegomemoria.R;
import utn.curso.mar71n.tpijuegomemoria.main.INiveles;

/**
 * Created by Usuario on 12/6/2016.
 */
public class NivelesFragmentListener implements View.OnClickListener {
    private RadioButton n1;
    private RadioButton n2;
    private RadioButton n3;
    INiveles mainAct;

    public NivelesFragmentListener(RadioButton n1, RadioButton n2, RadioButton n3, INiveles mainAct) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.mainAct = mainAct;
    }

    @Override
    public void onClick(View v) {
        int nivelId = v.getId();
        if (nivelId == R.id.radioButtonN1){
            mainAct.setNivel(1);
            Log.d("NFListener : ", "nivel 01");
        }
        if (nivelId == R.id.radioButtonN2){
            mainAct.setNivel(2);
            Log.d("NFListener : ", "nivel 02");
        }
        if (nivelId == R.id.radioButtonN3){
            mainAct.setNivel(3);
            Log.d("NFListener : ", "nivel 03");
        }
    }

}
