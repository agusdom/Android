package com.example.reproductordeaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Play;
    SoundPool Sp;
    int Sonido_De_Reproduccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Play = (Button) findViewById(R.id.button_Play);
        Sp = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
        Sonido_De_Reproduccion = Sp.load(this,R.raw.sound_short,1);
    }

    public void AudioSoundPool(View view){
        Sp.play(Sonido_De_Reproduccion,1,1,1,0,0);
    }

    public void AudioMediaPlayer(View view){
        MediaPlayer Mp = MediaPlayer.create(this,R.raw.sound_long);
        Mp.start();
    }
}