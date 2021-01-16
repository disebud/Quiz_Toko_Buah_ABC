package com.disebud.quiztokobuahabc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Contact extends AppCompatActivity {
    private SharedPreferences pref;
    private SharedPreferences.Editor editer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        pref = this.getSharedPreferences("MyPrefsFile", MODE_PRIVATE);
        editer = pref.edit();

        WebView webportal = (WebView) findViewById(R.id.webPortal);

        webportal.getSettings().getLoadsImagesAutomatically();
        webportal.getSettings().getJavaScriptEnabled();
        webportal.getSettings().getDomStorageEnabled();

        webportal.getSettings().setSupportZoom(true);
        webportal.getSettings().getDisplayZoomControls();
        webportal.getSettings().getBuiltInZoomControls();

        webportal.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webportal.setWebViewClient(new WebViewClient());

        // mengambil nilai parameter yang diberikan dari activity Main (GridView)
        String URL = "https://cordova-media.com/apps/quiz_pra_uas_web/hubungi_kami.php";
        webportal.loadUrl(URL);

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
            Intent main_intent = new Intent(Contact.this,
                    MainActivity.class);
            main_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(main_intent);
            editer.putInt("exitApp",1);
            editer.commit();
        }

        return true;
    }
}