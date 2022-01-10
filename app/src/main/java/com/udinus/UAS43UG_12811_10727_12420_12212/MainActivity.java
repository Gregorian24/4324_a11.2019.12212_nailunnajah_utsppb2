package com.udinus.UAS43UG_12811_10727_12420_12212;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.udinus.UAS43UG_12811_10727_12420_12212.adapters.MainAdapter;
import com.udinus.UAS43UG_12811_10727_12420_12212.LoginActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    //vars
    private final ArrayList<String> mNames = new ArrayList<>();
    private final ArrayList<String> mImageUrls = new ArrayList<>();
    private final ArrayList<String> mDetailss = new ArrayList<>();
    private final ArrayList<String> mPrice = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button= findViewById(R.id.btn_order);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ActivityServiceSelection.class);
            startActivity(intent);
        });
        final Button button3 = findViewById(R.id.btn_about);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityAbout.class);
                startActivity(intent);
            }
        });
        final Button button4 = findViewById(R.id.btn_map);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        Log.d(TAG, "onCreate: started.");


        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("R.drawable.cuci1");
        mNames.add("Cuci Reguler");
        mDetailss.add("Cuci exterior otomotif.");
        mPrice.add("Rp. 60.000,00");


        mImageUrls.add("R.drawable.cuci2");
        mNames.add("Cuci Reguler+");
        mDetailss.add("Cuci exterior serta interior otomotif.");
        mPrice.add("Rp. 115.000,00");

        mImageUrls.add("R.drawable.cuci3");
        mNames.add("Cuci Komplit");
        mDetailss.add("Cuci seluruh bagian otomotif, termasuk bagian yang sulit dicapai.");
        mPrice.add("Rp. 160.000,00");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        MainAdapter adapter = new MainAdapter(this, mNames, mImageUrls, mDetailss, mPrice);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void btnExit(View view) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}




















