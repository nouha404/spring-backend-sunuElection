package org.bakeli.bakeli.data.services;

public interface VotantService {
    Long getNombreVotant();
    void addVote(String numeroCni);
}
