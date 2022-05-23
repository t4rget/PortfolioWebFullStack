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
    private String iniEdu;
    private String finEdu;
    private String tituloEdu;
    private int idPersonaEdu;
    private  int idInstitucionEdu;
    
    // CONSTRUCTOR VACIO

    public Educacion() {
    }
    
    // CONSTRUCTOR

    public Educacion(Long idEdu, String iniEdu, String finEdu, String tituloEdu, int idPersonaEdu, int idInstitucionEdu) {
        this.idEdu = idEdu;
        this.iniEdu = iniEdu;
        this.finEdu = finEdu;
        this.tituloEdu = tituloEdu;
        this.idPersonaEdu = idPersonaEdu;
        this.idInstitucionEdu = idInstitucionEdu;
    }
    
        
}
