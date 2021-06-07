package com.example.sharedpreferencesagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Et_Nombre,Et_Datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Et_Nombre = (EditText) findViewById(R.id.txt_Nombre);
        Et_Datos = (EditText) findViewById(R.id.txt_Datos);
    }

    //Metodo boton Guardar
    public void Guardar(View view){
        String Nombre = Et_Nombre.getText().toString();
        String Datos = Et_Datos.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_Editor = preferencias.edit();
        Obj_Editor.putString(Nombre,Datos);
        Obj_Editor.commit();

        Toast.makeText(this,"El contacto ha sido guardado",Toast.LENGTH_SHORT).show();
    }

    //Metodo boton Buscar
    public void Buscar(View view){
        String Nombre = Et_Nombre.getText().toString();
        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String Datos = preferencias.getString(Nombre,"");

        if(Datos.length() == 0){
            Toast.makeText(this,"No se encontro ningun registro.",Toast.LENGTH_SHORT).show();
        }else{
            Et_Datos.setText(Datos);
        }
    }
}