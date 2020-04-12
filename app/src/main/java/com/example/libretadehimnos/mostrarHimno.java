package com.example.libretadehimnos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class mostrarHimno<HandleInputStart> extends AppCompatActivity {
    public View view;
    private Toolbar toolbar;
    private TextView etLetra, totalTime, currentTime, nombre;
    private double starTime = 0;
    private double finalTime = 0;
    private MediaPlayer mp[] = new MediaPlayer[41];
    private Button play;
    private Handler handler = new Handler();
    private SeekBar seekBar;
    private Runnable runnable;
    private int sel = 0;
    public static int oneTimeOnly = 0;
    private ObjectAnimator animatorX;
    private ObjectAnimator animatorY;
    private long animatorDuration = 1000;
    private AnimatorSet animatorSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_himno);
        //Codigo para habilitar la flecha de atras
        //casteo de variables
        view = this.getWindow().getDecorView();
        etLetra = (TextView) findViewById(R.id.etMostrar);
        totalTime = (TextView) findViewById(R.id.totalTimer);
        currentTime = (TextView) findViewById(R.id.currentTimer);
        nombre = (TextView) findViewById(R.id.nombre);
        play = (Button) findViewById(R.id.play1);
        play.setBackgroundResource(R.drawable.play);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        //llenar vector
        mp[0] = MediaPlayer.create(this, R.raw.angelesblancos);
        mp[1] = MediaPlayer.create(this, R.raw.loquendo);
        mp[2] = MediaPlayer.create(this, R.raw.allaenelcielo);
        mp[3] = MediaPlayer.create(this, R.raw.loquendo);
        mp[4] = MediaPlayer.create(this, R.raw.loquendo);
        mp[5] = MediaPlayer.create(this, R.raw.loquendo);
        mp[6] = MediaPlayer.create(this, R.raw.consejodivino);
        mp[7] = MediaPlayer.create(this, R.raw.loquendo);
        mp[8] = MediaPlayer.create(this, R.raw.cuantodolor);
        mp[9] = MediaPlayer.create(this, R.raw.loquendo);
        mp[10] = MediaPlayer.create(this, R.raw.loquendo);
        mp[11] = MediaPlayer.create(this, R.raw.divinocompanero);
        mp[12] = MediaPlayer.create(this, R.raw.luzdelamanana);
        mp[13] = MediaPlayer.create(this, R.raw.loquendo);
        mp[14] = MediaPlayer.create(this, R.raw.loquendo);
        mp[15] = MediaPlayer.create(this, R.raw.loquendo);
        mp[16] = MediaPlayer.create(this, R.raw.muyprontovendra);
        mp[17] = MediaPlayer.create(this, R.raw.loquendo);
        mp[18] = MediaPlayer.create(this, R.raw.juventud);
        mp[19] = MediaPlayer.create(this, R.raw.loquendo);
        mp[20] = MediaPlayer.create(this, R.raw.luzdelamanana);
        mp[21] = MediaPlayer.create(this, R.raw.loquendo);
        mp[22] = MediaPlayer.create(this, R.raw.undiadebodas);
        mp[23] = MediaPlayer.create(this, R.raw.loquendo);
        mp[24] = MediaPlayer.create(this, R.raw.loquendo);
        mp[25] = MediaPlayer.create(this, R.raw.muyprontovendra);
        mp[26] = MediaPlayer.create(this, R.raw.loquendo);
        mp[27] = MediaPlayer.create(this, R.raw.loquendo);
        mp[28] = MediaPlayer.create(this, R.raw.loquendo);
        mp[29] = MediaPlayer.create(this, R.raw.regresa);
        mp[30] = MediaPlayer.create(this, R.raw.loquendo);
        mp[31] = MediaPlayer.create(this, R.raw.loquendo);
        mp[32] = MediaPlayer.create(this, R.raw.loquendo);
        mp[33] = MediaPlayer.create(this, R.raw.loquendo);
        mp[34] = MediaPlayer.create(this, R.raw.loquendo);
        mp[35] = MediaPlayer.create(this, R.raw.undiadebodas);
        mp[36] = MediaPlayer.create(this, R.raw.loquendo);
        mp[37] = MediaPlayer.create(this, R.raw.yosoloespero);
        mp[38] = MediaPlayer.create(this, R.raw.loquendo);
        mp[39] = MediaPlayer.create(this, R.raw.loquendo);
        mp[40] = MediaPlayer.create(this, R.raw.loquendo);

        seekBar = (SeekBar) findViewById(R.id.seekBar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //revisar esto


        sel = getIntent().getIntExtra("selecion", -1);//forma para recibir un dato entero de otra actividad
        String titulo = getIntent().getStringExtra("titulo");
        String letra = getIntent().getStringExtra("letra");

        if (sel == 28) {
            getSupportActionBar().setSubtitle("Cumpleaños");
        }
        if (sel == 31) {
            getSupportActionBar().setSubtitle("Cumpleaños");
        }

        etLetra.setText(letra);
        getSupportActionBar().setTitle(titulo);


        animatorX = ObjectAnimator.ofFloat(nombre,"x",500f);
        animatorX.setDuration(animatorDuration);
        AnimatorSet animatorSetBucle = new AnimatorSet();
        animatorSetBucle.play(animatorX);
        animatorSetBucle.addListener(new AnimatorListenerAdapter() {
                                         @Override
                                         public void onAnimationEnd(Animator animation) {
                                             animation.start();
                                         }
                                    });
                animatorSetBucle.start();
        //codigo para el boton pausa y play
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (sel) {
                    case 0:
                        //Angeles blancos
                        tocarHimnos();
                        break;
                    case 1:
                        tocarHimnos();
                        break;
                    case 2:
                        tocarHimnos();
                        break;
                    case 3:
                        tocarHimnos();
                        break;
                    case 4:
                        tocarHimnos();
                        break;
                    case 5:
                        tocarHimnos();
                        break;
                    case 6:
                        tocarHimnos();
                        break;
                    case 7:
                        tocarHimnos();
                        break;
                    case 8:
                        tocarHimnos();
                        break;
                    case 9:
                        tocarHimnos();
                        break;
                    case 10:
                        tocarHimnos();
                        break;
                    case 11:
                        tocarHimnos();
                        break;
                    case 12:
                        tocarHimnos();
                        break;
                    case 13:
                        tocarHimnos();
                        break;
                    case 14:
                        tocarHimnos();
                        break;
                    case 15:
                        tocarHimnos();
                        break;
                    case 16:
                        tocarHimnos();
                        break;
                    case 17:
                        tocarHimnos();
                        break;
                    case 18:
                        //Muy pronto vendra
                        //codigo para el boton pausa y play
                        tocarHimnos();
                        break;
                    case 19:
                        tocarHimnos();
                        break;
                    case 20:
                        tocarHimnos();
                        break;
                    case 21:
                        tocarHimnos();
                        break;
                    case 22:
                        tocarHimnos();
                        break;
                    case 23:
                        tocarHimnos();
                        break;
                    case 24:
                        tocarHimnos();
                        break;
                    case 25:
                        tocarHimnos();
                        break;
                    case 26:
                        tocarHimnos();
                        break;
                    case 27:
                        tocarHimnos();
                        break;
                    case 28:
                        tocarHimnos();
                        break;
                    case 29:
                        tocarHimnos();
                        break;
                    case 30:
                        tocarHimnos();
                        break;
                    case 31:
                        tocarHimnos();
                        break;
                    case 32:
                        tocarHimnos();
                        break;
                    case 33:
                        tocarHimnos();
                        break;
                    case 34:
                        tocarHimnos();
                        break;
                    case 35:
                        tocarHimnos();
                        break;
                    case 36:
                        tocarHimnos();
                        break;
                    case 37:
                        tocarHimnos();
                        break;
                    case 38:
                        tocarHimnos();
                        break;
                    case 39:
                        tocarHimnos();
                        break;
                    case 40:
                        tocarHimnos();
                        break;
                }
            }
        });
    }

    private void tocarHimnos() {
        if (mp[sel] != null && mp[sel].isPlaying()) {
            mp[sel].pause();
            play.setBackgroundResource(R.drawable.pausa);
        } else {
            mp[sel].start();
            play.setBackgroundResource(R.drawable.corriendo);
            changeSeekbar();
            finalTime = mp[sel].getDuration();
            starTime = mp[sel].getCurrentPosition();
            if (oneTimeOnly == 0) {
                seekBar.setMax((int) finalTime);
                oneTimeOnly = 1;
            }
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (fromUser) {
                        seekBar.setMax(mp[sel].getDuration());
                        mp[sel].seekTo(progress);
                        seekBar.setProgress(progress);
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
        totalTime.setText(String.format("%d:%d",
                TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime)))
        );
        currentTime.setText(String.format("%d:%d",
                TimeUnit.MILLISECONDS.toMinutes((long) starTime),
                TimeUnit.MILLISECONDS.toSeconds((long) starTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) starTime)))
        );
        seekBar.setProgress((int) starTime);
        handler.postDelayed(UpdateSongTime, 1000);
    }
    //codigo para correr seekbar
    private void changeSeekbar() {
        seekBar.setProgress(mp[sel].getCurrentPosition());
        seekBar.setMax(mp[sel].getDuration());
        if (mp[sel].isPlaying()) {
            runnable = new Runnable() {
                @Override
                public void run() {
                    changeSeekbar();
                }
            };
            handler.postDelayed(runnable, 1000);
        }
    }

    //contador duracion del himno
    private Runnable UpdateSongTime = (new Runnable() {
        @Override
        public void run() {
            starTime = mp[sel].getCurrentPosition();
            currentTime.setText(String.format("%d:%d",
                    TimeUnit.MILLISECONDS.toMinutes((long) starTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) starTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) starTime)))
            );
            seekBar.setProgress((int) starTime);
            handler.postDelayed(this, 1000);
        }
    });

    //codigo detener musica al pulsar regresar
    public void onBackPressed() {
        if (mp[sel] != null && mp[sel].isPlaying()) {
            mp[sel].stop();
        }
        super.onBackPressed();
    }

    //codigo para manipular la flecha atras
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mp[sel].stop();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    private void animacion(){

    }
}
