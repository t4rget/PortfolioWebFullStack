package com.t4rget.portfolio.controller;

import com.t4rget.portfolio.model.Redes;
import com.t4rget.portfolio.service.RedesService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/redes")
public class RedesController {
    
    private final RedesService redesService;

    public RedesController(RedesService redesService) {
        this.redesService = redesService;
    }
    
    @GetMapping
    public ResponseEntity<List<Redes>> traerRedes() {
        
        List<Redes> redes=redesService.buscarRedes();
        
        return new ResponseEntity<>(redes, HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<Redes> editarRedes(@RequestBody Redes redes){

        Redes upRedes=redesService.editarRedes(redes);

        return new ResponseEntity<>(upRedes,HttpStatus.OK);  
    }

    @PostMapping
    public ResponseEntity<Redes> agregarRedes(@RequestBody Redes redes){
        
        Redes agregarRedes=redesService.agregarRedes(redes);
        
        return new ResponseEntity<>(agregarRedes,HttpStatus.CREATED);
    }  
    
    @DeleteMapping("/{id}")
    public  ResponseEntity<?> borrarRedes(@PathVariable("id") Long id){
        
        redesService.borrarRedes(id);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
