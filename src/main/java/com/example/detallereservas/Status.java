package com.example.detallereservas;

public class Status {

    private int codigo;
    private String nombre;

    public Status(int codigo, String nombre){
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getNombre(){
        return nombre;
    }
    
}
