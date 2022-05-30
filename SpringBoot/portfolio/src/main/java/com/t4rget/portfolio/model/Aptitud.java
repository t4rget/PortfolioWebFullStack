package com.t4rget.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

  // ANOTATIONS DE ENTIDAD Y USO DE LOMBOK PARA LOS GETTER Y SETTERS

@Entity
@Getter @Setter
public class Aptitud {
    
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idApt;
    
    private  int nivelApt;
    private String nombreHabilidadApt;
    private  String urlHabilidadApt;
    private String colorbarApt;
    
    // CONTRUCTOR VACIO

    public Aptitud() {
    }
    
    // CONTRUCTOR

    public Aptitud(Long idApt, int nivelApt, String nombreHabilidadApt, String urlHabilidadApt, String colorbarApt) {
        this.idApt = idApt;
        this.nivelApt = nivelApt;
        this.nombreHabilidadApt = nombreHabilidadApt;
        this.urlHabilidadApt = urlHabilidadApt;
        this.colorbarApt = colorbarApt;
    }





    
    
    
    
    
}
