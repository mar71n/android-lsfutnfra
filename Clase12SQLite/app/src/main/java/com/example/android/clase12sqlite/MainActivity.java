package com.example.android.clase12sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyOpenHelper helper = new MyOpenHelper(this,"Personas.db3");

        SQLiteDatabase db =  helper.getWritableDatabase();

        PersonaDAO dao = new PersonaDAO(db);

        ArrayList<Persona> lista = dao.getAll();

        for(Persona p : lista){
            Log.d("act",p.getNombre() + " edad: " + p.getEdad());
        }

        /*
        Cursor c;

        c = db.rawQuery("SELECT _id,nombre,edad FROM Personas WHERE _id=1",null);

        if(c.moveToFirst())
        {

            long id = c.getLong(0);
            String nombre = c.getString(1);
            int edad = c.getInt(2);
            Log.d("db", "Persona. id:" + id + " nombre:" + nombre + " edad:" + edad);
        }
        c.close();
        db.close();
        helper.close();
        */

    }
}
