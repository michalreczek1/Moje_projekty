package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
            .antMatchers("/products/new", "/products/*/edit").hasAuthority("ROLE_manager") // tylko manager może edytować
            .antMatchers("/customers/new", "/customers/*/edit").hasAuthority("ROLE_manager")
            .antMatchers("/products/find").authenticated() // zalogowany jako ktokolwiek może wyszukiwać
            .antMatchers("/", "/whoami", "/products/**", "/customers/**", "/*.css").permitAll() // dostęp dla wszystkich
            .antMatchers("/products?", "/products?/**").permitAll() // inne wersje listy produktów
            .antMatchers("/rest/**").permitAll()
            // .antMatchers("/login").anonymous() // nie może być zalogowany! - ale to przestało działać...
            .antMatchers("/login").permitAll()
            .antMatchers("/logout").authenticated() // zalogowany jako ktokolwiek
            .anyRequest().denyAll() // pozostałe adresy blokujemy
        .and()
            .formLogin()
        .and()
        .csrf().disable();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .passwordEncoder(passwordEncoder)
            .usersByUsernameQuery("SELECT username, password, enabled FROM spring_accounts WHERE username = ?")
            .authoritiesByUsernameQuery("SELECT username, role FROM spring_account_roles WHERE username = ?");
        
//        auth.inMemoryAuthentication()
//            .withUser("ala").password("{noop}abc123").roles("manager", "sprzedawca")
//        .and()
//            .withUser("ola").password("{noop}abc123").roles("sprzedawca")
//        .and()
//            .withUser("ula").password("{noop}abc123").roles();
    }
    
    
}



