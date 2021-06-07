package com.example.sd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText EtNombre,EtContenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EtNombre = (EditText) findViewById(R.id.txt_Nombre);
        EtContenido = (EditText) findViewById(R.id.txt_Contenido);
    }

    //Metodo para el boton Guardar
    public void Guardar(View view){
        String Nombre = EtNombre.getText().toString();
        String Contenido = EtContenido.getText().toString();

        try {
            File TarjetaSD = Environment.getExternalStorageDirectory();
            Toast.makeText(this,TarjetaSD.getPath(),Toast.LENGTH_SHORT).show();
            File rutaArchivo = new File(TarjetaSD.getPath(),Nombre);
            OutputStreamWriter CrearArchivo = new OutputStreamWriter(openFileOutput(Nombre, Activity.MODE_PRIVATE));

            CrearArchivo.write(Contenido);
            CrearArchivo.flush();
            CrearArchivo.close();

            Toast.makeText(this,"Guardado Correctamente.",Toast.LENGTH_SHORT).show();
            EtNombre.setText("");
            EtContenido.setText("");
        }catch (IOException e){
            Toast.makeText(this,"No se puede guardar",Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para el boton Consultar
    public void Consultar(View view){
        String Nombre = EtNombre.getText().toString();

        try {
            File TarjetaSD = Environment.getExternalStorageDirectory();
            File RutaArchivo = new File(TarjetaSD.getPath(),Nombre);
            InputStreamReader AbrirArchivo = new InputStreamReader(openFileInput(Nombre));

            BufferedReader LeerArchivo = new BufferedReader(AbrirArchivo);
            String Linea = LeerArchivo.readLine();
            String ContenidoCompleto = "";

            while (Linea != null){
                ContenidoCompleto = ContenidoCompleto + Linea + "\n";
                Linea = LeerArchivo.readLine();
            }
            LeerArchivo.close();
            AbrirArchivo.close();
            EtContenido.setText(ContenidoCompleto);
        }catch (IOException e){
            Toast.makeText(this,"Error al leer el archivo",Toast.LENGTH_SHORT).show();
        }
    }
}