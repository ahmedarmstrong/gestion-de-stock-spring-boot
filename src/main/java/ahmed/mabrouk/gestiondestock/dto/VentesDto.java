package ahmed.mabrouk.gestiondestock.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ahmed.mabrouk.gestiondestock.model.Ventes;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VentesDto {
	
	private Integer id ;
	private String code ;
	private Instant dateVente;
	private String commentaire ;
	@JsonIgnore
	private List<LigneVenteDto> ligneVentes;
	private Integer idEntreprise;
	
	public static VentesDto fromEntity (Ventes ventes) {
		if(ventes == null) {
			return null ;
			//TODOO
		}
		
		return VentesDto.builder()
				.id(ventes.getId())
				.code(ventes.getCode())
				.dateVente(ventes.getDateVente())
				.commentaire(ventes.getCommentaire())
				.idEntreprise(ventes.getIdEntreprise())
				.build();
	}
	
	public static Ventes toEntity (VentesDto ventesDto) {
		if(ventesDto == null) {
			return null ;
			//TODOO
		}
		
		Ventes ventes = new Ventes();
		ventes.setId(ventesDto.getId());
		ventes.setCode(ventesDto.getCode());
		ventes.setDateVente(ventesDto.getDateVente());
		ventes.setCommentaire(ventesDto.getCommentaire());
		ventes.setIdEntreprise(ventesDto.getIdEntreprise());
		return ventes;
	}

}
