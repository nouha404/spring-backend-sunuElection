package org.bakeli.bakeli.data.services;

import org.bakeli.bakeli.data.entities.Electeurs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ElecteurService {
    Page<Electeurs> getUtilisateur(String numero_electeur, Pageable page);
    Long getNombreElecteur();
    Page<Electeurs> getUtilisateurVoter(String numero_cni, Pageable page);

}
