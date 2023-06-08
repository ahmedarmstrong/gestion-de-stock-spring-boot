package com.api.gestion.api.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.api.gestion.api.user.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private Integer id;

    private String nom;

    private String prenom;

    private String email;

    private Instant dateDeNaissance;

    private String moteDePasse;


    private String photo;


    private List<RolesDto> roles;

    public static UserDto fromEntity(User utilisateur) {
        if (utilisateur == null) {
            return null;
        }

        return UserDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getLastname())
                .prenom(utilisateur.getFirstname())
                .email(utilisateur.getEmail())
                .moteDePasse(utilisateur.getPassword())
                .dateDeNaissance(utilisateur.getDateDeNaissance())
                .photo(utilisateur.getPhoto())
                .roles(
                        utilisateur.getRoles() != null ?
                                utilisateur.getRoles().stream()
                                        .map(RolesDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();
    }

    public static User toEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }

        User utilisateur = new User();
        utilisateur.setId(dto.getId());
        utilisateur.setLastname(dto.getNom());
        utilisateur.setFirstname(dto.getPrenom());
        utilisateur.setEmail(dto.getEmail());
        utilisateur.setPassword(dto.getMoteDePasse());
        utilisateur.setDateDeNaissance(dto.getDateDeNaissance());
        utilisateur.setPhoto(dto.getPhoto());

        return utilisateur;
    }
}
