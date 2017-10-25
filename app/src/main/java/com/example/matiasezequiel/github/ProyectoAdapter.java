package com.example.matiasezequiel.github;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
/**
 * Created by Mauri on 24/10/2017.
 */

public class ProyectoAdapter {
    private static final String NAME="proyecto";
    private SQLiteDatabase sqlDB;

    public ProyectoAdapter(SQLiteDatabase sqlDB)
    {
        this.sqlDB=sqlDB;
    }

    private class Columns implements BaseColumns
    {
        public final static String ID = "proyecto_id";
        public final static String DESCRIPCION = "descripcion";
        public final static String COSTO = "costo";
        public final static String CLIENTE_ID = "cliente_id";
    }

    public final static String [] COLUMNS = {
                    Columns.ID,Columns.DESCRIPCION,Columns.COSTO,Columns.CLIENTE_ID };


    public final static String CR_TABLE = "createtableifnotexists "
            + NAME + "(" + Columns.ID
            + " integerprimarykeyautoincrement, "
            + Columns.DESCRIPCION+ " textnotnull, "
            + Columns.COSTO+ " real, "
            + Columns.CLIENTE_ID+ " integer, FOREIGN KEY(cliente_id) REFERENCES cliente(cliente_id))";

    public boolean insert(String descripcion, double costo, int cliente_id) {
        //Relacionamos campos con valores en el objeto ContentValues.
        ContentValues values = new ContentValues();
        values.put(Columns.DESCRIPCION, descripcion);
        values.put(Columns.COSTO, costo);
        values.put(Columns.CLIENTE_ID, cliente_id);

        return sqlDB.insert(NAME, null, values) > 0;
    }

    //Devuelve el cursor con todos los nombres de proyectos registrados en la taba

    //@return Cursor

    public Cursor getDescripciones()
    {
        String [] columns = {Columns.DESCRIPCION};
        return sqlDB.query(NAME, columns, null, null, null, null, null);
    }





    //Devuelve el nombre de la tabla
    //@return NAME
    public String getName() {
        return NAME;
    }



    //devuelve el array con los nombres de todos los campos en la tabla
    //@return COLUMNS
    public String[] getColumns(){
        return COLUMNS;
    }


    //Comprueba si la tabla contiene datos
    //@return true si contiene datos
    public boolean isEmpty(){
        return sqlDB.query(NAME,COLUMNS,null, null, null, null, null).getCount() == 0;
    }




    /*devuelve todos los datos que contiene la tabla
    *
    * @return Cursor
    */

    public Cursor getDatos(){
        return sqlDB.query(NAME,COLUMNS, null, null, null, null, null);
    }

    //probando commit

}
