package com.example.goout.Model;

public class Cafe {

    private String nombre;
    private String ubicacion;
    private String horarios;
    private String  telefonos;
    private String imagen;
    private String info;

    public Cafe(String nombre, String ubicacion, String horarios, String telefonos, String imagen, String info) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.horarios = horarios;
        this.telefonos = telefonos;
        this.imagen = imagen;
        this.info = info;
    }

    public Cafe(){

    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }
}
