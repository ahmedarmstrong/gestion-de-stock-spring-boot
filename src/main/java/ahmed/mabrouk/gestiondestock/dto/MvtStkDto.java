package ahmed.mabrouk.gestiondestock.dto;

import java.math.BigDecimal;
import java.time.Instant;

import ahmed.mabrouk.gestiondestock.model.MvtStk;
import ahmed.mabrouk.gestiondestock.model.SourceMvtStk;
import ahmed.mabrouk.gestiondestock.model.TypeMvtStk;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MvtStkDto {
	
	private Integer id ;
	private Instant datemvt ;
	private BigDecimal quantite ;
	private ArticleDto article ;
	private TypeMvtStk typeMvt ;
	private SourceMvtStk sourceMvt;
	private Integer idEntreprise;
	
	public static MvtStkDto fromEntity (MvtStk mvtStk) {
		if(mvtStk == null) {
			return null ;
			//TODOO
		}
		return MvtStkDto.builder()
				.id(mvtStk.getId())
				.datemvt(mvtStk.getDatemvt())
				.quantite(mvtStk.getQuantite())
				.article(ArticleDto.fromEntity(mvtStk.getArticle()))
				.typeMvt(mvtStk.getTypeMvt())
				.sourceMvt(mvtStk.getSourceMvt())
				.idEntreprise(mvtStk.getIdEntreprise())
				.build();
	}
	
	public static MvtStk toEntity(MvtStkDto mvtStkDto) {
		if(mvtStkDto == null) {
			return null ;
			//TODOO
		}
		MvtStk mvtStk = new MvtStk();
		mvtStk.setId(mvtStkDto.getId());
		mvtStk.setDatemvt(mvtStkDto.getDatemvt());
		mvtStk.setQuantite(mvtStkDto.getQuantite());
		mvtStk.setArticle(ArticleDto.toEntity(mvtStkDto.getArticle()));
		mvtStk.setTypeMvt(mvtStkDto.getTypeMvt());
		mvtStk.setSourceMvt(mvtStkDto.getSourceMvt());
		mvtStk.setIdEntreprise(mvtStkDto.getIdEntreprise());
		return mvtStk;

	}
	

}
