package com.t4rget.portfolio.repository;

import com.t4rget.portfolio.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepo extends  JpaRepository<Educacion, Long>{
    
}
