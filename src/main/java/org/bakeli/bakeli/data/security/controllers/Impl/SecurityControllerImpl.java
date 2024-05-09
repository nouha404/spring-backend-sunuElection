package org.bakeli.bakeli.data.security.controllers.Impl;


import lombok.extern.slf4j.Slf4j;
import org.bakeli.bakeli.data.security.controllers.SecurityController;
import lombok.RequiredArgsConstructor;
import org.bakeli.bakeli.data.security.services.CustomUserDetailsService;
import org.bakeli.bakeli.data.security.services.Impl.JwtServiceImpl;
import org.bakeli.bakeli.data.web.dto.request.AuthRequestDto;
import org.bakeli.bakeli.data.web.dto.response.RestResponseDto;
import org.bakeli.bakeli.data.web.dto.response.TokenReponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
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
        Map<Object, Object> response;
        if(authenticate.isAuthenticated()){
            //generer le tokeen
            String token = jwtServiceImpl.createToken(authRequestDto.getNom());

            TokenReponseDto tokenDto = TokenReponseDto.builder()
                    .token(token)
                    .nom(authRequestDto.getNom())
                    .roles(authenticate.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                    .build();
            response= RestResponseDto.response(tokenDto, HttpStatus.OK);
        }else{
            response= RestResponseDto.response(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(response);
    }
}
