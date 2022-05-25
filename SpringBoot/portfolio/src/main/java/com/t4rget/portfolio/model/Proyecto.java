package com.t4rget.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;



@Getter @Setter
@Entity
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    public String name;
    public int id;

    public Proyecto() {
    }

    public Proyecto(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    
    
    
}
