package ahmed.mabrouk.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmed.mabrouk.gestiondestock.model.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}
