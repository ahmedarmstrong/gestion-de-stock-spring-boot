package ahmed.mabrouk.gestiondestock.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmed.mabrouk.gestiondestock.dto.ClientDto;
import ahmed.mabrouk.gestiondestock.exeption.EntityNotFoundException;
import ahmed.mabrouk.gestiondestock.exeption.ErrorCodes;
import ahmed.mabrouk.gestiondestock.exeption.InvalidEntityException;
import ahmed.mabrouk.gestiondestock.exeption.InvalidOperationException;
import ahmed.mabrouk.gestiondestock.model.CommandeClient;
import ahmed.mabrouk.gestiondestock.repository.ClientRepository;
import ahmed.mabrouk.gestiondestock.repository.CommandeClientRepository;
import ahmed.mabrouk.gestiondestock.service.ClientService;
import ahmed.mabrouk.gestiondestock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
	
	private ClientRepository clientRepository;
	  private CommandeClientRepository commandeClientRepository;
	  
	  
	@Autowired
	public ClientServiceImpl(ClientRepository clientRepository, CommandeClientRepository commandeClientRepository) {
		this.clientRepository = clientRepository;
		this.commandeClientRepository = commandeClientRepository;
	}

	@Override
	public ClientDto save(ClientDto dto) {
		List<String> errors = ClientValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("", dto);
			throw new InvalidEntityException("", ErrorCodes.CLIENT_NOT_VALID, errors);
		}
		return ClientDto.fromEntity(
				clientRepository.save(ClientDto.toEntity(dto))
				);
	}

	@Override
	public ClientDto findById(Integer id) {
		if (id == null) {
            log.error("Client ID is null");
            return null;
        }
		return clientRepository.findById(id).map(ClientDto::fromEntity).orElseThrow(() ->
				new EntityNotFoundException( "Aucun client avec l'ID = " + id + " n' ete trouve dans la BDD",
                ErrorCodes.CLIENT_NOT_FOUND)
				);
	}

	@Override
	public List<ClientDto> findAll() {
		// TODO Auto-generated method stub
		return clientRepository.findAll()
				.stream()
				.map(ClientDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		 if (id == null) {
		      log.error("Client ID is null");
		      return;
		    }
		    List<CommandeClient> commandeClients = commandeClientRepository.findAllByClientId(id);
		    if (!commandeClients.isEmpty()) {
		      throw new InvalidOperationException("Impossible de supprimer un client qui a deja des commande clients",
		          ErrorCodes.CLIENT_ALREADY_IN_USE);
		    }
		    clientRepository.deleteById(id);
		
	}

}
