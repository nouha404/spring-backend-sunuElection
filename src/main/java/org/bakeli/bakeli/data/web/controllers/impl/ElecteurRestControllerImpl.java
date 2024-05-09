package org.bakeli.bakeli.data.web.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.bakeli.bakeli.data.entities.Electeurs;
import org.bakeli.bakeli.data.security.services.CustomUserDetailsService;
import org.bakeli.bakeli.data.services.ElecteurService;
import org.bakeli.bakeli.data.services.VotantService;
import org.bakeli.bakeli.data.web.controllers.ElecteurRestController;
import org.bakeli.bakeli.data.web.dto.response.RestResponseDto;
import org.bakeli.bakeli.data.web.dto.response.UtilisateurResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/electeurs")
public class ElecteurRestControllerImpl implements ElecteurRestController {
    private final ElecteurService electeurService;
    private final VotantService votantService;
    @Override
    public ResponseEntity<Map<Object, Object>> listeUtilisateurs(int page, int size, String numero_electeur) {
        Page<Electeurs> utilisateur = electeurService.getUtilisateur(numero_electeur, PageRequest.of(page,size));

        Page<UtilisateurResponseDto> utilisateurDto = utilisateur.map(UtilisateurResponseDto::toDto);

        Map<Object,Object> response = RestResponseDto.response(
                utilisateurDto.getContent(),
                new int[utilisateurDto.getTotalPages()],
                utilisateurDto.getNumber(),
                page > 0 ? page-1:page,
                page < utilisateurDto.getTotalPages() - 1 ? page+1:page,
                utilisateurDto.getTotalElements(),
                utilisateurDto.getTotalPages(),
                HttpStatus.OK
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> listeNombreInscrit(int page, int size) {
        Long votant = electeurService.getNombreElecteur();
        Map<Object,Object> response = RestResponseDto.response(
                votant,
                HttpStatus.OK
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> nombreVoteur(int page, int size) {
        Long votant = votantService.getNombreVotant();
        Map<Object,Object> response = RestResponseDto.response(
                votant,
                HttpStatus.OK
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> nombreElecteurVoter(int page, int size, String CNI) {
        Page<Electeurs> utilisateur = electeurService.getUtilisateurVoter(CNI, PageRequest.of(page,size));
        Page<UtilisateurResponseDto> utilisateurDto = utilisateur.map(UtilisateurResponseDto::toDto);

        Map<Object,Object> response = RestResponseDto.response(
                utilisateurDto.getContent(),
                new int[utilisateurDto.getTotalPages()],
                utilisateurDto.getNumber(),
                page > 0 ? page-1:page,
                page < utilisateurDto.getTotalPages() - 1 ? page+1:page,
                utilisateurDto.getTotalElements(),
                utilisateurDto.getTotalPages(),
                HttpStatus.OK
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addVote(String numeroCni) {
        try {
            votantService.addVote(numeroCni); // Supposons que le nom d'utilisateur soit utilisé comme identifiant pour le vote
            return new ResponseEntity<>("Vote ajouté avec succès", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de l'ajout du vote: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
