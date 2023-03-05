package ahmed.mabrouk.gestiondestock.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmed.mabrouk.gestiondestock.model.CommandeClient;
import ahmed.mabrouk.gestiondestock.model.CommandeFournisseur;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer>{
	
	 Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);

	  List<CommandeClient> findAllByFournisseurId(Integer id);

}
