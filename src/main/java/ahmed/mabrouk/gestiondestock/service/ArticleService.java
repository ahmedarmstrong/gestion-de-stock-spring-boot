package ahmed.mabrouk.gestiondestock.service;

import ahmed.mabrouk.gestiondestock.dto.ArticleDto;
import ahmed.mabrouk.gestiondestock.dto.LigneCommandeClientDto;
import ahmed.mabrouk.gestiondestock.dto.LigneCommandeFournisseurDto;
import ahmed.mabrouk.gestiondestock.dto.LigneVenteDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto articleDto);

    ArticleDto findById(Integer id);

    ArticleDto findByCodeArticle(String codeArticle);

    List<ArticleDto> findAll();

    List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);

    List<LigneCommandeClientDto> findHistoriauriqueCommandeClient(Integer idArticle);

    List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle);

    List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);

    void delete(Integer id);
}
