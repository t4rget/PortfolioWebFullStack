
package com.t4rget.portfolio.repository;

import com.t4rget.portfolio.model.Usuarios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuariosRepo extends JpaRepository<Usuarios, Integer> {
    Optional<Usuarios> findByEmail(String email);
}
