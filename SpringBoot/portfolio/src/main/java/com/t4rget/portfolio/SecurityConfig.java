
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
import org.springframework.http.HttpMethod;
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
    
    /*@Override
    protected void configure(HttpSecurity http) throws  Exception {
        /*http.csrf().disable()
                
                .authorizeRequests().antMatchers("/api/login")
                    .permitAll()
                .antMatchers("/api/**")
                .authenticated()
                .and()
                .httpBasic();
                
                
        http.csrf().disable()
                .authorizeRequests().antMatchers("/api/login").permitAll()
                .anyRequest().authenticated()
    
                /*
                //old
                .authorizeRequests().antMatchers("/api/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
                
                 .and().addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
                
        //http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }*/
     
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
         /*
         * 1. Se desactiva el uso de cookies
         * 2. Se activa la configuración CORS con los valores por defecto
         * 3. Se desactiva el filtro CSRF
         * 4. Se indica que el login no requiere autenticación
         * 5. Se indica que el resto de URLs esten securizadas
	*/
	httpSecurity
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .cors().and()
            .csrf().disable()
            // SE PUEDE DEFINIR POR PATH
            .authorizeRequests().antMatchers("/api/login").permitAll()
            //.antMatchers("/api/persona/id/**").permitAll()
            //.antMatchers("/api/educacion/").permitAll()
            
            // SE PUEDE DEFINIR POR METODO (EJ:GET,PUT,POST,DELETE)    
            .antMatchers(HttpMethod.GET).permitAll()
            .antMatchers(HttpMethod.PUT).authenticated()
            .antMatchers(HttpMethod.POST).authenticated()
            .antMatchers(HttpMethod.DELETE).authenticated()
                .anyRequest().authenticated().and().httpBasic();
                
        
         httpSecurity.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
                //.addFilter(new JWTAuthenticationFilter(authenticationManager()))
                //.addFilter(new JWTAuthorizationFilter(authenticationManager()));
	}
} 
