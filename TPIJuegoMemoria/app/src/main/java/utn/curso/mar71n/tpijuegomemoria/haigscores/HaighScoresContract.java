package utn.curso.mar71n.tpijuegomemoria.haigscores;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Usuario on 20/6/2016.
 */
public class HaighScoresContract {
    //Para evitar que alguien accidentalmente crear instancias de la clase de contrato,
    // Darle un constructor vacío.
    public HaighScoresContract(){}

    // implementa BaseColumns
    public static abstract class ColumnsHS implements BaseColumns{
        public static final String TABLE_NAME = "hscores";
        public static final String COLUMN_NAME_TIEMPO = "tiempo";
        public static final String COLUMN_NAME_NOMBRE = "nombre";
    }

    public static final String TEXT_TYPE = " TEXT";
    public static final String INT_TYPE = " INTEGER";
    public static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_HSCORES =
            "CREATE TABLE " + ColumnsHS.TABLE_NAME + " (" +
                    ColumnsHS._ID + " INTEGER PRIMARY KEY," +
                    ColumnsHS.COLUMN_NAME_TIEMPO + INT_TYPE + COMMA_SEP +
                    ColumnsHS.COLUMN_NAME_NOMBRE + TEXT_TYPE +
                    " );";
    public static final String SQL_INSERT_HSCORES =
            "INSERT INTO "+ HaighScoresContract.ColumnsHS.TABLE_NAME + " VALUES" +
                    "(" + "null" + COMMA_SEP + "45" + COMMA_SEP + "\"C-3PO\"" + ")," +
                    "(" + "null" + COMMA_SEP + "56" + COMMA_SEP + "\"BB-8\"" + ")," +
                    "(" + "null" + COMMA_SEP + "60" + COMMA_SEP + "\"R2-D2\"" + ")," +
                    "(" + "null" + COMMA_SEP + "63" + COMMA_SEP + "\"CHEWBACCA\"" + ")," +
                    "(" + "null" + COMMA_SEP + "80" + COMMA_SEP + "\"ME-8D9\"" + ")," +
                    "(" + "null" + COMMA_SEP + "85" + COMMA_SEP + "\"REY\"" + ")," +
                    "(" + "null" + COMMA_SEP + "102" + COMMA_SEP + "\"LUKE\"" + ")," +
                    "(" + "null" + COMMA_SEP + "120" + COMMA_SEP + "\"HURID-327\"" + ")," +
                    "(" + "null" + COMMA_SEP + "145" + COMMA_SEP + "\"B-U4D\"" + ")," +
                    "(" + "null" + COMMA_SEP + "163" + COMMA_SEP + "\"WR12\"" + ");";
    public static final String SQL_DELETE_HSCORES =
            "DROP TABLE IF EXISTS " + HaighScoresContract.ColumnsHS.TABLE_NAME;


    private HScoresDBHelper datosHelper;
    private SQLiteDatabase database;

    public HaighScoresContract(Context context){
        datosHelper = new HScoresDBHelper(context);
        database = datosHelper.getWritableDatabase();
    }
}
