package org.bakeli.bakeli.data.web.dto.request;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AuthRequestDto {
    private String nom;
    private String prenom;
    private String telephone;
    private String numeroElecteur;
    private String numeroCni;
}
