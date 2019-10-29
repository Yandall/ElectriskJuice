package com.example.electrojuice.entities;

public class Clientes {
    private String tamaño;
    private String tipo;
    private String nombre;
    public Clientes(String tamaño, String nombre, String tipo){
        this.tamaño = tamaño;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Clientes() {

    }

    public String getTamaño() {

        return tamaño;
    }

    public String getTipo() {

        return tipo;
    }

    public String getNombre() {

        return nombre;
    }

}
