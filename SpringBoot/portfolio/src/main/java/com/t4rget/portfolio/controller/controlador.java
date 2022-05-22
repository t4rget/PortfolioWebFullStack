package com.t4rget.portfolio.controller;

import com.t4rget.portfolio.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controlador {
    
    @Autowired
    
    public PersonaRepository persoRepo;
    
    
    
}
