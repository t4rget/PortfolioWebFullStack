
package com.t4rget.portfolio.service;

import com.t4rget.portfolio.model.Proyecto;
import com.t4rget.portfolio.repository.ProyectoRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProyectoService {

    private final ProyectoRepo proyectoRepo;

    @Autowired
    public ProyectoService(ProyectoRepo proyectoRepo) {
        this.proyectoRepo = proyectoRepo;
    }

    public Proyecto agregarProyecto(Proyecto proyecto) {
        return proyectoRepo.save(proyecto);
    }

    public List<Proyecto> buscarProyectos() {
        return proyectoRepo.findAll();
    }

    public Proyecto editarProyecto(Proyecto proyecto) {
        return proyectoRepo.save(proyecto);
    }

    /*public Educacion buscarEducacionPorId(Long id){
         return educacionRepo.findById(id).orElseThrow(() ->new EducationNotFoundException("educacion no encontrada"));
     }
     */
    public void borrarProyecto(Long id) {
        proyectoRepo.deleteById(id);
    }
    
}
