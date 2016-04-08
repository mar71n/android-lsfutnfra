package com.lslutnfra.ejemplomvc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ScreenManager sm;
    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button)findViewById(R.id.button);
        b.setOnClickListener(this);

        sm = new ScreenManager(this);

        model = new Model();

        sm.showCounter(model.getCounter());
    }

    @Override
    public void onClick(View v) {
        model.inc();
        sm.showCounter(model.getCounter());
    }
}
