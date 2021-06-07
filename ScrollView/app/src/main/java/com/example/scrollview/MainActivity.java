package com.example.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Poner el icono en el action Bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    public void Seleccion(View view){
        switch (view.getId()){
            case R.id.Bananas:
                Toast.makeText(this,"Estas son Bananas",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Cerezas:
                Toast.makeText(this,"Estas son Cerezas",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Frambueza:
                Toast.makeText(this,"Estas son Frambuezas",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Fresa:
                Toast.makeText(this,"Estas son Fresas",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Kiwi:
                Toast.makeText(this,"Estos son Kiwis",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Mango:
                Toast.makeText(this,"Estos son Mangos",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Manzana:
                Toast.makeText(this,"Estas son Manzanas",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Melon:
                Toast.makeText(this,"Estos son Melones",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Pera:
                Toast.makeText(this,"Estas son Peras",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Pina:
                Toast.makeText(this,"Estas son Pinas",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Sandia:
                Toast.makeText(this,"Estas son Sandias",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Uva:
                Toast.makeText(this,"Estas son Uvas",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Zarzamora:
                Toast.makeText(this,"Estas son Zarzamoras",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}