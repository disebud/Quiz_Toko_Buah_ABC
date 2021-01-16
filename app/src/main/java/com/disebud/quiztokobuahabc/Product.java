package com.disebud.quiztokobuahabc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.disebud.quiztokobuahabc.Adapter.MyListAdapter;
import com.disebud.quiztokobuahabc.Data.Data;

public class Product extends AppCompatActivity {

    private SharedPreferences pref;
    private SharedPreferences.Editor editer;

    public MyListAdapter produkAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        pref = this.getSharedPreferences("MyPrefsFile", MODE_PRIVATE);
        editer = pref.edit();

        Data[] myListData = new Data[] {
                new Data("FRT-0001-Anggur California","Import" ,"Rp. 35.000,-/Kg",R.drawable.anggura),
                new Data("FRT-0002-Durian Montong","Lokal" ,"Rp. 40.000,-/Kg",R.drawable.duren),
                new Data("FRT-0003-Mangga Harum Manis","Lokal" ,"Rp. 25.000,-/Kg",R.drawable.mangga),
                new Data("FRT-0004-Nanas Spongebob","Lokal" ,"Rp. 20.000,-/Kg",R.drawable.nanas),
                new Data("FRT-0005-Nangka Cimpedak","Lokal" ,"Rp. 25.000,-/Kg",R.drawable.nangka),
                new Data("FRT-0006-Naga Chines","Import" ,"Rp. 25.000,-/Kg",R.drawable.naga),
                new Data("FRT-0007-Jambu Pink","Lokal" ,"Rp. 15.000,-/Kg",R.drawable.jambu),
                new Data("FRT-0008-Pepaya California","Lokal" ,"Rp. 25.000,-/Kg",R.drawable.pepaya),

        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        produkAdapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(produkAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.homeBase){
            startActivity(new Intent(this, MainActivity.class));
        } else if (item.getItemId() == R.id.produkKami) {
            startActivity(new Intent(this, Product.class));
        } else if (item.getItemId() == R.id.hubungiKami) {
            startActivity(new Intent(this, Contact.class));
        } else  {
//            finish();
            Intent main_intent = new Intent(Product.this,
                    MainActivity.class);
            main_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(main_intent);
            editer.putInt("exitApp",1);
            editer.commit();
        }

        return true;
    }



}