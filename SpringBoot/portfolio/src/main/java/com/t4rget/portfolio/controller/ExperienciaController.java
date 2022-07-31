
package com.t4rget.portfolio.controller;

import com.t4rget.portfolio.model.Experiencia;
import com.t4rget.portfolio.service.ExperienciaService;
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
//@CrossOrigin(origins = "https://portfolioap-a7790.web.app/")
@RequestMapping("/api/experiencia")
public class ExperienciaController {
    
    private final ExperienciaService experienciaService;

    public ExperienciaController(ExperienciaService experienciaService) {
        this.experienciaService = experienciaService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Experiencia>> traerExperiencias() {
        
        List<Experiencia> experiencias=experienciaService.buscarExperiencias();
        
        return new ResponseEntity<>(experiencias, HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Experiencia> editarExperiencia(@RequestBody Experiencia experiencia){

        Experiencia upExperiencia=experienciaService.editarExperiencia(experiencia);

        return new ResponseEntity<>(upExperiencia,HttpStatus.OK);  
    }

    @PostMapping("/add")
    public ResponseEntity<Experiencia> agregarExperiencia(@RequestBody Experiencia experiencia){
        
        Experiencia agregarExperiencia=experienciaService.agregarExperiencia(experiencia);
        
        return new ResponseEntity<>(agregarExperiencia,HttpStatus.CREATED);
    }  
    
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> borrarExperiencia(@PathVariable("id") Long id){
        
        experienciaService.borrarExperiencia(id);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}