package com.t4rget.portfolio.service;

import com.t4rget.portfolio.model.Redes;
import com.t4rget.portfolio.repository.RedesRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RedesService {

    private final RedesRepo redesRepo;

    @Autowired
    public RedesService(RedesRepo redesRepo) {
        this.redesRepo = redesRepo;
    }

    public Redes agregarRedes(Redes redes) {
        return redesRepo.save(redes);
    }

    public List<Redes> buscarRedes() {
        return redesRepo.findAll();
    }

    public Redes editarRedes(Redes redes) {
        return redesRepo.save(redes);
    }

    /*public Redes buscarRedesPorId(Long id){
         return redesRepo.findById(id).orElseThrow(() ->new RedesNotFoundException("red no encontrada"));
     }
     */
    public void borrarRedes(Long id) {
        redesRepo.deleteById(id);
    }

}
