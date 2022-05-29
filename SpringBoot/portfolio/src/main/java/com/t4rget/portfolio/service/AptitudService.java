
package com.t4rget.portfolio.service;

import com.t4rget.portfolio.model.Aptitud;
import com.t4rget.portfolio.repository.AptitudRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AptitudService {
    
    private final AptitudRepo aptitudRepo;
        
    @Autowired
    public AptitudService(AptitudRepo aptitudRepo) {
        this.aptitudRepo = aptitudRepo;
    }
        
           
     public Aptitud agregarAptitud(Aptitud aptitud){
         return aptitudRepo.save(aptitud);
     }
        
     public List<Aptitud> buscarAptitudes() {
         return aptitudRepo.findAll();
     }
        
     public Aptitud editarAptitud(Aptitud aptitud){
         return aptitudRepo.save(aptitud);
     }
    
     /*public Educacion buscarEducacionPorId(Long id){
         return educacionRepo.findById(id).orElseThrow(() ->new EducationNotFoundException("educacion no encontrada"));
     }
     */
     public void borrarAptitud(Long id){
         aptitudRepo.deleteById(id);
     }
    
}
