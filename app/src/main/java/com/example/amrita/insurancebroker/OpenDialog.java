package com.example.amrita.insurancebroker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class OpenDialog implements DialogInterface.OnClickListener{
    private Context context;
    public OpenDialog(Context context) {
        this.context = context;
    }
    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title);
        builder.setCancelable(true);
        builder.setPositiveButton( R.string.OK,this);
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int i) {
        dialog.cancel();
    }
}
