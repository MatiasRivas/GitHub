package com.example.matiasezequiel.github;

/**
 * Created by MatiasEzequiel on 24/10/2017.
 */
import android.app.Application;
import android.database.Cursor;

import com.example.matiasezequiel.github.databases.modelo.Cliente;
import com.example.matiasezequiel.github.utils.DBAdapter;

import java.util.ArrayList;

public class githubApplication extends Application{

    DBAdapterdbAdapter;

    public void onCreate(){
        dbAdapter = new DBAdapter(getApplicationContext());
        dbAdapter.open();

        super.onCreate();
    }

    public void onTerminate(){
        dbAdapter.close();
        super.onTerminate();
    }

    public void rellenarDatosTabla1(){
        if(dbAdapter.cliente1IsEmpty()){
            for (int i = 0; i < 30; i++){
                String nombre = "nombre" + String.valueOf(i);
                String apellido = "apellido" + String.valueOf(i);
                String numero = "555-" + String.valueOf(i);
                dbAdapter.clienteInsert(nombre, apellido, numero);
            }
        }
    }

    public boolean insertarCliente(String nombre, String apellido, String telefono){
        return dbAdapter.clienteInsert(nombre, apellido, telefono);
    }

    public ArrayList<String>nombreClientes(){
        ArrayList<String> lista = new ArrayList<>();
        Cursor c = dbAdapter.getDatosCliente();
        if(c.moveToFirst()){
            do{
                lista.add(c.getString(1));
            }while(c.moveToNext());
        }
        return lista;
    }
}
