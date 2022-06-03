
package com.t4rget.portfolio.controller;


import com.t4rget.portfolio.model.Aptitud;
import com.t4rget.portfolio.service.AptitudService;
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
@RequestMapping("/api/aptitud")
public class AptitudController {
    
    private final AptitudService aptitudService;

    public AptitudController(AptitudService aptitudService) {
        this.aptitudService = aptitudService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Aptitud>> traerAptitudes() {
        
        List<Aptitud> aptitudes=aptitudService.buscarAptitudes();
        
        return new ResponseEntity<>(aptitudes, HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Aptitud> editarAptitud(@RequestBody Aptitud aptitud){

        Aptitud upAptitud=aptitudService.editarAptitud(aptitud);

        return new ResponseEntity<>(upAptitud,HttpStatus.OK);  
    }

    @PostMapping("/add")
    public ResponseEntity<Aptitud> agregarAptitud(@RequestBody Aptitud aptitud){
        
        Aptitud agregarAptitud=aptitudService.agregarAptitud(aptitud);
        
        return new ResponseEntity<>(agregarAptitud,HttpStatus.CREATED);
    }  
    
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> borrarAptitud(@PathVariable("id") Long id){
        
        aptitudService.borrarAptitud(id);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}