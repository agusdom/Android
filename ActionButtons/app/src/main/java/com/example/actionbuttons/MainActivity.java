package com.example.actionbuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Metodo para mostrar los botones de accion.
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menuacciones, menu);
        return true;
    }

    //Metodo para agregar las acciones de los botones.
    public boolean onOptionsItemSelected(MenuItem Item){
        int Id = Item.getItemId();

        if(Id == R.id.Compartir){
            Toast.makeText(this,"Compartir",Toast.LENGTH_SHORT).show();
            return true;
        }else if(Id == R.id.Buscar){
            Toast.makeText(this,"Buscar",Toast.LENGTH_SHORT).show();
            return true;
        }else if(Id == R.id.Opcion1){
            Toast.makeText(this,"Opcion 1",Toast.LENGTH_SHORT).show();
            return true;
        }else if(Id == R.id.Opcion2){
            Toast.makeText(this,"Opcion 2",Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(Item);
    }
}