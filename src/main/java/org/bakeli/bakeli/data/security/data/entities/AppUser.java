package org.bakeli.bakeli.data.security.data.entities;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bakeli.bakeli.data.entities.AbstractEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@DiscriminatorValue(value="AppUser")
public class AppUser extends AbstractEntity {

    @Column(nullable = false)
    private String password;
    private String nom;
    private String prenom;
    private String telephone;
    private String numeroElecteur;
    private String numeroCni;

    public AppUser(String nom, String password) {
        this.nom = nom;
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns =  @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
    List<AppRole> roles = new ArrayList<>();
}










