package com.udinus.UAS43UG_12811_10727_12420_12212;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ActivityConfirmPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_password);
    }

    public void postChangePassword(View view) {
        Intent i = new Intent(ActivityConfirmPassword.this, activity_reset_success.class);
        Toast.makeText(ActivityConfirmPassword.this,"Belum diimplemntasi...", Toast.LENGTH_LONG).show();
        startActivity(i);
    }
}