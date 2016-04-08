package com.lslutnfra.ejemplomvc;

import android.app.Activity;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by ernesto on 05/04/16.
 */
public class ScreenManager {

    private TextView t;

    public ScreenManager(Activity a)
    {
        t = (TextView)a.findViewById(R.id.textview);
    }

    public void showCounter(int c)
    {
        t.setText("Contador:"+c);
    }
}
