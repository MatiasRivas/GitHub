package com.example.matiasezequiel.github;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by villa on 24/10/2017.
 */

public class ClienteAdapter {

    private static final String NAME = "cliente";
    private SQLiteDatabase sqlDB;

    public ClienteAdapter(SQLiteDatabase sqlDB){
        this.sqlDB = sqlDB;
    }


    private class Columns implements BaseColumns{
        public final static String ID = "cliente_id";
        public final static String NOMBRE = "cliente_id";
        public final static String APELLIDO = "cliente_id";
        public final static String TELEFONO = "cliente_id";
    }

    private final static String[] COLUMNS = {
            Columns.ID, Columns.NOMBRE, Columns.APELLIDO, Columns.TELEFONO
    };

    public final static String CR_TABLE = "createtableifnotexists" + NAME + "(" + Columns.ID + "integerprimarykeyautoincrement, " + Columns.NOMBRE + "textnotnull, " + Columns.APELLIDO+ "textnotnull, " + Columns.TELEFONO + "text) ";

    public boolean insert(String nombre, String apellido, String telefono){
        ContentValues values = new ContentValues();
        values.put(Columns.NOMBRE, nombre);
        values.put(Columns.APELLIDO, nombre);
        values.put(Columns.TELEFONO, nombre);

        return sqlDB.insert(NAME, null, values) > 0;
    }

    public boolean delete(int id){
        String whereClauese = "cliente_id?";
        String[] whereArgs = {String.valueOf(id)};
        return sqlDB.delete(NAME, whereClauese, whereArgs) > 0;
    }


    public Cursor getNombres(){
        String[] columns = {Columns.NOMBRE};

        return sqlDB.query(NAME, columns, null, null, null, null, null);
    }


    public String getName(){
        return NAME;
    }


    public String[] getColumns(){
        return COLUMNS;
    }

    public boolean isEmpty(){
        return sqlDB.query(NAME, COLUMNS, null, null, null, null, null).getCount() == 0;
    }


    public Cursor getDatos(){
        return sqlDB.query(NAME, COLUMNS, null, null, null, null, null);
    }
}
