package com.example.aplicacionesmultilenguaje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText User,Pass;
    private Button Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User = (EditText)findViewById(R.id.txt_User);
        Pass = (EditText) findViewById(R.id.txt_Pass);
    }

    //Log in
    public void Loggeo(View view){

        String Usuario = User.getText().toString();
        String Password = Pass.getText().toString();

        if(!Usuario.equals("") && !Password.equals("")){
            if(!Usuario.equals("Agusdom")){
                Toast.makeText(this,"El User es incorrecto.",Toast.LENGTH_SHORT).show();
            }else if( !Password.equals("123456")){
                Toast.makeText(this,"El Pass es incorrecto.",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Log in correcto.",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Debes de llenar todos los campos.",Toast.LENGTH_SHORT).show();
        }
    }
}