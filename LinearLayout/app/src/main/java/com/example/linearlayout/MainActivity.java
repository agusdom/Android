package com.example.linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Ee,Ep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ee = (EditText) findViewById(R.id.txt_Email);
        Ep = (EditText) findViewById(R.id.txt_Pass);
    }

    //Metodo Login
    public void Login(View view){
        String Mail = Ee.getText().toString();
        String Password = Ep.getText().toString();

        if(!Mail.isEmpty() && !Password.isEmpty()){
            if (Mail.equals("agustindominguez95@hotmail.com") && Password.equals("123456")){
                Toast.makeText(this,"Login Correcto.",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"El Mail o el Pass es incorrecto.",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Debes de llenar todos los campos.",Toast.LENGTH_SHORT).show();
        }
    }

}