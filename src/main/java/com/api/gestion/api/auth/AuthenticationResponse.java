package com.api.gestion.api.auth;

import com.api.gestion.api.dto.RolesDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationResponse {

    private String token;
    private Integer userId;
    private String firstname;
    private String lastname;

    private String email ;

    private List<RolesDto> roles;
}
