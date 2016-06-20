package utn.curso.mar71n.tpijuegomemoria.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import utn.curso.mar71n.tpijuegomemoria.haigscores.HScoresFragment;
import utn.curso.mar71n.tpijuegomemoria.inicio.InfoFragment;
import utn.curso.mar71n.tpijuegomemoria.niveles.NivelesFragment;

/**
 * Created by android on 31/05/16.
 */
public class MyScreenSlidePagerAdapter extends FragmentStatePagerAdapter
{
    private static final int NUM_PAGES = 3;

    public MyScreenSlidePagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        // Segun la posicion, creo el fragment correspondiente y lo devuelvo
        Fragment retFragmen;
        switch(position)
        {
            case 0 : retFragmen = new InfoFragment(); break;
            case 1 : retFragmen = new NivelesFragment(); break;
            case 2 : retFragmen = new HScoresFragment(); break;
            default: return null;
        }
        return  retFragmen;
    }

    @Override
    public int getCount()
    {
        return NUM_PAGES;
    }

    // Devolvemos el titulo de cada Fragment
    @Override
    public CharSequence getPageTitle(int position)
    {
        switch(position)
        {
            case 0: return "Información";
            case 1: return "Niveles";
            default: return "Haigh Scores";
        }
    }
}