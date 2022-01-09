package com.udinus.UAS43UG_12811_10727_12420_12212;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.udinus.UAS43UG_12811_10727_12420_12212.adapters.MainAdapter;

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
        Button button= findViewById(R.id.order);
        button.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            startActivity(intent);
        });
        Log.d(TAG, "onCreate: started.");


        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://thebeast07-cyber.github.io/bidascucisepatu/images/fastclean.png");
        mNames.add("Cuci Reguler");
        mDetailss.add("Cuci exterior otomotif.");
        mPrice.add("Rp. 60.000,00");


        mImageUrls.add("https://thebeast07-cyber.github.io/bidascucisepatu/images/fastclean%20(1).png");
        mNames.add("Cuci Reguler+");
        mDetailss.add("Cuci exterior serta interior otomotif.");
        mPrice.add("Rp. 115.000,00");

        mImageUrls.add("https://thebeast07-cyber.github.io/bidascucisepatu/images/Desain%20tanpa%20judul.png");
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
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        MainActivity.this.startActivity(intent);
        finish();
    }
}




















