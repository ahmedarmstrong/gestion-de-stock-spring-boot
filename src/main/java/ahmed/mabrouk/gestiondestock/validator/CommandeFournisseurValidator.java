package ahmed.mabrouk.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import ahmed.mabrouk.gestiondestock.dto.CommandeFournisseurDto;

public class CommandeFournisseurValidator {
	
	 public static List<String> validate(CommandeFournisseurDto commandeFournisseurDto) {
		    List<String> errors = new ArrayList<>();
		    if (commandeFournisseurDto == null) {
		      errors.add("Veuillez renseigner le code de la commande");
		      errors.add("Veuillez renseigner la date de la commande");
		      errors.add("Veuillez renseigner l'etat de la commande");
		      errors.add("Veuillez renseigner le client");
		      return errors;
		    }

		    if (!StringUtils.hasLength(commandeFournisseurDto.getCode())) {
		      errors.add("Veuillez renseigner le code de la commande");
		    }
		    if (commandeFournisseurDto.getDateCommandeFournisseur() == null) {
		      errors.add("Veuillez renseigner la date de la commande");
		    }
		    if (!StringUtils.hasLength(commandeFournisseurDto.getEtatCommande().toString())) {
		      errors.add("Veuillez renseigner l'etat de la commande");
		    }
		    if (commandeFournisseurDto.getFournisseur() == null || commandeFournisseurDto.getFournisseur().getId() == null) {
		      errors.add("Veuillez renseigner le fournisseur");
		    }

		    return errors;
		  }

}
