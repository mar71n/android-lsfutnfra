package utn.curso.mar71n.tpijuegomemoria.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import utn.curso.mar71n.tpijuegomemoria.haigscores.HScoresFragment;
import utn.curso.mar71n.tpijuegomemoria.niveles.NivelesFragment;
import utn.curso.mar71n.tpijuegomemoria.splash.SplashFragment;

/**
 * Created by mrampoldi on 01/07/2016.
 */
public class MyScreenSlidePagerAdapter  extends FragmentStatePagerAdapter {
    private static final int NUM_PAGES = 3;

    public MyScreenSlidePagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // Segun la posicion, creo el fragment correspondiente y lo devuelvo
        switch(position)
        {
            case 0 : return new SplashFragment();
            case 1 : return new NivelesFragment();
            case 2 : return new HScoresFragment();
        }
        return null;    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
