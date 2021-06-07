package com.example.appradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Num1,Num2;
    private RadioButton rb_Sumar,rb_Restar;
    private Button boton1;
    private TextView Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Num1 = (EditText)findViewById(R.id.txt_Num1);
        Num2 = (EditText)findViewById(R.id.txt_Num2);
        rb_Sumar = (RadioButton) findViewById(R.id.rb_Suma);
        rb_Restar = (RadioButton)findViewById(R.id.rb_Resta);
        Resultado = (TextView)findViewById(R.id.txt_Resultado);

    }

    //Funcion para los calculos
    public void Calcular(View view){
       String String_Num1 = Num1.getText().toString();
       String String_Num2 = Num2.getText().toString();

       int Valor1_int = Integer.parseInt(String_Num1);
       int Valor2_int = Integer.parseInt(String_Num2);

       if(rb_Sumar.isChecked() == true){
           int Suma = Valor1_int + Valor2_int;
           String Resultado_Suma = String.valueOf(Suma);
           Resultado.setText(Resultado_Suma);
       }else if(rb_Restar.isChecked() == true){
           int Resta = Valor1_int - Valor2_int;
           String Resultado_Resta = String.valueOf(Resta);
           Resultado.setText(Resultado_Resta);
       }
    }
}