package org.bakeli.bakeli.data.fixtures;


import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.bakeli.bakeli.data.entities.Electeurs;
import org.bakeli.bakeli.data.repositories.ElecteurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(4)
//@Component
@RequiredArgsConstructor
public class UtilisateurFixtures implements CommandLineRunner {
    private final ElecteurRepository electeurRepository;

    @Override
    public void run(String... args) throws Exception {
        for(long i = 1L; i < 30; i++){
            Faker faker = new Faker();
            Electeurs electeurs = new Electeurs();
            electeurs.setNom(faker.name().firstName());
            electeurs.setPrenom(faker.name().lastName());
            electeurs.setTelephone(faker.phoneNumber().cellPhone());
            electeurs.setNumeroCni(i+faker.numerify("######"));
            electeurs.setNumeroElecteur("CNI"+"0"+i+faker.numerify("####"));
            electeurs.setIsActive(true);
            electeurRepository.save(electeurs);

        }

    }
}
