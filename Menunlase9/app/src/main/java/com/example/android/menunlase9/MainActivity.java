package com.example.android.menunlase9;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener, SearchView.OnQueryTextListener {

    private ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.menu_item_share);
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,"http://www.lslutnfra.com");

        mShareActionProvider.setShareIntent(intent);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id)
        {
            case R.id.action_settings:
            {
                Log.d("activity", "setings");
                return true;
            }
            case R.id.opcion1:
            {
                Log.d("activity", "opcion 1");
                return true;
            }
            case R.id.opcion2:
            {
                Log.d("activity", "opcion 2");
                return true;
            }
            case R.id.opcion3:
            {
                Log.d("activity", "opcion 3");
                MiDialogo md = new MiDialogo();
                md.show(getSupportFragmentManager(),"dialogo");
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        Log.d("dialogo:","boton : " + which);
        switch (which){
            case AlertDialog.BUTTON_NEGATIVE:
            {
                break;
            }
            case AlertDialog.BUTTON_POSITIVE:
            {
                break;
            }
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d(getLocalClassName(),"Busca : " + query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d(getLocalClassName(),"Busca : " + newText);
        return false;
    }
}
