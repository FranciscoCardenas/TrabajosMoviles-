package com.example.franciscoemanuelcardenasramos.proyecto_empleados;

/**
 * Created by franciscoemanuelcardenasramos on 12/03/18.
 */

public class Empleado {

    public static final String TABLE_EMPLEAD = "empleado";


    /**
     * Define los campos de la tabla
     */
    public static final String ID = "id";
    public static final String NOMBRE = "nombre";
    public static final String ACTIVIDAD = "actividad";
    public static final String FECHAINICIO = "fechaini";
    public static final String FECHAFINAL = "fechafin";
    public static final String CEL = "cel";
    public static final String CANTIDADDEOBRA = "cantidad";
    public static final String PAGOESTIMADO = "pago";

    /**
     * Define la cadena SQL para la creación de la tabla
     * ->agregar aquí la otra tabla, Para la version 006
     *
     */
    public static final String CREATE_TABLE_PERSON = "CREATE TABLE " + TABLE_EMPLEAD + "("
            + ID + " INTEGER PRIMARY KEY,"
            + NOMBRE + " TEXT,"
            + ACTIVIDAD + " TEXT,"
            + FECHAINICIO + " TEXT,"
            + FECHAFINAL + " TEXT"
            + CEL + " TEXT"
            + CANTIDADDEOBRA + " TEXT"
            + PAGOESTIMADO + " TEXT" +


            ")";

}
