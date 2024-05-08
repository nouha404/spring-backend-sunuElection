package org.bakeli.bakeli.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "candidats")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Candidat extends AbstractEntity {
    private String nom;
    private String prenom;
    private String profession;
    private String partiePolitique;
    private String photoPath;
    private String programmeFilePath;
    @Column(length = 1000000000)
    private String description;
}
