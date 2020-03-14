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
    private TextView etMotor,totalTime,currentTime;
    private Button mplay;
    private Toolbar toolbar;
    private MediaPlayer m;
    private double starTime = 0;
    private double finalTime = 0;
    private Handler handler = new Handler();
    private SeekBar pista;
    private Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motorde_busqueda);

        etMotor = (TextView) findViewById(R.id.motorMostrar);
        totalTime = (TextView) findViewById(R.id.mtotalTimpo);
        currentTime = (TextView) findViewById(R.id.mcurrentTiempo);
        mplay = (Button) findViewById(R.id.playMotor);
        m = MediaPlayer.create(getApplication(),R.raw.muyprontovendra);
        pista = (SeekBar) findViewById(R.id.seekBarr);
        toolbar = (Toolbar) findViewById(R.id.mtoolbar);
        setSupportActionBar(toolbar);
        mplay.setBackgroundResource(R.drawable.play);

        final int sel = getIntent().getIntExtra("mId", -1);
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
                Toast.makeText(getApplication(), "HOLA"+sel,  Toast.LENGTH_LONG).show();
                if (sel == 1){


                }
                if (sel == 2){

                }
                if (sel == 3){

                }
                if (sel == 4){

                }
                if (sel == 5){

                }
                if (sel == 6){


                }
                if (sel == 7){

                }
                if (sel == 8){

                }
                if (sel == 9){

                }
                if (sel == 10){


                }
                if (sel == 11){

                }
                if (sel == 12){

                }
                if (sel == 13){

                }
                if (sel == 14){


                }
                if (sel == 15){

                }
                if (sel == 16){

                }
                if (sel == 17){

                }
                if (sel == 18){


                }
                if (sel == 19){
                    if (m != null && m.isPlaying()) {
                        m.pause();
                    }else{
                        m.start();
                        changeSeekbar();
                        finalTime = m.getDuration();
                        starTime = m.getCurrentPosition();
                        pista.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                            @Override
                            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                if (fromUser) {
                                    pista.setMax(m.getDuration());
                                    m.seekTo(progress);
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
                    totalTime.setText(String.format("%d:%d",
                            TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) finalTime)-
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)finalTime)))
                    );
                    currentTime.setText(String.format("%d:%d",
                            TimeUnit.MILLISECONDS.toMinutes((long) starTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) starTime)-
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)starTime)))
                    );
                    pista.setProgress((int)starTime);
                    handler.postDelayed(UpdateSongTime,1000);
                }
                if (sel == 20){

                }
                if (sel == 21){

                }
                if (sel == 22){

                }
                if (sel == 23){

                }
                if (sel == 24){

                }
                if (sel == 25){

                }
            }
        });
    }
    //codigo para correr seekbar
    private void changeSeekbar() {
        pista.setProgress(m.getCurrentPosition());
        pista.setMax(m.getDuration());
        if (m.isPlaying()){
            runnable = new Runnable() {
                @Override
                public void run() {
                    changeSeekbar();
                }
            };
            handler.postDelayed(runnable,1000);
        }
    }
//contador duracion del himno
    private Runnable UpdateSongTime = (new Runnable() {
        public void run() {
            starTime = m.getCurrentPosition();
            currentTime.setText(String.format("%d:%d",
                    TimeUnit.MILLISECONDS.toMinutes((long) starTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) starTime)-
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)starTime)))
            );
            pista.setProgress((int)starTime);
            handler.postDelayed(this,1000);
        }
    });
//codigo detener musica al pulsar regresar
    @Override
    public void onBackPressed() {
        if (m.isPlaying()) {
            m.stop();
        }
        super.onBackPressed();
    }
    //codigo para manipular la flecha atras
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            m.stop();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}