package com.example.alarmmanagerdemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DemoDialog.DemoDialogListener {

    private TextView mTextViewUsername;
    private TextView mTextViewPassword;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewUsername = findViewById(R.id.username_textview);
        mTextViewPassword = findViewById(R.id.textview_password);
        mButton = findViewById(R.id.open_dialog_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });


    }

    private void openDialog() {
        DemoDialog dialog = new DemoDialog();
        dialog.show(getSupportFragmentManager(), "Demo Dialog");
    }

    @Override
    public void applyTexts(String username, String password) {
        mTextViewUsername.setText(username);
        mTextViewPassword.setText(password);
    }
}
