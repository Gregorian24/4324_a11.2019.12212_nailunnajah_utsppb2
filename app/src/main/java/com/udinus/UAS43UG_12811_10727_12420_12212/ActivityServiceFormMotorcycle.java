package com.udinus.UAS43UG_12811_10727_12420_12212;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityServiceFormMotorcycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_form_motorcycle);

        final Button button1 = findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ActivityServiceFormMotorcycle.this, MainActivity.class);
                Toast.makeText(ActivityServiceFormMotorcycle.this,"Order Servis Motor Berhasil!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}