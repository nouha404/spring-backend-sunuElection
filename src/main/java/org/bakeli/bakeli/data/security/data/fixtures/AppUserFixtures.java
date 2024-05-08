package org.bakeli.bakeli.data.security.data.fixtures;


import lombok.RequiredArgsConstructor;
import org.bakeli.bakeli.data.security.data.entities.AppUser;
import org.bakeli.bakeli.data.security.services.CustomUserDetailsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//@Component
@RequiredArgsConstructor
@Order(2)
//@DependsOn("appRoleFixtures")
public class AppUserFixtures implements CommandLineRunner {
    private final CustomUserDetailsService securityService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        securityService.saveUser("nouha","ageram","770811045","CNI404Error","Elect404Error");

    }
}
