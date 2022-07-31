package com.t4rget.portfolio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
//import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
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
    private String ciudadPer;
    private String provinciaPer;
    private String paisPer;
    private String tituloPer;
    private String fotoPerfilPer;
    private String bannerPer;
    private String telefonoPer;
    private String emailPer;
    private String sobreMiPer;
    private String fechaNacPer;
    
    //CONSTRUCTOR VACIO

    public Persona() {
    }

    //CONTRUCTOR

    public Persona(long id, String nombrePer, String apellidoPer, String direccionPer, String ciudadPer, String provinciaPer, String paisPer, String tituloPer, String fotoPerfilPer, String bannerPer, String telefonoPer, String emailPer, String sobreMiPer, String fechaNacPer) {
        this.id = id;
        this.nombrePer = nombrePer;
        this.apellidoPer = apellidoPer;
        this.direccionPer = direccionPer;
        this.ciudadPer = ciudadPer;
        this.provinciaPer = provinciaPer;
        this.paisPer = paisPer;
        this.tituloPer = tituloPer;
        this.fotoPerfilPer = fotoPerfilPer;
        this.bannerPer = bannerPer;
        this.telefonoPer = telefonoPer;
        this.emailPer = emailPer;
        this.sobreMiPer = sobreMiPer;
        this.fechaNacPer = fechaNacPer;
    }
    
   /* // MAPEADO PARA LA VINCULACION, VER BIEN PARA QUE SIRVE
   
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idEdu")
    private List<Educacion> educacionList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idApt")
    private List<Aptitud> aptitudList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idExp")
    private  List<Experiencia> experienciaList;
*/

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "persona_educacion",
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "educacion_id")
    )
    private List<Educacion> educaciones = new ArrayList<Educacion>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "persona_experiencia",
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "experiencia_id")
    )
    private List<Experiencia> expericencias = new ArrayList<Experiencia>();
        
}
