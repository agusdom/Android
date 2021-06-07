package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView Tv1;
    private ListView Lv1;

    private String Nombres[] = {"Agustin","Matias","Pablo","Aaron","Marianella","Malena","Braian","Kevin","Leonel","Emiliano"};
    private String Edades[] = {"25","25","25","21","21","20","24","24","24","24"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tv1 = (TextView) findViewById(R.id.tv1);
        Lv1 = (ListView) findViewById(R.id.lv1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item_agustin,Nombres);
        Lv1.setAdapter(adapter);
        Lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tv1.setText("La edad de " + Lv1.getItemAtPosition(position) + " es " + Edades[position] + " años.");
            }
        });
    }
}