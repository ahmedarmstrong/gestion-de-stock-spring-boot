package ahmed.mabrouk.gestiondestock.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmed.mabrouk.gestiondestock.dto.EntrepriseDto;
import ahmed.mabrouk.gestiondestock.dto.RolesDto;
import ahmed.mabrouk.gestiondestock.dto.UtilisateurDto;
import ahmed.mabrouk.gestiondestock.exeption.EntityNotFoundException;
import ahmed.mabrouk.gestiondestock.exeption.ErrorCodes;
import ahmed.mabrouk.gestiondestock.exeption.InvalidEntityException;
import ahmed.mabrouk.gestiondestock.repository.EntrepriseRepository;
import ahmed.mabrouk.gestiondestock.repository.RolesRepository;
import ahmed.mabrouk.gestiondestock.service.EntrepriseService;
import ahmed.mabrouk.gestiondestock.service.UtilisateurService;
import ahmed.mabrouk.gestiondestock.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {
	
	private EntrepriseRepository entrepriseRepository;
	  private UtilisateurService utilisateurService;
	  private RolesRepository rolesRepository;
	  
	  
	@Autowired
	public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository, UtilisateurService utilisateurService,
			RolesRepository rolesRepository) {
		this.entrepriseRepository = entrepriseRepository;
		this.utilisateurService = utilisateurService;
		this.rolesRepository = rolesRepository;
	}

	@Override
	public EntrepriseDto save(EntrepriseDto dto) {
		List<String> errors = EntrepriseValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("Entreprise is not valid{}", dto);
            throw new InvalidEntityException("L'Entreprise n'est pas valid", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
		}
		 EntrepriseDto savedEntreprise = EntrepriseDto.fromEntity(
			        entrepriseRepository.save(EntrepriseDto.toEntity(dto))
			    );

			    UtilisateurDto utilisateur = fromEntreprise(savedEntreprise);

			    UtilisateurDto savedUser = utilisateurService.save(utilisateur);

			    RolesDto rolesDto = RolesDto.builder()
			        .roleName("ADMIN")
			        .utilisateur(savedUser)
			        .build();

			    rolesRepository.save(RolesDto.toEntity(rolesDto));

			    return  savedEntreprise;
	}

	@Override
	public EntrepriseDto findById(Integer id) {
		 if (id == null) {
	            log.error("Entreprise ID is null");
	            return null;
	        }
		return entrepriseRepository.findById(id).map(EntrepriseDto::fromEntity).orElseThrow(() ->
		new EntityNotFoundException( "Aucun Entreprise avec l'ID = " + id + " n' ete trouve dans la BDD",
				ErrorCodes.ENTREPRISE_NOT_FOUND)
		);
	}

	@Override
	public List<EntrepriseDto> findAll() {
		// TODO Auto-generated method stub
		return entrepriseRepository.findAll()
				.stream()
				.map(EntrepriseDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		 if (id == null) {
		      log.error("Entreprise ID is null");
		      return;
		    }
		    entrepriseRepository.deleteById(id);
		
	}

}