package org.bakeli.bakeli.data.repositories;

import org.bakeli.bakeli.data.entities.Candidat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatRepository extends JpaRepository<Candidat,Long> {
    Page<Candidat> findAllByIsActiveTrue(Pageable page);

    Page<Candidat> findByNomAndIsActiveTrue(String nom, Pageable page);
    Long countAllByIsActiveTrue();

    Page<Candidat> findAllByPartiePolitiqueContains(String partiePolitique, Pageable page);
}
