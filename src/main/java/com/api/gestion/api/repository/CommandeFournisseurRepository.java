package com.api.gestion.api.repository;

import java.util.List;
import java.util.Optional;

import com.api.gestion.api.model.CommandeClient;
import com.api.gestion.api.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {

    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);

    List<CommandeClient> findAllByFournisseurId(Integer id);
}
