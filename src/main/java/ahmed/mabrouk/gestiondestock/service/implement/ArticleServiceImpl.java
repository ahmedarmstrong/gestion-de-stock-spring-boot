package ahmed.mabrouk.gestiondestock.service.implement;

import ahmed.mabrouk.gestiondestock.dto.ArticleDto;
import ahmed.mabrouk.gestiondestock.dto.LigneCommandeClientDto;
import ahmed.mabrouk.gestiondestock.dto.LigneCommandeFournisseurDto;
import ahmed.mabrouk.gestiondestock.dto.LigneVenteDto;
import ahmed.mabrouk.gestiondestock.exeption.EntityNotFoundException;
import ahmed.mabrouk.gestiondestock.exeption.ErrorCodes;
import ahmed.mabrouk.gestiondestock.exeption.InvalidEntityException;
import ahmed.mabrouk.gestiondestock.exeption.InvalidOperationException;
import ahmed.mabrouk.gestiondestock.model.LigneCommandeClient;
import ahmed.mabrouk.gestiondestock.model.LigneCommandeFournisseur;
import ahmed.mabrouk.gestiondestock.model.LigneVente;
import ahmed.mabrouk.gestiondestock.repository.ArticleRepository;
import ahmed.mabrouk.gestiondestock.repository.LigneCommandeClientRepository;
import ahmed.mabrouk.gestiondestock.repository.LigneCommandeFournisseurRepository;
import ahmed.mabrouk.gestiondestock.repository.LigneVenteRepository;
import ahmed.mabrouk.gestiondestock.service.ArticleService;
import ahmed.mabrouk.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;
    private LigneVenteRepository venteRepository;
    private LigneCommandeFournisseurRepository commandeFournisseurRepository;
    private LigneCommandeClientRepository commandeClientRepository;

    public ArticleServiceImpl(
            ArticleRepository articleRepository,
            LigneVenteRepository venteRepository,
            LigneCommandeFournisseurRepository commandeFournisseurRepository,
            LigneCommandeClientRepository commandeClientRepository) {
        this.articleRepository = articleRepository;
        this.venteRepository = venteRepository;
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.commandeClientRepository = commandeClientRepository;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);
        if (!errors.isEmpty()){
            log.error("Article is not valid{}",articleDto);
            throw new InvalidEntityException("L'article n'est pas valid", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }
        return ArticleDto.fromEntity(
                articleRepository.save(ArticleDto.toEntity(articleDto))
        );
    }

    @Override
    public ArticleDto findById(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return null;
        }
        return articleRepository.findById(id).map(ArticleDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException( "Aucun article avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND)
                );
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)) {
            log.error("Article CODE is null");
            return null;
        }
            return articleRepository.findArticleByCodeArticle(codeArticle)
                    .map(ArticleDto::fromEntity)
                    .orElseThrow(() ->
                        new EntityNotFoundException(
                            "Aucun article avec le CODE = " + codeArticle + " n' ete trouve dans la BDD",
                            ErrorCodes.ARTICLE_NOT_FOUND)
                    );
    }

    @Override
    public List<ArticleDto> findAll() {
    	return articleRepository.findAll().stream()
    	        .map(ArticleDto::fromEntity)
    	        .collect(Collectors.toList());
    }

    @Override
    public List<LigneVenteDto> findHistoriqueVentes(Integer idArticle) {
        return venteRepository.findAllByArticleId(idArticle)
        		.stream()
        		.map(LigneVenteDto::fromEntity)
        		.collect(Collectors.toList());
    }

    @Override
    public List<LigneCommandeClientDto> findHistoriauriqueCommandeClient(Integer idArticle) {
        return null;
    }

    @Override
    public List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle) {
        return null;
    }

    @Override
    public List<ArticleDto> findAllArticleByIdCategory(Integer idCategory) {
        return null;
    }

    @Override
    public void delete(Integer id) {
    	
    	 if (id == null) {
    	      log.error("Article ID is null");
    	      return;
    	    }
    	    List<LigneCommandeClient> ligneCommandeClients = commandeClientRepository.findAllByArticleId(id);
    	    if (!ligneCommandeClients.isEmpty()) {
    	      throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des commandes client", ErrorCodes.ARTICLE_ALREADY_IN_USE);
    	    }
    	    List<LigneCommandeFournisseur> ligneCommandeFournisseurs = commandeFournisseurRepository.findAllByArticleId(id);
    	    if (!ligneCommandeFournisseurs.isEmpty()) {
    	      throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des commandes fournisseur",
    	          ErrorCodes.ARTICLE_ALREADY_IN_USE);
    	    }
    	    List<LigneVente> ligneVentes = venteRepository.findAllByArticleId(id);
    	    if (!ligneVentes.isEmpty()) {
    	      throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des ventes",
    	          ErrorCodes.ARTICLE_ALREADY_IN_USE);
    	    }
    	    articleRepository.deleteById(id);

    }
}
