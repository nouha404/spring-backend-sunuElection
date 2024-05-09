package org.bakeli.bakeli.data.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class CustomSecurityConfig {
    private final UserDetailsService service;
    private final PasswordEncoder passwordEncoder;
    private final JwtFilter jwtFilter;

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(service);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }

    // Authorisation a moment ou l'authentification est correcte
    @Bean // creer au démarrage
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // l'intercepteur http contient la requete
        return http.csrf(AbstractHttpConfigurer::disable)
                //.formLogin(AbstractAuthenticationFilterConfigurer::permitAll).
                        .authorizeHttpRequests( auth -> auth
                        .requestMatchers("/api/login","/api/**").permitAll()
                        .anyRequest()
                        .authenticated()

                ).authenticationProvider(authenticationProvider()) //auth par token
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class) // se charge recuperer le login et le password
                .build();

    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();

    }



}
