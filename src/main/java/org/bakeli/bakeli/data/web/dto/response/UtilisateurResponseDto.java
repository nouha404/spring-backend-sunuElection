package org.bakeli.bakeli.data.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bakeli.bakeli.data.entities.Electeurs;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class UtilisateurResponseDto {
    private String nom;
    private String prenom;
    private String telephone;
    private String numeroElecteur;
    private String numeroCni;

    public static UtilisateurResponseDto toDto(Electeurs electeurs){
        return UtilisateurResponseDto.builder()
                .nom(electeurs.getNom())
                .prenom(electeurs.getPrenom())
                .telephone(electeurs.getTelephone())
                .numeroElecteur(electeurs.getNumeroElecteur())
                .numeroCni(electeurs.getNumeroCni())
                .build();
    }
}
