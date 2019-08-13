package com.example.alarmmanagerdemo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class DemoDialog extends AppCompatDialogFragment {
    private EditText editTextUsername;
    private EditText editTextPassword;
    private DemoDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog,null);

        editTextUsername = view.findViewById(R.id.edit_username);
        editTextPassword = view.findViewById(R.id.edit_password);



        builder.setView(view)
                .setTitle("Login")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String username = editTextUsername.getText().toString();
                        String password = editTextPassword.getText().toString();
                        listener.applyTexts(username, password);

                    }
                });
        return builder.create();
    }

    public interface DemoDialogListener {
        void applyTexts(String username, String password);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (DemoDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+ " must implement DemoDialog interface");
        }
    }
}
