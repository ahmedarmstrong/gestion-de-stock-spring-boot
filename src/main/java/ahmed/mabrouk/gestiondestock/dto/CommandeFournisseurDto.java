package ahmed.mabrouk.gestiondestock.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ahmed.mabrouk.gestiondestock.model.CommandeFournisseur;
import ahmed.mabrouk.gestiondestock.model.EtatCommande;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeFournisseurDto {
	
	private Integer id ;
	private String code ;
	private Instant dateCommandeFournisseur ;
	private EtatCommande etatCommande;
	private FournisseurDto fournisseur ;
	private Integer idEntreprise;
	@JsonIgnore
	private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs ;

	
	public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur) {
		if(commandeFournisseur == null) {
			return null ;
			//TODOO
		}
		
		return CommandeFournisseurDto.builder()
				.id(commandeFournisseur.getId())
				.code(commandeFournisseur.getCode())
				.dateCommandeFournisseur(commandeFournisseur.getDateCommandeFournisseur())
				.etatCommande(commandeFournisseur.getEtatCommande())
				.fournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
				.idEntreprise(commandeFournisseur.getIdEntreprise())
				.build();			
	}
	public static CommandeFournisseur toEntity(CommandeFournisseurDto  commandeFournisseurDto) {
		if(commandeFournisseurDto == null) {
			return null ;
			//TODOO
		}
		
		CommandeFournisseur commandeFournisseur = new  CommandeFournisseur();
		commandeFournisseur.setId(commandeFournisseurDto.getId());
		commandeFournisseur.setCode(commandeFournisseurDto.getCode());
		commandeFournisseur.setDateCommandeFournisseur(commandeFournisseurDto.getDateCommandeFournisseur());
		commandeFournisseur.setEtatCommande(commandeFournisseurDto.getEtatCommande());
		commandeFournisseur.setFournisseur(FournisseurDto.toEntity(commandeFournisseurDto.getFournisseur()));
		commandeFournisseur.setIdEntreprise(commandeFournisseurDto.getIdEntreprise());
		return commandeFournisseur ;
	}
	
	 public boolean isCommandeLivree() {
		    return EtatCommande.LIVREE.equals(this.etatCommande);
		  }
}
