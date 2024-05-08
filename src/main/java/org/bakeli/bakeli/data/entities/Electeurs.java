package org.bakeli.bakeli.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "electeurs")
@Builder
public class Electeurs extends AbstractEntity{
    private String nom;
    private String prenom;
    private String telephone;
    private String numeroElecteur;
    private String numeroCni;

    @OneToMany(mappedBy = "electeurs")
    private List<Votant> votants;
}




