package utn.curso.mar71n.tpijuegomemoria;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

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
        switch(position)
        {
            case 0 : return new InfoFragment();
            case 1 : return new NivelesFragment();
            case 2 : return new AyudaFragment();
        }
        return null;
    }

    @Override
    public int getCount()
    {
        return NUM_PAGES;
    }
}