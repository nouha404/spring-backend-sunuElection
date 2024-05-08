package org.bakeli.bakeli.data.security.data.fixtures;



import lombok.RequiredArgsConstructor;
import org.bakeli.bakeli.data.security.services.CustomUserDetailsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
@Order(1)
public class AppRoleFixtures implements CommandLineRunner {
    private final CustomUserDetailsService securityService;
    @Override
    public void run(String... args) throws Exception {

        securityService.saveRole("ELECTEUR");
    }
}
