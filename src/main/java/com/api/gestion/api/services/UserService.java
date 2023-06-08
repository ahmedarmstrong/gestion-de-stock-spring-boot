package com.api.gestion.api.services;

import com.api.gestion.api.dto.ChangerMotDePasseUtilisateurDto;
import com.api.gestion.api.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto save(UserDto dto);

    UserDto findById(Integer id);

    List<UserDto> findAll();

    void delete(Integer id);

    UserDto findByEmail(String email);

    UserDto changerMotDePasse(ChangerMotDePasseUtilisateurDto dto);
}
