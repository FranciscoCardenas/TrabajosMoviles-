package com.example.franciscoemanuelcardenasramos.recyclerbd;

/**
 * Created by franciscoemanuelcardenasramos on 28/02/18.
 */

public class Item {
    private String id,nombre,apellido,salario;

    public Item(String id, String nombre, String apellido , String salario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario=salario;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getSalario() {
        return salario;
    }


}
