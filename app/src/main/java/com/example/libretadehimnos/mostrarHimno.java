package com.example.libretadehimnos;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
public class mostrarHimno extends AppCompatActivity {
    private TextView etLetra,totalTime,currentTime;
    private MediaPlayer mp;
    private Button play1;
    private Handler handler;
    private SeekBar pista;
    private Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_himno);

        //Codigo para habilitar la flecha de atras
        Bundle bundle = getIntent().getExtras();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //casteo de variables
        etLetra = (TextView) findViewById(R.id.etMostrar);
        totalTime = (TextView) findViewById(R.id.totalTimer);
        currentTime = (TextView) findViewById(R.id.currentTimer);
        play1 = (Button) findViewById(R.id.play1);

        mp = MediaPlayer.create(getApplication(), R.raw.muyprontovendra);

        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        handler = new Handler();
        pista = (SeekBar) findViewById(R.id.seekBar);


        final int selec = getIntent().getIntExtra("selecion", -1);//forma para resivir un dato entero de otra actividad
        String titulo = getIntent().getStringExtra("titulo");
        String letra = getIntent().getStringExtra("letra");


        etLetra.setText(letra);
        getSupportActionBar().setTitle(titulo);

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

            }
        });


        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (selec) {
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


                        break;
                    case 18:
                        //Muy pronto vendra
                        //codigo para el boton pausa y play
                        if (mp != null && mp.isPlaying()) {
                            mp.pause();
                        } else {
                            mp.start();
                            changeSeekbar();

                            pista.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                @Override
                                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                    if (fromUser) {
                                        pista.setMax(mp.getDuration());
                                        mp.seekTo(progress);
                                        pista.setProgress(progress);
                                        changeSeekbar();
                                    }
                                }
                                @Override
                                public void onStartTrackingTouch(SeekBar seekBar) {
                                }

                                @Override
                                public void onStopTrackingTouch(SeekBar seekBar) {
                                }
                               });


                             }

                        break;
                    case 19:
                        break;
                    case 20:

                        break;
                    case 21:
                        Toast.makeText(getApplication(), "" + selec, Toast.LENGTH_LONG).show();
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
                        Toast.makeText(getApplication(), "" + selec, Toast.LENGTH_LONG).show();
                        break;
                }
            }



            private String createTimeLabel(int time) {
                String timeLabel = "";
                int min = time /100 / 60;
                int sec = time /100 % 60;
                timeLabel = min + ":";
                if (min < 10) timeLabel += "0";
                timeLabel += sec;
                return timeLabel;
            }

        });




    }
//codigo para correr seekbar
    private void changeSeekbar() {
        pista.setProgress(mp.getCurrentPosition());
        pista.setMax(mp.getDuration());
        if (mp.isPlaying()){
            runnable = new Runnable() {
                @Override
                public void run() {
                    changeSeekbar();
                }
            };
            handler.postDelayed(runnable,1000);
        }
    }

}
