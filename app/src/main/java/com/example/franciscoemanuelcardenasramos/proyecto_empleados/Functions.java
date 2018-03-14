package com.example.franciscoemanuelcardenasramos.proyecto_empleados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by lenovo on 07/03/2018.
 */

public class Functions extends SQLiteOpenHelper {

    private static final String DB_NAME = "crud.db";
    private static final int DB_VERSION = 1;

    private Persona persona = new Persona();

    public Functions(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //execute table persona
        sqLiteDatabase.execSQL(persona.CREATE_TABLE_PERSON);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + persona.TABLE_PERSON);
    }

    /**
     * Insertar nuevos registros
     */
    public void Insert(Item item){

        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(persona.LASTNAME,item.getLastname());
        contentValues.put(persona.FIRSTNAME,item.getFirstname());
        contentValues.put(persona.MIDDLENAME,item.getMiddlename());
        contentValues.put(persona.CONTACT,item.getContact());

        database.insert(persona.TABLE_PERSON,null,contentValues);
    }

    /**
     * Retorna un ArrayList con elementos de tipo item
     * Convierte el Cursor en un ArrayList
     */
    public ArrayList<Item> getAllRecords(){

        ArrayList<Item>list = new ArrayList<Item>();
        SQLiteDatabase database = getReadableDatabase();

        String sql = "SELECT * FROM " + persona.TABLE_PERSON;

        Cursor cursor = database.rawQuery(sql,null);

        if (cursor.moveToFirst()){
            do {
                Item item = new Item();
                item.setId(Integer.parseInt(cursor.getString(0)));
                item.setLastname(cursor.getString(1));
                item.setFirstname(cursor.getString(2));
                item.setMiddlename(cursor.getString(3));
                item.setContact(cursor.getString(4));

                list.add(item);

            }while (cursor.moveToNext());
        }

        cursor.close();
        database.close();
        return list;
    }

    /**
     * Obtiene un registro en específico
     */
    public Item getSingleItem(int id){

        SQLiteDatabase database = getReadableDatabase();

        String sql = "SELECT * FROM " + persona.TABLE_PERSON + " WHERE " + persona.ID + "=?";
        Cursor cursor = database.rawQuery(sql,new String[]{String.valueOf(id)});

        if (cursor != null)
            cursor.moveToNext();

        Item item = new Item();
        item.setId(Integer.parseInt(cursor.getString(0)));
        item.setLastname(cursor.getString(1));
        item.setFirstname(cursor.getString(2));
        item.setMiddlename(cursor.getString(3));
        item.setContact(cursor.getString(4));

        cursor.close();
        database.close();
        return item;
    }

    /**
     * Borra un elemento de la tabla
     */
    public void DeleteItem(int id){

        SQLiteDatabase database = getWritableDatabase();
        database.delete(persona.TABLE_PERSON, persona.ID + "=?",new String[]{String.valueOf(id)});
        database.close();
    }

    /**
     *Actualiza un registro
     */
    public void Update(Item item){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(persona.LASTNAME,item.getLastname());
        contentValues.put(persona.FIRSTNAME,item.getFirstname());
        contentValues.put(persona.MIDDLENAME,item.getMiddlename());
        contentValues.put(persona.CONTACT,item.getContact());
        database.update(persona.TABLE_PERSON,contentValues, persona.ID + "=?",new String[]{String.valueOf(item.getId())});

    }

    /**
     * Responde a la opción del menu de borrar todo
     */
    public void DeleteAll(){
        SQLiteDatabase database = getWritableDatabase();
        database.delete(persona.TABLE_PERSON,null,null);
        database.close();
    }

}
