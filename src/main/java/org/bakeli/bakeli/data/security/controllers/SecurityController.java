package org.bakeli.bakeli.data.security.controllers;

import org.bakeli.bakeli.data.web.dto.request.AuthRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface SecurityController {
    @PostMapping("/login")
    ResponseEntity<Map<Object,Object>> login(@RequestBody AuthRequestDto authRequestDto);


}
