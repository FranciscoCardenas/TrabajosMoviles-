package com.ejemplo.appcrud005;

/**
 * Created by lenovo on 07/03/2018.
 */

public class Persona {

    /**
     * Define el nombre de la tabla
     */
    public static final String TABLE_CLIENT = "client";


    /**
     * Define los campos de la tabla
     */
    public static final String ID = "id";
    public static final String NOMBRE = "nombre";
    public static final String DIRECCION = "direccion";
    public static final String CEL = "cel";
    public static final String MAIL = "mail";
    public static final String DESCRIPCION = "descripcion";
    public static final String MONTO = "monto";
    public static final String FINALIZADO = "fin";


    /**
     * Define la cadena SQL para la creación de la tabla
     * ->agregar aquí la otra tabla, Para la version 006
     *
     */
    public static final String CREATE_TABLE_CLIENT= "CREATE TABLE " + TABLE_CLIENT + "("
            + ID + " INTEGER PRIMARY KEY,"
            + NOMBRE + " TEXT,"
            + DIRECCION+ " TEXT,"
            + CEL + " TEXT,"
            + MAIL + " TEXT,"
            + DESCRIPCION + " TEXT,"
            + MONTO + " TEXT,"
            + FINALIZADO + " TEXT"

            + ")";
}
