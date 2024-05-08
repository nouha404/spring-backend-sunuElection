package org.bakeli.bakeli.data.security.controllers.Impl;


import org.bakeli.bakeli.data.security.controllers.Security;
import lombok.RequiredArgsConstructor;
import org.bakeli.bakeli.data.security.services.CustomUserDetailsService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class SecurityImpl implements Security {
    private final CustomUserDetailsService securityService;

    @Override
    public String login(@AuthenticationPrincipal UserDetails user) {
        System.out.println(user.getUsername() + " est connecté !");
        // anyMatch dès qu'il trouve un critere valid …
        if(user.getAuthorities().stream().anyMatch(role -> role.getAuthority().compareTo("ELECTEUR") == 0) ){
            return "redirect:/api/candidats";
        }
        return "redirect:/login";
    }


}
