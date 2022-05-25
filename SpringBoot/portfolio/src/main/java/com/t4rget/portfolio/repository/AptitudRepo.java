package com.t4rget.portfolio.repository;

import com.t4rget.portfolio.model.Aptitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AptitudRepo extends JpaRepository<Aptitud, Long>{
    
}
