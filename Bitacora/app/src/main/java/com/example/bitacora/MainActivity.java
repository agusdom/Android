package com.example.bitacora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText Et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Et1 = (EditText)findViewById(R.id.txt_Bitacora);

        String Archivos[] = fileList();

        if (ArchivoExiste(Archivos, "Bitacora.txt")){
            try{
                InputStreamReader Archivo = new InputStreamReader(openFileInput("Bitacora.txt"));
                BufferedReader Br = new BufferedReader(Archivo);
                String Linea = Br.readLine();
                String BitacoraCompleta = "";

                while (Linea != null){
                    BitacoraCompleta = BitacoraCompleta + Linea + "\n";
                    Linea = Br.readLine();
                }
                Br.close();
                Archivo.close();
                Et1.setText(BitacoraCompleta);
            }catch (IOException e){

            }

        }
    }

    private Boolean ArchivoExiste(String Archivos[],String NombreArchivo){
        for (int i = 0; i<Archivos.length; i++)
            if (NombreArchivo.equals(Archivos[i]))
                return true;
        return false;
    }

    //Metodo para boton Guardar
    public void Guardar(View view){
        try{
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("Bitacora.txt", Activity.MODE_PRIVATE));
            archivo.write(Et1.getText().toString());
            archivo.flush();
            archivo.close();
        }catch (IOException e){
        }
        Toast.makeText(this,"Bitacora guardada correctamente",Toast.LENGTH_SHORT).show();
        finish();

    }
}