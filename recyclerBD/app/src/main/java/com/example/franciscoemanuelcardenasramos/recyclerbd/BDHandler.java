package com.example.franciscoemanuelcardenasramos.recyclerbd;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by franciscoemanuelcardenasramos on 28/02/18.
 */

public class BDHandler extends SQLiteOpenHelper {

    private static final String database = "Database2.db";
    private SQLiteDatabase db;
    private final Context context;


    public BDHandler(Context context) {
        super(context, database, null, 1);
        db = getWritableDatabase();
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Trabajos (idTrabajos INT PRIMARY KEY,Nombre VARCHAR(50),Apellido VARCHAR(50) ,Salario FLOAT )");
        sqLiteDatabase.execSQL("INSERT INTO Trabajos VALUES (29,'Francisco Emanuel','Cardenas Ramos',230)");
        sqLiteDatabase.execSQL("INSERT INTO Trabajos VALUES (30,'Dylan Salvador','Parra Dominguez',500)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Trabajos");
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Item> consulta() {
        ArrayList<Item> lista = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM Trabajos", null);
        while (c.moveToNext()) {
            lista.add(new Item(c.getString(0), c.getString(1), c.getString(2) ,c.getString(3) ));
        }
        c.close();
        return lista;
    }
}

