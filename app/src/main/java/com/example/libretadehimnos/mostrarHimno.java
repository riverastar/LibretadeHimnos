package com.example.libretadehimnos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class mostrarHimno extends AppCompatActivity {
  private TextView etLetra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_himno);

        etLetra = (TextView) findViewById(R.id.etMostrar);

        String letra = getIntent().getStringExtra("letra");
        etLetra.setText(letra);
    }
}
