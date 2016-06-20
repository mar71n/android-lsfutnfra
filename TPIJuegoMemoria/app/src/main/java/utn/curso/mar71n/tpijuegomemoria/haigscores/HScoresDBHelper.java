package utn.curso.mar71n.tpijuegomemoria.haigscores;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Usuario on 20/6/2016.
 */
public class HScoresDBHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "HaighScores.db3";
    private SQLiteDatabase db;

    public HScoresDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public ArrayList<HaighScores> getAll(){
        ArrayList<HaighScores> lista = new ArrayList<>();
        Cursor c;
        HaighScores hs = null;
        db = getReadableDatabase();
        c = db.query(HaighScoresContract.ColumnsHS.TABLE_NAME, new String[]
                        {HaighScoresContract.ColumnsHS._ID,
                         HaighScoresContract.ColumnsHS.COLUMN_NAME_TIEMPO,
                         HaighScoresContract.ColumnsHS.COLUMN_NAME_NOMBRE}, null, null, null, null,
                     HaighScoresContract.ColumnsHS.COLUMN_NAME_TIEMPO);
        if(c.moveToFirst())
        {
            do {
                hs = new HaighScores();
                hs.setId(c.getLong(0));
                hs.setTiempo(c.getInt(1));
                hs.setNombre(c.getString(2));
                lista.add(hs);
            }while(c.moveToNext());
        }
        c.close();
        Log.d("HELPER", "tamanio lista" + lista.size());
        return lista;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("HELPER","ejecuto onCreate");
        db.execSQL(HaighScoresContract.SQL_DELETE_HSCORES);
        db.execSQL(HaighScoresContract.SQL_CREATE_HSCORES);
        db.execSQL(HaighScoresContract.SQL_INSERT_HSCORES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("HELPER","ejecuto onUpgrade");
        db.execSQL(HaighScoresContract.SQL_DELETE_HSCORES);
        db.execSQL(HaighScoresContract.SQL_CREATE_HSCORES);
    }
}
