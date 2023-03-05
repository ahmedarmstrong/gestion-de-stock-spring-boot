package ahmed.mabrouk.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import ahmed.mabrouk.gestiondestock.dto.FournisseurDto;

public class FournisseurValidator {
	
	public static List<String> validate(FournisseurDto fournisseurDto) {
	    List<String> errors = new ArrayList<>();

	    if (fournisseurDto == null) {
	      errors.add("Veuillez renseigner le nom du fournisseur");
	      errors.add("Veuillez renseigner le prenom du fournisseur");
	      errors.add("Veuillez renseigner le Mail du fournisseur");
	      errors.add("Veuillez renseigner le numero de telephone du fournisseur");
	      errors.addAll(AdresseValidator.validate(null));
	      return errors;
	    }

	    if (!StringUtils.hasLength(fournisseurDto.getNom())) {
	      errors.add("Veuillez renseigner le nom du fournisseur");
	    }
	    if (!StringUtils.hasLength(fournisseurDto.getPrenom())) {
	      errors.add("Veuillez renseigner le prenom du fournisseur");
	    }
	    if (!StringUtils.hasLength(fournisseurDto.getEmail())) {
	      errors.add("Veuillez renseigner le Mail du fournisseur");
	    }
	    if (!StringUtils.hasLength(fournisseurDto.getNumTel())) {
	      errors.add("Veuillez renseigner le numero de telephone du fournisseur");
	    }
	    errors.addAll(AdresseValidator.validate(fournisseurDto.getAdresse()));
	    return errors;
	  }

}
