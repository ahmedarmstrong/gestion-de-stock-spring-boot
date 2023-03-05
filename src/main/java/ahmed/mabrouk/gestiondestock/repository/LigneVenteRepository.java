package ahmed.mabrouk.gestiondestock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmed.mabrouk.gestiondestock.model.LigneVente;

public interface LigneVenteRepository extends JpaRepository<LigneVente, Integer>{
	
	 List<LigneVente> findAllByArticleId(Integer idArticle);

	  List<LigneVente> findAllByVenteId(Integer id);

}
