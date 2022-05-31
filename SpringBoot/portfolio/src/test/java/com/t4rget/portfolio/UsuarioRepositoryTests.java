
package com.t4rget.portfolio;

import com.t4rget.portfolio.model.Usuario;
import com.t4rget.portfolio.repository.UsuarioRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UsuarioRepositoryTests {
    
    @Autowired
    UsuarioRepo repo;
    
    // puede ser que aca no este encryptando bien el password?
    
    @Test
    public void testCreateUser(){
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String rawPassword ="admin123";
        String encodePassword=passwordEncoder.encode(rawPassword);
        
        Usuario newUsuario=new Usuario("admin@admin.com",encodePassword);
        Usuario savedUsuario=repo.save(newUsuario);
        assertThat(savedUsuario).isNotNull();
        assertThat(savedUsuario.getIdU()).isGreaterThan(0);
    
    }
    
    
}
