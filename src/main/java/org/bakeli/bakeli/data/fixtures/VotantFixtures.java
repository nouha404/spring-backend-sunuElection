package org.bakeli.bakeli.data.fixtures;

import lombok.RequiredArgsConstructor;
import org.bakeli.bakeli.data.entities.Electeurs;
import org.bakeli.bakeli.data.entities.Votant;
import org.bakeli.bakeli.data.repositories.ElecteurRepository;
import org.bakeli.bakeli.data.repositories.VotantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(5)
//@Component
@RequiredArgsConstructor
public class VotantFixtures implements CommandLineRunner {
    private final VotantRepository votantRepository;
    private final ElecteurRepository electeurRepository;


    @Override
    public void run(String... args) throws Exception {
        for(Long i = 1L; i < 10; i++){
            Electeurs electeurs = electeurRepository.findById(i).orElse(null);
            Votant votant = new Votant();
            votant.setElecteurs(electeurs);
            votant.setIsActive(true);
            votantRepository.save(votant);
        }

    }
}
