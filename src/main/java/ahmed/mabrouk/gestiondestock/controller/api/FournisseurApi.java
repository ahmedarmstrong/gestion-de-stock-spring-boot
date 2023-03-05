package ahmed.mabrouk.gestiondestock.controller.api;

import ahmed.mabrouk.gestiondestock.dto.FournisseurDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ahmed.mabrouk.gestiondestock.utils.Constants.FOURNISSEUR_ENDPOINT;

public interface FournisseurApi {

    @PostMapping(FOURNISSEUR_ENDPOINT + "/create")
    FournisseurDto save(@RequestBody FournisseurDto dto);

    @GetMapping(FOURNISSEUR_ENDPOINT + "/{idFournisseur}")
    FournisseurDto findById(@PathVariable("idFournisseur") Integer id);

    @GetMapping(FOURNISSEUR_ENDPOINT + "/all")
    List<FournisseurDto> findAll();

    @DeleteMapping(FOURNISSEUR_ENDPOINT + "/delete/{idFournisseur}")
    void delete(@PathVariable("idFournisseur") Integer id);
}
