package org.bakeli.bakeli.data.security.repositories;



import org.bakeli.bakeli.data.security.data.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByNom(String username);
    AppUser findByNumeroCni(String numeroCni);
}
