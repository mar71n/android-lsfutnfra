package com.cursoandroid.martin.miprimeraapplicacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button)findViewById(R.id.button);
        b.setText("Hola desde java 3 ");
        // OrejaEscuchaBoton oreja = new OrejaEscuchaBoton(t);
        b.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        TextView t = (TextView)findViewById(R.id.textView);
        t.setText("ando! tambien");
    }
}
