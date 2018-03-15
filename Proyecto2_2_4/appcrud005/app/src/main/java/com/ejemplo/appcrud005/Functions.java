package com.ejemplo.appcrud005;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by lenovo on 07/03/2018.
 */

public class Functions extends SQLiteOpenHelper {

    private static final String DB_NAME = "crud11.db";
    private static final int DB_VERSION = 1;

    private Persona cliente = new Persona();
    private Empleados empleado = new Empleados();
    private  Tabla tabla = new Tabla();

    public Functions(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //execute table persona
        sqLiteDatabase.execSQL(cliente.CREATE_TABLE_CLIENT);
        sqLiteDatabase.execSQL(empleado.CREATE_TABLE_EMPLEADO);
        sqLiteDatabase.execSQL(tabla.CREATE_TABLE_TABLA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + cliente.TABLE_CLIENT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + empleado.TABLE_EMPLEADO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + tabla.TABLE_TABLA);
    }

    /**
     * Insertar nuevos registros
     */
    public void Insert(Item item){

        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(cliente.NOMBRE,item.getNombre());
        contentValues.put(cliente.DIRECCION,item.getDireccion());
        contentValues.put(cliente.CEL,item.getCel());
        contentValues.put(cliente.MAIL,item.getMail());
        contentValues.put(cliente.DESCRIPCION,item.getDescripcion());
        contentValues.put(cliente.MONTO,item.getMonto());
        contentValues.put(cliente.FINALIZADO,item.getFin());

        database.insert(cliente.TABLE_CLIENT,null,contentValues);
    }

    public void Insert2(Item_Empleados item){

        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(empleado.NOMBREEM,item.getNombreem());
        contentValues.put(empleado.ACTIVIDAD,item.getActividad());
        contentValues.put(empleado.FECHAINICIO,item.getFechainicio());
        contentValues.put(empleado.FECHAFINAL,item.getFechafinal());
        contentValues.put(empleado.CELU,item.getCelu());
        contentValues.put(empleado.CANTIDAD,item.getCantidad());
        contentValues.put(empleado.PAGO,item.getPago());

        database.insert(empleado.TABLE_EMPLEADO,null,contentValues);
    }


    //insert alac
    public void InsertALAC(Item_Tabla item){

        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(tabla.ID,item.getId());
        contentValues.put(tabla.NOMBREEM,item.getNombreem());
        contentValues.put(tabla.NOMBRECL,item.getNombrecl());



        database.insert(tabla.TABLE_TABLA,null,contentValues);
    }






    /**
     * Retorna un ArrayList con elementos de tipo item
     * Convierte el Cursor en un ArrayList
     */
    public ArrayList<Item> getAllRecords(){

        ArrayList<Item>list = new ArrayList<Item>();
        SQLiteDatabase database = getReadableDatabase();

        String sql = "SELECT * FROM " + cliente.TABLE_CLIENT + " ORDER BY nombre ASC" ;

        Cursor cursor = database.rawQuery(sql,null);

        if (cursor.moveToFirst()){
            do {
                Item item = new Item();
                item.setId(Integer.parseInt(cursor.getString(0)));
                item.setNombre(cursor.getString(1));
                item.setDireccion(cursor.getString(2));
                item.setCel(cursor.getString(3));
                item.setMail(cursor.getString(4));
                item.setDescripcion(cursor.getString(5));
                item.setMonto(cursor.getString(6));
                item.setFin(cursor.getString(7));

                list.add(item);

            }while (cursor.moveToNext());
        }

        cursor.close();
        database.close();
        return list;
    }



    public ArrayList<Item_Empleados> getAllRecords2(){

        ArrayList<Item_Empleados>list = new ArrayList<Item_Empleados>();
        SQLiteDatabase database = getReadableDatabase();

        String sql = "SELECT * FROM " + empleado.TABLE_EMPLEADO  + " ORDER BY nombreem ASC";

        Cursor cursor = database.rawQuery(sql,null);

        if (cursor.moveToFirst()){
            do {
                Item_Empleados item = new Item_Empleados();
                item.setId(Integer.parseInt(cursor.getString(0)));
                item.setNombreem(cursor.getString(1));
                item.setActividad(cursor.getString(2));
                item.setFechainicio(cursor.getString(3));
                item.setFechafinal(cursor.getString(4));
                item.setCelu(cursor.getString(5));
                item.setCantidad(cursor.getString(6));
                item.setPago(cursor.getString(7));

                list.add(item);

            }while (cursor.moveToNext());
        }

        cursor.close();
        database.close();
        return list;
    }




