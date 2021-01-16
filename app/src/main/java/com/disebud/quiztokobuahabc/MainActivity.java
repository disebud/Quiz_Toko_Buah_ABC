package com.disebud.quiztokobuahabc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences pref;
    private SharedPreferences.Editor editer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pref = this.getSharedPreferences("MyPrefsFile", MODE_PRIVATE);
        editer = pref.edit();

        if(pref.getInt("exitApp", 0) == 1){
            editer.putInt("exitApp", 0);
            editer.commit();
            finish();
        }

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
           finish();
        }

        return true;
    }

}