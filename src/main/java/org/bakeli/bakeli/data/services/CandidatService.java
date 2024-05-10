package org.bakeli.bakeli.data.services;

import org.bakeli.bakeli.data.entities.Candidat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface CandidatService {
    Page<Candidat> getCandidat(String nom,Pageable pageable);
    Long getNombreInscrit();
}
