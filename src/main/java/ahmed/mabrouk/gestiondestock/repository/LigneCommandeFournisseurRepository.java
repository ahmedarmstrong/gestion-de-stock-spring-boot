package ahmed.mabrouk.gestiondestock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmed.mabrouk.gestiondestock.model.LigneCommandeFournisseur;

public interface LigneCommandeFournisseurRepository extends JpaRepository<LigneCommandeFournisseur, Integer>{
	
	List<LigneCommandeFournisseur> findAllByCommandeFournisseurId(Integer idCommande);

	  List<LigneCommandeFournisseur> findAllByArticleId(Integer idCommande);

}
