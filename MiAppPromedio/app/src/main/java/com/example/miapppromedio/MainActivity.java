package com.example.miapppromedio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Notation;

public class MainActivity extends AppCompatActivity {

    private EditText Nota1,Nota2,Nota3;
    private TextView Promedio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nota1 = (EditText) findViewById(R.id.Txt_Matematicas);
        Nota2 = (EditText) findViewById(R.id.Txt_Fisica);
        Nota3 = (EditText) findViewById(R.id.Txt_Quimica);
        Promedio = (TextView) findViewById(R.id.txt_Promedio);
    }

    //Funcion saca Promedio
    public void SacarPromedio(View view){
        String String_Matematica = Nota1.getText().toString();
        String String_Fisica = Nota2.getText().toString();
        String String_Quimica = Nota3.getText().toString();

        int Nota_Matematicas,Nota_Fisica,Nota_Quimica,Nota_Promedio;

        Nota_Matematicas = Integer.parseInt(String_Matematica);
        Nota_Fisica = Integer.parseInt(String_Fisica);
        Nota_Quimica = Integer.parseInt(String_Quimica);

        Nota_Promedio =  (Nota_Matematicas + Nota_Fisica + Nota_Quimica) / 3;

        if(Nota_Promedio>= 7){
            Promedio.setText("El alumno ha aprobado con promedio " + Nota_Promedio);
        }else{
            Promedio.setText("El alumno ha desaprobado con promedio " + Nota_Promedio);
        }
    }

}