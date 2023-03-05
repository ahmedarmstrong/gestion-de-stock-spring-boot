package ahmed.mabrouk.gestiondestock.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ahmed.mabrouk.gestiondestock.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UtilisateurDto {
	
	private Integer id ;
	private String nom ;
	private String prenom;
	private String email ;
	private Instant dateDeNaissance ;
	private String moteDePasse ;
	private AdresseDto adresse ;
	private String photo ;
	private EntrepriseDto entreprise ;
	@JsonIgnore
	private List<RolesDto> roles ;
	
	public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
	    if (utilisateur == null) {
	      return null;
	    }

	    return UtilisateurDto.builder()
	        .id(utilisateur.getId())
	        .nom(utilisateur.getNom())
	        .prenom(utilisateur.getPrenom())
	        .email(utilisateur.getEmail())
	        .moteDePasse(utilisateur.getMoteDePasse())
	        .dateDeNaissance(utilisateur.getDateDeNaissance())
	        .adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
	        .photo(utilisateur.getPhoto())
	        .entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
	        .roles(
	            utilisateur.getRoles() != null ?
	                utilisateur.getRoles().stream()
	                    .map(RolesDto::fromEntity)
	                    .collect(Collectors.toList()) : null
	        )
	        .build();
	  }
	
	public static Utilisateur toEntity(UtilisateurDto utilisateurDto) {
	    if (utilisateurDto == null) {
	      return null;
	    }

	    Utilisateur utilisateur = new Utilisateur();
	    utilisateur.setId(utilisateurDto.getId());
	    utilisateur.setNom(utilisateurDto.getNom());
	    utilisateur.setPrenom(utilisateurDto.getPrenom());
	    utilisateur.setEmail(utilisateurDto.getEmail());
	    utilisateur.setMoteDePasse(utilisateurDto.getMoteDePasse());
	    utilisateur.setDateDeNaissance(utilisateurDto.getDateDeNaissance());
	    utilisateur.setAdresse(AdresseDto.toEntity(utilisateurDto.getAdresse()));
	    utilisateur.setPhoto(utilisateurDto.getPhoto());
	    utilisateur.setEntreprise(EntrepriseDto.toEntity(utilisateurDto.getEntreprise()));

	    return utilisateur;
	  }

}
