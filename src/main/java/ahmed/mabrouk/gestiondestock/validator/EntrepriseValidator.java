package ahmed.mabrouk.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import ahmed.mabrouk.gestiondestock.dto.EntrepriseDto;

public class EntrepriseValidator {
	
	public static List<String> validate(EntrepriseDto entrepriseDto) {
	    List<String> errors = new ArrayList<>();
	    if (entrepriseDto == null) {
	      errors.add("Veuillez renseigner le nom de l'entreprise");
	      errors.add("Veuillez reseigner la description de l'entreprise");
	      errors.add("Veuillez reseigner le code fiscal de l'entreprise");
	      errors.add("Veuillez reseigner l'email de l'entreprise");
	      errors.add("Veuillez reseigner le numero de telephone de l'entreprise");
	      errors.addAll(AdresseValidator.validate(null));
	      return errors;
	    }

	    if (!StringUtils.hasLength(entrepriseDto.getNom())) {
	      errors.add("Veuillez renseigner le nom de l'entreprise");
	    }
	    if (!StringUtils.hasLength(entrepriseDto.getDescription())) {
	      errors.add("Veuillez reseigner la description de l'entreprise");
	    }
	    if (!StringUtils.hasLength(entrepriseDto.getCodeFiscale())) {
	      errors.add("Veuillez reseigner le code fiscal de l'entreprise");
	    }
	    if (!StringUtils.hasLength(entrepriseDto.getEmail())) {
	      errors.add("Veuillez reseigner l'email de l'entreprise");
	    }
	    if (!StringUtils.hasLength(entrepriseDto.getNumTel())) {
	      errors.add("Veuillez reseigner le numero de telephone de l'entreprise");
	    }

	    errors.addAll(AdresseValidator.validate(entrepriseDto.getAdresse()));
	    return errors;
	  }

}
