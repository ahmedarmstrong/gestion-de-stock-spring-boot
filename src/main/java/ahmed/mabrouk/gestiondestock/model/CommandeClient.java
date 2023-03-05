package ahmed.mabrouk.gestiondestock.model;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "commandeclient")
public class CommandeClient  extends AbstractEntity{
	
	
	@Column(name = "code")
	private String code ;
	
	
	@Column(name = "datecommandeclient")
	private Instant dateCommandeClient ;
	
	@Column(name = "etatcommande")
	@Enumerated(EnumType.STRING)
	private EtatCommande etatCommande;
	
	
	
	@Column(name = "identreprise")
	private Integer idEntreprise;
	
	
	
	@ManyToOne
	@JoinColumn(name = "idclient")
	private Client client ;
	
	
	@OneToMany(mappedBy = "commandeclient")
	private List<LigneCommandeClient> ligneCommandeClient ;

}
