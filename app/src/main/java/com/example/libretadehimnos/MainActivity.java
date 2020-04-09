package com.example.libretadehimnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.net.URL;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private String url;
    private int noche[] = new int[12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        url = "https://osvaldor300.wixsite.com/libretadehimnos";
        //llamado del toolbar generico dos formas
        //toolbar.inflateMenu(R.menu.overflow);
        setSupportActionBar(toolbar);
        //mostrar icono en el tooolbar
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        noche[0] = 18;
        noche[1] = 19;
        noche[2] = 20;
        noche[3] = 21;
        noche[4] = 22;
        noche[5] = 23;
        noche[6] = 0;
        noche[7] = 1;
        noche[8] = 2;
        noche[9] = 3;
        noche[10] = 4;
        noche[11] = 5;
        automatico();
    }

    //Metodo para mostrar y ocultar el menu y aqui tengo el modo nocturno
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow, menu);
        MenuItem itemSwitch = menu.findItem(R.id.app_bar_switch);
        itemSwitch.setActionView(R.layout.switch_item);
        final Switch sw = (Switch) menu.findItem(R.id.app_bar_switch).getActionView().findViewById(R.id.action_switch);
        int currentMode = AppCompatDelegate.getDefaultNightMode();
        if (currentMode == AppCompatDelegate.MODE_NIGHT_YES) {
            sw.setChecked(true);
        } else {
            sw.setChecked(false);
        }
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (sw.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    restartCurrentCurrentActivity();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    restartCurrentCurrentActivity();
                }
            }
        });
        return true;
    }
    private void restartCurrentCurrentActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    //Metodo para asignar las funciones correspondientes a las opciones del menu
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.pprivacidad) {
            Toast.makeText(this, "opcion1", Toast.LENGTH_SHORT).show();
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        if (id == R.id.item2) {
            Toast.makeText(this, "opcionsi1", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.item3) {
            Toast.makeText(this, "opcionsi1", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.subitem1) {
            Toast.makeText(this, "opcionsi1", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public void onClinck(View view) {
        Intent miIntent = new Intent(MainActivity.this, Lista.class);
        startActivity(miIntent);
    }
    public void reproductor(View view) {
        Intent miIntent = new Intent(MainActivity.this, Reproductor.class);
        startActivity(miIntent);
    }
    public void automatico(){
        Calendar calendario = Calendar.getInstance();
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        for (int contador=0; contador<=11; contador++){
            if (hora == noche[contador]){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        }
    }
}
