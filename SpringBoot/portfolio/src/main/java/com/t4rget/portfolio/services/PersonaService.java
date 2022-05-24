package com.t4rget.portfolio.services;

import com.t4rget.portfolio.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.t4rget.portfolio.repository.PersonaRepo;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    
    public PersonaRepo persoRepo;
    
    @Override
    public List<Persona> verPersonasc() {
       return persoRepo.findAll();
    }

    @Override
    public void crearPersonac(Persona per) {
        persoRepo.save(per);
    }

    @Override
    public void borrarPersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        return persoRepo.findById(id).orElse(null);
    }
    
}
