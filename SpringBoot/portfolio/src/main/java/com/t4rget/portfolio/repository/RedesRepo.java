package com.t4rget.portfolio.repository;

import com.t4rget.portfolio.model.Redes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedesRepo extends JpaRepository<Redes, Long>{
    
}
