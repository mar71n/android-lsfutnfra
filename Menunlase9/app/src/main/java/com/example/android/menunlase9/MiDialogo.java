package com.example.android.menunlase9;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by android on 18/05/16.
 */
public class MiDialogo extends DialogFragment  {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
        builder.setTitle("Alerta !!!");
        builder.setMessage("ojota con los viruses....");
        builder.setPositiveButton("vamos con esa...", (DialogInterface.OnClickListener) getActivity());
        builder.setNegativeButton("Naaaaaaa...", (DialogInterface.OnClickListener) getActivity());
        android.support.v7.app.AlertDialog ad = builder.create();
        return ad;
    }
}
