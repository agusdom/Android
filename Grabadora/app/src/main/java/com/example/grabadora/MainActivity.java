package com.example.grabadora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private MediaRecorder Grabacion;
    private String ArchivoSalida = null;
    private Button Btn_Recorder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn_Recorder = (Button)findViewById(R.id.btn_Rec);

        //Permisos correspondientes
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1000);
        }
    }

    //Grabar
    public void Recorder(View view){
        if(Grabacion == null){
            ArchivoSalida = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Grabacion.mp3";
            Grabacion = new MediaRecorder();
            Grabacion.setAudioSource(MediaRecorder.AudioSource.MIC);
            Grabacion.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            Grabacion.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
            Grabacion.setOutputFile(ArchivoSalida);

            try {
                Grabacion.prepare();
                Grabacion.start();
            }catch (IOException e){
            }

            Btn_Recorder.setBackgroundResource(R.drawable.rec);
            Toast.makeText(this,"Grabando...",Toast.LENGTH_SHORT).show();
        }else{
            Grabacion.stop();
            Grabacion.release();
            Grabacion = null;
            Btn_Recorder.setBackgroundResource(R.drawable.stop_rec);
            Toast.makeText(this,"Grabacion finalizada.",Toast.LENGTH_SHORT).show();
        }
    }

    //Reproducir
    public void Reproducir(View view){
        MediaPlayer MediaPlayer = new MediaPlayer();
        try{
            MediaPlayer.setDataSource(ArchivoSalida);
            MediaPlayer.prepare();
        }catch (IOException e){
        }

        MediaPlayer.start();
        Toast.makeText(this,"Reproduciendo Audio.",Toast.LENGTH_SHORT).show();
    }
}