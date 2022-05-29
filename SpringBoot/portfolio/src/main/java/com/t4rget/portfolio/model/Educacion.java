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

public class Educacion {
    
    // ATRIBUTOS DE EXPERIENCIA
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEdu;
    
    private int iniEdu;
    private int finEdu;
    private String tituloEdu;
    private String urlInstitucionEdu;
    private  String institucionEdu;
    
    // CONSTRUCTOR VACIO

    public Educacion() {
    }
    
    // CONSTRUCTOR

    public Educacion(Long idEdu, int iniEdu, int finEdu, String tituloEdu, String urlInstitucionEdu, String institucionEdu) {
        this.idEdu = idEdu;
        this.iniEdu = iniEdu;
        this.finEdu = finEdu;
        this.tituloEdu = tituloEdu;
        this.urlInstitucionEdu = urlInstitucionEdu;
        this.institucionEdu = institucionEdu;
    }    
        
}
