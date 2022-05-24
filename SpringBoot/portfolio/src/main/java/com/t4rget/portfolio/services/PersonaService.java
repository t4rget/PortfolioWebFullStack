package com.t4rget.portfolio.services;

import com.t4rget.portfolio.model.Persona;
import com.t4rget.portfolio.repository.PersonaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonaService {
    
    private final PersonaRepo personaRepo;

    @Autowired
    public PersonaService(PersonaRepo personaRepo) {
        this.personaRepo = personaRepo;
    }
    
    
    
    public Persona agregarPersona(Persona persona){
         return personaRepo.save(persona);
     }

     public List<Persona> buscarPersonas() {
         return personaRepo.findAll();
     }
        
     public Persona editarPersona(Persona persona){
         return personaRepo.save(persona);
     }
     
     public void borrarPersona(Long id){
         personaRepo.deleteById(id);
     }
    
}
