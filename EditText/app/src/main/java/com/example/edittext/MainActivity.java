package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

private EditText Etn,Etp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Etn = (EditText) findViewById(R.id.txt_User);
        Etp = (EditText) findViewById(R.id.txt_Pass);
    }

    //Metodo para el boton
    public void Registrar(View view){
        String Nombre = Etn.getText().toString();
        String Password = Etp.getText().toString();

        if(Nombre.equals("")){
            Toast.makeText(this,"Debes de escribir un nombre.",Toast.LENGTH_LONG).show();
        }
        if(Password.equals("")){
            Toast.makeText(this,"Debes de escribir un password.",Toast.LENGTH_LONG).show();
        }
        if (!Nombre.equals("") && !Password.equals(""))
        {
            Toast.makeText(this,"Registro en proceso........",Toast.LENGTH_LONG).show();
        }
    }
}