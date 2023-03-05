package ahmed.mabrouk.gestiondestock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ahmed.mabrouk.gestiondestock.controller.api.ClientApi;
import ahmed.mabrouk.gestiondestock.dto.ClientDto;
import ahmed.mabrouk.gestiondestock.service.ClientService;

public class ClientController implements ClientApi {
	
	private ClientService clientService;
	
	
	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@Override
	public ClientDto save(ClientDto dto) {
		// TODO Auto-generated method stub
		return clientService.save(dto);
	}

	@Override
	public ClientDto findById(Integer id) {
		// TODO Auto-generated method stub
		return clientService.findById(id);
	}

	@Override
	public List<ClientDto> findAll() {
		// TODO Auto-generated method stub
		return clientService.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		clientService.delete(id);
		
	}

}
