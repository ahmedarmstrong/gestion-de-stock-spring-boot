package ahmed.mabrouk.gestiondestock.controller.api;

import ahmed.mabrouk.gestiondestock.dto.ChangerMotDePasseUtilisateurDto;
import ahmed.mabrouk.gestiondestock.dto.UtilisateurDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ahmed.mabrouk.gestiondestock.utils.Constants.UTILISATEUR_ENDPOINT;

public interface UtilisateurApi {

    @PostMapping(UTILISATEUR_ENDPOINT + "/create")
    UtilisateurDto save(@RequestBody UtilisateurDto dto);

    @PostMapping(UTILISATEUR_ENDPOINT + "/update/password")
    UtilisateurDto changerMotDePasse(@RequestBody ChangerMotDePasseUtilisateurDto dto);

    @GetMapping(UTILISATEUR_ENDPOINT + "/{idUtilisateur}")
    UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

    @GetMapping(UTILISATEUR_ENDPOINT + "/find/{email}")
    UtilisateurDto findByEmail(@PathVariable("email") String email);

    @GetMapping(UTILISATEUR_ENDPOINT + "/all")
    List<UtilisateurDto> findAll();

    @DeleteMapping(UTILISATEUR_ENDPOINT + "/delete/{idUtilisateur}")
    void delete(@PathVariable("idUtilisateur") Integer id);
}
