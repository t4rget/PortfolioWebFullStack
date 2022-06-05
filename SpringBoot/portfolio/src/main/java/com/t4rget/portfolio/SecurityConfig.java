
package com.t4rget.portfolio;

import com.t4rget.portfolio.security.jwt.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.t4rget.portfolio.repository.UsuarioRepo;
import java.util.Arrays;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.configurers.UrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UsuarioRepo usuariosRepo;
    @Autowired
    private JwtTokenFilter jwtTokenFilter;
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(
            username -> usuariosRepo.findByEmail(username)
                .orElseThrow(
                    () -> new UsernameNotFoundException("Usuario " + username + " no encontrado."))            
            
              );
    }
 
 
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
        
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return  super.authenticationManager();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws  Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/api/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
                
         http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
     
} 
