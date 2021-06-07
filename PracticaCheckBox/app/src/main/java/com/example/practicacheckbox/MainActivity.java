package com.example.practicacheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Num1,Num2;
    private CheckBox Cb1,Cb2;
    private TextView Tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Num1 = (EditText) findViewById(R.id.txt_Num1);
        Num2 = (EditText) findViewById(R.id.txt_Num2);
        Cb1 = (CheckBox) findViewById(R.id.check_Suma);
        Cb2 = (CheckBox) findViewById(R.id.check_Resta);
        Tv = (TextView) findViewById(R.id.txt_Resultado);
    }

    //Este metodo es la función del botón
    public void Calculos(View view){

        String Num1_String = Num1.getText().toString();
        String Num2_String = Num2.getText().toString();

        int Num1_Int = Integer.parseInt(Num1_String);
        int Num2_Int = Integer.parseInt(Num2_String);

        String Resultado = "";

        if (Cb1.isChecked() == true){
            int Suma = Num1_Int + Num2_Int;
            Resultado = Resultado  + "El resultado de la suma es: " + Suma;

        }
        Tv.setText(Resultado);

        if (Cb2.isChecked() == true){
            int Resta = Num1_Int - Num2_Int;
            Resultado = Resultado  + "El resultado de la resta es: " + Resta;

        }
        Tv.setText(Resultado);
        }
    }
