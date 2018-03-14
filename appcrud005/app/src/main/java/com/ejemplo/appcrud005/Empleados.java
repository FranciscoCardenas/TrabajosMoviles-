package com.ejemplo.appcrud005;

/**
 * Created by franciscoemanuelcardenasramos on 13/03/18.
 */

public class Empleados {

    public static final String TABLE_EMPLEADO = "empleado";


    /**
     * Define los campos de la tabla
     */
    public static final String ID = "id";
    public static final String NOMBREEM = "nombreem";
    public static final String ACTIVIDAD = "actividad";
    public static final String FECHAINICIO = "fechainicio";
    public static final String FECHAFINAL = "fechafinal";
    public static final String CELU = "celu";
    public static final String CANTIDAD= "cantidad";
    public static final String PAGO = "pago";


    /**
     * Define la cadena SQL para la creación de la tabla
     * ->agregar aquí la otra tabla, Para la version 006
     *
     */
    public static final String CREATE_TABLE_EMPLEADO= "CREATE TABLE " + TABLE_EMPLEADO + "("
            + ID + " INTEGER PRIMARY KEY,"
            + NOMBREEM + " TEXT,"
            + ACTIVIDAD+ " TEXT,"
            + FECHAINICIO + " TEXT,"
            + FECHAFINAL + " TEXT,"
            + CELU + " TEXT,"
            + CANTIDAD + " TEXT,"
            + PAGO + " TEXT"

            + ")";


}
