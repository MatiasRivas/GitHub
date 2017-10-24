package com.example.matiasezequiel.github;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.matiasezequiel.github.*;

public class Principal extends AppCompatActivity {
    private EditText nombre;
    private EditText apellido;
    private EditText telefono;
    private Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        nombre = (EditText)findViewById(R.id.etnombre);
        apellido = (EditText)findViewById(R.id.etapellido);
        telefono = (EditText)findViewById(R.id.ettelefono);

        guardar = (Button)findViewById(R.id.btguardar);

        guardar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ((githubApplication)getApplication()).insertarCliente(nombre.getText().toString(),
                        apellido.getText().toString(),
                        telefono.getText().toString());
                Intent i = new Intent(Principal.this, ListActivity.class);
                startActivity(i);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
