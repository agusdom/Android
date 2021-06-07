package com.example.miprimerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private EditText Txt_Num1,Txt_Num2;
    private TextView Txt_Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Txt_Num1 = (EditText) findViewById(R.id.txt_Num1);
        Txt_Num2 = (EditText) findViewById(R.id.txt_Num2);
        Txt_Resultado = (TextView) findViewById(R.id.txt_Resultado);
    }

    //Este metodo realiza la suma
    public void Sumar(View view){
        String Valor1 = Txt_Num1.getText().toString();
        String Valor2 = Txt_Num2.getText().toString();

        int Num1 = Integer.parseInt(Valor1);
        int Num2 = Integer.parseInt(Valor2);

        int Suma = Num1 + Num2;

        String Resultado = String.valueOf(Suma);

        Txt_Resultado.setText(Resultado);
    }
}