package org.bakeli.bakeli.data.services.impl;

import lombok.RequiredArgsConstructor;
import org.bakeli.bakeli.data.entities.Electeurs;
import org.bakeli.bakeli.data.entities.Votant;
import org.bakeli.bakeli.data.exceptions.EntityNotFoundException;
import org.bakeli.bakeli.data.repositories.ElecteurRepository;
import org.bakeli.bakeli.data.repositories.VotantRepository;
import org.bakeli.bakeli.data.services.VotantService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VotantServiceImpl implements VotantService {
    private final VotantRepository votantRepository;
    private final ElecteurRepository electeurRepository;
    @Override
    public Long getNombreVotant() {
        return votantRepository.countAllByIsActiveTrue();
    }

    @Override
    public void addVote(Long electeurId) {
        Electeurs electeur = electeurRepository.findById(electeurId).orElse(null);
        if (electeur != null) {
            Votant votant = new Votant();
            votant.setElecteurs(electeur);
            votant.setIsActive(true);
            votantRepository.save(votant);
        } else {
            throw new EntityNotFoundException("Électeur non trouvé avec l'ID: " + electeurId);
        }



    }
}
