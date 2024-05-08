package org.bakeli.bakeli.data.repositories;

import org.bakeli.bakeli.data.entities.Electeurs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ElecteurRepository extends JpaRepository<Electeurs,Long> {
    Page<Electeurs> findAllByIsActiveTrueAndNumeroElecteurContains(String numeroElecteur, Pageable pageable);
    Page<Electeurs> findAllByIsActiveTrue(Pageable page);
    Long countAllByIsActiveTrue();
    Electeurs findByNumeroCni(String CNI);


    @Query("SELECT DISTINCT u FROM Electeurs u JOIN FETCH u.votants v WHERE (:cni IS NULL OR u.numeroCni = :cni)")
    Page<Electeurs> findElecteurWhoVoted(@Param("cni") String cni, Pageable pageable);

    @Query("SELECT DISTINCT e FROM Electeurs e JOIN FETCH e.votants v")
    Page<Electeurs> findElecteurWhoVotedWithoutFiltre(Pageable pageable);

}
