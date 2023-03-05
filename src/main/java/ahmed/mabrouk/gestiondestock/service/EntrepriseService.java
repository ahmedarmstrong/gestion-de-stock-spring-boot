package ahmed.mabrouk.gestiondestock.service;

import java.util.List;

import ahmed.mabrouk.gestiondestock.dto.EntrepriseDto;

public interface EntrepriseService {
	
	 EntrepriseDto save(EntrepriseDto dto);

	  EntrepriseDto findById(Integer id);

	  List<EntrepriseDto> findAll();

	  void delete(Integer id);

}
