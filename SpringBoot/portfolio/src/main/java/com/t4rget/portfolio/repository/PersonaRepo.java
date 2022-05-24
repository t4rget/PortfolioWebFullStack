package com.t4rget.portfolio.repository;

import com.t4rget.portfolio.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepo extends  JpaRepository<Persona, Long>{
    
}