    public ArrayList<Item_Tabla> getAllRecords3(int idc){

        ArrayList<Item_Tabla>list = new ArrayList<Item_Tabla>();
        SQLiteDatabase database = getReadableDatabase();

        String sql = "SELECT * FROM " + tabla.TABLE_TABLA  + " WHERE "+ cliente.ID + "=?";
        Cursor cursor = database.rawQuery(sql,new String[]{String.valueOf(idc)});


        if (cursor.moveToFirst()){
            do {
                Item_Tabla item = new Item_Tabla();
                item.setId(Integer.parseInt(cursor.getString(0)));
                item.setNombreem(cursor.getString(1));
                item.setNombrecl(cursor.getString(2));



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

        String sql = "SELECT * FROM " + cliente.TABLE_CLIENT+ " WHERE " + cliente.ID + "=?" ;
        Cursor cursor = database.rawQuery(sql,new String[]{String.valueOf(id)});

        if (cursor != null)
            cursor.moveToNext();

        Item item = new Item();
        item.setId(Integer.parseInt(cursor.getString(0)));
        item.setNombre(cursor.getString(1));
        item.setDireccion(cursor.getString(2));
        item.setCel(cursor.getString(3));
        item.setMail(cursor.getString(4));
        item.setDescripcion(cursor.getString(5));
        item.setMonto(cursor.getString(6));
        item.setFin(cursor.getString(7));

        cursor.close();
        database.close();
        return item;
    }


    public Item_Empleados getSingleItem2(int id){

        SQLiteDatabase database = getReadableDatabase();

        String sql = "SELECT * FROM " + empleado.TABLE_EMPLEADO+ " WHERE " +empleado.ID + "=?" ;
        Cursor cursor = database.rawQuery(sql,new String[]{String.valueOf(id)});

        if (cursor != null)
            cursor.moveToNext();

        Item_Empleados item = new Item_Empleados();
        item.setId(Integer.parseInt(cursor.getString(0)));
        item.setNombreem(cursor.getString(1));
        item.setActividad(cursor.getString(2));
        item.setFechainicio(cursor.getString(3));
        item.setFechafinal(cursor.getString(4));
        item.setCelu(cursor.getString(5));
        item.setCantidad(cursor.getString(6));
        item.setPago(cursor.getString(7));

        cursor.close();
        database.close();
        return item;
    }


    public ArrayAdapter<Spinner> llenarSpinner(Context cont) {

        ArrayList<Item_Empleados> list = new ArrayList<>();
        ArrayList<Spinner> list2 = new ArrayList<>();

        SQLiteDatabase database = getReadableDatabase();

        String sql = "SELECT * FROM " + empleado.TABLE_EMPLEADO + " ORDER BY nombreem ASC";

        Cursor cursor = database.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                Item_Empleados item = new Item_Empleados();
                Spinner item2 = new Spinner();
                item.setId(Integer.parseInt(cursor.getString(0)));
                item.setNombreem(cursor.getString(1));
                list.add(item);

                item2.setId(Integer.parseInt(cursor.getString(0)));
                item2.setNombre(cursor.getString(1));
                list2.add(item2);

            } while (cursor.moveToNext());
        }

            ArrayAdapter<Spinner> adapter =
                    new ArrayAdapter<Spinner>(cont, R.layout.spinner_layaout_ejemplo,list2);
            adapter.setDropDownViewResource(R.layout.spinner_layaout_ejemplo);

            cursor.close();
            database.close();

            return adapter;
        }



    /**
     * Borra un elemento de la tabla
     */
    public void DeleteItem(int id){

        SQLiteDatabase database = getWritableDatabase();
        database.delete(cliente.TABLE_CLIENT, cliente.ID + "=?",new String[]{String.valueOf(id)});
        database.close();
    }
    public void DeleteItem2(int id){

        SQLiteDatabase database = getWritableDatabase();
        database.delete(empleado.TABLE_EMPLEADO, cliente.ID + "=?",new String[]{String.valueOf(id)});
        database.close();
    }

    /**
     *Actualiza un registro
     */
    public void Update(Item item){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(cliente.NOMBRE,item.getNombre());
        contentValues.put(cliente.DIRECCION,item.getDireccion());
        contentValues.put(cliente.CEL,item.getCel());
        contentValues.put(cliente.MAIL,item.getMail());
        contentValues.put(cliente.DESCRIPCION,item.getDescripcion());
        contentValues.put(cliente.MONTO,item.getMonto());
        contentValues.put(cliente.FINALIZADO,item.getFin());


        database.update(cliente.TABLE_CLIENT,contentValues, cliente.ID + "=?",new String[]{String.valueOf(item.getId())});

    }


    public void Update2(Item_Empleados item){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(empleado.NOMBREEM,item.getNombreem());
        contentValues.put(empleado.ACTIVIDAD,item.getActividad());
        contentValues.put(empleado.FECHAINICIO,item.getFechainicio());
        contentValues.put(empleado.FECHAFINAL,item.getFechafinal());
        contentValues.put(empleado.CELU,item.getCelu());
        contentValues.put(empleado.CANTIDAD,item.getCantidad());
        contentValues.put(empleado.PAGO,item.getPago());


        database.update(empleado.TABLE_EMPLEADO,contentValues, empleado.ID + "=?",new String[]{String.valueOf(item.getId())});

    }


    /**as
     * Responde a la opción del menu de borrar todo
     */
    public void DeleteAll(){
        SQLiteDatabase database = getWritableDatabase();
        database.delete(cliente.TABLE_CLIENT,null,null);
        database.close();
    }

    public void DeleteAll2(){
        SQLiteDatabase database = getWritableDatabase();
        database.delete(empleado.TABLE_EMPLEADO,null,null);
        database.close();
    }


}
