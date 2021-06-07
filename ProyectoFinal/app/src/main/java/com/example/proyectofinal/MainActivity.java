package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Et_Nombre;
    private ImageView Iv_Personaje;
    private TextView Tv_BestScore;
    private MediaPlayer Mp;

    int Num_Aleatorios = (int) (Math.random() * 10);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Et_Nombre = (EditText) findViewById(R.id.txt_Nombre);
        Iv_Personaje = (ImageView) findViewById(R.id.imageView_Personaje);
        Tv_BestScore = (TextView) findViewById(R.id.textView_BestScore);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        int Id;

        if(Num_Aleatorios == 0 || Num_Aleatorios == 10){
            Id = getResources().getIdentifier("mango","drawable",getPackageName());
            Iv_Personaje.setImageResource(Id);
        }else if(Num_Aleatorios == 1 || Num_Aleatorios == 9){
            Id = getResources().getIdentifier("fresa","drawable",getPackageName());
            Iv_Personaje.setImageResource(Id);
        }else if(Num_Aleatorios == 2 || Num_Aleatorios == 8){
            Id = getResources().getIdentifier("manzana","drawable",getPackageName());
            Iv_Personaje.setImageResource(Id);
        }else if(Num_Aleatorios == 3 || Num_Aleatorios == 7){
            Id = getResources().getIdentifier("sandia","drawable",getPackageName());
            Iv_Personaje.setImageResource(Id);
        }else if(Num_Aleatorios == 4 || Num_Aleatorios == 5 || Num_Aleatorios == 6){
            Id = getResources().getIdentifier("uva","drawable",getPackageName());
            Iv_Personaje.setImageResource(Id);
        }

        AdminSQLiteOpenHelper Admin = new AdminSQLiteOpenHelper(this,"BD",null,1);
        SQLiteDatabase BD = Admin.getWritableDatabase();

        Cursor Consulta = BD.rawQuery(
                "select * from puntaje where Score = (select max(Score) from puntaje)",null);
        if(Consulta.moveToFirst()){
            String Temp_Nombre = Consulta.getString(0);
            String Temp_Score = Consulta.getString(1);
            Tv_BestScore.setText("Record " + Temp_Score + " de " + Temp_Nombre);
            BD.close();
        }else{
            BD.close();
        }

        Mp = MediaPlayer.create(this,R.raw.alphabet_song);
        Mp.start();
        Mp.setLooping(true);

    }

    public void Jugar(View view){

        String Nombre = Et_Nombre.getText().toString();
        if(!Nombre.equals("")){
            Mp.stop();
            Mp.release();

            Intent intent = new Intent(this, MainActivity_Nivel1.class);

            intent.putExtra("Jugador", Nombre);
            startActivity(intent);
            finish();

        }else{

            Toast.makeText(this,"Debes ingresar tu nombre..!!!",Toast.LENGTH_SHORT).show();

            Et_Nombre.requestFocus();
            InputMethodManager Imn = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
            Imn.showSoftInput(Et_Nombre,InputMethodManager.SHOW_IMPLICIT);

        }
    }

    @Override
    public void onBackPressed(){

    }
}