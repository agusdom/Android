package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity_Nivel2 extends AppCompatActivity {
    private EditText Et_Respuesta;
    private ImageView Iv_Auno,Iv_Ados,Iv_Vidas;
    private TextView Tv_Nombre,Tv_Score;
    private MediaPlayer Mp,Mp_Great,Mp_Bad;

    int Score,Num_Aleatorio_Uno,Num_Aleatorio_Dos,Resultado,Vidas = 3;
    String Nombre_Jugador,String_Score,String_Vidas;

    String Numero[] = {"cero","uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__nivel1);

        Toast.makeText(this,"Nivel 2 - Sumas Moderadas",Toast.LENGTH_SHORT).show();

        Tv_Nombre = (TextView) findViewById(R.id.textView_Nombre );
        Tv_Score = (TextView) findViewById(R.id.textView_Score);
        Iv_Vidas = (ImageView) findViewById(R.id.imageView_Vidas);
        Iv_Auno = (ImageView) findViewById(R.id.imageView_Num1);
        Iv_Ados = (ImageView) findViewById(R.id.imageView_Num2);
        Et_Respuesta = (EditText) findViewById(R.id.txtView_Resultado);

        Nombre_Jugador = getIntent().getStringExtra("Jugador");
        Tv_Nombre.setText("Jugador:" + Nombre_Jugador);

        String_Score = getIntent().getStringExtra("Score");
        Score = Integer.parseInt(String_Score);
        Tv_Score.setText("Score:" + Score);

        String_Vidas = getIntent().getStringExtra("Vidas");
        Vidas = Integer.parseInt(String_Vidas);

        if(Vidas == 3){
            Iv_Vidas.setImageResource(R.drawable.tresvidas);
        }
        if(Vidas == 2){
            Iv_Vidas.setImageResource(R.drawable.dosvidas);
        }
        if(Vidas == 1){
            Iv_Vidas.setImageResource(R.drawable.unavida);
        }

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        Mp = MediaPlayer.create(this,R.raw.goats);
        Mp.start();
        Mp.setLooping(true);

        Mp_Great = MediaPlayer.create(this, R.raw.wonderful);
        Mp_Bad = MediaPlayer.create(this,R.raw.bad);

        NumAleatorio();

    }

    public void Comparar(View view){
        String Respuesta = Et_Respuesta.getText().toString();

        if(!Respuesta.equals("")){
            int Respuesta_Jugador = Integer.parseInt(Respuesta);
            if(Resultado == Respuesta_Jugador){

                Mp_Great.start();
                Score++;
                Tv_Score.setText("Score:" + Score);
                Et_Respuesta.setText("");
                BaseDeDatos();
            }else{
                Mp_Bad.start();
                Vidas--;
                BaseDeDatos();

                switch (Vidas){
                    case 3:
                        Iv_Vidas.setImageResource(R.drawable.tresvidas);
                        break;
                    case 2:
                        Toast.makeText(this,"Te quedan dos vidas.!!!!!",Toast.LENGTH_SHORT).show();
                        Iv_Vidas.setImageResource(R.drawable.dosvidas);
                        break;
                    case 1:
                        Toast.makeText(this,"Te queda una vida.!!!!!",Toast.LENGTH_SHORT).show();
                        Iv_Vidas.setImageResource(R.drawable.unavida);
                        break;
                    case 0:
                        Toast.makeText(this,"Has perdido todas tus manzanas.!!!!!",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this,MainActivity.class);
                        startActivity(intent);
                        finish();
                        Mp.stop();
                        Mp.release();
                        break;
                }
                Et_Respuesta.setText("");
            }

            NumAleatorio();
        }else{
            Toast.makeText(this,"Escribe tu respuesta.!!!!",Toast.LENGTH_SHORT).show();
        }
    }
    public void NumAleatorio(){
        if(Score <= 19){
            Num_Aleatorio_Uno = (int) (Math.random() * 10);
            Num_Aleatorio_Dos = (int) (Math.random() * 10);

            Resultado = Num_Aleatorio_Uno + Num_Aleatorio_Dos;
            
                for(int i = 0; i < Numero.length; i++){
                    int Id = getResources().getIdentifier(Numero[i], "drawable", getPackageName());
                    if(Num_Aleatorio_Uno == i){
                        Iv_Auno.setImageResource(Id);
                    }if(Num_Aleatorio_Dos == i){
                        Iv_Ados.setImageResource(Id);
                    }
                }

        }else{
            Intent intent = new Intent(this, MainActivity_Nivel3.class);

            String_Score = String.valueOf(Score);
            String_Vidas = String.valueOf(Vidas);
            intent.putExtra("Jugador",Nombre_Jugador);
            intent.putExtra("Score",String_Score);
            intent.putExtra("Vidas",String_Vidas);

            startActivity(intent);
            finish();
            Mp.stop();
            Mp.release();
        }
    }
    public void BaseDeDatos(){
        AdminSQLiteOpenHelper Admin = new AdminSQLiteOpenHelper(this,"BD",null,1);
        SQLiteDatabase BD = Admin.getWritableDatabase();

        Cursor Consulta = BD.rawQuery("select * from puntaje where Score = (select max(Score) from puntaje)",null);
        if(Consulta.moveToFirst()){
            String Temp_Nombre = Consulta.getString(0);
            String Temp_Score = Consulta.getString(1);

            int Best_Score = Integer.parseInt(Temp_Score);

            if(Score>Best_Score){
                ContentValues Modificacion = new ContentValues();
                Modificacion.put("Nombre",Nombre_Jugador);
                Modificacion.put("Score",Score);

                BD.update("puntaje", Modificacion,"Score =" + Best_Score,null);
            }
            BD.close();
        }else{
            ContentValues Insertar = new ContentValues();

            Insertar.put("Nombre",Nombre_Jugador);
            Insertar.put("Score",Score);

            BD.insert("puntaje",null,Insertar);
            BD.close();
        }
    }

    @Override
    public void onBackPressed(){

    }
}