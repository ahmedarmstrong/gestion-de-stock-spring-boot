package ahmed.mabrouk.gestiondestock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ahmed.mabrouk.gestiondestock.model.Entreprise;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrepriseDto {
	
	private Integer id ;
	private String nom ;
	private String description ;
	private AdresseDto adresse ;
	private String codeFiscale ;
	private String photo ;
	private String email ;
	private String numTel ;
	private String siteWeb ;
	@JsonIgnore
	private List<UtilisateurDto> utilisateurs ;
	
	public static EntrepriseDto fromEntity(Entreprise entreprise) {
		if(entreprise == null) {
			return null ;
			//TODOO
		}
		
		return EntrepriseDto.builder()
		.id(entreprise.getId())
		.nom(entreprise.getNom())
		.description(entreprise.getDescription())
		.adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
		.codeFiscale(entreprise.getCodeFiscale())
		.photo(entreprise.getPhoto())
		.email(entreprise.getEmail())
		.numTel(entreprise.getNumTel())
		.siteWeb(entreprise.getSiteWeb())
		.build();
	}
	
	public static Entreprise toEntity (EntrepriseDto entrepriseDto) {
		if(entrepriseDto == null) {
			return null ;
			//TODOO
		}
		
		Entreprise entreprise = new Entreprise();
		entreprise.setId(entrepriseDto.getId());
		entreprise.setNom(entrepriseDto.getNom());
		entreprise.setDescription(entrepriseDto.getDescription());
		entreprise.setAdresse(AdresseDto.toEntity(entrepriseDto.getAdresse()));
		entreprise.setCodeFiscale(entrepriseDto.getCodeFiscale());
		entreprise.setPhoto(entrepriseDto.getPhoto());
		entreprise.setEmail(entrepriseDto.getEmail());
		entreprise.setNumTel(entrepriseDto.getNumTel());
		entreprise.setSiteWeb(entrepriseDto.getSiteWeb());
		
		return entreprise;
		
	}


}
