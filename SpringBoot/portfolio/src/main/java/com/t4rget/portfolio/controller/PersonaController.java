
package com.t4rget.portfolio.controller;

import com.t4rget.portfolio.model.Persona;
import com.t4rget.portfolio.services.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/usuario")
public class PersonaController {
    
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Persona> obtenerPesona(@PathVariable("id") Long id){
        Persona persona=personaService.buscarPersonasPorId(id);
        
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }
    
    
}
