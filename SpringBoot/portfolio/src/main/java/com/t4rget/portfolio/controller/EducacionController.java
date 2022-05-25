package com.t4rget.portfolio.controller;

import com.t4rget.portfolio.model.Educacion;
import com.t4rget.portfolio.service.EducacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
public class EducacionController {
    
    private final EducacionService educacionService;

    public EducacionController(EducacionService educacionService) {
        this.educacionService = educacionService;
    }
    
    @GetMapping("id/{id}")
    public ResponseEntity<Educacion> traerEducacion(@PathVariable("id")Long id) {
        
        Educacion educacion=educacionService.buscarEducacionPorId(id);
        
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Educacion> editarEducacion(@RequestBody Educacion educacion){

        Educacion upEducacion=educacionService.editarEducacion(educacion);

        return new ResponseEntity<>(upEducacion,HttpStatus.OK);  
    }

    @PostMapping("/add")
    public ResponseEntity<Educacion> agregarEducacion(@RequestBody Educacion educacion){
        
        Educacion agregarEducacion=educacionService.agregarEducacion(educacion);
        
        return new ResponseEntity<>(agregarEducacion,HttpStatus.OK);
    }  
    

}

