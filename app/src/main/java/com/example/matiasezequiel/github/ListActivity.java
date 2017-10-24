package com.example.matiasezequiel.github;

import android.app.LauncherActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.matiasezequiel.github.*;
/**
 * Created by Usuario on 20/10/2017.
 */

public class ListActivity extends ActionBarActivity{
    private TextView lista;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lista = (TextView)findViewById(R.id.tvlista);
        for (String it:((githubApplication)getApplication()).nombreClientes()){
            lista.setText(lista.getText()+it);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_list,menu);
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
