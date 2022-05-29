package com.t4rget.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Proyecto {
    
    //ATRIBUTOS
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPro;
    
    private String nombrePro;
    private String sobrePro;
    private String urlPro;
    private String urlImagenPro;

    // CONSTRUCTOR VACIO
    
    public Proyecto() {
    }

    // CONTRUCTOR

    public Proyecto(long idPro, String nombrePro, String sobrePro, String urlPro, String urlImagenPro) {
        this.idPro = idPro;
        this.nombrePro = nombrePro;
        this.sobrePro = sobrePro;
        this.urlPro = urlPro;
        this.urlImagenPro = urlImagenPro;
    }
    


    
    
}
