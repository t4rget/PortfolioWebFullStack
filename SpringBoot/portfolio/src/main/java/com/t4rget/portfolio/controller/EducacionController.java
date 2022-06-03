package com.t4rget.portfolio.controller;

import com.t4rget.portfolio.model.Educacion;
import com.t4rget.portfolio.service.EducacionService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/educacion")
public class EducacionController {
    
    private final EducacionService educacionService;

    public EducacionController(EducacionService educacionService) {
        this.educacionService = educacionService;
    }
    
    @GetMapping
    public ResponseEntity<List<Educacion>> traerEducaciones() {
        
        List<Educacion> educaciones=educacionService.buscarEducaciones();
        
        return new ResponseEntity<>(educaciones, HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<Educacion> editarEducacion(@RequestBody Educacion educacion){

        Educacion upEducacion=educacionService.editarEducacion(educacion);

        return new ResponseEntity<>(upEducacion,HttpStatus.OK);  
    }

    @PostMapping
    public ResponseEntity<Educacion> agregarEducacion(@RequestBody Educacion educacion){
        
        Educacion agregarEducacion=educacionService.agregarEducacion(educacion);
        
        return new ResponseEntity<>(agregarEducacion,HttpStatus.CREATED);
    }  
    
    @DeleteMapping("/{id}")
    public  ResponseEntity<?> borrarEducacion(@PathVariable("id") Long id){
        
        educacionService.borrarEducacion(id);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}

