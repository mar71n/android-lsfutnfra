package utn.curso.mar71n.tpijuegomemoria.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import utn.curso.mar71n.tpijuegomemoria.R;
import utn.curso.mar71n.tpijuegomemoria.haigscores.HScoresFragment;
import utn.curso.mar71n.tpijuegomemoria.niveles.NivelesFragment;
import utn.curso.mar71n.tpijuegomemoria.splash.SplashFragment;
import utn.curso.mar71n.tpijuegomemoria.tablero.TableroJMActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, INiveles {
    private DrawerLayout drawer;
    private int nivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nivel = 2;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugar();
            }
        });
        // obtengo el ViewPager
        //viewPager = (ViewPager) findViewById(R.id.vpager);
        FragmentManager fm = getSupportFragmentManager();
        //MyScreenSlidePagerAdapter adapter = new MyScreenSlidePagerAdapter(fm);
        //viewPager.setAdapter(adapter);
        //TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        //tabLayout.setupWithViewPager(viewPager);

        //viewPager.setCurrentItem(0);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment = new SplashFragment();
        cargarFragment(fragment);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.drawer_item_presentacion){
            Fragment fragment = new SplashFragment();
            cargarFragment(fragment);
        }
        if (id == R.id.drawer_item_niveles){
            Fragment fragment = new NivelesFragment();
            cargarFragment(fragment);
        }
        if (id == R.id.drawer_item_records){
            Fragment fragment = new HScoresFragment();
            cargarFragment(fragment);
        }
        if (id == R.id.drawer_item_jugar){
            jugar();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void jugar(){
        Fragment fragment = new SplashFragment();
        cargarFragment(fragment);
        Intent i = new Intent(this,TableroJMActivity.class);
        i.putExtra("nivel",nivel);
        startActivity(i);
    }

    private void cargarFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.contenedor, fragment)
                .commit();
    }

    @Override
    public int getNivel(){
        return nivel;
    }

    @Override
    public void setNivel(int n){
        nivel = n;
    }

}
