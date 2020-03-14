package com.example.libretadehimnos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
    private TextView etLetra,totalTime,currentTime;
    private double starTime = 0;
    private double finalTime = 0;
    private MediaPlayer mp [] = new MediaPlayer[24];
    private Button play;
    private Handler handler = new Handler();
    private SeekBar seekBar;
    private Runnable runnable;
    int sel = 0,cont;

    public static int oneTimeOnly = 0;

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
        play = (Button) findViewById(R.id.play1);
        play.setBackgroundResource(R.drawable.play);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //llenar vector
        mp[0] = MediaPlayer.create(this,R.raw.angelesblancos);
        mp[1] = MediaPlayer.create(this,R.raw.angelesblancos_2);
        mp[2] = MediaPlayer.create(this,R.raw.angelesblancos_3);
        mp[3] = MediaPlayer.create(this,R.raw.angelesblancos_4);
        mp[4] = MediaPlayer.create(this,R.raw.angelesblancos_5);
        mp[5] = MediaPlayer.create(this,R.raw.angelesblancos_6);
        mp[6] = MediaPlayer.create(this,R.raw.angelesblancos_7);
        mp[7] = MediaPlayer.create(this,R.raw.angelesblancos_8);
        mp[8] = MediaPlayer.create(this,R.raw.angelesblancos_9);
        mp[9] = MediaPlayer.create(this,R.raw.angelesblancos_10);
        mp[10] = MediaPlayer.create(this,R.raw.angelesblancos_11);
        mp[11] = MediaPlayer.create(this,R.raw.angelesblancos_12);
        mp[12] = MediaPlayer.create(this,R.raw.angelesblancos_13);
        mp[13] = MediaPlayer.create(this,R.raw.angelesblancos_14);
        mp[14] = MediaPlayer.create(this,R.raw.angelesblancos_15);
        mp[15] = MediaPlayer.create(this,R.raw.angelesblancos_16);
        mp[16] = MediaPlayer.create(this,R.raw.angelesblancos_17);
        mp[17] = MediaPlayer.create(this,R.raw.muyprontovendra);
        mp[18] = MediaPlayer.create(this,R.raw.muyprontovendra);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //revisar esto
         //mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        final int sel = getIntent().getIntExtra("selecion", -1);//forma para recibir un dato entero de otra actividad
        String titulo = getIntent().getStringExtra("titulo");
        String letra = getIntent().getStringExtra("letra");
        //para colocar subtitulo
        if (sel == 3) {
            getSupportActionBar().setSubtitle("Cumpleaños");
        }
        if (sel == 4) {
            getSupportActionBar().setSubtitle("Cumpleaños");
        }
        etLetra.setText(letra);
        getSupportActionBar().setTitle(titulo);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(),"hola"+sel,Toast.LENGTH_LONG).show();
                if (sel == 0){
                    //Angeles Blancos
                    if (mp[sel] != null && mp[sel].isPlaying()) {
                        mp[sel].pause();
                        play.setBackgroundResource(R.drawable.pausa);
                    }else{
                        mp[sel].start();
                        play.setBackgroundResource(R.drawable.corriendo);
                        changeSeekbar();
                        finalTime = mp[sel].getDuration();
                        starTime = mp[sel].getCurrentPosition();
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
                            TimeUnit.MILLISECONDS.toSeconds((long) finalTime)-
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)finalTime)))
                    );
                    currentTime.setText(String.format("%d:%d",
                            TimeUnit.MILLISECONDS.toMinutes((long) starTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) starTime)-
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)starTime)))
                    );
                    seekBar.setProgress((int)starTime);
                    handler.postDelayed(UpdateSongTime,1000);
                }
                if (sel == 1){
                    Toast.makeText(getApplication(),"hola"+sel,Toast.LENGTH_LONG).show();
                }
                if (sel == 2){
                    Toast.makeText(getApplication(),"hola"+sel,Toast.LENGTH_LONG).show();
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
                    Toast.makeText(getApplication(),"hola"+sel,Toast.LENGTH_LONG).show();
                    if (mp[sel] != null && mp[sel].isPlaying()) {
                        mp[sel].pause();
                        play.setBackgroundResource(R.drawable.pausa);
                    }else{
                        mp[sel].start();
                        play.setBackgroundResource(R.drawable.corriendo);
                        changeSeekbar();
                        finalTime = mp[sel].getDuration();
                        starTime = mp[sel].getCurrentPosition();
                        cont = sel;
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
                            TimeUnit.MILLISECONDS.toSeconds((long) finalTime)-
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)finalTime)))
                    );
                    currentTime.setText(String.format("%d:%d",
                            TimeUnit.MILLISECONDS.toMinutes((long) starTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) starTime)-
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)starTime)))
                    );
                    seekBar.setProgress((int)starTime);
                    handler.postDelayed(UpdateSongTime,1000);

                }
                if (sel == 19){

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
        seekBar.setProgress(mp[sel].getCurrentPosition());
        seekBar.setMax(mp[sel].getDuration());
        if (mp[sel].isPlaying()){
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
            starTime = mp[sel].getCurrentPosition();
            currentTime.setText(String.format("%d:%d",
                    TimeUnit.MILLISECONDS.toMinutes((long) starTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) starTime)-
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)starTime)))
            );
            seekBar.setProgress((int)starTime);
            handler.postDelayed(this,1000);
        }
    });
    //codigo detener musica al pulsar regresar

    public void onBackPressed() {
        Toast.makeText(getApplication(),"hola"+cont,Toast.LENGTH_LONG).show();
        if (mp[cont]!= null && mp[cont].isPlaying()) {
            mp[cont].stop();
        }
        super.onBackPressed();
    }
    //codigo para manipular la flecha atras
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(getApplication(),"hola"+sel,Toast.LENGTH_LONG).show();
        if (item.getItemId() == android.R.id.home){
            mp[sel].stop();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
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
}
