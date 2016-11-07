package com.example.kota.appmovil_trabajo2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Kota on 24-10-2016.
 */
public class DbManager{
    public static final String TABLA = "tblPersona";
    public static final String COL_ID = "id";
    public static final String COL_NOMBRE = "nombre";
    public static final String COL_APEPAT = "apepat";
    public static final String COL_APEMAT = "apemat";
    public static final String COL_FONO = "fono";
    public static final String COL_MAIL = "mail";

    public static final String CREATE_TABLE = "CREATE TABLE "
            +TABLA+" "+"(" +COL_ID+ " integer primary key autoincrement, "
            + COL_NOMBRE+ " Text NOT NULL,"
            + COL_APEPAT+ " Text NOT NULL,"
            + COL_APEMAT+ " Text NOT NULL,"
            + COL_FONO+ " Integer NOT NULL,"
            + COL_MAIL+ " Text);" ;

    private  DbHelper helper;
    private SQLiteDatabase db;

    public DbManager(Context context){
        helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }

    public void inserta(String nombre, String apepat, String apemat, Integer fono, String mail){
        ContentValues valores = new ContentValues();
        valores.put(COL_NOMBRE, nombre);
        valores.put(COL_APEPAT, apepat);
        valores.put(COL_APEMAT, apemat);
        valores.put(COL_FONO, fono);
        valores.put(COL_MAIL, mail);

        db.insert(TABLA, null, valores);
    }

    public  void eliminar (String codNombre){
    //PENDIENTE ASIGNACION DE VALUE
        db.delete(TABLA, COL_ID + "=?", new String[]{codNombre});
    }


    public  void actualizar(String codNombre, String nuevoFono, String nuevoMail){
        ContentValues valores = new ContentValues();
        valores.put(COL_ID, codNombre);
        valores.put(COL_FONO, nuevoFono);
        valores.put(COL_MAIL, nuevoMail);

        db.update(TABLA, valores, COL_ID + "=?", new String[]{codNombre});
    }

    public void listar(){
        db.execSQL("select * from " + TABLA);
    }

}
