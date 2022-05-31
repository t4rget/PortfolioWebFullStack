
package com.t4rget.portfolio.security;
 
import javax.validation.Valid;
 
import com.t4rget.portfolio.model.Usuario;
import com.t4rget.portfolio.security.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
 
 
@RestController
public class AuthApi {
    
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    JwtTokenUtil jwtUtil;
     
    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword())
            );
           //Acá dice que el usuario y contraseña estan mal
            Usuario usuarios = (Usuario) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(usuarios);
            AuthResponse response = new AuthResponse(usuarios.getEmail(), accessToken);
             
            return ResponseEntity.ok().body(response);
             
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}