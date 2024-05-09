package org.bakeli.bakeli.data.fixtures;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import org.bakeli.bakeli.data.entities.Candidat;
import org.bakeli.bakeli.data.entities.CandidatData;
import org.bakeli.bakeli.data.repositories.CandidatRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;


import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Order(3)
//@Component
@RequiredArgsConstructor
public class CandidatFixtures implements CommandLineRunner {
    private final CandidatRepository candidatRepository;
    private final ResourceLoader resourceLoader;
    @Value("classpath:data.json")
    Resource dataResource;


    @Override
    public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = dataResource.getInputStream();
        String json = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        CandidatData candidatData = objectMapper.readValue(json, CandidatData.class);

        List<Candidat> candidats = candidatData.getResults();

        for (Candidat candidatInfo : candidats) {
            Candidat candidat = new Candidat();
            candidat.setNom(candidatInfo.getNom());
            candidat.setPrenom(candidatInfo.getPrenom());
            candidat.setProfession(candidatInfo.getProfession());
            candidat.setPartiePolitique(candidatInfo.getPartiePolitique());
            candidat.setDescription(candidatInfo.getDescription());
            candidat.setIsActive(true);
            candidat.setPhotoPath(candidatInfo.getPhotoPath());
            candidat.setProgrammeFilePath(candidatInfo.getProgrammeFilePath());

            candidatRepository.save(candidat);

        }

    }

}
