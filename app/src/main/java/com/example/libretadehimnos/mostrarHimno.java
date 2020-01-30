package com.example.libretadehimnos;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class mostrarHimno extends AppCompatActivity {
  private TextView etLetra, tituloHimno;
  private MediaPlayer mp;
  private ListView himnoselec;
  private Button play1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_himno);

        //Codigo para habilitar la flecha de atras
        Bundle bundle = getIntent().getExtras();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //casteo de variables
        tituloHimno = (TextView)findViewById(R.id.tituloHimno);
        etLetra = (TextView)findViewById(R.id.etMostrar);
        play1 = (Button)findViewById(R.id.play1);
        mp = MediaPlayer.create(getApplication(),R.raw.muyprontovendra);

        himnoselec = (ListView)findViewById(R.id.listaHimnos);

        final int selec = getIntent().getIntExtra("selecion",-1);
        String titulo = getIntent().getStringExtra("titulo");
        String letra = getIntent().getStringExtra("letra");

        tituloHimno.setText(titulo);
        etLetra.setText(letra);

        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (selec){
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:
                        break;
                    case 3:

                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    case 12:
                        break;
                    case 13:
                        break;
                    case 14:
                        break;
                    case 15:
                        break;
                    case 16:
                        break;
                    case 17:
                        if (mp.isPlaying()){
                            mp.pause();
                            Toast.makeText(getApplication(),"PAUSA",Toast.LENGTH_LONG).show();
                        }else{
                            mp.start();
                            Toast.makeText(getApplication(),"PLAY",Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 18:
                        Toast.makeText(getApplication(),""+selec,Toast.LENGTH_LONG).show();
                        break;
                    case 19:
                        break;
                    case 20:

                        break;
                    case 21:
                        Toast.makeText(getApplication(),""+selec,Toast.LENGTH_LONG).show();
                        break;
                    case 22:
                        break;
                    case 23:
                        break;
                    case 24:
                        break;
                    case 25:
                        break;
                    case 26:
                        break;
                    case 27:
                        break;
                    case 28:
                        break;
                    case 29:
                        Toast.makeText(getApplication(),""+selec,Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });



    }

}
