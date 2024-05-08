package org.bakeli.bakeli.data.services.impl;

import lombok.RequiredArgsConstructor;
import org.bakeli.bakeli.data.entities.Electeurs;
import org.bakeli.bakeli.data.repositories.ElecteurRepository;
import org.bakeli.bakeli.data.services.ElecteurService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ElecteurServiceImpl implements ElecteurService {
    private final ElecteurRepository electeurRepository;
    @Override
    public Page<Electeurs> getUtilisateur(String numero_electeur, Pageable page) {
        if (numero_electeur != null && !numero_electeur.isEmpty()) {
            return electeurRepository.findAllByIsActiveTrueAndNumeroElecteurContains(numero_electeur,page);
        } else {
            System.out.println(electeurRepository.findAllByIsActiveTrue(page));
            return electeurRepository.findAllByIsActiveTrue(page);
        }

    }

    @Override
    public Long getNombreElecteur() {
        return electeurRepository.countAllByIsActiveTrue();
    }

    @Override
    public Page<Electeurs> getUtilisateurVoter(String numero_cni, Pageable page) {

        if (numero_cni != null && !numero_cni.isEmpty()) {
            return electeurRepository.findElecteurWhoVoted(numero_cni,page);
        } else {
            return electeurRepository.findElecteurWhoVotedWithoutFiltre(page);
        }

    }
}
