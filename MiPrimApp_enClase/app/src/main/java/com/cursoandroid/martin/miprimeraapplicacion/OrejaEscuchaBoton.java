package com.cursoandroid.martin.miprimeraapplicacion;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by android on 29/03/16.
 */
public class OrejaEscuchaBoton implements View.OnClickListener{
    TextView t;
    public OrejaEscuchaBoton(TextView txt){
        t = txt;
    }
    @Override
    public void onClick(View v) {
        Log.d("tagoreja.onclick","marcha un click");
        t.setText("ando!");
    }
}
