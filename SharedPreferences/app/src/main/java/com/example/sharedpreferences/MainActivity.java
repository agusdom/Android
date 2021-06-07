package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText Et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Et1 = (EditText) findViewById(R.id.txt_Email);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        Et1.setText(preferences.getString("Email", ""));
    }

    //Metodo para el boton guardar
    public void Guardar(View view){
        SharedPreferences preferences = getSharedPreferences("datos",Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = preferences.edit();
        Obj_editor.putString("Email", Et1.getText().toString());
        Obj_editor.commit();
        finish();

    }
}