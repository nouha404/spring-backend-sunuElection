package org.bakeli.bakeli.data.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface CandidatRestController {

    @GetMapping("")
    ResponseEntity<Map<Object,Object>> listeCandidat(
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "5", name = "size") int size,
            @RequestParam(defaultValue = "", name = "nom") String nom
    );

    @GetMapping("/inscrits")
    ResponseEntity<Map<Object,Object>> listeNombreCandidat(
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "10", name = "size") int size
    );
}
