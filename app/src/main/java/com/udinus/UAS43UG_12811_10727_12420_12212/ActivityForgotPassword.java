package com.udinus.UAS43UG_12811_10727_12420_12212;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }

    public void postSendRequest(View view) {
        Intent i = new Intent(ActivityForgotPassword.this, ActivityConfirmPassword.class);
        startActivity(i);
    }
}