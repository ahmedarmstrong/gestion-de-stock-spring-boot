package ahmed.mabrouk.gestiondestock.service;

import java.util.List;

import ahmed.mabrouk.gestiondestock.dto.ClientDto;

public interface ClientService {
	
	 ClientDto save(ClientDto dto);

	  ClientDto findById(Integer id);

	  List<ClientDto> findAll();

	  void delete(Integer id);

}
