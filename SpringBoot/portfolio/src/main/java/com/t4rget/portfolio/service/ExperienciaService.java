
package com.t4rget.portfolio.service;

import com.t4rget.portfolio.model.Experiencia;
import com.t4rget.portfolio.repository.ExperienciaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ExperienciaService {
    
    private final ExperienciaRepo experienciaRepo;

    @Autowired
    public ExperienciaService(ExperienciaRepo experienciaRepo) {
        this.experienciaRepo = experienciaRepo;
    }

    public Experiencia agregarExperiencia(Experiencia experiencia) {
        return experienciaRepo.save(experiencia);
    }

    public List<Experiencia> buscarExperiencias() {
        return experienciaRepo.findAll();
    }

    public Experiencia editarExperiencia(Experiencia experiencia) {
        return experienciaRepo.save(experiencia);
    }

    /*public Experiencia buscarExperienciaPorId(Long id){
         return experienciaRepo.findById(id).orElseThrow(() ->new ExperienciaNotFoundException("experiencia no encontrada"));
     }
     */
    public void borrarExperiencia(Long id) {
        experienciaRepo.deleteById(id);
    }
    
}
