package org.bakeli.bakeli.data.security.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bakeli.bakeli.data.security.services.CustomUserDetailsService;
import org.bakeli.bakeli.data.security.services.Impl.JwtServiceImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//intercepeter la requete et generer un token
@Component
@RequiredArgsConstructor
@Slf4j //pour debuger a la place des sysout
public class JwtFilter extends OncePerRequestFilter {
    private final JwtServiceImpl jwtServiceImpl;
    private final CustomUserDetailsService securityService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //les infos de la requete , les transformer
        String autorizationHeader = request.getHeader("Authorization");
        String token = "";
        String nom = "";
        if (autorizationHeader != null && autorizationHeader.startsWith("Bearer ")) {
            token = autorizationHeader.substring(7);
            //extraire le username
            nom = jwtServiceImpl.extractName(token);
            log.info(nom);

        }
        if(nom!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = securityService.loadUserByUsername(nom);
            if (jwtServiceImpl.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities()); //recupere les donnes
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); //ajoute la requte

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        //appel encore a filtrer chain apres traitment
        filterChain.doFilter(request,response);

    }
}
