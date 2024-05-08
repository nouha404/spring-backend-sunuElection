package org.bakeli.bakeli.data.security.services.Impl;

import lombok.RequiredArgsConstructor;
import org.bakeli.bakeli.data.repositories.ElecteurRepository;
import org.bakeli.bakeli.data.security.data.entities.AppRole;
import org.bakeli.bakeli.data.security.data.entities.AppUser;
import org.bakeli.bakeli.data.security.repositories.AppRoleRepository;
import org.bakeli.bakeli.data.security.repositories.AppUserRepository;
import org.bakeli.bakeli.data.security.services.CustomUserDetailsService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService, UserDetailsService {
    private final ElecteurRepository electeursRepository;
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final AppRoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String numeroCNI) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByNumeroCni(numeroCNI);
        if (appUser == null) {
            throw new UsernameNotFoundException("Électeur non trouvé avec le numéro d'electeur: " + numeroCNI);
        }

        List<SimpleGrantedAuthority> authorities = appUser.getRoles()
                .stream()
                .map(appRole -> new SimpleGrantedAuthority(appRole.getRoleName())).toList();

        return new User(
                appUser.getNom(),
                appUser.getNumeroElecteur(), // Utilisation du téléphone comme mot de passe (peut être ajusté selon les besoins)
                authorities
        );
    }

    @Override
    public AppUser getUser(String numeroCNI) {
        return appUserRepository.findByNumeroCni(numeroCNI);
    }

    @Override
    public AppUser saveUser(String nom,String prenom,String telephone ,String Cni,String numeroElecteur) {
        AppUser user = appUserRepository.findByNumeroCni(Cni);
        if (user!=null) throw new RuntimeException("User already exist");
        user=new AppUser(nom,passwordEncoder.encode(Cni));
        user.setNumeroElecteur(numeroElecteur);
        user.setTelephone(telephone);
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setNumeroCni(Cni);
        user.setIsActive(true);
        return appUserRepository.save(user);
    }

    @Override
    public AppRole saveRole(String roleName) {
        AppRole role = roleRepository.findByRoleName(roleName);
        if (role!=null) throw new RuntimeException("Role already exist");
        role = new AppRole(roleName,null);
        role.setIsActive(true);
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String nom, String roleName) {
        AppUser user = appUserRepository.findByNom(nom);
        if (user==null) throw new RuntimeException("User not found");
        AppRole role = roleRepository.findByRoleName(roleName);
        if (role==null) throw new RuntimeException("Role not found");
        user.getRoles().add(role);
        appUserRepository.save(user);

    }

    @Override
    public void removeRoleToUser(String nom, String roleName) {
        AppUser user = appUserRepository.findByNom(nom);
        if (user==null) throw new RuntimeException("User not found");
        AppRole role = roleRepository.findByRoleName(roleName);
        if (role==null) throw new RuntimeException("Role not found");
        // suppression
        user.getRoles().remove(role);
        appUserRepository.save(user);

    }
}
