package com.example.bbdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Et_Codigo,Et_Descripcion,Et_Precio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Et_Codigo = (EditText)findViewById(R.id.txt_Codigo);
        Et_Descripcion = (EditText)findViewById(R.id.txt_Descripcion);
        Et_Precio = (EditText)findViewById(R.id.txt_Precio);
    }

    //Metodo para dar de alta los productos
    public void Registrar(View view){
        AdminSQL Admin = new AdminSQL(this,"Administracion",null,1);
        SQLiteDatabase BaseDeDatos = Admin.getWritableDatabase();

        String Codigo = Et_Codigo.getText().toString();
        String Descripcion = Et_Descripcion.getText().toString();
        String Precio = Et_Precio.getText().toString();

        if(!Codigo.isEmpty() && !Descripcion.isEmpty() && !Precio.isEmpty()){
            ContentValues Registro = new ContentValues();
            Registro.put("Codigo", Codigo);
            Registro.put("Descripcion",Descripcion);
            Registro.put("Precio",Precio);

            BaseDeDatos.insert("Articulos", null, Registro);
            BaseDeDatos.close();
            Et_Codigo.setText("");
            Et_Descripcion.setText("");
            Et_Precio.setText("");
            Toast.makeText(this,"Registro Exitoso.",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Debes de llenar todos los campos.",Toast.LENGTH_SHORT).show();
        }
    }
    
    //Metodo para consultar un articulo o producto
    public void Buscar(View view){
        AdminSQL Admin = new AdminSQL(this,"Administracion",null,1);
        SQLiteDatabase BaseDeDatos = Admin.getWritableDatabase();

        String Codigo = Et_Codigo.getText().toString();

        if (!Codigo.isEmpty()){
            Cursor Fila = BaseDeDatos.rawQuery
                    ("select Descripcion,Precio from articulos where Codigo =" + Codigo,null);
            if (Fila.moveToFirst()){
                Et_Descripcion.setText(Fila.getString(0));
                Et_Precio.setText(Fila.getString(1));
                BaseDeDatos.close();
            }else{
                Toast.makeText(this,"No existe el articulo.",Toast.LENGTH_SHORT).show();
                BaseDeDatos.close();
            }
        }else{
            Toast.makeText(this,"Debes introducir el codigo del productos.",Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para dar de baja un articulo o producto
    public void Eliminar(View view){
        AdminSQL Admin = new AdminSQL(this,"Administracion",null,1);
        SQLiteDatabase BaseDeDatos = Admin.getWritableDatabase();

        String Codigo = Et_Codigo.getText().toString();

        if (!Codigo.isEmpty()){
            int Cantidad = BaseDeDatos.delete("articulos","Codigo=" + Codigo,null);
            BaseDeDatos.close();

            Et_Codigo.setText("");
            Et_Descripcion.setText("");
            Et_Precio.setText("");

            if (Cantidad == 1){
                Toast.makeText(this,"Articulo eliminado exitosamente.",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"El articulo no existe.",Toast.LENGTH_SHORT).show();
            }


        }else{
            Toast.makeText(this,"Debes de introducir el codigo del articulo.",Toast.LENGTH_SHORT).show();
        }

    }

    //Metodo para modificar un articulo o producto
    public void Modificar(View view){
        AdminSQL Admin = new AdminSQL(this,"Administracion",null,1);
        SQLiteDatabase BaseDeDatos = Admin.getWritableDatabase();

        String Codigo = Et_Codigo.getText().toString();
        String Precio = Et_Precio.getText().toString();
        String Descripcion = Et_Descripcion.getText().toString();

        if (!Codigo.isEmpty() && !Descripcion.isEmpty() && !Precio.isEmpty()){
            ContentValues Registro = new ContentValues();
            Registro.put("codigo",Codigo);
            Registro.put("descripcion",Descripcion);
            Registro.put("precio",Precio);

            int Cantidad = BaseDeDatos.update("articulos",Registro,"Codigo=" + Codigo,null);
            BaseDeDatos.close();

            if (Cantidad == 1){
                Toast.makeText(this,"Articulo modificado correctamente.",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"El articulo no existe.",Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this,"Debes de llenar todos los campos",Toast.LENGTH_SHORT).show();
        }
    }
}