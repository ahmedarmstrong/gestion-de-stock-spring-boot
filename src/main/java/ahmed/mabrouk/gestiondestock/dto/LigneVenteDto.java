package ahmed.mabrouk.gestiondestock.dto;

import java.math.BigDecimal;

import ahmed.mabrouk.gestiondestock.model.LigneVente;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneVenteDto {
	
	private Integer id ;
	private BigDecimal quantite ;
	private BigDecimal prixUnitaire ;
	private VentesDto ventes ;
	private ArticleDto article;
	private Integer idEntreprise;
	 
	public static LigneVenteDto fromEntity (LigneVente ligneVente) {
		if(ligneVente == null) {
			return null ;
			//TODOO
		}
		
		return LigneVenteDto.builder()
				.id(ligneVente.getId())
				.quantite(ligneVente.getQuantite())
				.prixUnitaire(ligneVente.getPrixUnitaire())
				.ventes(VentesDto.fromEntity(ligneVente.getVente()))
				.article(ArticleDto.fromEntity(ligneVente.getArticle()))
				.idEntreprise(ligneVente.getIdEntreprise())
				.build();
	}
	
	public static LigneVente toEntity (LigneVenteDto ligneVenteDto) {
		if(ligneVenteDto == null) {
			return null ;
			//TODOO
		}
		
		LigneVente ligneVente = new LigneVente() ;
		ligneVente.setId(ligneVenteDto.getId());
		ligneVente.setQuantite(ligneVenteDto.getQuantite());
		ligneVente.setPrixUnitaire(ligneVenteDto.getPrixUnitaire());
		ligneVente.setVente(VentesDto.toEntity(ligneVenteDto.getVentes()));
		ligneVente.setArticle(ArticleDto.toEntity(ligneVenteDto.getArticle()));
		ligneVente.setIdEntreprise(ligneVenteDto.getIdEntreprise());
		return ligneVente;
		
	}

}
