package com.cursoandroid.martin.miprimeraapplicacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button)findViewById(R.id.button);
        b.setText("Hola desde java 2 ");
        TextView t = (TextView)findViewById(R.id.textView);
        OrejaEscuchaBoton oreja = new OrejaEscuchaBoton(t);
        b.setOnClickListener(oreja);
    }
}
