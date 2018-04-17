package com.example.franciscoemanuelcardenasramos.proyecto_empleados;

/**
 * Created by lenovo on 07/03/2018.
 */

public class Persona {

    /**
     * Define el nombre de la tabla
     */
    public static final String TABLE_PERSON = "person";


    /**
     * Define los campos de la tabla
     */
    public static final String ID = "id";
    public static final String LASTNAME = "lastname";
    public static final String FIRSTNAME = "firstname";
    public static final String MIDDLENAME = "middlename";
    public static final String CONTACT = "contact";

    /**
     * Define la cadena SQL para la creación de la tabla
     * ->agregar aquí la otra tabla, Para la version 006
     *
     */
    public static final String CREATE_TABLE_PERSON = "CREATE TABLE " + TABLE_PERSON + "("
            + ID + " INTEGER PRIMARY KEY,"
            + LASTNAME + " TEXT,"
            + FIRSTNAME + " TEXT,"
            + MIDDLENAME + " TEXT,"
            + CONTACT + " TEXT" + ")";
}
