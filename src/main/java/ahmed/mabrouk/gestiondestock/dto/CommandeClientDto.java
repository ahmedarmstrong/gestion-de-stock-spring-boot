package ahmed.mabrouk.gestiondestock.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ahmed.mabrouk.gestiondestock.model.CommandeClient;
import ahmed.mabrouk.gestiondestock.model.EtatCommande;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeClientDto {
	
	private Integer id ;
	private String code ;
	private Instant dateCommandeClient ;
	private EtatCommande etatCommande;
	private ClientDto client ;
	private Integer idEntreprise;
	@JsonIgnore
	private List<LigneCommandeClientDto> ligneCommandeClients ;
	
	public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
		if(commandeClient == null) {
			return null ;
			//TODOO
		}
		
		return CommandeClientDto.builder()
				.id(commandeClient.getId())
				.code(commandeClient.getCode())
				.dateCommandeClient(commandeClient.getDateCommandeClient())
				.etatCommande(commandeClient.getEtatCommande())
				.client(ClientDto.fromEntity(commandeClient.getClient()))
				.idEntreprise(commandeClient.getIdEntreprise())
				.build();			
	}
	public static CommandeClient toEntity(CommandeClientDto commandeClientDto) {
		if(commandeClientDto == null) {
			return null ;
			//TODOO
		}
		
		CommandeClient commandeClient = new CommandeClient();
		commandeClient.setId(commandeClientDto.getId());
		commandeClient.setCode(commandeClientDto.getCode());
		commandeClient.setDateCommandeClient(commandeClientDto.getDateCommandeClient());
		commandeClient.setEtatCommande(commandeClientDto.getEtatCommande());
		commandeClient.setClient(ClientDto.toEntity(commandeClientDto.getClient()));
		commandeClient.setIdEntreprise(commandeClientDto.getIdEntreprise());
		return commandeClient ;
	}
	
	 public boolean isCommandeLivree() {
		    return EtatCommande.LIVREE.equals(this.etatCommande);
		  }
}
