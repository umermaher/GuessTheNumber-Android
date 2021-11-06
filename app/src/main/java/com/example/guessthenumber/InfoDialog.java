package com.example.guessthenumber;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import org.jetbrains.annotations.NotNull;

public class InfoDialog extends AppCompatDialogFragment {
    private InfoDialogListener listener;
    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Dialog onCreateDialog(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder =new AlertDialog.Builder(getActivity());
        builder.setTitle("Information").setMessage("Guess the number between 1 and 100")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onOkClick();
                    }
                });
        return builder.create();
    }

    public interface InfoDialogListener{
        void onOkClick();
    }

    @Override
    public void onAttach(@NotNull Context context) {
        super.onAttach(context);
        try {
            listener = (InfoDialogListener) context;
        }catch(ClassCastException cce){
            Toast.makeText(context, cce.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}