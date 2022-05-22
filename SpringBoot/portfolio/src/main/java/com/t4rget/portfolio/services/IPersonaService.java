package com.t4rget.portfolio.services;

import com.t4rget.portfolio.model.Persona;
import java.util.List;

public interface IPersonaService {

    public List<Persona> verPersonasc();
    
    public void crearPersonac(Persona per);
    
    public void borrarPersona (Long id);
    
    public Persona buscarPersona (Long id);
}
