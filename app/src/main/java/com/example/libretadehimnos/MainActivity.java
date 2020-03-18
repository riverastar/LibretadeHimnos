package com.example.libretadehimnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Toolbar toolbar;
private Window window;
private View view;
private Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //view = getLayoutInflater().inflate(R.layout.activity_mostrar_himno, null);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        myButton = (Button) findViewById(R.id.iraLista);
        //llamado del toolbar generico dos formas
        //toolbar.inflateMenu(R.menu.overflow);

        setSupportActionBar(toolbar);
        //mostrar icono en el tooolbar
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }
    //Metodo para mostrar y ocultar el menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow, menu);
        MenuItem itemSwitch = menu.findItem(R.id.app_bar_switch);
        itemSwitch.setActionView(R.layout.switch_item);
        final Switch sw = (Switch) menu.findItem(R.id.app_bar_switch).getActionView().findViewById(R.id.action_switch);
        int currentMode = AppCompatDelegate.getDefaultNightMode();

        if (currentMode == AppCompatDelegate.MODE_NIGHT_YES){
            sw.setChecked(true);
        }else{
            sw.setChecked(false);
        }

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (sw.isChecked()){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    restartCurrentCurrentActivity();
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    restartCurrentCurrentActivity();
                }
            }
        });
        return true;
    }
    private void restartCurrentCurrentActivity(){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    //Metodo para asignar las funciones correspondientes a las opciones del menu
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1) {
            Toast.makeText(this, "opcionsi1", Toast.LENGTH_SHORT).show();

        }if (id == R.id.item2) {
            Toast.makeText(this, "opcionsi1", Toast.LENGTH_SHORT).show();
        }if (id == R.id.item3) {
            Toast.makeText(this, "opcionsi1", Toast.LENGTH_SHORT).show();
        }if (id == R.id.subitem1) {
            Toast.makeText(this, "opcionsi1", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

     public void onClinck(View view){
        Drawable background = myButton.getBackground();
        myButton.setBackgroundResource(R.color.newColor);
        Intent miIntent = new Intent(MainActivity.this,Lista.class);
        startActivity(miIntent);

    }

}
