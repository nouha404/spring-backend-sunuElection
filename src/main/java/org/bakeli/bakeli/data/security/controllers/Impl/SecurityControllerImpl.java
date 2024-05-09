package org.bakeli.bakeli.data.security.controllers.Impl;


import lombok.extern.slf4j.Slf4j;
import org.bakeli.bakeli.data.security.controllers.SecurityController;
import lombok.RequiredArgsConstructor;
import org.bakeli.bakeli.data.security.services.CustomUserDetailsService;
import org.bakeli.bakeli.data.security.services.Impl.JwtServiceImpl;
import org.bakeli.bakeli.data.web.dto.request.AuthRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class SecurityControllerImpl implements SecurityController {
    private final CustomUserDetailsService securityService;
    private final AuthenticationManager authenticationManager;
    private final JwtServiceImpl jwtServiceImpl;


    @Override
    public ResponseEntity<Map<Object, Object>> login(AuthRequestDto authRequestDto) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.getNom(), authRequestDto.getNumeroCni()));
        log.info("Generer le token");
        if(authenticate.isAuthenticated()){
            //generer le tokeen
            String token = jwtServiceImpl.createToken(authRequestDto.getNom());
            log.info(token);
        }
        return null;
    }
    /*@Override
    public ResponseEntity<Map<Object, Object>> login(AuthenticationRequestDto authenticationRequestDto) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequestDto.getUsername(), authenticationRequestDto.getPassword()));
        Map<Object, Object> response;
        if(authenticate.isAuthenticated()){
            //Generer le token
             String token= jwtService.createToken(authenticationRequestDto.getUsername());
            TokenReponseDto tokenDto = TokenReponseDto.builder()
                    .token(token)
                    .username(authenticationRequestDto.getUsername())
                    .roles(authenticate.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                    .build();
            response= RestResponse.response(tokenDto, HttpStatus.OK);
        }else{
            response= RestResponse.response(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(response);
    }*/
}
