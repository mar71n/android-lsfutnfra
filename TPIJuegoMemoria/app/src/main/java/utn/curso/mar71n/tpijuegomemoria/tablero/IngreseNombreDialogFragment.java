package utn.curso.mar71n.tpijuegomemoria.tablero;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import utn.curso.mar71n.tpijuegomemoria.R;
import utn.curso.mar71n.tpijuegomemoria.haigscores.entidades.HScoresDBHelper;
import utn.curso.mar71n.tpijuegomemoria.haigscores.entidades.HaighScores;

/**
 * Created by mrampoldi on 21/06/2016.
 */
public class IngreseNombreDialogFragment extends android.support.v4.app.DialogFragment
        implements DialogInterface.OnClickListener {
    private EditText etnombre;
    private int segundos;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        segundos = getArguments().getInt("segundos");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View v = inflater.inflate(R.layout.ingresenombre_layout, null);
        builder.setView(v);
        builder.setPositiveButton("Aceptar", this);
        etnombre = (EditText) v.findViewById(R.id.etnombrehs);
        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        HScoresDBHelper dbHelper = new HScoresDBHelper(getContext());
        HaighScores hs = new HaighScores();
        hs.setNombre(String.valueOf(etnombre.getText()));
        hs.setTiempo(segundos);
        dbHelper.saveHS(hs);
    }
}

