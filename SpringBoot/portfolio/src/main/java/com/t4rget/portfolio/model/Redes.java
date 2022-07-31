package com.t4rget.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Redes {
    
    //ATRIBUTOS
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idRed;
    
    private String nombre_red;
    private String url_logo;
    private String link_red;
    
    //CONTRUCTOR VACIO

    public Redes() {
    }
    
    //CONTRUCTOR

    public Redes(long idRed, String nombre_red, String url_logo, String link_red) {
        this.idRed = idRed;
        this.nombre_red = nombre_red;
        this.url_logo = url_logo;
        this.link_red = link_red;
    }
    
    
    
    
    
    
}
