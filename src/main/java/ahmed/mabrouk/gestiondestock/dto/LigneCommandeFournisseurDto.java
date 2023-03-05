package ahmed.mabrouk.gestiondestock.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ahmed.mabrouk.gestiondestock.model.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeFournisseurDto {
	
	private Integer id ;
	private BigDecimal quantite ;
	private BigDecimal prixUnitaire ;
	private ArticleDto article ;
	@JsonIgnore
	private CommandeFournisseurDto commandeFournisseur ;
	private Integer idEntreprise;
	
	public static LigneCommandeFournisseurDto fromEntity (LigneCommandeFournisseur ligneCommandeFournisseur) {
		if(ligneCommandeFournisseur == null) {
			return null ;
			//TODOO
		}
		
		return LigneCommandeFournisseurDto.builder()
				.id(ligneCommandeFournisseur.getId())
				.quantite(ligneCommandeFournisseur.getQuantite())
				.prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
				.article(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle()))
				.idEntreprise(ligneCommandeFournisseur.getIdEntreprise())
				.build();
	}
	
	public static LigneCommandeFournisseur toEntity (LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
		if(ligneCommandeFournisseurDto == null) {
			return null ;
			//TODOO
		}
		
		LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur() ;
		ligneCommandeFournisseur.setId(ligneCommandeFournisseurDto.getId());
		ligneCommandeFournisseur.setQuantite(ligneCommandeFournisseurDto.getQuantite());
		ligneCommandeFournisseur.setPrixUnitaire(ligneCommandeFournisseurDto.getPrixUnitaire());
		ligneCommandeFournisseur.setArticle(ArticleDto.toEntity(ligneCommandeFournisseurDto.getArticle()));
		ligneCommandeFournisseur.setIdEntreprise(ligneCommandeFournisseurDto.getIdEntreprise());
		return ligneCommandeFournisseur;
		
	}

}
