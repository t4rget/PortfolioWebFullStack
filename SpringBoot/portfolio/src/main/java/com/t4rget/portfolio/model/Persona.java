package com.t4rget.portfolio.model;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter //Metodos
public class Persona {
    
    //Atributos
    
    private long id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String ciudad;
    private String provincia;
    private String pais;
    private String titulo;
    private String foto_perfil;
    private String telefono;
    private String email;
    private String sobre_mi;
    private String fecha_nac;
    
    //Contructores

    public Persona() {
    }

    public Persona(long id, String nombre, String apellido, String direccion, String ciudad, String provincia, String pais, String titulo, String foto_perfil, String telefono, String email, String sobre_mi, String fecha_nac) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.pais = pais;
        this.titulo = titulo;
        this.foto_perfil = foto_perfil;
        this.telefono = telefono;
        this.email = email;
        this.sobre_mi = sobre_mi;
        this.fecha_nac = fecha_nac;
    }
    
        
}
