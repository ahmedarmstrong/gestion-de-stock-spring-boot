package ahmed.mabrouk.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import ahmed.mabrouk.gestiondestock.dto.ArticleDto;

public class ArticleValidator {
	
	 public static List<String> validate(ArticleDto articleDto) {
		    List<String> errors = new ArrayList<>();

		    if (articleDto == null) {
		      errors.add("Veuillez renseigner le code de l'article");
		      errors.add("Veuillez renseigner la designation de l'article");
		      errors.add("Veuillez renseigner le prix unitaire HT l'article");
		      errors.add("Veuillez renseigner le taux TVA de l'article");
		      errors.add("Veuillez renseigner le prix unitaire TTC de l'article");
		      errors.add("Veuillez selectionner une categorie");
		      return errors;
		    }

		    if (!StringUtils.hasLength(articleDto.getCodeArticle())) {
		      errors.add("Veuillez renseigner le code de l'article");
		    }
		    if (!StringUtils.hasLength(articleDto.getDesignation())) {
		      errors.add("Veuillez renseigner la designation de l'article");
		    }
		    if (articleDto.getPrixUnitaireHt() == null) {
		      errors.add("Veuillez renseigner le prix unitaire HT l'article");
		    }
		    if (articleDto.getTauxTva() == null) {
		      errors.add("Veuillez renseigner le taux TVA de l'article");
		    }
		    if (articleDto.getPrixUnitaireTtc() == null) {
		      errors.add("Veuillez renseigner le prix unitaire TTC de l'article");
		    }
		    if (articleDto.getCategory() == null || articleDto.getCategory().getId() == null) {
		      errors.add("Veuillez selectionner une categorie");
		    }
		    return errors;
	 }

}
