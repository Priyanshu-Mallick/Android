package com.example.multiplevideo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button2;
    private SurfaceView surfaceView;
    private SurfaceView surfaceView2;
    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayer2;
    private SeekBar seekBar;
    private SeekBar seekBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        surfaceView = findViewById(R.id.surfaceView);
        surfaceView2 = findViewById(R.id.surfaceView2);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        seekBar = findViewById(R.id.seekBar);
        seekBar2 = findViewById(R.id.seekBar2);
        mediaPlayer = MediaPlayer.create(this, R.raw.vid1);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.vid2);
        surfaceView.setKeepScreenOn(true);
        surfaceView2.setKeepScreenOn(true);
        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                mediaPlayer.setDisplay(surfaceHolder);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

            }
        });
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b){
                    mediaPlayer.seekTo(i);
                    seekBar.setProgress(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        SurfaceHolder surfaceHolder2 = surfaceView2.getHolder();
        surfaceHolder2.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder2) {
                mediaPlayer2.setDisplay(surfaceHolder2);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder2, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder2) {

            }
        });
        seekBar2.setMax(mediaPlayer2.getDuration());
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar2, int i, boolean b) {
                if (b){
                    mediaPlayer2.seekTo(i);
                    seekBar2.setProgress(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
//        mediaPlayer.start();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    mediaPlayer2.start();
                    button.setText("Play video 1");
                }
                else if (mediaPlayer2.isPlaying()){
                    mediaPlayer.start();
                    mediaPlayer2.pause();
                    button.setText("Play video 2 ");
                }
                else{
                    mediaPlayer.start();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
                if (mediaPlayer2.isPlaying()){
                    mediaPlayer2.pause();
                }
            }
        });
    }
}