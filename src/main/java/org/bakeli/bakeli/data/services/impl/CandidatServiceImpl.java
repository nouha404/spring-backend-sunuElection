package org.bakeli.bakeli.data.services.impl;

import lombok.RequiredArgsConstructor;
import org.bakeli.bakeli.data.entities.Candidat;
import org.bakeli.bakeli.data.repositories.CandidatRepository;
import org.bakeli.bakeli.data.services.CandidatService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class CandidatServiceImpl implements CandidatService {
    private final CandidatRepository candidatRepository;

    @Override
    public Page<Candidat> getCandidat(String nom, Pageable pageable) {
        if (nom != null && !nom.isEmpty()) {
            return candidatRepository.findByNomAndIsActiveTrue(nom,pageable);
        } else {
            return candidatRepository.findAllByIsActiveTrue(pageable);
        }
    }
}
