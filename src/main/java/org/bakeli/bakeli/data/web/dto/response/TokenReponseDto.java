package org.bakeli.bakeli.data.web.dto.response;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TokenReponseDto {
    private String token;
    private String nom;
    private List<String> roles=new ArrayList<String>();
}
