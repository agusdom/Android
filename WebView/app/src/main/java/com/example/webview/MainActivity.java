package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText Et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Et1 = (EditText) findViewById(R.id.txt_Web);
    }

    //Metodo Boton ir
    public void Navegar(View view){
        Intent i = new Intent(this,ActivityWeb.class);
        i.putExtra("sitioWeb", Et1.getText().toString());
        startActivity(i);
    }
}