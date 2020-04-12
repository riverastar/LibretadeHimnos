package com.example.libretadehimnos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;


public class motordeBusqueda extends AppCompatActivity {
    private TextView etMotor, totalTime, currentTime;
    private Button mplay;
    private Toolbar toolbar;
    private double starTime = 0;
    private double finalTime = 0;
    private MediaPlayer mp[] = new MediaPlayer[42];
    private Handler handler = new Handler();
    private SeekBar seekBar;
    private Runnable runnable;
    private int sel = 0;
    public static int oneTimeOnly = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motorde_busqueda);

        etMotor = (TextView) findViewById(R.id.motorMostrar);
        totalTime = (TextView) findViewById(R.id.mtotalTimpo);
        currentTime = (TextView) findViewById(R.id.mcurrentTiempo);
        mplay = (Button) findViewById(R.id.playMotor);
        seekBar = (SeekBar) findViewById(R.id.seekBarr);
        toolbar = (Toolbar) findViewById(R.id.mtoolbar);
        setSupportActionBar(toolbar);
        mplay.setBackgroundResource(R.drawable.play);

        //llenar vector
        mp[1] = MediaPlayer.create(this, R.raw.angelesblancos);
        mp[2] = MediaPlayer.create(this, R.raw.loquendo);
        mp[3] = MediaPlayer.create(this, R.raw.allaenelcielo);
        mp[4] = MediaPlayer.create(this, R.raw.loquendo);
        mp[5] = MediaPlayer.create(this, R.raw.loquendo);
        mp[6] = MediaPlayer.create(this, R.raw.loquendo);
        mp[7] = MediaPlayer.create(this, R.raw.consejodivino);
        mp[8] = MediaPlayer.create(this, R.raw.loquendo);
        mp[9] = MediaPlayer.create(this, R.raw.cuantodolor);
        mp[10] = MediaPlayer.create(this, R.raw.loquendo);
        mp[11] = MediaPlayer.create(this, R.raw.loquendo);
        mp[12] = MediaPlayer.create(this, R.raw.divinocompanero);
        mp[13] = MediaPlayer.create(this, R.raw.luzdelamanana);
        mp[14] = MediaPlayer.create(this, R.raw.loquendo);
        mp[15] = MediaPlayer.create(this, R.raw.loquendo);
        mp[16] = MediaPlayer.create(this, R.raw.loquendo);
        mp[17] = MediaPlayer.create(this, R.raw.muyprontovendra);
        mp[18] = MediaPlayer.create(this, R.raw.loquendo);
        mp[19] = MediaPlayer.create(this, R.raw.juventud);
        mp[20] = MediaPlayer.create(this, R.raw.loquendo);
        mp[21] = MediaPlayer.create(this, R.raw.luzdelamanana);
        mp[22] = MediaPlayer.create(this, R.raw.loquendo);
        mp[23] = MediaPlayer.create(this, R.raw.undiadebodas);
        mp[24] = MediaPlayer.create(this, R.raw.loquendo);
        mp[25] = MediaPlayer.create(this, R.raw.loquendo);
        mp[26] = MediaPlayer.create(this, R.raw.muyprontovendra);
        mp[27] = MediaPlayer.create(this, R.raw.loquendo);
        mp[28] = MediaPlayer.create(this, R.raw.loquendo);
        mp[29] = MediaPlayer.create(this, R.raw.loquendo);
        mp[30] = MediaPlayer.create(this, R.raw.regresa);
        mp[31] = MediaPlayer.create(this, R.raw.loquendo);
        mp[32] = MediaPlayer.create(this, R.raw.loquendo);
        mp[33] = MediaPlayer.create(this, R.raw.loquendo);
        mp[34] = MediaPlayer.create(this, R.raw.loquendo);
        mp[35] = MediaPlayer.create(this, R.raw.loquendo);
        mp[36] = MediaPlayer.create(this, R.raw.undiadebodas);
        mp[37] = MediaPlayer.create(this, R.raw.loquendo);
        mp[38] = MediaPlayer.create(this, R.raw.yosoloespero);
        mp[39] = MediaPlayer.create(this, R.raw.loquendo);
        mp[40] = MediaPlayer.create(this, R.raw.loquendo);
        mp[41] = MediaPlayer.create(this, R.raw.loquendo);

        sel = getIntent().getIntExtra("mId", -1);
        String mTitulo = getIntent().getStringExtra("mTitulo");
        String mLetra = getIntent().getStringExtra("mLetra");
        getSupportActionBar().setTitle(mTitulo);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        etMotor.setText(mLetra);
        //control para el boton play en el motor de busqueda
        mplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (sel) {
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
            mplay.setBackgroundResource(R.drawable.pausa);
        } else {
            Toast.makeText(getApplication(), "" + sel, Toast.LENGTH_LONG).show();
            mp[sel].start();
            mplay.setBackgroundResource(R.drawable.corriendo);
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
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplication(), "hola" + sel, Toast.LENGTH_LONG).show();
        if (mp[sel] != null && mp[sel].isPlaying()) {
            mp[sel].pause();
        }
        super.onBackPressed();
    }

    //codigo para manipular la flecha atras
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mp[sel].pause();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}