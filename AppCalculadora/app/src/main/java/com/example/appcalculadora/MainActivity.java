package com.example.appcalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Num1,Num2;
    private RadioButton Rb1,Rb2,Rb3,Rb4;
    private Button Boton;
    private TextView Tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Num1 = (EditText) findViewById(R.id.txt_Num1);
        Num2 = (EditText) findViewById(R.id.txt_Num2);
        Rb1 = (RadioButton) findViewById(R.id.rb1);
        Rb2 = (RadioButton) findViewById(R.id.rb2);
        Rb3 = (RadioButton) findViewById(R.id.rb3);
        Rb4 = (RadioButton) findViewById(R.id.rb4);
        Tv = (TextView) findViewById(R.id.tv_Resultado);
    }

    //Calculos
    public void Calculos(View view){
        String Num1_String = Num1.getText().toString();
        String Num2_String = Num2.getText().toString();

        int Num1_Int = Integer.parseInt(Num1_String);
        int Num2_Int = Integer.parseInt(Num2_String);

        if(Rb1.isChecked() == true){
            int Suma = Num1_Int + Num2_Int;
            String Resultado = String.valueOf(Suma);
            Tv.setText(Resultado);
        }else if(Rb2.isChecked() == true){
            int Resta = Num1_Int - Num2_Int;
            String Resultado = String.valueOf(Resta);
            Tv.setText(Resultado);
        }else if(Rb3.isChecked() == true){
            int Multiplicacion = Num1_Int * Num2_Int;
            String Resultado = String.valueOf(Multiplicacion);
            Tv.setText(Resultado);
        }else if(Rb4.isChecked() == true){
            if(Num2_Int != 0){
                int Division = Num1_Int / Num2_Int;
                String Resultado = String.valueOf(Division);
                Tv.setText(Resultado);
            }else{
                Toast.makeText(this,"No se puede dividir por 0", Toast.LENGTH_LONG).show();
            }

        }
    }
}