package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Num1,Num2;
    private Spinner Spinner1;
    private TextView Tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Num1 = (EditText) findViewById(R.id.txt_Num1);
        Num2 = (EditText) findViewById(R.id.txt_Num2);
        Spinner1 = (Spinner) findViewById(R.id.spinner);
        Tv = (TextView) findViewById(R.id.txt_Resultado);

        String[] opciones = {"Sumar","Restar","Multiplicar","Dividir"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_agustin, opciones);
        Spinner1.setAdapter(adapter);
    }

    //Metodo del botón

    public void Calcular(View view){
        String Num1_Text = Num1.getText().toString();
        String Num2_Text = Num2.getText().toString();

        int Num1_Entero = Integer.parseInt(Num1_Text);
        int Num2_Entero = Integer.parseInt(Num2_Text);

        String Seleccion = Spinner1.getSelectedItem().toString();

        if (Seleccion.equals("Sumar")){
            int Suma = Num1_Entero + Num2_Entero;
            String Resultado = String.valueOf(Suma);
            Tv.setText(Resultado);
        }else if (Seleccion.equals("Restar")){
            int Resta = Num1_Entero - Num2_Entero;
            String Resultado = String.valueOf(Resta);
            Tv.setText(Resultado);
        }else if (Seleccion.equals("Multiplicar")){
            int Multiplicar = Num1_Entero * Num2_Entero;
            String Resultado = String.valueOf(Multiplicar);
            Tv.setText(Resultado);
        }else if (Seleccion.equals("Dividir")){
            if(Num2_Entero != 0){
                int Division = Num1_Entero / Num2_Entero;
                String Resultado = String.valueOf(Division);
                Tv.setText(Resultado);
            }else{
                Toast.makeText(this,"No se puede dividir por 0", Toast.LENGTH_LONG).show();
            }

        }
    }
}