package com.t4rget.portfolio.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

// ANOTATIONS DE ENTIDAD Y USO DE LOMBOK PARA LOS GETTER Y SETTERS

@Entity
@Getter @Setter
public class Persona implements Serializable{ //VER PARA QUE SIRVE EL SERIALIZABLE
    
    // ATRIBUTOS
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = false, updatable = false)
    private long id;
    
    private String nombrePer;
    private String apellidoPer;
    private String direccionPer;
    private String idciudadPer;
    private String idprovinciaPer;
    private String idpaisPer;
    private String tituloPer;
    private String fotoPerfilPer;
    private String telefonoPer;
    private String emailPer;
    private String sobreMiPer;
    private String fechaNacPer;
    private int idUsuarioPer;
    
    //CONSTRUCTOR VACIO

    public Persona() {
    }

    //CONTRUCTOR

    public Persona(long id, String nombrePer, String apellidoPer, String direccionPer, String idciudadPer, String idprovinciaPer, String idpaisPer, String tituloPer, String fotoPerfilPer, String telefonoPer, String emailPer, String sobreMiPer, String fechaNacPer, int idUsuarioPer) {
        this.id = id;
        this.nombrePer = nombrePer;
        this.apellidoPer = apellidoPer;
        this.direccionPer = direccionPer;
        this.idciudadPer = idciudadPer;
        this.idprovinciaPer = idprovinciaPer;
        this.idpaisPer = idpaisPer;
        this.tituloPer = tituloPer;
        this.fotoPerfilPer = fotoPerfilPer;
        this.telefonoPer = telefonoPer;
        this.emailPer = emailPer;
        this.sobreMiPer = sobreMiPer;
        this.fechaNacPer = fechaNacPer;
        this.idUsuarioPer = idUsuarioPer;
    }
    
    // MAPEADO PARA LA VINCULACION, VER BIEN PARA QUE SIRVE
   
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idEdu")
    private List<Educacion> educacionList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idApt")
    private List<Aptitud> aptitudList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idExp")
    private  List<Experiencia> experienciaList;

    
        
}
