package org.bakeli.bakeli.data.web.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.bakeli.bakeli.data.entities.Candidat;
import org.bakeli.bakeli.data.services.CandidatService;
import org.bakeli.bakeli.data.web.controllers.CandidatRestController;
import org.bakeli.bakeli.data.web.dto.response.RestResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/candidats")
public class CandidatRestControllerImpl implements CandidatRestController {
    private final CandidatService candidatService;

    @Override
    public ResponseEntity<Map<Object, Object>> listeCandidat(int page, int size, String nom) {
        Page<Candidat> candidats = candidatService.getCandidat(nom, PageRequest.of(page,size));
        Map<Object,Object> response = RestResponseDto.response(
                candidats.getContent(),
                new int[candidats.getTotalPages()],
                candidats.getNumber(),
                page > 0 ? page-1:page,
                page < candidats.getTotalPages() - 1 ? page+1:page,
                candidats.getTotalElements(),
                candidats.getTotalPages(),
                HttpStatus.OK
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
