package com.edu.mx.practica.uno.Persona;
import lombok.Data;

@Data
public class Datos {

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public Datos (String n, String p, String m){
        this.nombre=n;
        this.apellidoPaterno= p;
        this.apellidoMaterno =m;
    }
}
