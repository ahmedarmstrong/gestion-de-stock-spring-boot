package ahmed.mabrouk.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ahmed.mabrouk.gestiondestock.model.Roles;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDto {
	
	private Integer id ;
	private String roleName ;
	@JsonIgnore
	private UtilisateurDto utilisateur ;
	
	public static RolesDto fromEntity(Roles roles) {
		if(roles == null) {
			return null ;
			//TODOO
		}
		return RolesDto.builder()
				.id(roles.getId())
				.roleName(roles.getRoleName())
				.build();
	}
	
	public static Roles toEntity(RolesDto rolesDto) {
		if(rolesDto == null) {
			return null ;
			//TODOO
		}
		Roles roles = new Roles();
		roles.setId(rolesDto.getId());
		roles.setRoleName(rolesDto.getRoleName());
		roles.setUtilisateur(UtilisateurDto.toEntity(rolesDto.getUtilisateur()));
		
		return roles ;
	}
	

}
