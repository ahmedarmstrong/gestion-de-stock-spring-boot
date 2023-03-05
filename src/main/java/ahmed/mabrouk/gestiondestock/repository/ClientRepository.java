package ahmed.mabrouk.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmed.mabrouk.gestiondestock.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
