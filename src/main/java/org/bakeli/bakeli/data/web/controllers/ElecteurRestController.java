package org.bakeli.bakeli.data.web.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface ElecteurRestController {

    @GetMapping("")
    ResponseEntity<Map<Object,Object>> listeUtilisateurs(
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "10", name = "size") int size,
            @RequestParam(defaultValue = "", name = "numero_electeur") String numero_electeur
    );

    @GetMapping("/nombre-inscrits")
    ResponseEntity<Map<Object,Object>> listeNombreInscrit(
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "10", name = "size") int size
    );
    @GetMapping("/voter")
    ResponseEntity<Map<Object,Object>> nombreVoteur(
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "10", name = "size") int size
    );
    @GetMapping("/voter/informations")
    ResponseEntity<Map<Object,Object>> nombreElecteurVoter(
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "10", name = "size") int size,
            @RequestParam(required = false) String CNI
    );

    @PostMapping("/voter")
    ResponseEntity<?> addVote(
            @AuthenticationPrincipal UserDetails userDetails
    );

}
