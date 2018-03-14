package com.ejemplo.appcrud005;

/**
 * Created by franciscoemanuelcardenasramos on 13/03/18.
 */

public class Item_Empleados {
    private int id;
    private String nombreem;
    private String actividad;
    private String fechainicio;
    private String fechafinal;
    private String celu;
    private String cantidad;
    private String pago;



    public Item_Empleados(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombreem() {
        return nombreem;
    }

    public void setNombreem(String nombreem) {
        this.nombreem = nombreem;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }
    public String getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(String fechafinal) {
        this.fechafinal = fechafinal;
    }


    public String getCelu() {
        return celu;
    }

    public void setCelu(String celu) {
        this.celu = celu;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }
}
