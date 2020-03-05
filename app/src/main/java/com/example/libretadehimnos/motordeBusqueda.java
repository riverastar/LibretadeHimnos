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

public class motordeBusqueda extends AppCompatActivity {
    private TextView etMotor;
    private Button mplay;
    private MediaPlayer m;
    private Handler handler;
    private SeekBar pista;
    private Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motorde_busqueda);

        etMotor = (TextView) findViewById(R.id.motorMostrar);
        mplay = (Button) findViewById(R.id.playMotor);
        m = MediaPlayer.create(getApplication(),R.raw.muyprontovendra);
        pista = (SeekBar) findViewById(R.id.seekBarr);
        handler = new Handler();
        final int sel = getIntent().getIntExtra("mId", -1);
        String mTitulo = getIntent().getStringExtra("mTitulo");
        String mLetra = getIntent().getStringExtra("mLetra");
        getSupportActionBar().setTitle(mTitulo);
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
                    } else {
                        m.start();
                        changeSeekbar();

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
//codigo detener musica al pulsar regresar
    @Override
    public void onBackPressed() {
        if (m.isPlaying()) {
            m.stop();
        }
        super.onBackPressed();
    }

}