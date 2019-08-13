package com.example.goout.Model;

public class Restaurants {

    private String nombre;
    private String ubicacion;
    private String horarios;
    private Long telefonos;
    private String imagen;

    public Restaurants(String nombre, String ubicacion, String horarios, Long telefonos, String imagen) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.horarios = horarios;
        this.telefonos = telefonos;
        this.imagen = imagen;
    }

    public Restaurants(){

    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public Long getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Long telefonos) {
        this.telefonos = telefonos;
    }
}
