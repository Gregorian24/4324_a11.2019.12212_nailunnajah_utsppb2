package com.udinus.UAS43UG_12811_10727_12420_12212;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityServiceFormTruck extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_form_truck);

        final Button button1 = findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ActivityServiceFormTruck.this, MainActivity.class);
                Toast.makeText(ActivityServiceFormTruck.this,"Order Servis Truk Berhasil!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}