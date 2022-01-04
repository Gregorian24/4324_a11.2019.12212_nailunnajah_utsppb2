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
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mDetailss = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button= (Button)findViewById(R.id.order);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://wa.me/6282228132455?text=Saya%20ingin%20mencuci%20sepatu%20saya"));
                startActivity(intent);
            }
        });
        Log.d(TAG, "onCreate: started.");


        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://thebeast07-cyber.github.io/bidascucisepatu/images/fastclean.png");
        mNames.add("Fast Clean");
        mDetailss.add("*Pembersihan area:\n -midsole\n -upper\n include parfum anti bakteri dan silica\n" +
                "Bersih dalam hitungan jam");


        mImageUrls.add("https://thebeast07-cyber.github.io/bidascucisepatu/images/fastclean%20(1).png");
        mNames.add("Deep Clean");
        mDetailss.add("Pembersihan area:\n -midsole\n -upper\n -insole\n -outsole\n include parfum anti bakteri dan silica\n" +
                "Bersih Wangi Tahan Lama");

        mImageUrls.add("https://thebeast07-cyber.github.io/bidascucisepatu/images/Desain%20tanpa%20judul.png");
        mNames.add("Unyellowing");
        mDetailss.add("Kategori Easy Medium dan Hard\n untuk mid sole yang menguning.\n include Deep Clean\n" +
                "Putih Seperti Baru");

        mImageUrls.add("https://thebeast07-cyber.github.io/bidascucisepatu/images/fastclean%20(2).png");
        mNames.add("Repaint");
        mDetailss.add("Mengembalikan warna Upper atau Mid sole pada sepatu\n include Deep Clean\n " +
                "Sepatu Tampak Baru");

        mImageUrls.add("https://people-shoes.com/wp-content/uploads/2019/04/SEWING-e1554880208421.png");
        mNames.add("Reglue");
        mDetailss.add("Memperbaiki sole sepatu yang sudah jebol.\n menggunakan lem khusus sepatu sehingga tidak mudah jebol\n" +
                "Sepatu Kesayangan Bisa Dipakai Kembali");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        MainAdapter adapter = new MainAdapter(this, mNames, mImageUrls, mDetailss);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void btnExit(View view) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        MainActivity.this.startActivity(intent);
        finish();
    }
}




















