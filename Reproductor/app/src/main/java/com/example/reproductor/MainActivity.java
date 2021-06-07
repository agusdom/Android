package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button Play_Pause,Btn_Repetir;
    MediaPlayer Mp;
    ImageView Iv;
    int Repetir = 2, Posicion = 0;

    MediaPlayer VectorMp[] = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Play_Pause = (Button)findViewById(R.id.BtnPlay);
        Btn_Repetir = (Button)findViewById(R.id.btnLoop);
        Iv = (ImageView) findViewById(R.id.imageView);

        VectorMp[0] = MediaPlayer.create(this,R.raw.race);
        VectorMp[1] = MediaPlayer.create(this,R.raw.sound);
        VectorMp[2] = MediaPlayer.create(this,R.raw.tea);
    }

    //Metodo para el boton Pause
    public void PlayPause(View view){
        if(VectorMp[Posicion].isPlaying()){
            VectorMp[Posicion].pause();
            Play_Pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this,"Pausa",Toast.LENGTH_SHORT).show();
        }else{
            VectorMp[Posicion].start();
            Play_Pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this,"Play",Toast.LENGTH_SHORT).show();
        }
    }
    //Metodo para el boton Stop
    public void Stop(View view){
        if (VectorMp[Posicion]!= null){
            VectorMp[Posicion].stop();

            VectorMp[0] = MediaPlayer.create(this,R.raw.race);
            VectorMp[1] = MediaPlayer.create(this,R.raw.sound);
            VectorMp[2] = MediaPlayer.create(this,R.raw.tea);
            Posicion = 0;
            Play_Pause.setBackgroundResource(R.drawable.reproducir);
            Iv.setImageResource(R.drawable.portada1);
            Toast.makeText(this,"Stop",Toast.LENGTH_SHORT).show();
        }
    }

        //Metodo para el boton Loop
    public void Loop(View view){
       if(Repetir == 1){
           Btn_Repetir.setBackgroundResource(R.drawable.no_repetir);
           Toast.makeText(this,"No Repetir",Toast.LENGTH_SHORT).show();
           VectorMp[Posicion].setLooping(false);
           Repetir = 2;
       }else{
           Btn_Repetir.setBackgroundResource(R.drawable.repetir);
           Toast.makeText(this,"Repetir",Toast.LENGTH_SHORT).show();
           VectorMp[Posicion].setLooping(true);
           Repetir = 1;
       }
    }

    //Metodo para el boton Siguiente
    public void Siguiente(View view){
        if(Posicion < VectorMp.length -1){
            if(VectorMp[Posicion].isPlaying()){
                VectorMp[Posicion].stop();
                Posicion++;
                VectorMp[Posicion].start();
                if(Posicion == 0){
                    Iv.setImageResource(R.drawable.portada1);
                }else if(Posicion == 1){
                    Iv.setImageResource(R.drawable.portada2);
                }else if(Posicion == 2){
                    Iv.setImageResource(R.drawable.portada3);
                }

            }else{
                Posicion++;

                if(Posicion == 0){
                    Iv.setImageResource(R.drawable.portada1);
                }else if(Posicion == 1){
                    Iv.setImageResource(R.drawable.portada2);
                }else if(Posicion == 2){
                    Iv.setImageResource(R.drawable.portada3);
                }
            }
        }else{
            Toast.makeText(this,"No hay mas canciones",Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para el boton Anterior
    public void Anterior(View view){
        if (Posicion >= 1){
            if (VectorMp[Posicion].isPlaying()){
                VectorMp[Posicion].stop();
                VectorMp[0] = MediaPlayer.create(this,R.raw.race);
                VectorMp[1] = MediaPlayer.create(this,R.raw.sound);
                VectorMp[2] = MediaPlayer.create(this,R.raw.tea);
                Posicion--;



                VectorMp[Posicion].start();

                if(Posicion == 0){
                    Iv.setImageResource(R.drawable.portada1);
                }else if(Posicion == 1){
                    Iv.setImageResource(R.drawable.portada2);
                }else if(Posicion == 2){
                    Iv.setImageResource(R.drawable.portada3);
                }
            }else{
                Posicion--;

                if(Posicion == 0){
                    Iv.setImageResource(R.drawable.portada1);
                }else if(Posicion == 1){
                    Iv.setImageResource(R.drawable.portada2);
                }else if(Posicion == 2){
                    Iv.setImageResource(R.drawable.portada3);
                }
            }
        }else{
            Toast.makeText(this,"No hay mas canciones",Toast.LENGTH_SHORT).show();
        }
    }

}
