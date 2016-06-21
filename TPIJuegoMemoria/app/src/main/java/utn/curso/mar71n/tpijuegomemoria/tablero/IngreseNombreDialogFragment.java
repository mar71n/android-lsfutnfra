package utn.curso.mar71n.tpijuegomemoria.tablero;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import utn.curso.mar71n.tpijuegomemoria.R;

/**
 * Created by mrampoldi on 21/06/2016.
 */
public class IngreseNombreDialogFragment extends android.support.v4.app.DialogFragment
        implements DialogInterface.OnClickListener, View.OnKeyListener {
    EditText nombre;
    String snombre;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        snombre = "paso";
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View v = inflater.inflate(R.layout.ingresenombre_layout, null);
        builder.setView(v);
        builder.setPositiveButton("Aveptar", this);
         /*
        builder.setView(inflater.inflate(R.layout.ingresenombre_layout, null))
                // Add action buttons
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                        Log.d("DialogFrag", "nombre : ");
                    }
                });*/
        return builder.create();
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        nombre = (EditText) view.findViewById(R.id.nombrehs);
        nombre.setOnKeyListener(this);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        Log.d("listener", "nombre " + snombre);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        snombre = String.valueOf(nombre.getText());
        return false;
    }
}

