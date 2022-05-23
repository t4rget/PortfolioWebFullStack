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
    private String iniExp;
    private String finExp;
    private String descripcionExp;
    private int trabajoActExp;
    private  String idEmpresaExp;
    private String idCargoExp;
    private String idTipoEmpleoExp;
    
    // CONTRUCTOR

    public Experiencia(Long idExp, String iniExp, String finExp, String descripcionExp, int trabajoActExp, String idEmpresaExp, String idCargoExp, String idTipoEmpleoExp) {
        this.idExp = idExp;
        this.iniExp = iniExp;
        this.finExp = finExp;
        this.descripcionExp = descripcionExp;
        this.trabajoActExp = trabajoActExp;
        this.idEmpresaExp = idEmpresaExp;
        this.idCargoExp = idCargoExp;
        this.idTipoEmpleoExp = idTipoEmpleoExp;
    }
    
    // CONTRUCTOR VACIO

    public Experiencia() {
    }
    
    
}
