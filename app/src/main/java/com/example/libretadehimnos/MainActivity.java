package com.example.libretadehimnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private LinearLayout fondo;
private Toolbar toolbar;
private View view,view2;
private Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = this.getWindow().getDecorView();


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fondo = (LinearLayout) findViewById(R.id.conten1);
        myButton = (Button) findViewById(R.id.iraLista);
        //llamado del toolbar generico dos formas
        //toolbar.inflateMenu(R.menu.overflow);

        setSupportActionBar(toolbar);

    }



    //Metodo para mostrar y ocultar el menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow, menu);
        MenuItem itemSwitch = menu.findItem(R.id.app_bar_switch);
        itemSwitch.setActionView(R.layout.switch_item);
        final Switch sw = (Switch) menu.findItem(R.id.app_bar_switch).getActionView().findViewById(R.id.action_switch);
        view.setBackgroundResource(R.drawable.principaldia);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (sw.isChecked()){
                    Toast.makeText(getApplication(),"on",Toast.LENGTH_LONG).show();
                    view.setBackgroundResource(R.drawable.principalnoct);

                }else{
                    view.setBackgroundResource(R.drawable.principaldia);
                }
            }
        });
        return true;
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
