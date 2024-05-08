package org.bakeli.bakeli.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "votants")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Votant extends AbstractEntity{
    @ManyToOne
    private Electeurs electeurs;
}
