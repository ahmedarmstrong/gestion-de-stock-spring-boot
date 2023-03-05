package ahmed.mabrouk.gestiondestock.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ahmed.mabrouk.gestiondestock.model.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeClientDto {
	
	private Integer id ;
	private BigDecimal quantite ;
	private BigDecimal prixUnitaire ;
	private ArticleDto article ;
	@JsonIgnore
	private CommandeClientDto commandeClient;
	private Integer idEntreprise;
	
	public static LigneCommandeClientDto fromEntity (LigneCommandeClient ligneCommandeClient) {
		if(ligneCommandeClient == null) {
			return null ;
			//TODOO
		}
		
		return LigneCommandeClientDto.builder()
				.id(ligneCommandeClient.getId())
				.quantite(ligneCommandeClient.getQuantite())
				.prixUnitaire(ligneCommandeClient.getPrixUnitaire())
				.article(ArticleDto.fromEntity(ligneCommandeClient.getArticle()))
				.idEntreprise(ligneCommandeClient.getIdEntreprise())
				.build();
	}
	
	public static LigneCommandeClient toEntity (LigneCommandeClientDto ligneCommandeClientDto) {
		if(ligneCommandeClientDto == null) {
			return null ;
			//TODOO
		}
		
		LigneCommandeClient ligneCommandeClient = new LigneCommandeClient() ;
		ligneCommandeClient.setId(ligneCommandeClientDto.getId());
		ligneCommandeClient.setQuantite(ligneCommandeClientDto.getQuantite());
		ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDto.getPrixUnitaire());
		ligneCommandeClient.setArticle(ArticleDto.toEntity(ligneCommandeClientDto.getArticle()));
		ligneCommandeClient.setIdEntreprise(ligneCommandeClientDto.getIdEntreprise());
		return ligneCommandeClient;
		
	}

}
