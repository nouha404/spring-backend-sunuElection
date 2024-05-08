package org.bakeli.bakeli.data.repositories;

import org.bakeli.bakeli.data.entities.Electeurs;
import org.bakeli.bakeli.data.entities.Votant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotantRepository  extends JpaRepository<Votant,Long> {
    Long countAllByIsActiveTrue();

    
}
