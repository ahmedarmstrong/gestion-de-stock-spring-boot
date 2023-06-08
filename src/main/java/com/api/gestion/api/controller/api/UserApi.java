package com.api.gestion.api.controller.api;

import com.api.gestion.api.dto.ChangerMotDePasseUtilisateurDto;
import com.api.gestion.api.dto.UserDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.api.gestion.api.utils.Constants.UTILISATEUR_ENDPOINT;
@Tag(name = "user")
public interface UserApi {
    @PostMapping(UTILISATEUR_ENDPOINT + "/create")
    UserDto save(@RequestBody UserDto dto);

    @PostMapping(UTILISATEUR_ENDPOINT + "/update/password")
    UserDto changerMotDePasse(@RequestBody ChangerMotDePasseUtilisateurDto dto);

    @GetMapping(UTILISATEUR_ENDPOINT + "/{idUtilisateur}")
    UserDto findById(@PathVariable("idUtilisateur") Integer id);

    @GetMapping(UTILISATEUR_ENDPOINT + "/find/{email}")
    UserDto findByEmail(@PathVariable("email") String email);

    @GetMapping(UTILISATEUR_ENDPOINT + "/all")
    List<UserDto> findAll();

    @DeleteMapping(UTILISATEUR_ENDPOINT + "/delete/{idUtilisateur}")
    void delete(@PathVariable("idUtilisateur") Integer id);

}
