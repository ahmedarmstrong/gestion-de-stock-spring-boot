package com.api.gestion.api.controller;

import com.api.gestion.api.controller.api.UserApi;
import com.api.gestion.api.dto.ChangerMotDePasseUtilisateurDto;
import com.api.gestion.api.dto.UserDto;
import com.api.gestion.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {

    private UserService utilisateurService;


    @Autowired
    public UserController(UserService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    public UserDto save(UserDto dto) {
        return utilisateurService.save(dto);
    }

    @Override
    public UserDto changerMotDePasse(ChangerMotDePasseUtilisateurDto dto) {
        return utilisateurService.changerMotDePasse(dto);
    }

    @Override
    public UserDto findById(Integer id) {
        return utilisateurService.findById(id);
    }

    @Override
    public UserDto findByEmail(String email) {
        return utilisateurService.findByEmail(email);
    }

    @Override
    public List<UserDto> findAll() {
        return utilisateurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        utilisateurService.delete(id);
    }
}
