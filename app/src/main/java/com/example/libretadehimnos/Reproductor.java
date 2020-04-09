package com.example.libretadehimnos;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class Reproductor extends AppCompatActivity {
    private TextView tex1, tex2, tex3;
    private Button b1, b2, b3, b4, b5;
    private SeekBar sB;
    private MediaPlayer mp;
    private MediaPlayer vectormp[] = new MediaPlayer[10];
    private Handler myHandler = new Handler();
    private double starTime = 0;
    private double finalTime = 0;
    String him[] = {"ANGELES BLANCOS", "ALLA EN EL CIELO", "CONSEJO DIVINO", "CUANTO DOLOR", "DIVINO COMPAÑERO", "LUZ DE LA MAÑANA", "MUY PRONTO VENDRA", "REGRESA", "JUVENTUD", "YO SOLO ESPERO"};
    int repetir = 0, posicion = 0;
    public static int oneTimeOnly = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);
        b1 = (Button) findViewById(R.id.boton);
        b2 = (Button) findViewById(R.id.boton2);
        b3 = (Button) findViewById(R.id.boton3);
        b4 = (Button) findViewById(R.id.boton4);
        b5 = (Button) findViewById(R.id.boton5);
        tex1 = (TextView) findViewById(R.id.textView);
        tex2 = (TextView) findViewById(R.id.textView2);
        tex3 = (TextView) findViewById(R.id.textView3);
        tex1.setText(him[posicion]);
        tex1.setSelected(true);
        vectormp[0] = MediaPlayer.create(this, R.raw.angelesblancos);
        vectormp[1] = MediaPlayer.create(this, R.raw.allaenelcielo);
        vectormp[2] = MediaPlayer.create(this, R.raw.consejodivino);
        vectormp[3] = MediaPlayer.create(this, R.raw.cuantodolor);
        vectormp[4] = MediaPlayer.create(this, R.raw.divinocompanero);
        vectormp[5] = MediaPlayer.create(this, R.raw.muyprontovendra);
        vectormp[6] = MediaPlayer.create(this, R.raw.luzdelamanana);
        vectormp[7] = MediaPlayer.create(this, R.raw.undiadebodas);
        vectormp[8] = MediaPlayer.create(this, R.raw.juventud);
        vectormp[9] = MediaPlayer.create(this, R.raw.yosoloespero);
        b1.setBackgroundResource(R.drawable.playr);
        b2.setBackgroundResource(R.drawable.stop);
        b3.setBackgroundResource(R.drawable.norepetir);
        b4.setBackgroundResource(R.drawable.ante);
        b5.setBackgroundResource(R.drawable.sig);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vectormp[posicion].isPlaying()) {
                    vectormp[posicion].pause();
                    b1.setBackgroundResource(R.drawable.playr);
                    Toast.makeText(getApplication(), "PAUSA", Toast.LENGTH_SHORT).show();
                } else {
                    b1.setBackgroundResource(R.drawable.pausa);
                    Toast.makeText(getApplication(), "PLAY", Toast.LENGTH_SHORT).show();
                            vectormp[posicion].start();

                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vectormp[posicion] != null) {
                    vectormp[posicion].stop();
                    vectormp[0] = MediaPlayer.create(getApplication(), R.raw.angelesblancos);
                    vectormp[1] = MediaPlayer.create(getApplication(), R.raw.allaenelcielo);
                    vectormp[2] = MediaPlayer.create(getApplication(), R.raw.consejodivino);
                    vectormp[3] = MediaPlayer.create(getApplication(), R.raw.cuantodolor);
                    vectormp[4] = MediaPlayer.create(getApplication(), R.raw.divinocompanero);
                    vectormp[5] = MediaPlayer.create(getApplication(), R.raw.muyprontovendra);
                    vectormp[6] = MediaPlayer.create(getApplication(), R.raw.luzdelamanana);
                    vectormp[7] = MediaPlayer.create(getApplication(), R.raw.undiadebodas);
                    vectormp[8] = MediaPlayer.create(getApplication(), R.raw.juventud);
                    vectormp[9] = MediaPlayer.create(getApplication(), R.raw.yosoloespero);
                    posicion = 0;

                    Toast.makeText(getApplication(), "STOP", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (repetir == 1) {
                    b3.setBackgroundResource(R.drawable.norepetir);
                    Toast.makeText(getApplication(), "NO REPETIR", Toast.LENGTH_SHORT).show();
                    vectormp[posicion].setLooping(false);
                    repetir = 2;
                } else {
                    b3.setBackgroundResource(R.drawable.repetir);
                    Toast.makeText(getApplication(), "REPETIR", Toast.LENGTH_SHORT).show();
                    vectormp[posicion].setLooping(true);
                    repetir = 1;
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (posicion >=1) {
                    if (vectormp[posicion].isPlaying()) {
                        vectormp[posicion].stop();
                        vectormp[0] = MediaPlayer.create(getApplication(), R.raw.angelesblancos);
                        vectormp[1] = MediaPlayer.create(getApplication(), R.raw.allaenelcielo);
                        vectormp[2] = MediaPlayer.create(getApplication(), R.raw.consejodivino);
                        vectormp[3] = MediaPlayer.create(getApplication(), R.raw.cuantodolor);
                        vectormp[4] = MediaPlayer.create(getApplication(), R.raw.divinocompanero);
                        vectormp[5] = MediaPlayer.create(getApplication(), R.raw.muyprontovendra);
                        vectormp[6] = MediaPlayer.create(getApplication(), R.raw.luzdelamanana);
                        vectormp[7] = MediaPlayer.create(getApplication(), R.raw.undiadebodas);
                        vectormp[8] = MediaPlayer.create(getApplication(), R.raw.juventud);
                        vectormp[9] = MediaPlayer.create(getApplication(), R.raw.yosoloespero);
                        posicion--;
                        vectormp[posicion].start();
                        tex1.setText(him[posicion]);
                    } else {
                        posicion--;
                    }
                } else {
                    Toast.makeText(getApplication(), "NO HAY MAS HIMNOS", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (posicion < vectormp.length - 1) {
                    if (vectormp[posicion].isPlaying()) {
                        vectormp[posicion].stop();
                        posicion++;
                        vectormp[posicion].start();
                        tex1.setText(him[posicion]);
                    } else {
                        posicion++;
                    }
                } else {
                    Toast.makeText(getApplication(), "NO HAY MAS HIMNOS", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //codigo detener musica al pulsar regresar
    public void onBackPressed() {
        posicion++;
        if (vectormp[posicion] != null && vectormp[posicion].isPlaying()) {
            vectormp[posicion].stop();
        }
        super.onBackPressed();
    }
}

