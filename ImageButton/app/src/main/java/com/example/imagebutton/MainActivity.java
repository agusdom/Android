package com.example.imagebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Metodo Boton Geekipendia de Ernestos
    public void MensajeGeekipendia(View view){
        Toast.makeText(this, "Geekipendia de Ernestos", Toast.LENGTH_SHORT).show();
    }

    //Metodo Boton Mano
    public void MensajeMano(View view){
        Toast.makeText(this, "Mano", Toast.LENGTH_SHORT).show();
    }
}