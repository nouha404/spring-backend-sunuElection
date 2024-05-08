package org.bakeli.bakeli.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;




@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass()
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "boolean default false")
    private Boolean isActive;

    public AbstractEntity() {
        this.isActive = false;
    }
}
