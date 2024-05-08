package org.bakeli.bakeli.data.security.services;

import org.bakeli.bakeli.data.entities.Electeurs;
import org.bakeli.bakeli.data.security.data.entities.AppRole;
import org.bakeli.bakeli.data.security.data.entities.AppUser;

public interface CustomUserDetailsService {
    AppUser getUser(String numeroCNI);

    AppUser saveUser(String nom,String prenom,String telephone ,String Cni,String numeroElecteur);
    AppRole saveRole(String roleName);
    void addRoleToUser(String nom,String roleName);
    void removeRoleToUser(String nom,String roleName);
}