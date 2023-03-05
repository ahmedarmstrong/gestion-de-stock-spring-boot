package ahmed.mabrouk.gestiondestock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmed.mabrouk.gestiondestock.model.LigneCommandeClient;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient, Integer>{
	
	List<LigneCommandeClient> findAllByCommandeClientId(Integer id);

	  List<LigneCommandeClient> findAllByArticleId(Integer id);

}
