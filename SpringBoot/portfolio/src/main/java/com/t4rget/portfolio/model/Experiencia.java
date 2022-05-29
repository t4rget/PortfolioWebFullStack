// IMPORTACION DE PACKETES Y DEPENDENCIAS

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
public class Experiencia {
    
    // ATRIBUTOS DE EXPERIENCIA
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idExp;
    private int iniExp;
    private int finExp;
    private int trabajoActExp;
    private  String empresaExp;
    private String cargoExp;
    private String tipoEmpleoExp;
    private String direccionExp;
    private String ciudadExp;
    private String provinciaExp;
    private String paisExp;
    
    // CONTRUCTOR

    public Experiencia(Long idExp, int iniExp, int finExp, int trabajoActExp, String empresaExp, String cargoExp, String tipoEmpleoExp, String direccionExp, String ciudadExp, String provinciaExp, String paisExp) {
        this.idExp = idExp;
        this.iniExp = iniExp;
        this.finExp = finExp;
        this.trabajoActExp = trabajoActExp;
        this.empresaExp = empresaExp;
        this.cargoExp = cargoExp;
        this.tipoEmpleoExp = tipoEmpleoExp;
        this.direccionExp = direccionExp;
        this.ciudadExp = ciudadExp;
        this.provinciaExp = provinciaExp;
        this.paisExp = paisExp;
    }

    // CONTRUCTOR VACIO

    public Experiencia() {
    }
    
    
}
